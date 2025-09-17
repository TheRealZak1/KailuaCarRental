Formål:

ER-diagrammet findes i filen: ERD.png.

Entiteter:

CarCategory – beskriver de tre bilgrupper (Luxury, Family, Sport) samt deres karakteristika. BLIVER IKKE BRUG I PROGRMMET, DA PROGRAMMETS FUNKTIONALTITET KAN ADMISTRERES UDEN

Car – hver enkelt bil, med registreringsnummer, mærke, model, km osv.

Customer – kundeoplysninger, inkl. kørekortnummer og kontaktinfo.

RentalContract – lejekontrakter, der binder en kunde og en bil sammen.

Relationer:

En CarCategory kan indeholde mange biler (1:N).

En Customer kan have mange lejekontrakter (1:N).

En Car kan indgå i mange lejekontrakter over tid (1:N).



JAVA-applikation :

    Funktionalitet:

           Car: opret, opdater, slet, søg

           Customer: opret, opdater, slet, søg

           RentalContract: opret, afslut, søg

    Valideringer:

           En bil kan ikke slettes, hvis den har en aktiv kontrakt.

           En bil kan ikke have to overlappende kontrakter i samme periode.

           Returneret km-stand skal være større eller lig med start km-stand.

test