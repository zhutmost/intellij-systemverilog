package com.zhutmost.systemverilog.commenter

import com.intellij.lang.Commenter

//CodeDocumentationAwareCommenter

class VerilogCommenter extends Commenter {
  override def getLineCommentPrefix: String = "//"

  override def getBlockCommentPrefix: String = "/*"

  override def getBlockCommentSuffix: String = "*/"

  override def getCommentedBlockCommentPrefix: String = null

  override def getCommentedBlockCommentSuffix: String = null
}
