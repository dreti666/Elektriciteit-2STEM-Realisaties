# Elektriciteit stap voor stap

<img src="icons/icoon-192.png" width="96" align="right" alt="Icoon van de app">

Een leer- en oefenapp over de basis van elektriciteit voor **2B STEM Realisaties** (basisoptie STEM-technieken, 1ste graad B-stroom), St.-Jozefinstituut Schoten.

Gemaakt door **Timmy De Rechter**, klastitularis 2B STEM Realisaties.

## Wat zit erin?

- **20 stappen** in 4 hoofdstukken: Basis, Schakelingen in huis, Schema's en symbolen, Duurzame energie.
- Elke stap: eerst **leren** (korte kaarten), dan **oefenen** op drie niveaus: **Gemakkelijk**, **Moeilijk** en **Doordenker**. Een niveau gaat open bij 70% op het vorige niveau.
- **De energiewoning**: een woning met zonnepanelen, een verticale windturbine en een thuisbatterij. De leraar stelt het weer in en geeft de klas een code van 5 cijfers.
- Symbolen en schema's komen uit de lessen (PowerPoints).
- Afgestemd op OKAN/VOKAN, autisme, AD(H)D, OCD, dyscalculie en dysorthografie: korte zinnen, voorleesknop, woordenlijst met beelden, nergens typen, één vraag per scherm, rustige feedback, rustige modus, grote letters.
- Donker thema in de kleuren van de school.
- Werkt op Chromebook, laptop, tablet en gsm. Na het eerste bezoek werkt de app ook zonder internet.

## Online zetten met GitHub Pages (eenmalig)

1. Ga naar de repository op GitHub.
2. Klik op **Settings** → **Pages**.
3. Bij **Source**: kies **Deploy from a branch**.
4. Bij **Branch**: kies **main** en de map **/ (root)**. Klik op **Save**.
5. Wacht 1 à 2 minuten. Het adres van de app staat bovenaan op die pagina, bijvoorbeeld:
   `https://dreti666.github.io/<naam-van-de-repository>/`

De repository moet **openbaar (public)** zijn voor gratis GitHub Pages.

## Delen via Teams

1. Open je klasteam en het juiste kanaal.
2. Klik bovenaan op **+** (tabblad toevoegen) → **Website**.
3. Naam: `Elektriciteit stap voor stap`. Plak het adres van de app. Klik op **Opslaan**.
4. De leerlingen openen de app nu als tabblad in Teams.

Tip: zet het adres ook in een bericht in het kanaal. Dan kunnen leerlingen de app in hun browser openen en installeren.

## Installeren als app

- **Chromebook / Windows (Chrome of Edge):** open het adres en klik op het installatie-icoon rechts in de adresbalk.
- **Android:** open het adres in Chrome → menu (⋮) → **App installeren** of **Toevoegen aan startscherm**.
- **iPhone / iPad:** open het adres in Safari → **Deel** → **Zet op beginscherm**.

## Punten in Teams

De app is om te oefenen. De resultaten blijven op het toestel van de leerling; de leerling kan ze kopiëren en in Teams plakken.

Voor **punten in het puntenboek van Teams** gebruik je **BookWidgets**. In de map [`bookwidgets`](bookwidgets/) staan 12 toetsen als CSV-bestand (4 hoofdstukken × 3 niveaus) en een [handleiding](bookwidgets/HANDLEIDING-BookWidgets-Teams.md).

## Voor de leraar in de app

- **Start → Voor de leraar**: koppeling met de leerplandoelen, uitleg over de niveaus en de knop **Alle niveaus open** (per toestel).
- **De energiewoning → Leraar**: code **1234** (pas die aan in de app). Stel zon, wind, batterij en oefenreeks in en geef de code van 5 cijfers aan de klas.

## De app aanpassen

Alles zit in één bestand: `index.html`. Na een aanpassing: bewaar, upload naar GitHub, en verhoog in `sw.js` de versie (`elek-v1` → `elek-v2`). Dan krijgen de leerlingen zeker de nieuwe versie.

## Bestanden

| Bestand | Wat |
|---|---|
| `index.html` | de volledige app |
| `manifest.webmanifest` | naam, kleuren en icoon voor installeren |
| `sw.js` | zorgt dat de app ook zonder internet werkt |
| `icons/` | het app-icoon in verschillende formaten |
| `bookwidgets/` | toetsen voor BookWidgets en de handleiding |
