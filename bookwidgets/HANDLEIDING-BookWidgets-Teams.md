# Punten in Teams met BookWidgets

De app is om te **oefenen**. Voor **punten in Teams** gebruik je BookWidgets: een toets in BookWidgets verbetert zichzelf en stuurt de punten automatisch naar het puntenboek (Cijfers) van je klasteam.

## Wat zit er in deze map?

12 CSV-bestanden in `per-hoofdstuk/`: 4 hoofdstukken × 3 niveaus.

| Hoofdstuk | Gemakkelijk | Moeilijk | Doordenker |
|---|---|---|---|
| 1 Basis | 26 vragen | 25 vragen | 36 vragen |
| 2 Schakelingen in huis | 14 | 20 | 26 |
| 3 Schema's en symbolen | 7 | 3 | 8 |
| 4 Duurzame energie | 19 | 22 | 19 |

- Elke vraag begint met het onderwerp tussen haken, bv. `[De wet van Ohm]`. Zo zie je in BookWidgets meteen bij welke stap van de app de vraag hoort. Je mag dat weghalen.
- De vragen zijn **dezelfde als in de app**, met dezelfde uitleg (kolom *Rationale*). De leerling ziet die uitleg bij de verbetering.
- Alleen vragen met tekst zitten erin. Vragen met een tekening, symbool of schema (bv. "Welk symbool is een wisselschakelaar?") kan een CSV-bestand niet meenemen. Wil je die in de toets, voeg ze dan in BookWidgets toe als vraag met een afbeelding. Neem daarvoor de symbolen uit je eigen PowerPoints.
- De vragen over de energiewoning horen bij scenario **80600** (de vrije woning met de standaardinstellingen).
- Hoofdstuk 3 heeft weinig tekstvragen, want bijna alles daar gaat over tekeningen. Vul die toets aan met afbeeldingsvragen.

## Eenmalig: BookWidgets in Teams zetten

1. Je school heeft een BookWidgets-licentie nodig. Er is ook een gratis proefperiode.
2. Ga in Teams naar **Apps**, zoek **BookWidgets** en voeg de app toe.

## Een toets maken met een CSV-bestand

1. Open BookWidgets en maak een nieuwe **Quiz** (of **Worksheet**).
2. Geef de toets een duidelijke naam, bv. `Elektriciteit – Basis – Gemakkelijk`.
3. Klik rechtsboven op het **tandwiel** en kies **Import CSV…**.
4. Kies het bestand, bv. `1-Basis_1-Gemakkelijk.csv`. De vragen staan nu in de toets.
5. Klik op **Preview** en kijk de toets na.
6. Staat de eerste rij met kolomnamen (Question, A, B …) als vraag in de toets? Verwijder die vraag dan.
7. Bewaar de toets.

Tip: je kan ook een kleinere toets maken. Importeer een bestand en verwijder de vragen die je niet wil gebruiken.

## De toets geven in Teams

1. Ga in je klasteam naar **Opdrachten** en kies **Nieuw → Opdracht**.
2. Kies bij **Toevoegen** de app **BookWidgets** en daarna je toets.
3. Zet de punten (bv. 10 of 20) en de deadline. Wijs de opdracht toe.
4. De leerlingen openen de opdracht in Teams en maken de toets.
5. Bekijk de resultaten in het BookWidgets-overzicht. De punten komen **vanzelf** in **Cijfers** van je klasteam.
6. Geef feedback terug vanuit het BookWidgets-overzicht. Geef daarna de opdracht terug in Teams.

## Differentiëren met de drie niveaus

- **Gemakkelijk**: herkennen en kiezen. Voor iedereen, ook voor OKAN/VOKAN.
- **Moeilijk**: toepassen.
- **Doordenker**: rekenen en verklaren.

In Teams kan je een opdracht aan een **deel van de klas** toewijzen. Zo geef je elke leerling het niveau dat bij hem of haar past.

## Aanpassen voor leerlingen met een leerstoornis

In BookWidgets kan je per opdracht:
- de antwoorden laten **voorlezen** (immersive reader in Teams),
- **geen tijdslimiet** zetten,
- **meerdere pogingen** toelaten.

## Een CSV-bestand zelf aanpassen

Open het bestand in Excel. De kolommen zijn:

| Kolom | Inhoud |
|---|---|
| Question | de vraag |
| A tot F | de antwoorden (lege vakjes worden overgeslagen) |
| Answer | de letter van het juiste antwoord |
| Rationale | de uitleg bij de verbetering |
| RandomOrder | `yes` = antwoorden in willekeurige volgorde, `no` = vaste volgorde (bv. Veilig / Niet veilig) |
| MultiColumn | `yes` = antwoorden naast elkaar |

Bewaar daarna als **CSV UTF-8 (door komma's gescheiden)**. Dan blijven ë, é, Ω en ² juist.
