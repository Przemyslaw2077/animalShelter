INSERT INTO
    Animal_adopter(first_name, last_name, telephone_number)
values
    ('Marcin', 'Błaszczyk', '123334553'),
    ('Andrzej', 'Szklarski', '88689009'),
    ('Kondrad', 'Starosta', '344548600');

INSERT INTO
    Dog(name, species, gender, age, size, description, race, adopted, animal_adopter_id)
VALUES
    ('Benia', 'DOG', 'SHE', 'YOUNG', 'BIG', 'Benia to około roczna sunia.
        Sunia jest przyjacielska, nieagresywna jeśli chodzi o ludzi.
        Rozpoczęła naukę chodzenia na smyczy.
        Potrzebuje terenu aby mogła się wybiegać.','GERMAN_SHEPHERD', 'true', 1),

    ('Krysia', 'DOG', 'SHE', 'ADULT', 'BIG', 'Całe swoje życie była przeganiana i straszona.
        Błąkała się od wsi do wsi w poszukiwaniu jedzenia.
        Udało nam się odłowić Krysię.
        Potrzebny jest jej czas, dużo pracy i socjalizacji.','DALMATIAN', 'false', NULL),

    ('Max', 'DOG', 'HE', 'OLD', 'SMALL', 'Max w warunkach schroniskowych dał się poznać jako pies trudny i przejawiający agresję.
        Ponad życie uwielbia spacery, na widok smyczy skacze i cieszy się bardzo. Wtedy pozwala na zapięcie na smycz.
        Max bardzo lubi inne psy.','PEKINGESE', 'false', NULL),

    ('Iskierka', 'DOG', 'SHE', 'ADULT', 'SMALL', 'Iskierka to mała/średnia pogodna suczka. Jest bardzo energiczna, lubi ludzi, spacery, głaskanie, i pieszczoty. W boksie grzecznie czeka na zapięcie smyczy i otwarcie drzwiczek na spacerek.
        Ale czasem potrafi być z niej i rozrabiaka.','LABRADOR_RETRIEVER', 'false', NULL),

    ('Hańcza', 'DOG', 'SHE', 'YOUNG', 'MEDIUM', 'Hańcza to młoda suczka, która wróciła do schroniska z nieudanej adopcji. Sunia jest wesoła i towarzyska.
        Od pierwszych chwil w schronisku czuje się jak u siebie. Sunia umie chodzić na smyczy.
        Hańcza dobrze dogaduje się z kolegą z boksu.','LABRADOR_RETRIEVER', 'false', NULL),

    ('Luna', 'DOG', 'SHE', 'ADULT', 'MEDIUM', 'Zapatrzona w opiekuna, toleruje inne psy, koty też jej nie przeszkadzają.  Uwielbia spacery po lesie i bardzo pomaga innym psom, które przeżyły jakąś traumę.
        Ma w sobie coś takiego, że je przyciąga do siebie.','GERMAN_SHEPHERD', 'false', NULL),

    ('Roki', 'DOG', 'HE', 'OLD', 'SMALL', 'Roki to przekochany pies, jest łagodny, spokojny, ale też potrafi nabrać rozpędu bawiąc się i szalejąc jak szczeniak. :) Uwielbia spacery.
        Roki ma 10 lat, waży ok 28kg, jest niskopodłogowy, sięga do kolana.','PEKINGESE', 'false', NULL),

    ('Timo', 'DOG', 'HE', 'OLD', 'MEDIUM', 'Timo, Cichutki, spokojny, naprawdę nie wadzi nikomu. Dopiero niedawno poznał dotyk, przez który przemawia miłość. I chyba to polubił. :)
        w domu umie zostać sam. Leży sobie wtedy w swoim legowisku i drzemie.
        I nie nabrudzi!','BERNARD', 'false', NULL);

INSERT INTO
    Cat(name, species, gender, age, size, description, race, adopted, animal_adopter_id)
VALUES
    ('Miętus', 'CAT', 'HE', 'OLD', 'BIG', 'Miętus to 10 letni kocurek. Przyjechał do nas 6.03.2022 z Lwowa. To większy spokojny, kocurek którego największą przyjemnością jest dobra saszetka za którą ,,zrobi wszystko",
        taki łasuszek z niego i oczywiście najbardziej pragnie uwagi człowieka.','PERSIAN_CAT', 'false', NULL),

    ('Penny', 'CAT', 'SHE', 'ADULT', 'MEDIUM', 'Penny przeżyła bolesny wypadek, niestety nigdy nie dowiemy się jaki, miała połamaną miednicę. Poza tym jej stan ogólny był zły: wychudzona, wygłodniała.
        Na szczęście leczenie nie trwało długo i kotka szybko stanęła na nogi.','HIMALAYAN_CAT', 'false', NULL),

    ('Platyna', 'CAT', 'SHE', 'ADULT', 'SMALL', 'Platyna to kotka znaleziona na terenie gminy Wieliszew. Kicia w pierwszym kontakcie z człowiekiem jest trochę nieufna i ostrożna, ale szybko przełamuje swoje lęki i pokazuje swoją przyjacielską naturę.
        Lubi mizianki i drapanko po szyjce.','PERSIAN_CAT', 'false', NULL),

    ('Cytrus', 'CAT', 'HE', 'YOUNG', 'MEDIUM', 'Szukamy odpowiedzialnego domu dla bardzo towarzyskiego kota. Kotek ma roczek,ma na imię Cytrus. Jest wykastrowany,odrobaczony i zaszczepiony.Akceptuje psy i koty.
        Ogólnie jest bardzo towarzyski nie boi się obcych każdego wita odrazu przy drzwiach.','SIBERIAN_CAT', 'false', NULL),

    ('Kredka', 'CAT', 'SHE', 'YOUNG', 'SMALL', 'Kredka to koteczka znaleziona razem z dziećmi na terenie Miasta Sochaczew. Kicia jest troszkę onieśmielona i zachowuje ostrożność w kontaktach z nowymi opiekunami.
        Jednak gdy ma ochotę na odrobinę bliskości pozwala nam na delikatne przytulanki.','EUROPEAN_CAT', 'false', NULL),

    ('Traszka', 'CAT', 'SHE', 'YOUNG', 'MEDIUM', 'Ten wspaniały gość, czeka na ciepły dom i rodzinę.
        No dobra, to teraz będziemy słodzić.
        Poznajcie Traszke, najbardziej "miziasto słodziastego" kota.
        Chyba nie musimy przekonywać nikogo, że nasz Urwis to fajny chłopak.','SIAMESE_CAT', 'false', NULL),

    ('Bilon', 'CAT', 'HE', 'ADULT', 'BIG', 'Ten wspaniały gość, czeka na ciepły dom i rodzinę.
        Kot całe swoje życie spędził w gospodarstwie gdzie był przeganiany i źle traktowany, schronienie udzieliła mu Pani, która zgłosiła nam chorego kota.
        Obiecaliśmy biedakowi spokojne życie.','HIMALAYAN_CAT', 'false', NULL),

    ('Tomasz', 'CAT', 'HE', 'OLD', 'BIG', 'Tomasz to wspaniały, dorosły kocurek.
        Miłośnik spania i jedzenia. To taki duży, spokojny misiu, który kocha wszystkich. W pierwszym kontakcie bywa nieśmiały ale szybko się przełamuje i domaga się pieszczot.
        Taki kot to prawdziwy skarb.','EUROPEAN_CAT', 'false', NULL);

INSERT INTO
    Employee(id, first_name, last_name, user_name, password)
VALUES
--     easypass
    (1, 'Jan', 'Tomczyk', 'Jtomczyk22', '{bcrypt}$2a$12$lnxxt7PWadwuBOD265Pvm.R.7vVI0Rrll3HtcBvHD2OFv8afh3oKu'),
--     hard
    (2, 'Jakub', 'Kowal', 'Jkowal33', '{bcrypt}$2a$10$Ruu5GtmSVkfLeuGfz/wHUuzflCcMbwJHSBo/.Wui0EM0KIM52Gs2S'),
--     hardpass
    (3, 'Jacek', 'Malinowski', 'Jmalinowski44', '{bcrypt}$2a$12$NJjb7wDuTNs.zCY43oi0D.t3SRxww6pfubH6jXQGRtRdItw6wQYC.');

insert into user_role(id, role, description)
values (1, 'USER_ROLE', 'default');

insert into roles(user_id, role_id)
values (1, 1),
       (2, 1),
       (3, 1);
INSERT INTO
    adoption_history(employee_id, cat_id, dog_id, adopter_id, adopt_date)
VALUES

    (1,null,1,1,'2022-05-08 16:00:00')
