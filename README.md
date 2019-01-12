# projekat
Web aplikacija za vođenje evidencije o zadacima u okviru projekata

Završni test - JWD 28
Korišćenjem radnih okvira Spring Boot, AngularJS i Bootstrap razviti Web aplikaciju za vođenje
evidencije o zadacima u okviru projekata.
1.1 Aplikacija bi trebalo da obezbedi rad sa sledećim entitetima, uz čije atribute su data i ograničenja na
nivou baze podataka:
Projekat:
• Id - identifikator
• Naziv - tekstualna vrednost
• Rok završetka – tekstualna vrednost
Stanje:
• Id - identifikator
• Naziv - tekstualna vrednost
Zadatak:
• Id - identifikator
• Naziv – tekstualna obavezna i jedinstvena vrednost
• Zaduženi – tekstualna obavezna vrednost
• Procenjeno sati – celobrojna obavezna vrednost
• Opis – tekstualna vrednost
• Projekat - veza sa instancom klase Projekat (jednan zadatak može pripadati samo
jednom projektu, a jedan projekat može imati više zadataka). Suprotan deo veze kreirati
kod entiteta Projekat.
• Stanje - veza sa instancom klase Stanje (jednan zadatak biti samo u jednom stanju, dok više
zadataka može biti u istom stanju). Suprotan deo veze kreirati kod entiteta Stanje.
1.2 Pomoću radnog okvira Spring Boot implementirati sledeći REST API:
• GET /api/projekti - preuzimanje svih projekata
• GET /api/projekti/{id_projekta}/zadaci - preuzimanje svih zadataka za zadati projekat
• GET /api/zadaci - preuzimanje svih zadataka
• GET /api/zadaci/{id} - preuzimanje zadatka po zadatom id-u
• POST /api/ zadaci - dodavanje novog zadatka
• PUT /api/zadaci/{id} - izmena postojećeg zadatka
• DELETE /api/zadaci/{id} - brisanje postojećeg zadatka
• GET /api/stanja - preuzimanje svih stanja
1.3 Na nivou API-ja validirati sledeće sledeće stavke:
• Da naziv zadatka nije prazan string ili null vrednost
• Da je dužina naziva zadatka maksimalno 40 karaktera
• Da polje zaduženi nije prazan string ili null vrednost
• Da vrednost procenjenog vremena nije manja od jednog sata (1 h)2.1 Obezbediti unos novog zadatka, na novoj stranici. Nakon unosa vrednosti u polja prikazana na
slici 1. i klika na dugme dodaj, zadatak se preko API-ja dodaje u aplikaciju, a korisnik se
preusmerava na stranicu za prikaz zadataka.
Slika 1
Slika 2
2.2 Obezbediti brisanje zadatka. Nakon klika na dugme obriši u tabeli za prikaz zadataka (slika 2),
zadatak se briše iz aplikacije i uklanja iz tabele.
2.3 Obezbediti izmenu zadatka u zasebnoj stranici. Nakon klika na dugme izmeni, podaci o zadatku se
prikazuju u zasebnoj stranici koja omogućava čuvanje izmena. Ukoliko korisnik odabere da sačuva
podatke, izmenjeni podaci se čuvaju u aplikaciji i prelazi se na stranicu za unos i prikaz zadataka.2.4 Obezbediti pretragu zadataka, preko forme (slika 2). Prilikom pretrage korisnik može da unese,
naziv zadatka, ime zaduženog, i projekat (drop-down meni sa nazivima projekata, dok se
pretraga u pozadini vrši po id-u projekta). Pronalaze se i prikazuju zadaci koje zadovoljavaju sve
kriterijume. Ukoliko korisnik neko polje ne unese, vrednost tog polja se ignoriše u pretrazi. Filtriranje
se vrši na back-end delu aplikacije. Uz formu za pretragu, stoji dugme koje poništava pretragu, tj.
briše unete parametre i osvežava tabelu.
2.5 Obezbediti paginirani prikaz podataka. Dugme prethodno i dugme sledeće iznad tabele za prikaz
zadataka (slika 2) omogućuju promenu stranice. Ukoliko se korisnik nalazi na prvoj stranici
onemogućiti dugme prethodno, a, ukoliko se nalazi na poslednjoj onemogućiti dugme sledeće.
Paginacija se vrši na na back-end delu aplikacije, a jedna stranica sadrži maksimalno četiri (4)
zadatka.
3. Implementirati promenu stanja zadatka. Prilikom kreiranja samog zadatka, zadatku se zadaje
inicijalno stanje, npr. “nov” (na back-end delu aplikacije). Na stranici za prikaz zadataka (slika 2), u
tabeli uz svaki zadatak stoji dugme “Pređi u sledeće stanje”, koje prevodi zadatak u sledeće stanje (npr.
iz stanja “nov” u stanje “u-toku”, ili iz stanja “u-toku” u stanje “završen”). Prelaz između stanja se vrši
na back-end strani aplikacije. Kada je zadatak u svom finalnom stanju (npr. “završen”), dugme se
onemogućava.
4. Implementirati prikaz ukupne procene sati za zadatke koji zadovoljavaju parametre pretrage na
trenutnoj stranici. Na front-end-u se ukupni sati prikazuju korisniku ispod tabele. Samo izračunavanje
se dešava na nivou servisa na back-end-u. Izračunata vrednost se na front-end propagira kroz HTTP
zaglavlje odgovora kojim se prenose zadaci na front-end.
