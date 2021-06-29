package de.hdmstuttgart.fitnessapp.database

import de.hdmstuttgart.fitnessapp.database.entities.Discipline
import de.hdmstuttgart.fitnessapp.database.entities.Exercise

object TableData {

    val listOfExercises = listOf<Exercise>(
        Exercise(
            101,
            "Achter-Lauf",
            "Die Athleten laufen in einer Reihe oder einzeln an den Hüttchen in Form einer, auf dem bodenliegende, Acht herum. Variation: Als erstes kann man die Übung so verändern, dass nach jedem dritten Schritt abgesprungen wird. Zudem wäre es noch eine Möglichkeit das Absprung und/oder Landebein zu bestimmen. Als zweites kann man den Absprung auf die Markierungen festlegen und zwei Markierungen wegnehmen. Sodas die Athleten immer an den Markierungen in der Kurve hochspringen. Auch hier kann man das Sprungbein",
            "3 - 5 Hüttchen",
            "Hüttchen in der Form einer Acht auf dem Boden verteilen benötigt werden dazu 5 Markierungen auf dem Boden.",
            "Alle in einer Reihe",
            10,
            1
        ),
        Exercise(
            102,
            "Klosprünge",
            "Die Athleten sollen sich mit dem Rücken zur Matte an die Markierung stellen. Dann sollen sie mit einem Sprung nach hinten (über die Schnur) auf die Matte springen. Dabei sollte auf die richtige Körperhaltung geachtet werden. Sie sollten keinen Katzenbuckel machen und beim Absprung sollen die Knie auch weiterhin nach vorne schauen.",
            "2 Hütchen",
            "Zwei Hüttchen mit ein Wenig Abstand vor die Matte stellen. Es kann eine Schnur gespannt werden über die gesprungen werden soll.",
            "zwei Reihen einteilen",
            10,
            1
        ),
        Exercise(
            103,
            "Sprünge mit Anlauf",
            "Die Athleten sollten zunächst einige Male mit drei Schritten in Richtung der Matte anlaufen und dann zunächst erstmal parallel zur Matte/Schnur hochspringen. Die Anzahl der Schritte kann man gegebenenfalls auch erhöhen.    Variation: Um möglichst die besten Resultate, beim Abspringen, zu erzielen ist es möglich sich selber auf die Matte zu stellen und sich von den Athleten per High-Five abklatschen zu lassen. ",
            "-aufgebaute Hochsprunganlage - zwei Hütchen auf jeder Seite eins für den Anlauf",
            "Hier variiert der Aufbau je nach Anzahl der Schritte welche gemacht werden sollen. Je nachdem wird das Hüttchen weiterweg von der Matte aufgestellt",
            "Aufteilung nach Sprungbein",
            10,
            1
        ),
        Exercise(
            104,
            "Sprünge mit Anlauf über die Matte",
            "Zuerst sollen die Athleten mit drei Schritten in Richtung der Matte anlaufen und dann sollen sie mittels des Scherensprungs über die gespannte Schnur springen.                                                                                                                                                                    Variation:                                                                                                                                                                                                                      Auch hier kann man das Hüttchen nach hinten verschieben um die Anzahl der Schritte zu erhöhen zunächst auf fünf und danach auf sieben. Auch die höhe der Schnur kann individuell angepasst werden.\n" +
                    "Bei dem Anlauf mit sieben Schritten ist es wichtig darauf zu achten, dass die Athleten richtig anlaufen. Sprich zunächst einmal gerade um Tempo aufzubauen und dann mit einer kleiner Kurve in Richtung Matte abbiegen um dann darüber zu springen.\n" +
                    "Auch die Sprungart als solches kann man verändern und auf den Flop umstellen.",
            "ein Hütchen pro Sprungbahn",
            "- aufgebaute Hochsprunganlage - zwei Hütchen auf jeder Seite eins für den Anlauf",
            "Aufteilung nach Sprungbein",
            30,
            1
        ),
        Exercise(
            105,
            "Standsprung",
            "Die Athleten springen von möglichst weit vorne aus dem Stand heraus in die Sandgrube.  Drauf zu achten ist, dass die Athleten ungefähr Schulterbreit dastehen und denn Schwung aus der Hocke mit dem ganzen Körper beim Sprung mitnehmen sollen.",
            "ein Hütchen pro Sprungbahn",
            "Ein Hütchen ganz vorne am Rand für jede Bahn bei der es möglich ist zu springen",
            "Aufteilung um ungefähr gleich große Gruppen zu bekommen",
            10,
            2
        ),
        Exercise(
            106,
            "Standsprung",
            "Die Athleten springen von möglichst weit vorne aus dem Stand heraus in die Sandgrube.  Drauf zu achten ist, dass die Athleten ungefähr Schulterbreit dastehen und denn Schwung aus der Hocke mit dem ganzen Körper beim Sprung mitnehmen sollen.",
            "ein Hütchen pro Sprungbahn",
            "Ein Hütchen ganz vorne am Rand für jede Bahn bei der es möglich ist zu springen",
            "Aufteilung um ungefähr gleich große Gruppen zu bekommen",
            10,
            2
        ),
        Exercise(
            107,
            "Landung im Stuhl",
            "Die Athleten springen mit einem Anlauf von drei Metern in die Sandgrube. Das wichtige bei dieser Übung ist weniger der Sprung als die besondere Landung. Bei der Landung ist das Sprungbein am Ende hinten und berührt mit dem Knie den Sand und das andere Bein ist vorne aufgestellt auf den Fuß. Die Athleten sollten nach der Landung in dieser Position bleiben und nicht umkippen.",
            "- Hütchen pro Sprungbahn abgemessen mit drei Schritten aufstellen",
            "Eine Markierung für einen kurzen Anlauf von ungefähr drei Schritte.",
            "Aufteilung um ungefähr gleich große Gruppen zu bekommen",
            15,
            2
        ),
        Exercise(
            108,
            "Steigesprünge",
            "Die Athleten starten an der Markierung und springen nach einem Anlauf von drei Schritten mit einem Bein ab. Wichtig ist es bei dieser Übung, dass die Athleten sich versuchen möglichst kräftig abzudrücken und nach Oben zu springen.  Als mögliches Hilfsmittel kann eine kleine Hürde oder ein anderweitiges Hindernis in die Sandgrube gestellt werden die Übersprungen werden muss. Hierbei kann dann sowohl die Höhe wie auch die Entfernung des Hindernisses verändert werden.",
            "- Ein Hütchen pro Sprungbahn um Anlauf zu kennzeichnen - Eventuell eine Hürde oder anderes Hindernis pro Sprungbahn",
            "Eine Markierung um einen ungefähren Anlauf von drei Schritten zu kennzeichnen auf den Boden legen um den Startpunkt zu markieren.",
            "Aufteilung um ungefähr gleich große Gruppen zu bekommen",
            20,
            2
        ),
        Exercise(
            109,
            "",
            "Die Anzahl der Schritte des Anlaufes die durch die Markierungen gekennzeichnet werden. Die Anzahl der Schritte sollte bei drei beginnen dann auf fünf steigen und zuletzt bis sieben hochgeben. Die Markierungen sind dafür da die Stellen zu markieren an welchen die Athleten ihre Schritte setzen sollen. Die letzten drei Schritte sollten etwas enger gesetzt sein, da diese gewollt etwas kleiner gesetzt werden sollen um beim Absprung einen besseren Winkel zum Abdrücken zu haben. Durch die Übung soll genau, dass trainiert werden. Bei den etwas längeren Anläufen sollte darauf geachtet werden, dass die Athleten auch wirklich auf volles Tempo beschleunigen.",
            "- drei rutschfeste Markierungen  pro sprungbahn",
            "Es werden einige rutschfeste Markierungen auf den Boden gelegt. Es kommt auf die gewollte Schrittanzahl an wie viele dieser Markierung benötigt werden.",
            "Aufteilung um ungefähr gleich große Gruppen zu bekommen",
            20,
            2
        ),
        Exercise(
            110,
            "Sprünge mit individuellem Anlauf",
            "Die Athleten sprinten von ihrer Markierung aus richtig Grube und springen im besten Fall auf dem Brett ab in die Grube. Sollte der Anlauf nicht stimmen kann korrigierend eingegriffen werden durch ein Verschieben des Anlaufes nach vorne oder hinten. Das wichtigste ist hierbei allerdings auf die richtige Technik sowohl beim Absprung wie auch beim Flug und der Landung zu achten. Beim Flug ist es wichtig die Beine mit nach oben zu nehmen und sie auch oben zu halten. Bei der Landung ist besonders bei jüngeren Athleten darauf zu achten, dass sie nicht nach hinten kippen.",
            "- ein Hütchen pro Athlet ",
            "pro Athlet eine Markierung die den jeweiligen Anlauf kennzeichnen soll.",
            "Aufteilung um ungefähr gleich große Gruppen zu bekommen",
            25,
            2
        ),
        Exercise(
            111,
            "",
            "",
            "",
            "",
            "",
            10,
            2
        ),
        Exercise(
            112,
            "Lauf-Ringe",
            "Die Athleten sprinten eine gerade Strecke entlang auf welcher die Ringe liegen. Es wird versucht beim Beschleunigen in jeden Ring zu treten, ihn aber nicht wegzutreten. Der Sinn dahinter ist die Athleten mit zunehmend gelaufener Strecke zu größeren Schritten zu zwingen da die Ringe eine immer größere Entfernung haben. \n" +
                    "Die Anzahl der Ringe sowie der Abstand kann mit der Zeit erhöht werden immer den oben genannten Effekt zu verstärken.\n",
            "- 10 Ringe pro Bahn später erweiterbar                                                       - eine Markierung für den Start",
            "Es werden einige Ringe auf den Boden gelegt. Zwischen den Ringen wird immer ein bisschen Platz gelassen, dieser Platz wird mit jedem Ring allerdings größer",
            "Aufteilung um ungefähr gleich große Gruppen zu bekommen",
            25,
            3
        ),
        Exercise(
            113,
            "Karten-Laufspiel",
            "Der Trainer nimmt eine Auswahl der Karten vor entweder nach Farben oder Zeichen die es im Spiel gibt. Es werden mindestens zwei Gruppen gebildet, sollte die Anzahl der Athleten zu groß sein kann man auch mehr Gruppen bilden. Jede Gruppe bekommt entweder eine Farbe oder ein Zeichen zugewiesen je nachdem was vorne hingelegt wurde.\n" +
                    "Nach dem ein Startsignal gegeben wurde rennt eine Person aus jeder Gruppe gleichzeitig nach vorne und dreht eine Karte um. Wenn es das Zeichen oder die Farbe der Gruppe ist darf die Karte mit zurück genommen werden. Sollte es die falsche Karte sein muss die Karte wieder umgedreht werden. Danach rennt die Person wieder zurück zu ihrer Gruppe und wenn sie angekommen ist darf die nächste Person los. Das Ende kann variabel festgelegt werden, je nachdem wie viele Karten die einzelnen Gruppen sammeln sollen.\n",
            "- ein Karten-Set /n -Markierungen für den Start",
            "Benötigt wird ein ganz normales Kartenset. Die Karten werden mit einem Abstand von gut 20 Metern zu den Athleten umgedreht auf den Boden gelegt.",
            "gleich große Teams",
            20,
            3
        ),
        Exercise(
            114,
            "Sprint-Starts",
            "Die Athleten stellen sich an ihrer Markierung auf. Auf ein Startsignal hinweg sprinten die Athleten zu der Markierung am Ende. Durch, dass verändern der Startposition zum Beispiel in eine liegende Position kann durch die Kreativität des Trainers die Übung interessant gehalten werden. Außerdem kann durch eine veränderte Startposition auch verschiedenes trainiert werden, wie zum Beispiel auch die Reaktionsschnelligkeit und nicht nur die Schnellkraft.",
            "- ein Hütchen ",
            "Für jeden Athleten wird eine Markierung auf den Boden gelegt. Und eine Markierung wird auf die Höhe des Endes gelegt",
            "Auf jede Bahn ein Athlet",
            15,
            3
        ),
        Exercise(
            115,
            "„Sprint-Parkour“",
            "Der Aufbau kann wie bereits beschrieben variieren. Das wichtigste ist immer wieder verschiedene Richtungswechsel sowie Bewegungsmusterwechsel in die Strecken einzubauen.Zum Beispiel wird mit einer kurzen geraden Strecke für den Sprint angefangen. Danach soll ein kurzer Seitgalopp nach links ausgeführt werden danach soll wieder gesprintet werden. So können immer weiter verschiedene Übungen aneinandergereiht werden. Der Sinn ist es dabei mit den Übungen und den Richtungswechseln den Schwung zu nehmen damit der Athlet in immer wieder neu aufnehmen muss bei jedem Sprint.",
            "- mehrere Hütchen /n - Hürden /n - Hindernisse",
            "Dieser kann variieren je nachdem wie der Trainer es insgesamt aufbauen möchte.",
            "Alle in einer Reihe ",
            15,
            3
        ),
        Exercise(
            116,
            "Intervallsprints",
            "Die Athleten stellen sich auf einer der Seiten an die Hütchen auf Kommando sprinten sie zu den auf der anderen Seite stehenden Hütchen. Auf dem Weg zurück zum Start können sie etwas gehen um wieder zu Atem zu kommen. Die Übung kann bis zu 10-mal wiederholt werden.",
            "-zwei Reihen Hüttchen in der Anzahl der Athleten",
            "Auf zwei gegenüberliegenden Seiten werden Reihen mit Hütchen aufgestellt mit einem Abstand von ungefähr 60 m",
            "jeder Athlet an ein Hütchen",
            15,
            3
        ),
        Exercise(
            117,
            "Hütchen-Sprints",
            "Die Athleten beginnen in der ersten Runde indem sie die zwei Hütchen zum Start mit einem schnellem Seitgallop antippen. Danach bewegen sie sich seitlich schräg durch die Hütchen durch und sprinten dann aus dieser Bewegung heraus zum Ziel-Hütchen.",
            "-zwei Start-Hütchen /n -pro Reihe in der Bahn 3 Hütchen /n - ein Ziel-Hütchen",
            "Es werden zwei Hütchen links und rechts mit einem knappen Abstand von ungefähr 4-5 m zueinander aufgestellt. Hintendran wird eine kleine Bahn von Hütchen aufgestellt. Als Ziel wird ein Hütchen mit einem Abstand von etwa 10-15 m zu der Bahn aufgestellt.",
            "je nach Anzahl kann eine zweite Bahn aufgebaut werden. Grundsätzlich ist es eine Einzelübung",
            15,
            3
        ),
        Exercise(
            118,
            "",
            "Die Athleten stellen sich am Rand zum Feld auf mit Blickrichtung zum Feld hin. Die Athleten nehmen die Kugel in beide Hände und gehen damit ein wenig in die Knie, der Rücken soll gerade sein.Aus dieser Position heraus nehmen sie Schwung um die Kugel nach vorne hinweg in das Feld werfen. Wichtig ist das die Athleten die Bewegung mit dem ganzen Körper mitmachen und im besten Fall mit der Kugel mit einen kleinen Sprung in die selbe Richtung mitgehen.",
            "- eine Kugel pro Athlet",
            "Die Athleten sollen sich an der Feld aufstellen mit ihrer Kugel",
            "in kleine Gruppen einteilen á 2-3 Personen",
            10,
            4
        ),
        Exercise(
            119,
            "Über-Kopf-Wurf",
            "Die Athleten stellen sich am Rand zum Feld auf mit Blickrichtung weg vom Feld. Die Athleten nehmen die Kugel in beide Hände und gehen damit ein wenig in die Knie, der Rücken soll gerade sein. Aus dieser Position heraus nehmen sie Schwung um die Kugel nach hinten weg über ihren Kopf hinweg in das Feld werfen. Wichtig ist das die Athleten die Bewegung mit dem ganzen Körper mitmachen und im besten Fall mit der Kugel mit einen kleinen Sprung in die selbe Richtung mitgehen.",
            "- eine Kugel pro Athlet",
            "Die Athleten sollen sich an der Feld aufstellen mit ihrer Kugel mit Blickrichtung weg von der Kugel",
            "in kleine Gruppen einteilen á 2-3 Personen",
            10,
            4
        ),
        Exercise(
            120,
            "Standstoßen",
            "Die Athleten stellen sich am Rand zum Feld auf. Die Rechtshänder stellen sich mit dem linken Fuß nach vorne auf und die Linkshänder mit dem rechten Fuß nach vorne. Die Kugel wird an den Hals gelegt. Die Hand mit der gestoßen wird liegt etwas hinter der Kugel. Der Ellbogen sollte nicht angelegt sein sondern vom Körper weggerichtet sein. Aus dieser Position heraus versucht der Athlet nun die Kugel zu stoßen. Es sollte darauf geachtet werden, dass die Kugel so lange wie möglich am Hals gehalten wird und der Athlet auch beim stoßen groß bleibt. ",
            "- eine Kugel pro Athlet",
            "Die Athleten sollen sich an der Feld aufstellen mit ihrer Kugel",
            "in kleine Gruppen einteilen á 2-3 Personen",
            20,
            4
        ),
        Exercise(
            121,
            "Vorübung für den Anlauf",
            "Die Athleten stellen sich am Rand zum Feld auf und drehen sich mit dem Körper weg vom Feld. Die Rechtshänder haben ihr rechtes Bein vorne und verlagern ihr Gewicht auf das Bein für LInkshänder entsprechend das andere Bein. Die Fussspitzen zeigen in die gleiche Richtung leicht zur Seite weg. Die Kugel wird an den Hals gelegt. Die Hand mit der gestoßen wird liegt etwas hinter der Kugel. Der Ellbogen sollte nicht angelegt sein sondern vom Körper weggerichtet sein. Aus dieser Position heraus dreht sich der Athlet nun von den Füßen beginnt in einem Schwung Richtung des Feldes um die Kugel zu stoßen. Es sollte darauf geachtet werden, dass die Kugel so lange wie möglich am Hals gehalten wird und der Athlet auch beim stoßen groß bleibt.",
            "- eine Kugel pro Athlet",
            "Die Athleten sollen sich am Rand des Feldes aufzustellen mit ihrer Kugel",
            "in kleine Gruppen einteilen á 2-3 Personen",
            25,
            4
        ),
        Exercise(
            122,
            "Nachzieh-Anlauf",
            "",
            "- eine Kugel pro Athlet",
            "",
            "in kleine Gruppen einteilen á 2-3 Personen",
            25,
            4
        ),
        Exercise(
            123,
            "Koordinationsleiter- Läufe",
            "Die Athleten gehen auf verschiedener Art und Weise durch die Leiter. Der Kreativität ist bei den Bewegungsabläufen eigentlich keine Grenze gesetzt. Um ein paar Beispiele aufzulisten: 1. Die Anzahl der Kontakte in jedem Feld variiren von 1-3 oder auch noch mehr. 2. seitlich an die Leiter stellen und dann einen Fuß in das erste Feld setzen, dann mittels Wechslesprung immer zwei Kontakte pro Feld machen. 3. mittels schnellen seitlichen Bewegungen durch die Felder gehen. Also auf einer Seite der Leiter aufstellen und dann im Seitgalopp durch bis auf die Rechte Seite. Außerhalb und innerhalb des Feldes der Leiter können die Kontakte frei definiert werden. ZUm Abschluss an der Übung innerhalb der Leiter ist jeweils ein Sprint bis zum Hütchen zu machen.",
            "-2 - 3 Koordinationsleitern                                                                                                                                                                            - entsprechend der Anzahl der Leitern jeweils 2 Hütchen",
            "Die Koordinationsleitern auf dem Boden auslegen ein Hütchen für den Start vor der Leiter aufstellen. Ein Hütchen als Ziel aufstellen etwa 10 - 15 Meter entfernt aufstellen.",
            "aufgeteilt auf die vorhandenen Leitern in kleinere Gruppen ",
            20,
            5
        ),
        Exercise(
            124,
            "Koordinationsleiter- Sprünge",
            "Die Athleten gehen auf verschiedener Art und Weise durch die Leiter. Der Kreativität ist bei den Bewegungsabläufen eigentlich keine Grenze gesetzt. Um ein paar Beispiele aufzulisten: 1. mit geschlossenen Beinen durch jedes Feld in der Leiter springen. Als Variation kann man gleich ergänzen, dass auch mit geöffneten Beinen gesprungen werden kann, hierbei sollte man auf den Sprung achten. 2. Es sind im Grunde genommen die gleichen Sprünge wie im ersten Beispiel allerdings kann man noch ergänzen, dass mit den Sprüngen auch Felder ausgelassen werden können. Sprich es soll nur in jedes zweite/dritte Feld gesprungen werden. Dort kann noch ergänzt werden ,dass auch noch Sprünge wieder zurück möglich wären als Variation. 3. Die Sprünge können natürlich auch so auf einem Bein gemacht werden. Als Variation kann man hier die bereits im Beispiel 2 genannte Möglichkeit verwenden. Zudem kann man hier bei den Sprüngen auch die Beine in den Feldern wechseln. ",
            "-2 - 3 Koordinationsleitern /n - entsprechend der Anzahl der Leitern jeweils 2 Hütchen",
            "Die Koordinationsleitern auf dem Boden auslegen ein Hütchen für den Start vor der Leiter aufstellen. Ein Hütchen als Ziel aufstellen etwa 10 - 15 Meter entfernt aufstellen.",
            "aufgeteilt auf die vorhandenen Leitern in kleinere Gruppen ",
            20,
            5
        ),
        Exercise(
            125,
            "Linien-Sprünge",
            "",
            "",
            "Hierfür ist kein Aufbau nötig. Nur genug Linien und Platz für jeden Athleten.",
            "aufgeteilt auf die vorhandenen Lienen in kleinere Gruppen ",
            15,
            5
        ),
        Exercise(
            126,
            "Aufwärmen mit dem Speer",
            "Die Athleten stellen sich mit dem Speer in einem großen Kreis auf. Der Abstand sollte zwischen den Athleten groß genug sein damit sie sich nicht gegenseitig mit dem Speer treffen. Die Übungen sollen die Arme aufwärmen und mobilisieren. Übung 1 : Der Speer wird mit beiden Händen gehalten welche etwas weiter auseinander sind. Dann wird der Speer über den Kopf nach Hinten an den Rücken bewegt und dann wieder zurück vor der Körper bewegt. Der Speer wird die ganze Zeit in der gleichen Position gehalten. Übung 2 : Der Speer wird genau so gehalten wie in Übung 1, allerdings wird der Speer nun in Schräglage in einem Kreis um den Körper herum bewegt. Die Richtung des kreisens sollte abgewechselt werden. Übung 3 : Der Speer wird hinter dem Kopf auf die Schultern gelegt. Der Athlet stellt sich Hüftbreitmit den Beinen hin und versucht mit der Spitze des Speers an die gegenüberliegende Fußspitze zu kommen. Natürlich gibt es noch viel mehr Möglichkeiten den Oberkörper und die Arme aufzuwärmen, dies sind nur ein paar Beispiele hierfür",
            "- ein Speer für jeden Athleten",
            "Ein Speer für jeden Athleten und dann im Kreis aufstellen lassen mit genug Abstand zueinander",
            "- Die komplette Gruppe mit dem jeweils eigenen Speer",
            20,
            6
        ),
        Exercise(
            127,
            "Standwurf mit beiden Händen ",
            "Die Athleten stellen sich mit dem Speer an den Rand eines Feldes auf. Der Stand sollte hierbei Hüftbreit sein und der Speer wird in beide Hände genommen. Die Athleten sollen nun beim Wurf schwung holen mit dem Oberköper aus einer Haltung heraus die an ein \"C\" erinnern soll. Der Speer wird dabei mit beiden Händen über den Kopf genommen. Aus der Bewegung mit dem Oberkörper kann wird der Speer nun geworfen.",
            "- ein Speer für jeden Athleten",
            "Ein Speer für jeden und dann am Rand zum Rasen mit genug Abstand zu den Nebenleuten aufstellen. ",
            "- Die Athleten alle zusammen in einer Reihe  ",
            10,
            6
        ),
        Exercise(
            128,
            "",
            "",
            "",
            "",
            "",
            10,
            4
        ),
        Exercise(
            128,
            "",
            "",
            "",
            "",
            "",
            10,
            4
        ),
        Exercise(
            128,
            "",
            "",
            "",
            "",
            "",
            10,
            4
        ),
        Exercise(
            128,
            "",
            "",
            "",
            "",
            "",
            10,
            4
        ),
        Exercise(
            128,
            "",
            "",
            "",
            "",
            "",
            10,
            4
        ),
        Exercise(
            128,
            "",
            "",
            "",
            "",
            "",
            10,
            4
        ),
        Exercise(
            128,
            "",
            "",
            "",
            "",
            "",
            10,
            4
        ),
        Exercise(
            128,
            "",
            "",
            "",
            "",
            "",
            10,
            4
        ),
        Exercise(
            128,
            "",
            "",
            "",
            "",
            "",
            10,
            4
        ),
        Exercise(
            128,
            "",
            "",
            "",
            "",
            "",
            10,
            4
        ),
        Exercise(
            128,
            "",
            "",
            "",
            "",
            "",
            10,
            4
        ),
        Exercise(
            128,
            "",
            "",
            "",
            "",
            "",
            10,
            4
        ),
        Exercise(
            128,
            "",
            "",
            "",
            "",
            "",
            10,
            4
        ),
        Exercise(
            128,
            "",
            "",
            "",
            "",
            "",
            10,
            4
        ),
        Exercise(
            128,
            "",
            "",
            "",
            "",
            "",
            10,
            4
        ),

    )

    private var listOfDisciplines = listOf<Discipline>(
        Discipline(1, "Hochsprung"),
        Discipline(2, "Weitsprung"),
        Discipline(3, "Sprint"),
        Discipline(4, "Kugelstoßen"),
        Discipline(5, "Koordination"),
        Discipline(6, "Speer"),
        Discipline(7, "Diskus"),
        Discipline(8, "Kraft"),
        Discipline(9, "Einleitung"),
        Discipline(10, "Schluss")
    )

    fun populateExerciseTable(): List<Exercise> {
        return listOfExercises
    }

    fun populateDisciplineTable() : List<Discipline>{
        return listOfDisciplines
    }
}