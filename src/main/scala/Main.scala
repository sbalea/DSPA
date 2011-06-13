package dspa

object Main {
    def main(args: Array[String]) {
        println("Simple graph:")
        println(DSPA.run(Graph1.edges, "foo"))
        
        println("More complex graph:")
        println(DSPA.run(Graph2.edges, "1"))
        
        println("Same graph but directed:")
        println(DSPA.run(Graph2.edges, "1", true))
        
        println("Even more complex graph:")
        println(DSPA.run(Graph3.edges, 1))
    }
}