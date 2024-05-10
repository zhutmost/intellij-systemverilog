<div>
<img src="https://raw.githubusercontent.com/zhutmost/intellij-systemverilog/main/resources/META-INF/pluginIcon.svg" alt="Logo" align="left" width="40" height="40"/>
<h1 align="left"> SystemVerilog Language Server for Intellij IDEA </h1>
</div>

![Build](https://github.com/zhutmost/intellij-systemverilog/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/com.zhutmost.systemverilog.svg)](https://plugins.jetbrains.com/plugin/com.zhutmost.systemverilog)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/com.zhutmost.systemverilog.svg)](https://plugins.jetbrains.com/plugin/com.zhutmost.systemverilog)
<!-- Plugin description -->
This plugin integrates SystemVerilog language servers (LSP) into Intellij IDEA, which enables on-the-fly syntax linting.
It supports multiple language servers, including:
- [Verible](https://github.com/chipsalliance/verible) by ChipAlliance
- [Svls](https://github.com/dalance/svls) by @dalance
- Custom LSP (You can specify your own LSP binary)

## 📦 Requirements

#### 1. Install a SystemVerilog Language Server

Before starting, you need to install a LSP binary, and add it to your PATH environment variable.
For example, you can download Verible bianry `verible-verilog-ls` from [its GitHub Release](https://github.com/chipsalliance/verible/releases).

#### 2. Intellij IDEA Ultimate

Only Intellij IDEA Ultimate supports LSP, so you cannot use this plugin with the Community version.

Currently, the language server protocol (LSP) support for Jetbrains IDEs is still in beta (View [JetBrains' Blog](https://blog.jetbrains.com/platform/2023/07/lsp-for-plugin-developers/) for more details).

#### 3. Third-party SystemVerilog Plugin (Optional but Recommended)

This plugin does NOT include syntax highlighting. So you may need to install another SystemVerilog plugin
`studio.edaphic.sv` from [Jetbrains Marketplace](https://plugins.jetbrains.com/plugin/10695-systemverilog).

Although this plugin itself is free, the above third-party plugin and the Intellij IDEA Ultimate version are both paid, so you need to pay for them. You can [apply for free licenses](https://www.jetbrains.com/community/education/#students) for education or open-source proposes.

## ⚙️ Configuration

Just add the LSP binaries to your PATH environment variable.
To specify a LSP, You can set the plugin settings in:

 <kbd>Settings/Preferences</kbd> > <kbd>Tools</kbd> > <kbd>SystemVerilog Plus</kbd>.
 
![Settings](https://raw.githubusercontent.com/zhutmost/intellij-systemverilog/main/img/settings.jpg)

 Then restart your Intellij IDEA, and see the LSP is activated:

![LSP status](https://raw.githubusercontent.com/zhutmost/intellij-systemverilog/main/img/lsp-status.jpg)

Some LSP may need extra configuration files, you can find them in their READMEs.

### Verible

### Linting on the Fly
![Verible linting demo](https://raw.githubusercontent.com/zhutmost/intellij-systemverilog/main/img/demo-linter-verible.jpg)

To custom your linting style, you can create a `.rules.verible_lint` file in your project root directory. You can find the linting rules in [Verible Linter Rule List](https://chipsalliance.github.io/verible/verilog_lint.html).

### Go to Definition

No configuration is needed. Just "Ctrl/Cmd + Click" on the identifier and the editor will jump to its declaration.

For more details of Verible, please visit:
- [Verible Linter README](https://github.com/chipsalliance/verible/tree/master/verilog/tools/lint)
- [Verible LSP README](https://github.com/chipsalliance/verible/tree/master/verilog/tools/ls)

## ⚠️ Know Issues

The LSP support by JetBrains is still in beta, so the features of this plugin may not be stable.
If you have any problems, please feel free to open an issue on [GitHub](https://github.com/zhutmost/intellij-systemverilog/issues).

<!-- Plugin description end -->

### About the Third-party Plugin

Besides, the mentioned SystemVerilog plugin (`studio.edaphic.sv` ) is no longer maintained, and it is not compatible with the latest version of Intellij IDEA.
So we provide a modified version of this plugin on [GitHub](https://github.com/zhutmost/intellij-systemverilog/releases/download/v0.0.1/SystemVerilog.zip). You can choose to install this plugin manually:

<kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>

They may obey their license (although it is not maintained), so you can choose to use it or not.
