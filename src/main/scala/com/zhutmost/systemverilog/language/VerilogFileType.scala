package com.zhutmost.systemverilog.language

import com.intellij.openapi.fileTypes.LanguageFileType

import javax.swing.Icon

class VerilogFileType extends LanguageFileType(VerilogLanguage.INSTANCE) {
  def getName: String = "SystemVerilog"

  def getDescription: String = "SystemVerilog HDL file"

  def getDefaultExtension: String = "sv"

  def getIcon: Icon = VerilogIcon.FILE
}

object VerilogFileType {
  val INSTANCE = new VerilogFileType
}
