import sbt.Def.settings

name := "scala-macro-skeleton"

version := "0.1"

scalaVersion := "2.13.5"

val commonConfig = settings(
  scalacOptions ++= Seq(
    "-Ywarn-unused:imports",
    "-Xfatal-warnings",
    "-language:experimental.macros",
    "-language:higherKinds",
    "-deprecation",
    "-feature",
    "-unchecked"
  ),
  libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value
)

lazy val macros = project
  .in(file("macros"))
  .settings(commonConfig)

lazy val main = project
  .in(file("."))
  .in(file("main"))
  .settings(commonConfig)
  .dependsOn(macros)

lazy val root = project.aggregate(macros, main).settings(commonConfig)
