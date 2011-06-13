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
        "solve even more complex graphs"                    ! e4 ^
        "handle disconnected graphs"                        ! e5
        
    def e1 = {
        DSPA.run(Graph1.edges, "foo") must havePairs("foo" -> (0, List("foo")),
                                                     "bar" -> (3, List("foo", "baz", "bar")),
                                                     "baz" -> (2, List("foo", "baz")))
    }
    
    def e2 = {
        DSPA.run(Graph2.edges, "1") must havePairs("1" -> (0, List("1")),
                                                   "2" -> (7, List("1", "2")),
                                                   "3" -> (9, List("1", "3")),
                                                   "4" -> (20, List("1", "3", "4")),
                                                   "5" -> (20, List("1", "3", "6", "5")),
                                                   "6" -> (11, List("1", "3", "6")))
    }
    
    def e3 = {
        DSPA.run(Graph2.edges, "1", true) must havePairs("1" -> (0, List("1")),
                                                         "2" -> (7, List("1", "2")),
                                                         "3" -> (9, List("1", "3")),
                                                         "4" -> (20, List("1", "3", "4")),
                                                         "5" -> (26, List("1", "3", "4", "5")),
                                                         "6" -> (11, List("1", "3", "6")))
    }
    
    def e4 = {
        DSPA.run(Graph3.edges, 1) must havePairs(1 -> (0, List(1)),
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
    
    def e5 = {
        DSPA.run(Graph4.edges, 1) must havePairs(1 -> (0, List(1)),
                                                 2 -> (5, List(1, 2)),
                                                 3 -> (Integer.MAX_VALUE, List()),
                                                 4 -> (Integer.MAX_VALUE, List()))
    }
}