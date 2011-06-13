package dspa.unit

import org.specs2.mutable._
import dspa._

class NodeSpec extends Specification {
    "Node objects" should {
        "have a name" in {
            val n1 = new Node("foo")
            n1.name === "foo"
            val n2 = new Node(1)
            n2.name === 1
        }
        
        "contain a set of unique edges" in {
            val n1 = new Node(1)
            val n2 = new Node(2)
            val n3 = new Node(3)
            
            val e1 = Edge(n2, 10)
            val e2 = Edge(n3, 20)
            
            n1.addEdge(e1)
            n1.addEdge(e2)
            n1.addEdge(e1) // Add the first edge a second time to test uniqueness
            
            n1.edges must haveTheSameElementsAs(List(e1, e2))
        }
    }
}