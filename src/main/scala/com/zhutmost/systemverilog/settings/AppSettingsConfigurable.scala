package com.zhutmost.systemverilog.settings

import com.intellij.openapi.options.Configurable

import javax.swing.JComponent

final class AppSettingsConfigurable extends Configurable {
  private var mySettingsComponent: AppSettingsComponent = null

  def getDisplayName = "SystemVerilog Plus"

  override def getPreferredFocusedComponent: JComponent = mySettingsComponent.getPreferredFocusedComponent

  def createComponent: JComponent = {
    mySettingsComponent = new AppSettingsComponent
    mySettingsComponent.getPanel
  }

  def isModified: Boolean = {
    val settings = AppSettingsState.getInstance
    var modified = false
    modified |= mySettingsComponent.getLspServer != settings.lspServer
    modified |= mySettingsComponent.getLspServerCustomCommand != settings.lspServerCustomCommand
    modified
  }

  def apply(): Unit = {
    val settings = AppSettingsState.getInstance
    settings.lspServer = mySettingsComponent.getLspServer
    settings.lspServerCustomCommand = mySettingsComponent.getLspServerCustomCommand
  }

  override def reset(): Unit = {
    val settings = AppSettingsState.getInstance
    mySettingsComponent.setLspServer(settings.lspServer)
    mySettingsComponent.setLspServerCustomCommand(settings.lspServerCustomCommand)
  }

  override def disposeUIResources(): Unit = {
    mySettingsComponent = null
  }
}
