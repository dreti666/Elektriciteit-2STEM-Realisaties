package be.sjs.elektriciteit;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.Locale;

/**
 * Elektriciteit stap voor stap.
 * De app toont de website, zodat leerlingen elke aanpassing meteen krijgen.
 * Zonder internet toont ze de kopie die in de app zit.
 */
public class MainActivity extends Activity {
    private static final String ADRES = "https://timmyderechter.pages.dev/elektriciteit/";
    private static final String HOST = "timmyderechter.pages.dev";
    private static final String KOPIE = "file:///android_asset/elektriciteit/index.html";

    private WebView web;
    private TextToSpeech tts;
    private boolean ttsKlaar = false;

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        web = new WebView(this);
        web.setBackgroundColor(0xFF0B0F0D);
        setContentView(web);

        WebSettings s = web.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);
        s.setDatabaseEnabled(true);
        s.setMediaPlaybackRequiresUserGesture(false);
        s.setSupportMultipleWindows(false);

        // Voorlezen: de WebView van Android kent geen spraak, dus de app leest zelf voor.
        tts = new TextToSpeech(this, status -> {
            if (status == TextToSpeech.SUCCESS) {
                int r = tts.setLanguage(new Locale("nl", "BE"));
                if (r == TextToSpeech.LANG_MISSING_DATA || r == TextToSpeech.LANG_NOT_SUPPORTED) {
                    tts.setLanguage(new Locale("nl", "NL"));
                }
                ttsKlaar = true;
            }
        });
        web.addJavascriptInterface(new Spraak(), "AndroidTTS");

        web.setWebChromeClient(new WebChromeClient());
        web.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Uri u = request.getUrl();
                if (HOST.equals(u.getHost()) || "file".equals(u.getScheme())) return false;
                // Andere sites (bv. het formulier van de leraar) openen in de browser.
                try { startActivity(new Intent(Intent.ACTION_VIEW, u)); } catch (Exception ignored) { }
                return true;
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                if (request.isForMainFrame() && !KOPIE.equals(request.getUrl().toString())) {
                    view.loadUrl(KOPIE);
                }
            }
        });

        if (state != null) web.restoreState(state);
        else web.loadUrl(ADRES);
    }

    /** Brug voor de voorleesknop in de app. */
    private class Spraak {
        @JavascriptInterface
        public boolean klaar() { return ttsKlaar; }

        @JavascriptInterface
        public void spreek(String tekst, float snelheid) {
            if (!ttsKlaar || tekst == null) return;
            tts.setSpeechRate(snelheid > 0 ? snelheid : 1f);
            tts.speak(tekst, TextToSpeech.QUEUE_ADD, null, "z" + System.nanoTime());
        }

        @JavascriptInterface
        public void stop() { if (ttsKlaar) tts.stop(); }
    }

    @Override
    protected void onSaveInstanceState(Bundle out) {
        super.onSaveInstanceState(out);
        web.saveState(out);
    }

    @Override
    @SuppressWarnings("deprecation")
    public void onBackPressed() {
        // Eerst terug naar het startscherm van de app, pas daarna de app sluiten.
        web.evaluateJavascript("(window.terug&&window.terug())?'ja':'nee'", v -> {
            if (v != null && v.contains("ja")) return;
            if (web.canGoBack()) web.goBack(); else finish();
        });
    }

    @Override
    protected void onDestroy() {
        if (tts != null) { tts.stop(); tts.shutdown(); }
        if (web != null) web.destroy();
        super.onDestroy();
    }
}
