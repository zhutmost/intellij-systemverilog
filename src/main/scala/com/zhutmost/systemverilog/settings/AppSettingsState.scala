package com.zhutmost.systemverilog.settings

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.{PersistentStateComponent, State, Storage}
import com.intellij.util.xmlb.XmlSerializerUtil

object AppSettingsState {
  def getInstance: AppSettingsState = ApplicationManager.getApplication.getService(classOf[AppSettingsState])
}

@State(
  name = "com.zhutmost.systemverilog.settings.AppSettingsState",
  storages = Array(new Storage("systemverilog-plus.xml"))
)
final class AppSettingsState extends PersistentStateComponent[AppSettingsState] {
  var lspServer              = "Verible"
  var lspServerCustomCommand = ""

  def getState: AppSettingsState = this

  def loadState(state: AppSettingsState): Unit = {
    XmlSerializerUtil.copyBean(state, this)
  }
}
