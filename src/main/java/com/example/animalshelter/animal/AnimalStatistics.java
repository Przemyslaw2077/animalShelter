package com.example.animalshelter.animal;

import lombok.Getter;

public class AnimalStatistics {

    @Getter
    public enum Species{
        DOG("pies"), CAT("kot");
        private String translation;
        Species(String translation) {
            this.translation = translation;
        }
    }

    @Getter
    public enum Gender{
        SHE("ona"), HE("on");

        private String translation;

        Gender(String translation) {
            this.translation = translation;
        }
    }

    @Getter
    public enum Age{
        YOUNG("młody"), ADULT("dorosły"), OLD("stary");

        private String translation;

        Age(String translation) {
            this.translation = translation;
        }
    }

    @Getter
    public enum Size{
        SMALL("mały"), MEDIUM("średni"), BIG("duży");

        private String translation;

        Size(String translation) {
            this.translation = translation;
        }
    }

    @Getter
    public enum DogRace {
        GERMAN_SHEPHERD("Owczarek niemiecki","/img/owczarek-niemiecki.jpg","To wesoły, energiczny, czujny i lojalny pies, który wykazuje wysoką gotowość do współpracy. Owczarek niemiecki jest bardzo wytrwały, uwielbia spędzać czas ze swoimi opiekunami. Bezgranicznie ufa i oddaje się jednej, wybranej osobie, często pełni funkcję psa rodzinnego, ale nie tylko. To znakomity stróż, zaliczany do obronnych, może być więc psem patrolowym, wojskowym, tropiącym, przewodnikiem niewidomych, poszukującym osób zaginionych, narkotyków lub materiałów wybuchowych. Nie bez przyczyny owczarek niemiecki jest uznawany w wielu rankingach za jedną z najbardziej wszechstronnych ras na świecie. Warto podkreślić, że wymaga odpowiedniego szkolenia i socjalizacji na etapie szczenięctwa."),
        LABRADOR_RETRIEVER("Labrador retriever","/img/labrador.jpg","Labrador retriever to inteligentna i szybko ucząca się rasa psów. Czworonogi te są przyjacielskie, towarzyskie i dobrze czują się wśród innych zwierząt. Nadają się na psy rodzinne, a łagodny i ufny charakter labradorów sprawia, że sprawdzają się one jako doskonali kompani."),
        PEKINGESE("Pekińczyk","/img/pekinczyk.jpg","Można powiedzieć, nawiązując do ich historii pochodzenia, że pekińczyki lubią być traktowane „po cesarsku”. Są dość uparte, pewne siebie, niezależne i potrafią postawić na swoim. Raczej zachowują dystans i jeśli same nie inicjują pieszczot, nie przepadają za nimi. Jednocześnie bardzo przywiązują się do swojej ludzkiej rodziny, zwłaszcza jednego wybranego opiekuna. Wyłącznie od niego oczekują bardzo wiele czułości i ciągle mogą chcieć leżeć na jego kolanach. Jeśli odpowiednio wcześnie nie zaczniemy pracować z pekińczykiem nad jego zachowaniami i nie ustalimy odpowiednich granic, bardzo trudno może być nam je później zmienić. "),
        BERNARD("Bernardyn","/img/bernardyn.jpg","Bernardyn doskonale sprawdza się w roli stróża. Ze względu na gabaryty potrzebuje dużej przestrzeni, dlatego zaleca się wychowywać go w domu z ogrodem. Wbrew swojej posturze to zwierzę dosyć energiczne i skłonne do zabaw ruchowych. Cechuje się również wysoką inteligencją i doskonałą pamięcią, dzięki czemu idealnie nadaje się do szkoleń. Potrzebuje łagodnego, lecz stanowczego treningu, aby nauczyć się posłuszeństwa wobec opiekuna."),
        DALMATIAN("Delmatyńczyk","/img/dalmatynczyk.jpg","Dalmatyńczyk to bardzo energiczny pies, niemal zawsze chętny do zabawy. Ta rasa nie będzie odpowiednia dla osób, które nie mogą poświęcić zwierzęciu czasu na wspólną aktywność. Czworonóg będzie natomiast doskonałym kompanem osób uprawiających sporty. Chętnie towarzyszy opiekunowi podczas biegania lub jazdy rowerowej. Należy jednak pamiętać, że szczenięta dalmatyńczyka nie powinny być zmuszane do nadmiernego wysiłku. ");
        private String Translation;
        private String IMGDirectory;
        private String RaceDescription;

