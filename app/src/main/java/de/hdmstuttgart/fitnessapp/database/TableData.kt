package de.hdmstuttgart.fitnessapp.database

import de.hdmstuttgart.fitnessapp.database.entities.Discipline
import de.hdmstuttgart.fitnessapp.database.entities.Exercise

object TableData {

    private val listOfExercises = listOf(
        Exercise(
            100,
            "Pause",
            "-",
            "-",
            "-",
            "-",
            5,
            0
        ),
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
            "Drei-Schritt-Anlauf",
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
            112,
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
            113,
            "Sprint-Starts",
            "Die Athleten stellen sich an ihrer Markierung auf. Auf ein Startsignal hinweg sprinten die Athleten zu der Markierung am Ende. Durch, dass verändern der Startposition zum Beispiel in eine liegende Position kann durch die Kreativität des Trainers die Übung interessant gehalten werden. Außerdem kann durch eine veränderte Startposition auch verschiedenes trainiert werden, wie zum Beispiel auch die Reaktionsschnelligkeit und nicht nur die Schnellkraft.",
            "- ein Hütchen ",
            "Für jeden Athleten wird eine Markierung auf den Boden gelegt. Und eine Markierung wird auf die Höhe des Endes gelegt",
            "Auf jede Bahn ein Athlet",
            15,
            3
        ),
        Exercise(
            114,
            "Sprint-Parkour",
            "Der Aufbau kann wie bereits beschrieben variieren. Das wichtigste ist immer wieder verschiedene Richtungswechsel sowie Bewegungsmusterwechsel in die Strecken einzubauen.Zum Beispiel wird mit einer kurzen geraden Strecke für den Sprint angefangen. Danach soll ein kurzer Seitgalopp nach links ausgeführt werden danach soll wieder gesprintet werden. So können immer weiter verschiedene Übungen aneinandergereiht werden. Der Sinn ist es dabei mit den Übungen und den Richtungswechseln den Schwung zu nehmen damit der Athlet in immer wieder neu aufnehmen muss bei jedem Sprint.",
            "- mehrere Hütchen /n - Hürden /n - Hindernisse",
            "Dieser kann variieren je nachdem wie der Trainer es insgesamt aufbauen möchte.",
            "Alle in einer Reihe ",
            15,
            3
        ),
        Exercise(
            115,
            "Intervallsprints",
            "Die Athleten stellen sich auf einer der Seiten an die Hütchen auf Kommando sprinten sie zu den auf der anderen Seite stehenden Hütchen. Auf dem Weg zurück zum Start können sie etwas gehen um wieder zu Atem zu kommen. Die Übung kann bis zu 10-mal wiederholt werden.",
            "-zwei Reihen Hüttchen in der Anzahl der Athleten",
            "Auf zwei gegenüberliegenden Seiten werden Reihen mit Hütchen aufgestellt mit einem Abstand von ungefähr 60 m",
            "jeder Athlet an ein Hütchen",
            15,
            3
        ),
        Exercise(
            116,
            "Hütchen-Sprints",
            "Die Athleten beginnen in der ersten Runde indem sie die zwei Hütchen zum Start mit einem schnellem Seitgallop antippen. Danach bewegen sie sich seitlich schräg durch die Hütchen durch und sprinten dann aus dieser Bewegung heraus zum Ziel-Hütchen.",
            "-zwei Start-Hütchen /n -pro Reihe in der Bahn 3 Hütchen /n - ein Ziel-Hütchen",
            "Es werden zwei Hütchen links und rechts mit einem knappen Abstand von ungefähr 4-5 m zueinander aufgestellt. Hintendran wird eine kleine Bahn von Hütchen aufgestellt. Als Ziel wird ein Hütchen mit einem Abstand von etwa 10-15 m zu der Bahn aufgestellt.",
            "je nach Anzahl kann eine zweite Bahn aufgebaut werden. Grundsätzlich ist es eine Einzelübung",
            15,
            3
        ),
        Exercise(
            117,
            "Hüft-Wurf",
            "Die Athleten stellen sich am Rand zum Feld auf mit Blickrichtung zum Feld hin. Die Athleten nehmen die Kugel in beide Hände und gehen damit ein wenig in die Knie, der Rücken soll gerade sein.Aus dieser Position heraus nehmen sie Schwung um die Kugel nach vorne hinweg in das Feld werfen. Wichtig ist das die Athleten die Bewegung mit dem ganzen Körper mitmachen und im besten Fall mit der Kugel mit einen kleinen Sprung in die selbe Richtung mitgehen.",
            "- eine Kugel pro Athlet",
            "Die Athleten sollen sich an der Feld aufstellen mit ihrer Kugel",
            "in kleine Gruppen einteilen á 2-3 Personen",
            10,
            4
        ),
        Exercise(
            118,
            "Über-Kopf-Wurf",
            "Die Athleten stellen sich am Rand zum Feld auf mit Blickrichtung weg vom Feld. Die Athleten nehmen die Kugel in beide Hände und gehen damit ein wenig in die Knie, der Rücken soll gerade sein. Aus dieser Position heraus nehmen sie Schwung um die Kugel nach hinten weg über ihren Kopf hinweg in das Feld werfen. Wichtig ist das die Athleten die Bewegung mit dem ganzen Körper mitmachen und im besten Fall mit der Kugel mit einen kleinen Sprung in die selbe Richtung mitgehen.",
            "- eine Kugel pro Athlet",
            "Die Athleten sollen sich an der Feld aufstellen mit ihrer Kugel mit Blickrichtung weg von der Kugel",
            "in kleine Gruppen einteilen á 2-3 Personen",
            10,
            4
        ),
        Exercise(
            119,
            "Standstoßen",
            "Die Athleten stellen sich am Rand zum Feld auf. Die Rechtshänder stellen sich mit dem linken Fuß nach vorne auf und die Linkshänder mit dem rechten Fuß nach vorne. Die Kugel wird an den Hals gelegt. Die Hand mit der gestoßen wird liegt etwas hinter der Kugel. Der Ellbogen sollte nicht angelegt sein sondern vom Körper weggerichtet sein. Aus dieser Position heraus versucht der Athlet nun die Kugel zu stoßen. Es sollte darauf geachtet werden, dass die Kugel so lange wie möglich am Hals gehalten wird und der Athlet auch beim stoßen groß bleibt. ",
            "- eine Kugel pro Athlet",
            "Die Athleten sollen sich an der Feld aufstellen mit ihrer Kugel",
            "in kleine Gruppen einteilen á 2-3 Personen",
            20,
            4
        ),
        Exercise(
            120,
            "Vorübung für den Anlauf",
            "Die Athleten stellen sich am Rand zum Feld auf und drehen sich mit dem Körper weg vom Feld. Die Rechtshänder haben ihr rechtes Bein vorne und verlagern ihr Gewicht auf das Bein für LInkshänder entsprechend das andere Bein. Die Fussspitzen zeigen in die gleiche Richtung leicht zur Seite weg. Die Kugel wird an den Hals gelegt. Die Hand mit der gestoßen wird liegt etwas hinter der Kugel. Der Ellbogen sollte nicht angelegt sein sondern vom Körper weggerichtet sein. Aus dieser Position heraus dreht sich der Athlet nun von den Füßen beginnt in einem Schwung Richtung des Feldes um die Kugel zu stoßen. Es sollte darauf geachtet werden, dass die Kugel so lange wie möglich am Hals gehalten wird und der Athlet auch beim stoßen groß bleibt.",
            "- eine Kugel pro Athlet",
            "Die Athleten sollen sich am Rand des Feldes aufzustellen mit ihrer Kugel",
            "in kleine Gruppen einteilen á 2-3 Personen",
            25,
            4
        ),
        Exercise(
            121,
            "Nachzieh-Anlauf",
            "Die Athleten stellen sich am Rand des Ringes auf, mit Blickrichtung weg vom Feld. Bei Rechtshändern steht er auf dem rechten Fuß und der linke ist nur ganz leicht auf den Boden aufgesetzt. Als nächstes wird dieser linke Fuß schnell nach hinten über den Boden gezogen und der andere Fuß rückt ebenfalls etwas hinterher. Zum Schluss muss nach eine schnelle Drehung erfolgen. Diese findet von unten nach oben statt. Wichtig ist ,dass die Athleten die Kugel lange am Hals behalten um sie nicht zu werfen.",
            "- eine Kugel pro Athlet",
            "Die Athleten sollen sich am Rand des Ringes mit ihrer Kugel aufstellen.",
            "in kleine Gruppen einteilen á 2-3 Personen",
            25,
            4
        ),
        Exercise(
            122,
            "Koordinationsleiter- Läufe",
            "Die Athleten gehen auf verschiedener Art und Weise durch die Leiter. Der Kreativität ist bei den Bewegungsabläufen eigentlich keine Grenze gesetzt. Um ein paar Beispiele aufzulisten: 1. Die Anzahl der Kontakte in jedem Feld variiren von 1-3 oder auch noch mehr. 2. seitlich an die Leiter stellen und dann einen Fuß in das erste Feld setzen, dann mittels Wechslesprung immer zwei Kontakte pro Feld machen. 3. mittels schnellen seitlichen Bewegungen durch die Felder gehen. Also auf einer Seite der Leiter aufstellen und dann im Seitgalopp durch bis auf die Rechte Seite. Außerhalb und innerhalb des Feldes der Leiter können die Kontakte frei definiert werden. ZUm Abschluss an der Übung innerhalb der Leiter ist jeweils ein Sprint bis zum Hütchen zu machen.",
            "-2 - 3 Koordinationsleitern                                                                                                                                                                            - entsprechend der Anzahl der Leitern jeweils 2 Hütchen",
            "Die Koordinationsleitern auf dem Boden auslegen ein Hütchen für den Start vor der Leiter aufstellen. Ein Hütchen als Ziel aufstellen etwa 10 - 15 Meter entfernt aufstellen.",
            "aufgeteilt auf die vorhandenen Leitern in kleinere Gruppen ",
            20,
            5
        ),
        Exercise(
            123,
            "Koordinationsleiter- Sprünge",
            "Die Athleten gehen auf verschiedener Art und Weise durch die Leiter. Der Kreativität ist bei den Bewegungsabläufen eigentlich keine Grenze gesetzt. Um ein paar Beispiele aufzulisten: 1. mit geschlossenen Beinen durch jedes Feld in der Leiter springen. Als Variation kann man gleich ergänzen, dass auch mit geöffneten Beinen gesprungen werden kann, hierbei sollte man auf den Sprung achten. 2. Es sind im Grunde genommen die gleichen Sprünge wie im ersten Beispiel allerdings kann man noch ergänzen, dass mit den Sprüngen auch Felder ausgelassen werden können. Sprich es soll nur in jedes zweite/dritte Feld gesprungen werden. Dort kann noch ergänzt werden ,dass auch noch Sprünge wieder zurück möglich wären als Variation. 3. Die Sprünge können natürlich auch so auf einem Bein gemacht werden. Als Variation kann man hier die bereits im Beispiel 2 genannte Möglichkeit verwenden. Zudem kann man hier bei den Sprüngen auch die Beine in den Feldern wechseln. ",
            "-2 - 3 Koordinationsleitern /n - entsprechend der Anzahl der Leitern jeweils 2 Hütchen",
            "Die Koordinationsleitern auf dem Boden auslegen ein Hütchen für den Start vor der Leiter aufstellen. Ein Hütchen als Ziel aufstellen etwa 10 - 15 Meter entfernt aufstellen.",
            "aufgeteilt auf die vorhandenen Leitern in kleinere Gruppen ",
            20,
            5
        ),
        Exercise(
            124,
            "Linien-Sprünge",
            "Die Athleten stellen sich neben einer Linie auf. Die Grundbewegung ist immer dieselbe. Die Athleten sollen immer mit dem jeweils von der Linie wegstehenden Bein über Kreuz über die Linie springen und bei jedem dritten Sprung mit beiden Beinen springen und landen. Zusätzlich können dann später noch die Arme mit Bewegungen eingebunden werden.",
            "- keine Utensilien nötig",
            "Hierfür ist kein Aufbau nötig. Nur genug Linien und Platz für jeden Athleten.",
            "aufgeteilt auf die vorhandenen Lienen in kleinere Gruppen ",
            15,
            5
        ),
        Exercise(
            125,
            "Aufwärmen mit dem Speer",
            "Die Athleten stellen sich mit dem Speer in einem großen Kreis auf. Der Abstand sollte zwischen den Athleten groß genug sein damit sie sich nicht gegenseitig mit dem Speer treffen. Die Übungen sollen die Arme aufwärmen und mobilisieren. Übung 1 : Der Speer wird mit beiden Händen gehalten welche etwas weiter auseinander sind. Dann wird der Speer über den Kopf nach Hinten an den Rücken bewegt und dann wieder zurück vor der Körper bewegt. Der Speer wird die ganze Zeit in der gleichen Position gehalten. Übung 2 : Der Speer wird genau so gehalten wie in Übung 1, allerdings wird der Speer nun in Schräglage in einem Kreis um den Körper herum bewegt. Die Richtung des kreisens sollte abgewechselt werden. Übung 3 : Der Speer wird hinter dem Kopf auf die Schultern gelegt. Der Athlet stellt sich Hüftbreitmit den Beinen hin und versucht mit der Spitze des Speers an die gegenüberliegende Fußspitze zu kommen. Natürlich gibt es noch viel mehr Möglichkeiten den Oberkörper und die Arme aufzuwärmen, dies sind nur ein paar Beispiele hierfür",
            "- ein Speer für jeden Athleten",
            "Ein Speer für jeden Athleten und dann im Kreis aufstellen lassen mit genug Abstand zueinander",
            "- Die komplette Gruppe mit dem jeweils eigenen Speer",
            20,
            6
        ),
        Exercise(
            126,
            "Standwurf mit beiden Händen",
            "Die Athleten stellen sich mit dem Speer an den Rand eines Feldes auf. Der Stand sollte hierbei Hüftbreit sein und der Speer wird in beide Hände genommen. Die Athleten sollen nun beim Wurf schwung holen mit dem Oberköper aus einer Haltung heraus die an ein \"C\" erinnern soll. Der Speer wird dabei mit beiden Händen über den Kopf genommen. Aus der Bewegung mit dem Oberkörper kann wird der Speer nun geworfen.",
            "- ein Speer für jeden Athleten",
            "Ein Speer für jeden und dann am Rand zum Rasen mit genug Abstand zu den Nebenleuten aufstellen. ",
            "- Die Athleten alle zusammen in einer Reihe  ",
            10,
            6
        ),
        Exercise(
            127,
            "Standwurf mit einer Hand",
            "Die Athleten stellen sich mit dem Speer an den Rand eines Feldes auf. Bei Rechtshändern wird nun das linke Bein nach vorne gemacht.Die Blickrichtung ist bei Rechthändern nach rechts. Der Arm sollte lang nach hinten ausgestreckt werden und der Speer sollt möglichst quasi an der Nasenspitze liegen. Dann wird aus dem Stand von dem rechten Bein aus über die Hüfte der Körper nach vorne gedreht bis der Oberkörper in Richtung des Feldes zeigt. Der Oberkörper soll sich vor dem Abwurf in einer \"C\" ähnlichen Haltung befinden aus der zusätzlich zu der Drehung Schwung geholt wird. Beim Wurf ist darauf zu achten das der Athlet den Ellbogen nach vorne zeigt und den Arm nicht an den Körper heranzieht sonder über dem Kopf den Speer abwirft.",
            "- ein Speer für jeden Athleten",
            "Ein Speer für jeden und dann am Rand zum Rasen mit genug Abstand zu den Nebenleuten aufstellen. ",
            "- Die Athleten alle zusammen in einer Reihe  ",
            15,
            6
        ),
        Exercise(
            128,
            "Wurf mit drei Schritten",
            "Die Athleten nehmen den Speer lang mit dem Arm nach hinten und berühren mit der Spitze beinahe ihre Nase. Der Anlauf soll aus drei Schritten bestehen und somit aus dem bekannten Am-ster-dam takt. Sprich es sind ein etwas langsamer Schritt und dann zwei schnelle Schritte zum Abwurf hin. Auch hier soll beim Abwurf die \"C\" ähnliche Haltung vorhanden sein. Sowie eine schöne Drehung von den Füßen her über die Hüfte bis hin zur Schulter. Auch der Wurf soll zum Schluss mit einem langen Arm stattfinden.",
            "- ein Speer für jeden Athleten",
            "Ein Speer für jeden und dann mit etwas Abstand zum Rand am Feld, mit ebenfalls genug Abstand zu den Nebenleuten aufstellen. ",
            "- Die Athleten alle zusammen in einer Reihe  ",
            25,
            6
        ),
        Exercise(
            129,
            "Aufwärmen mit dem Diskus",
            "Die Athleten stellen sich mit dem Diskus in einem großen Kreis auf. Der Abstand sollte zwischen den Athleten groß genug sein damit sie sich nicht gegenseitig mit dem Diskus treffen. Die Übungen sollen die Arme aufwärmen und mobilisieren. Übung 1: Der Diskus wir in einem Kreis um die Hüfte herum von der einen Hand an die andere gegeben. Der Athlet steht bei der Übung Schulterbreit da. Es soll ein Gefühl für das Gerät geschaffen werden. Übung 2: Der Diskus wird in einer Hand gehalten und dann vor dem Körper in Form einer liegenden Acht bewegt. Die Fingerspitzen sind direkt am Rand des Diskus um ihn damit festzuhalten. Der Diskus sollte dabei nicht runterfallen. Natürlich gibt es noch viel mehr Möglichkeiten den Oberkörper und die Arme aufzuwärmen, dies sind nur ein paar Beispiele hierfür",
            "- ein Diskus für jeden Athleten",
            "Ein Diskus für jeden Athleten und dann im Kreis aufstellen lassen mit genug Abstand zueinander. In der Nähe zum Rasen aufstellen",
            "-Die komplette Gruppe mit dem jeweils eigenen Diskus",
            15,
            7
        ),
        Exercise(
            130,
            "Standwurf",
            "Die Athleten stellen sich in den Abwurfring mit Blickrichtung des Feldes. Bei Rechtshänder wird das linke Bein etwas nach vorne versetzt, bei Linkshändern entsprechend das rechte Bein. Anschließend wird Schwung geholt für den Wurf. Beim Wurf selber ist es wichtig das die Bewegung langsam ansteigend ist um den Diskus am Ende groß und hoch hinauszuwerfen. Der Diskus liegt zu beginn beim Abwurf unter der Handfläche. Zudem ist es wichtig den Diskus über den Zeigefinger abzurollen damit er nicht flattert in der Luft.",
            "- ein Diskus für jeden Athleten",
            "Jeweils ein Athlet steht in dem Abwurfring innerhalb der Schutznetze ",
            "- Ein Athlet alleine beim Wurf ",
            10,
            7
        ),
        Exercise(
            131,
            "Abroll-Übung",
            "Die Athleten stellen sich am Rand des Feldes auf. Der Diskus wird in einer Hand gehalten mit den Fingerspitzen am Rand der Scheibe ist ein sicherer Halt gegeben. Der Diskus soll bei dieser Übung nicht geworfen werden. Sondern er wird über den Zeigefinger hinweg abgerollt. Das soll den späteren Ablauf beim Wurf üben bei welchem dies auch getan wird. Der Diskus sollte sie weit wie möglich stabil über das Feld rollen.",
            "- ein Diskus für jeden Athleten",
            "Die Athleten stellen sich mit ihrem Diskus am Rand des Feldes auf.",
            "- Ein Athlet alleine beim Wurf ",
            10,
            7
        ),
        Exercise(
            132,
            "Rumpf",
            "Die Athleten sollen auf dem Boden verschiedene Arten von Sit-Ups machen um die verschiedenen Bauchmuskelarten anzusprechen. ",
            "- keine Utensilien nötig",
            "Die Athleten sollten sich am Rand eines Feldes aufstellen oder zumindest so das man sie am besten im Blick behalten kann",
            "-Athleten stellen sich an einer Linie auf",
            20,
            8
        ),
        Exercise(
            133,
            "Rumpf",
            "Die Athleten sollen auf dem Boden verschiedene Trainingsmethoden für die Bauchmuskeln machen. Zum Beispiel das Rudern im Sitzen mit den Beinen in der Luft oder auch nur das einfache sitzen auf dem Boden und anheben und gestreckt halten der Beine in der Luft.",
            "- keine Utensilien nötig",
            "Die Athleten sollten sich am Rand eines Feldes aufstellen oder zumiondest so das man sie am besten im Blick behalten kann",
            "-Athleten stellen sich an einer Linie auf",
            20,
            8
        ),
        Exercise(
            134,
            "Beine",
            "Die Athleten stellen sich nebeneinander auf einer Linie auf. Es werden auf einer Art Sprungbahnen verschiedene Sprünge absolviert. Die Weite oder Anzahl der Sprünge kann vom Trainer variabel aufgestellt werden. Beispiel Übungen hierfür sind: 1. Froschsprünge, hierbei geht der Athlet bei etwa Hüftbreiten Beinen nach unten um Schwung zu holen und dann nach vorne zu springen.  2. Sprünge mit geschlossenen Beinen, hierbei sollen die Fußspitzen bei jedem Sprung nach oben gezogen werden. 3. Ein Absprung nach jedem dritten Schritt, die Athleten sollen immer wieder drei schnelle Schritte machen und dann nach oben springen. Wichtig ist das der Schritt beim landen bereits als erster Schritt zählen soll.",
            "- keine Utensilien nötig",
            "Die Athleten sollten sich am Rand eines Feldes aufstellen oder zumiondest so das man sie am besten im Blick behalten kann",
            "-Athleten stellen sich an einer Linie auf",
            20,
            8
        ),
        Exercise(
            135,
            "Beine",
            "Die Athleten stellen sich an dem Fuß der Treppe auf. Es sollen insgesamt 6 Runden absolviert werden innerhalb eines Durchgangs. Eine Runde bedeutet es werden zuerst die Treppenstufen auf verschiedenen Arten nach oben gegangen dann wird oben eine kurze Bahn gejoggt und dann wird wieder eine Treppe runtegenommen und wieder eine kurze Strecke gejoggt, dass ist eine komplette Runde. Als Beispiel für eine Auteilung der 6 Runden: -  2  Runden mit einem Kontakt pro Treppenstufe ; -  2  Runden mit beiden Beinen Springen , -   eine Runden auf nur einem Bein springen und die nächste Runde auf dem dann jeweils anderen springen.",
            "- keine Utensilien nötig",
            "Die Athleten stellen sich an den Beginn der Treppen in einer Reihe auf",
            "-Athleten stellen sich einzeln an eine Treppe",
            20,
            8
        ),
        Exercise(
            136,
            "Arme",
            "Die perfekten Übungen für die Arme sowie eigentlich den kompletten Körper sind verschiedene Stütz- und Halteübungen. Hierfür gibt es ganz verschiedene Übungen. 1. Die bekannten Stützübungen auf den Unterarmen. Dabei soll der komplette Körper in einer Linie sein und die Bauchmuskeln angespannt werden. 2. Halteübungen bei ausgestreckten Armen auf den Handflächen, dabei kann zusätzlich noch abwechselnd eine Hand vom Boden gehoben werden. 3. Ein Mix aus Liegestützen und Stützübungen, dabei geht der Athlet immer abwechselnd von den Unterarmen auf die Handflächen und dann wieder zurück auf die Unterarme.",
            "- keine Utensilien nötig",
            "Die Athleten sollten sich am Rand eines Feldes aufstellen oder zumiondest so das man sie am besten im Blick behalten kann",
            "-Athleten stellen sich an einer Linie auf",
            20,
            8
        ),
        Exercise(
            137,
            "Arme",
            "Auch sehr gute Übungen für die Arme sind Übungen mit dem Medizinball. 1. Die Athleten nehmen sich den Medizinball in beide Hände und werfen den Ball bei möglichst geradem Rücken mit aller Kraft den Ball auf den Boden. 2. Der Medizinball wird vor den Athleten gelegt. Derr Ablauf ist wiefolgt der Ball auf dem Boden wird aufgehoben in einer Kniebeuge-Bewegung, dann wird er über den Kopf genommen und nach oben gesprungen danach wird der Ball wieder mit einer Kniebeuge abgelegt. ",
            "- ein Medizinball für jeden Athleten",
            "Die Athleten sollten sich am Rand eines Feldes aufstellen oder zumiondest so das man sie am besten im Blick behalten kann",
            "-Athleten stellen sich an einer Linie auf",
            20,
            8
        ),
        Exercise(
            138,
            "Rücken",
            "Die Athleten legen sich auf den Bauch und dann gibt es verschiedene Möglichkeiten den Rücken zu trainieren. 1. Es werden nur die Arme vom Boden gehoben und abwechselnd nach oben und unten bewegt. 2. Es werden Arme und Beine vom Boden gehoben und dann nach oben und unten bewegt. 3. Die Arme und Beine werden mit einer etwas schnelleren Bewegung gleichzeitig vom Boden gehoben werden und dann wieder abgelegegt werden.",
            "- keine Utensilien nötig",
            "Die Athleten sollten sich am Rand eines Feldes aufstellen oder zumiondest so das man sie am besten im Blick behalten kann",
            "-Athleten stellen sich an einer Linie auf",
            20,
            8
        ),
        Exercise(
            139,
            "Runden Joggen mit Ball",
            "Die Athleten sollen mit dem Ball ein paar Runden laufen. Der Ball kann entweder mit dem Fuss mitgenommen werden oder geprellt werden um mögliche Verwendungsmöglichkeiten aufzuzählen",
            "- Tennisbälle",
            "Die Athleten sollen sich mit jeweils einem Tennisball auf die Bahn stellen",
            "- ein Tennisball für jeden",
            10,
            8
        ),
        Exercise(
            140,
            "Runden Joggen",
            "Die Athleten sollen ein paar Runden in ihrem Tempo Joggen gehen um sich warm zulaufen. Die Anzahl der Runden kann dem Alter abhängig gemacht werden.",
            "- keine Utensilien nötig",
            "Die Athleten sollen sich auf der Bahn sammeln ",
            "- Auf der Bahn",
            10,
            9
        ),
        Exercise(
            141,
            "Laufschule",
            "Die Athleten stellen sich auf die Bahnen verteilt auf. Nach und nach sollen Sie verschiedene Bewegungsarten erfüllen. Zum Beispiel verschiedene Skippings oder Steigerungsläufe",
            "- keine Utensilien nötig",
            "Die Athleten sollen sich über die verschiedenen Bahnen verteilen zur Not auch in mehreren Reihen",
            "- verteilt auf die Bahnen ",
            15,
            9
        ),
        Exercise(
            142,
            "Basketball",
            "Die Athleten sollen nach der Anzahl abhängig auf verschiedene gleichgroße Teams verteilt werden. Danach wird ganz normales Basketball gegeneinander gespielt.",
            "- ein Basketball",
            "Es sind zwei Baskettballkörbe nötig und ein Ball. Dann werden noch Teams gebildet",
            "- gleichgroße Teams",
            15,
            9
        ),
        Exercise(
            143,
            "Dehnen und Mobilisieren",
            "Die Athleten sollen sich so aufstellen, dass der Trainer alle im Blick hat. Danach werden verschiedene Dehn- und Mobilisierungsübungen ausgeführt. Die Übungen sollten sich speziell an den späteren Disziplinen orientieren.",
            "- keine Utensilien nötig",
            "Es wird nicht für einen Aufbau benötigt nur genug Platz um die Athleten aufstellen zu können.",
            "- kreis oder Linie ",
            10,
            9
        ),
        Exercise(
            144,
            "Bam-Bam",
            "Die Athleten stellen sich in einer Reihe auf, es haben immer die ersten beiden die Baskettbälle in der Hand. Ziel ist es als erstes den Korb zu treffen. Nachdem man den Korb getroffen hat muss man den Ball direkt an den nächsten in der Reihe weitergeben. Ziel ist es als Hintermann den Korb vor dem Vordermann zu treffen und ihn somit rauszuwerfen.",
            "- zwein Baskettbälle",
            "Es wird ein Baskettballkorb sowie zwein Baskettbälle gebraucht. Dazu stellen sich die Athleten an der Freiwurflinie auf in einer Reihe",
            "- an der Freiwurflinie in einer Reihe aufstellen",
            15,
            10
        ),
        Exercise(
            145,
            "Schere-Stein-Papier",
            "Es springt immer jeweils eine Person aus den jeweiligen Teams mit Froschsprüngen durch die Ringe. Wenn sich die Beide treffen spielen Sie Schere-Stein-Papier der Gewinner geht mit den Sprüngen weiter der Verlierer rennt zurück und schlägt den nächsten in der Reihe ab. Das Ziel ist es bis zum jeweils anderen Ende zu kommen. ",
            "- einige Ringe",
            "Die Ringe werden auf dem Boden ausgelegt in einer Reihe und die Teams stellen sich jeweils an ein Ende.",
            "- die Ringe in Reihe und zwei Teams an jeweils an Ende stellen",
            15,
            10
        ),
    )

    private var listOfDisciplines = listOf(
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