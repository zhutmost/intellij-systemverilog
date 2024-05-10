package com.zhutmost.systemverilog.lsp

import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lsp.api.ProjectWideLspServerDescriptor
import com.zhutmost.systemverilog.settings.AppSettingsState

abstract private class VerilogLspServerDescriptor(project: Project, displayName: String)
    extends ProjectWideLspServerDescriptor(project, displayName) {
  override def isSupportedFile(file: VirtualFile): Boolean = VerilogLspServerSupportProvider.isLspSupportedFile(file)
}

private final class SvlsLspServerDescriptor(project: Project) extends VerilogLspServerDescriptor(project, "Svls") {
  override def createCommandLine(): GeneralCommandLine = new GeneralCommandLine("svls")
}

private final class VeribleLspServerDescriptor(project: Project)
    extends VerilogLspServerDescriptor(project, "Verible") {
  override def createCommandLine(): GeneralCommandLine = new GeneralCommandLine("verible-verilog-ls")
}

private final class CustomLspServerDescriptor(project: Project)
    extends VerilogLspServerDescriptor(project, "Custom LSP") {
  override def createCommandLine(): GeneralCommandLine = {
    val settings = AppSettingsState.getInstance
    settings.lspServerCustomCommand match {
      case "" => throw new IllegalStateException("Custom LSP server command is not set")
      case command =>
        val commandArray = command.split(" ")
        new GeneralCommandLine(commandArray: _*)
    }
  }
}
