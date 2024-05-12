import org.jetbrains.sbtidea.Keys.*

import Utils.readmeDescriptionExtract

lazy val systemverilog =
  project.in(file("."))
    .enablePlugins(SbtIdeaPlugin)
    //.enablePlugins(LaikaPlugin)
    .settings(
      scalaVersion := "2.13.13",
      intellijPlugins += "com.intellij.properties".toPlugin,
//      libraryDependencies += "com.eclipsesource.minimal-json" % "minimal-json" % "0.9.5" withSources(),
      version := "0.0.3",

      ThisBuild / intellijPluginName := "SystemVerilog Plus by Zhutmost",
      ThisBuild / intellijBuild      := "241",
      ThisBuild / intellijPlatform   := IntelliJPlatform.IdeaUltimate,
      Global    / intellijAttachSources := true,
      Compile / javacOptions ++= "--release" :: "21" :: Nil,
      Compile / unmanagedResourceDirectories += baseDirectory.value / "resources",
      Test / unmanagedResourceDirectories    += baseDirectory.value / "testResources",

      patchPluginXml := pluginXmlOptions { xml =>
        xml.version = version.value
        xml.pluginDescription = readmeDescriptionExtract(file(".") / "README.md")
      }
    )
