package com.zhutmost.systemverilog.lsp

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lsp.api.LspServerSupportProvider
import com.zhutmost.systemverilog.language.VerilogFileType
import com.zhutmost.systemverilog.settings.AppSettingsState

private object VerilogLspServerSupportProvider {
  def isLspSupportedFile(file: VirtualFile): Boolean = {
    val maybeVerilog: Boolean = ("(?i)verilog".r findFirstIn file.getFileType.getName).isDefined
    maybeVerilog || file.getFileType.isInstanceOf[VerilogFileType]
  }
}

class VerilogLspServerSupportProvider extends LspServerSupportProvider {
  override def fileOpened(
    project: Project,
    virtualFile: VirtualFile,
    lspServerStarter: LspServerSupportProvider.LspServerStarter
  ): Unit = {
    if (VerilogLspServerSupportProvider.isLspSupportedFile(virtualFile)) {
      val settings = AppSettingsState.getInstance
      lspServerStarter.ensureServerStarted(settings.lspServer match {
        case "Verible" => new VeribleLspServerDescriptor(project)
        case "Svls"    => new SvlsLspServerDescriptor(project)
        case "Custom"  => new CustomLspServerDescriptor(project)
      })
    }
  }
}
