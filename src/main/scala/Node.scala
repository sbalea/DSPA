package dspa

import scala.collection.mutable.{Set, HashSet}

class Node(val name: Any) {
    private val _edges:Set[Edge] = new HashSet[Edge]
    var distance = Integer.MAX_VALUE
    var visited = false
    var previous:Node = null

    def addEdge(edge:Edge) {
        _edges += edge
    }
    
    def edges = _edges.toList
}