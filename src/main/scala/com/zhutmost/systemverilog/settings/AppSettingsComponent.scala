package com.zhutmost.systemverilog.settings

import com.intellij.openapi.ui.ComboBox
import com.intellij.ui.HyperlinkLabel
import com.intellij.ui.components.{JBLabel, JBTextField}
import com.intellij.util.ui.FormBuilder

import javax.swing.{JComponent, JPanel}

class AppSettingsComponent {
  private val lspServerChoices       = Array("Verible", "Svls", "Custom")
  private val lspServerField         = new ComboBox(lspServerChoices)
  private val lspServerCustomCommand = new JBTextField()

  private val helpMessage = new HyperlinkLabel()
  helpMessage.setTextWithHyperlink("Visit our<hyperlink> GitHub page </hyperlink>to get doc or report issues")
  helpMessage.setHyperlinkTarget("https://github.com/zhutmost/intellij-systemverilog")
  helpMessage.setUseIconAsLink(true)

  final private val myMainPanel: JPanel = {
    FormBuilder.createFormBuilder
      .addLabeledComponent(new JBLabel("LSP select: "), lspServerField, 1, false)
      .addTooltip("Restart IDE after changing the language server.")
      .addLabeledComponent(new JBLabel("LSP custom command: "), lspServerCustomCommand, 1, false)
      .addTooltip("Only used when a CUSTOM LSP server is selected.")
      .addSeparator(10)
      .addComponent(new JBLabel("Thanks for using SystemVerilog Plus by @zhutmost!"), 10)
      .addComponent(helpMessage, 1)
      .addComponentFillVertically(new JPanel, 0)
      .getPanel
  }

  // Only enable the custom command field when a CUSTOM lspServer is selected
  lspServerField.addItemListener(_ => {
    lspServerCustomCommand.setEnabled(lspServerField.getSelectedItem.toString == "Custom")
  })

  def getPanel: JPanel = myMainPanel

  def getPreferredFocusedComponent: JComponent = lspServerField

  def getLspServer: String = lspServerField.getSelectedItem.toString

  def setLspServer(newText: String): Unit = {
    lspServerField.setItem(newText)
    lspServerCustomCommand.setEnabled(lspServerField.getSelectedItem.toString == "Custom")
  }

  def getLspServerCustomCommand: String = lspServerCustomCommand.getText

  def setLspServerCustomCommand(newText: String): Unit = {
    lspServerCustomCommand.setText(newText)
  }
}
