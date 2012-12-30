import sbt._

import Keys._
import AndroidKeys._

object General {
  val settings = Defaults.defaultSettings ++ Seq (
    name := "$name$",
    version := "0.1",
    versionCode := 0,
    scalaVersion := "$scala_version$",
    platformName in Android := "android-$api_level$"
  )

  val proguardSettings = Seq (
    useProguard in Android := $useProguard$
  )

  // RoboSpecs
  val bddSettings = Seq(
    resolvers += "jbrechtel snapshots" at "http://jbrechtel.github.com/repo/snapshots",
    libraryDependencies += "com.github.jbrechtel" %% "robospecs" % "$robospecs_version$" % "test",
    parallelExecution in Test := false,
    testOptions in Test += Tests.Argument("sequential")
  )

  lazy val fullAndroidSettings =
    General.settings ++
    AndroidProject.androidSettings ++
    TypedResources.settings ++
    proguardSettings ++
    bddSettings ++
    AndroidManifestGenerator.settings ++
    AndroidMarketPublish.settings ++ Seq (
      keyalias in Android := "change-me"
    )
}

object AndroidBuild extends Build {
  lazy val main = Project (
    "$name$",
    file("."),
    settings = General.fullAndroidSettings
  )

  lazy val tests = Project (
    "tests",
    file("tests"),
    settings = General.settings ++
               AndroidTest.androidSettings ++
               General.proguardSettings ++ Seq (
      name := "$name$Tests"
    )
  ) dependsOn main
}
