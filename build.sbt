scalaVersion := "2.12.4"

lazy val dynamicsMacrosSample = (project in file("."))
  .dependsOn(dynamicsMacrosSampleMacro)

lazy val dynamicsMacrosSampleMacro = (project in file("macro"))
  .settings(
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-reflect"  % scalaVersion.value % "compile",
      "org.scala-lang" % "scala-compiler" % scalaVersion.value % "optional"
    )
  )
