package dspa.acceptance

import org.specs2._
import dspa._

class DSPAAcceptanceSpec extends Specification { def is = 
    
    "This is a specification that tests the DSP Algorithm"  ^
                                                            p^
    "DSPA module should"                                    ^
        "solve simple graphs"                               ! e1 ^
        "solve more complex graphs"                         ! e2 ^
        "solve directed graphs as well"                     ! e3 ^
        "solve even more complex graphs"                    ! e4
        
    def e1 = {
        val edges = List(("foo", "bar", 5),
                         ("foo", "baz", 2),
                         ("bar", "baz", 1))
        DSPA.run(edges, "foo") must havePairs("foo" -> (0, List("foo")),
                                              "bar" -> (3, List("foo", "baz", "bar")),
                                              "baz" -> (2, List("foo", "baz")))
    }
    
    def e2 = {
        val edges = List(("1", "2", 7),
                         ("1", "3", 9),
                         ("1", "6", 14),
                         ("2", "3", 10),
                         ("2", "4", 15),
                         ("3", "4", 11),
                         ("3", "6", 2),
                         ("4", "5", 6),
                         ("5", "6", 9))
        DSPA.run(edges, "1") must havePairs("1" -> (0, List("1")),
                                            "2" -> (7, List("1", "2")),
                                            "3" -> (9, List("1", "3")),
                                            "4" -> (20, List("1", "3", "4")),
                                            "5" -> (20, List("1", "3", "6", "5")),
                                            "6" -> (11, List("1", "3", "6")))
    }
    
    def e3 = {
        val edges = List(("1", "2", 7),
                         ("1", "3", 9),
                         ("1", "6", 14),
                         ("2", "3", 10),
                         ("2", "4", 15),
                         ("3", "4", 11),
                         ("3", "6", 2),
                         ("4", "5", 6),
                         ("5", "6", 9))
        DSPA.run(edges, "1", true) must havePairs("1" -> (0, List("1")),
                                                  "2" -> (7, List("1", "2")),
                                                  "3" -> (9, List("1", "3")),
                                                  "4" -> (20, List("1", "3", "4")),
                                                  "5" -> (26, List("1", "3", "4", "5")),
                                                  "6" -> (11, List("1", "3", "6")))
    }
    
    def e4 = {
        val edges = List((1, 2, 7),
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
                         (9, 10, 6))
        DSPA.run(edges, 1) must havePairs(1 -> (0, List(1)),
                                          2 -> (7, List(1, 2)),
                                          3 -> (5, List(1, 3)),
                                          4 -> (7, List(1, 3, 4)),
                                          5 -> (8, List(1, 3, 5)),
                                          6 -> (13, List(1, 3, 5, 6)),
                                          7 -> (12, List(1, 3, 7)),
                                          8 -> (13, List(1, 3, 5, 8)),
                                          9 -> (15, List(1, 3, 7, 9)),
                                          10 -> (17, List(1, 3, 5, 8, 10)))
    }
}