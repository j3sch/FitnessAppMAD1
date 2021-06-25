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
            105,
            "Standsprung",
            "Die Athleten springen von möglichst weit vorne aus dem Stand heraus in die Sandgrube.  Drauf zu achten ist, dass die Athleten ungefähr Schulterbreit dastehen und denn Schwung aus der Hocke mit dem ganzen Körper beim Sprung mitnehmen sollen.",
            "ein Hütchen pro Sprungbahn",
            "Ein Hütchen ganz vorne am Rand für jede Bahn bei der es möglich ist zu springen",
            "Aufteilung um ungefähr gleich große Gruppen zu bekommen",
            10,
            2
        )

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
        Discipline(9, "Hochsprung"),
        Discipline(10, "Einleitung"),
        Discipline(11, "Schluss")
    )

    fun populateExerciseTable(): List<Exercise> {
        return listOfExercises
    }

    fun populateDisciplineTable() : List<Discipline>{
        return listOfDisciplines
    }
}