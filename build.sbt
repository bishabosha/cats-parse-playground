val scala3Version = "3.0.0-RC1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "playground-cats-parse",
    version := "0.1.0",

    scalaVersion := scala3Version,

    libraryDependencies += "org.typelevel" %% "cats-parse" % "0.3-7-33b03e0",
  )
