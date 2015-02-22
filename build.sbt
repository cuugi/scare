val sv = "2.11.4"

name := "Scare"

version := "0.1.0"

licenses := Seq("LGPL v2.1+" -> url("http://www.gnu.org/licenses/lgpl-2.1.txt"))

scalaVersion := sv

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")

libraryDependencies += "org.scala-lang" % "scala-reflect" % sv

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"
