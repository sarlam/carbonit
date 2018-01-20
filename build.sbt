import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "me.jarleton",
      scalaVersion := "2.12.3",
      version      := "0.0.1"
    )),
    name := "Hello",
    libraryDependencies += scalaTest % Test
  )

scalacOptions in (Compile,doc) := Seq("-groups", "-implicits")
