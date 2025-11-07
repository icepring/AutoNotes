package com.tym.ui

import com.intellij.openapi.options.Configurable
import javax.swing.JComponent

class AppSettingsConfigurable : Configurable {

    private var component: AppSettingComponent? = null
    private val state: AppSettingsState = AppSettingsState.instance
    override fun getDisplayName(): String = "TInputManagerSettings"

    override fun createComponent(): JComponent {
        val ui = AppSettingComponent()
        component = ui
        ui.resetFrom(state)
        return ui.panel
    }

    override fun isModified(): Boolean = component?.isModified(state) ?: false

    override fun apply() {
        component?.applyTo(state)
    }

    override fun reset() {
        component?.resetFrom(state)
    }

    override fun disposeUIResources() {
        component = null
    }

    override fun getPreferredFocusedComponent(): JComponent? = component?.preferredFocusedComponent
}