        DogRace(String translation, String IMGDirectory, String raceDescription) {
            Translation = translation;
            this.IMGDirectory = IMGDirectory;
            RaceDescription = raceDescription;
        }
    }

    @Getter
    public enum CatRace {
        PERSIAN_CAT("Kot perski","/img/kot-perski.jpg","Persy to koty o krępej budowie ciała, ze stosunkowo krótkimi łapami i niedługim ogonem. Ten powinien być także mocny i gruby. Głowa tych kotów jest proporcjonalnie duża i okrągła, z małymi, ale szeroko rozstawionymi oczami i uszami. Powinny mieć mocną brodę, ale z silną i prostą szczęką. Ich cechą charakterystyczną jest kryza rosnąca wokół głowy, przypominająca nieco lwią grzywę. Czoło tego kota powinno być wypukłe, z pełnymi policzkami. Podaje się, że jego średnia długość sierści to ok. 10 cm, w związku z czym wymaga on regularnej pielęgnacji. Przedstawiciele tej rasy nie szczególnie zwinni, jednak poruszają się z elegancją."),
        EUROPEAN_CAT("Kot europejski","/img/kot-europejski.jpg","Kot europejski to rasa naturalna, ale bardzo niejednolita. Właśnie dlatego określenie jednego profilu charakterologicznego tych zwierzaków jest bardzo trudne. Zazwyczaj zwierzęta te są indywidualistami, które budują relację z człowiekiem na swoich zasadach. Wiele zależy od tego, ile poświęcisz im czasu i jakie będziesz miał do nich podejście. "),
        HIMALAYAN_CAT("Kot himalajski","/img/kot-himalajski.jpg","Usposobienie kota himalajskiego jest połączeniem cech persa i syjama. Jego temperament jest raczej zrównoważony. Zwierzak ceni sobie spokój i wygodne miejsce do leżenia. Chętnie akceptuje pieszczoty i bardzo głośno mruczy. Po swoich syjamskich przodkach odziedziczył jednak pogodne usposobienie i w niektórych przypadkach może naprawdę mocno napsocić. "),
        SIAMESE_CAT("Kot syjamski","/img/kot-syjamski.jpg","Jedną z najważniejszych cech charakterystycznych kota syjamskiego jest budowa głowy. Ma ona klinowy kształt, co podkreśla ich uszy. Są trójkątne i ostro zakończone. Ich oczy mają kształt migdałów i powinny mieć głęboki, niebieski kolor. Koty mają muskularną, ale szczupłą i wydłużoną sylwetkę, co sprawia, że są dość zwinne i poruszają się z prawdziwą elegancją. To wszystko sprawia, że zwierzęta te sprawiają wrażenie zdrowych i bardzo sprawnych."),
        SIBERIAN_CAT("Kot syberyjski","/img/kot-syberyjski.jpg","Już samym wyglądem kot syberyjski sprawia wrażenie łagodnego i towarzyskiego zwierzęcia. Nigdy jednak nie wyzbył się swoich korzeni, czego dowodzi ochoczymi wypadami w poszukiwaniu ofiary. Kot syberyjski zdecydowanie posiada instynkt myśliwego, a w oddawaniu się tym przyjemnościom nie przeszkadza mu ani niska temperatura, ani deszcz czy śnieg. Nie bądź zatem zaskoczony, gdy w zupełnie niesprzyjających warunkach kot pochwali ci się przyniesioną myszką.");

        private final String Translation;
        private String IMGDirectory;
        private String RaceDescription;


        CatRace(String translation, String IMGDirectory, String raceDescription) {
            Translation = translation;
            this.IMGDirectory = IMGDirectory;
            RaceDescription = raceDescription;
        }
    }
}
