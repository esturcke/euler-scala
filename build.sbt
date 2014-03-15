name := "Project Euler Solutions in Scala"

version := "0.1"

scalaVersion := "2.10.3"

scalacOptions ++= Seq("-deprecation", "-feature")

libraryDependencies ++= Seq(
  "org.scalatest"  %% "scalatest"     % "2.1.0"            % "test",
  "org.jsoup"      %  "jsoup"         % "1.6.3",
  "org.scala-lang" %  "scala-reflect" % scalaVersion.value
)

testOptions in Test += Tests.Argument("-oD")
