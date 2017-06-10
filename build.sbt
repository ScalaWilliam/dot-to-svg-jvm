autoScalaLibrary := false

autoScalaLibrary in Test := true

scalaVersion := "2.12.2"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.3" % "test"
libraryDependencies += "org.webjars.npm" % "viz.js" % "1.7.0"

name := "dot-to-svg"

organization := "com.scalawilliam.dot"