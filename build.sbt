import org.jetbrains.sbtidea.Keys._

lazy val pluginIntellijSystemVerilog =
  project.in(file("."))
    .enablePlugins(SbtIdeaPlugin)
    .settings(
      version := "0.0.1-SNAPSHOT",
      scalaVersion := "2.13.13",
      ThisBuild / intellijPluginName := "SystemVerilog Plus by Zhutmost",
      ThisBuild / intellijBuild      := "241",
      ThisBuild / intellijPlatform   := IntelliJPlatform.IdeaUltimate,
      Global    / intellijAttachSources := true,
      Compile / javacOptions ++= "--release" :: "21" :: Nil,
      intellijPlugins += "com.intellij.properties".toPlugin,
      libraryDependencies += "com.eclipsesource.minimal-json" % "minimal-json" % "0.9.5" withSources(),
      Compile / unmanagedResourceDirectories += baseDirectory.value / "resources",
      Test / unmanagedResourceDirectories    += baseDirectory.value / "testResources"
    )
