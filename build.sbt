name := "Scare"

version := "0.1.0-SNAPSHOT"

licenses := Seq("LGPL v2.1+" -> url("http://www.gnu.org/licenses/lgpl-2.1.txt"))

scalaVersion := "2.12.4"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")

// libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.4" % "test"
