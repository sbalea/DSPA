import sbt._

class DSPAProject(info:ProjectInfo) extends DefaultProject(info) {
    val specs2 = "org.specs2" %% "specs2" % "1.3" % "test"
    val scalaz = "org.specs2" %% "specs2-scalaz-core" % "6.0.RC2" % "test"

    def specs2Framework = new TestFramework("org.specs2.runner.SpecsFramework")
    override def testFrameworks = super.testFrameworks ++ Seq(specs2Framework)
    
    override def includeTest(s: String) = { s.endsWith("Spec") }

    val snapshots = "snapshots" at "http://scala-tools.org/repo-snapshots"
    val releases  = "releases" at "http://scala-tools.org/repo-releases"
}