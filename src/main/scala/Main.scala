package dspa

object Main {
    val edges1 = List(("1", "2", 7),
                     ("1", "3", 9),
                     ("1", "6", 14),
                     ("2", "3", 10),
                     ("2", "4", 15),
                     ("3", "4", 11),
                     ("3", "6", 2),
                     ("4", "5", 6),
                     ("5", "6", 9)
                    )
    val startNode1 = "1"
    
    val edges2 = List((1, 2, 7),
                      (1, 3, 5),
                      (1, 4, 8),
                      (1, 5, 10),
                      (2, 3, 8),
                      (2, 7, 9),
                      (3, 4, 2),
                      (3, 5, 3),
                      (3, 6, 9),
                      (3, 7, 7),
                      (4, 5, 3),
                      (5, 6, 5),
                      (5, 8, 5),
                      (6, 7, 3),
                      (6, 8, 6),
                      (6, 9, 4),
                      (6, 10, 5),
                      (7, 9, 3),
                      (8, 10, 4),
                      (9, 10, 6)
                     )
    val startNode2 = 1
    
    def main(args: Array[String]) {
        println(DSPA.run(edges1, startNode1, true))
        println(DSPA.run(edges2, startNode2, true))
    }
}