/* Elektriciteit stap voor stap: werkt ook zonder internet na het eerste bezoek. */
const VERSIE='elek-v5';
const BESTANDEN=['./','./index.html','./manifest.webmanifest','./icons/icoon-192.png','./icons/icoon-512.png','./icons/icoon-maskable-512.png','./icons/apple-touch-icon.png','./icons/favicon-32.png'];
self.addEventListener('install',e=>{e.waitUntil(caches.open(VERSIE).then(c=>c.addAll(BESTANDEN)).then(()=>self.skipWaiting()));});
self.addEventListener('activate',e=>{e.waitUntil(caches.keys().then(k=>Promise.all(k.filter(x=>x!==VERSIE).map(x=>caches.delete(x)))).then(()=>self.clients.claim()));});
/* eerst het netwerk (zo krijgen leerlingen altijd de nieuwste versie), anders de bewaarde versie */
self.addEventListener('fetch',e=>{
  if(e.request.method!=='GET')return;
  e.respondWith(fetch(e.request).then(r=>{if(r.ok&&new URL(e.request.url).origin===location.origin){const c=r.clone();caches.open(VERSIE).then(x=>x.put(e.request,c));}return r;}).catch(()=>caches.match(e.request).then(r=>r||caches.match('./index.html'))));
});
