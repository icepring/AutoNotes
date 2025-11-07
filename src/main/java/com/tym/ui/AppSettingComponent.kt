package com.tym.ui

import com.intellij.ui.components.*
import com.intellij.util.ui.FormBuilder
import java.awt.event.ItemListener
import javax.swing.*

class AppSettingComponent {

    val panel: JPanel

    // 单选互斥组
    private val toChinese = JBRadioButton(message("toChinese"))
    private val toJapanese = JBRadioButton(message("toJapanese"))
    private val toFirstLang = JBRadioButton(message("toFirstLang"))
    private val languageGroup = ButtonGroup()

    private val enable = JBCheckBox(message("enable"))

    init {
        // 默认选中
        toChinese.isSelected = true

        languageGroup.add(toChinese)
        languageGroup.add(toJapanese)
        languageGroup.add(toFirstLang)

        // enable 控制语言单选是否可用
        val toggle = ItemListener { updateLanguageEnableState() }
        enable.addItemListener(toggle)
        updateLanguageEnableState()

        panel = FormBuilder.createFormBuilder()
            .addComponent(enable)
            .addSeparator()
            .addComponent(toChinese)
            .addComponent(toJapanese)
            .addComponent(toFirstLang)
            .addComponentFillVertically(JPanel(), 0)
            .panel
    }

    private fun updateLanguageEnableState() {
        val enabled = enable.isSelected
        toChinese.isEnabled = enabled
        toJapanese.isEnabled = enabled
        toFirstLang.isEnabled = enabled
    }

    // ---- getter / setter 与 state 同步 ----

    fun resetFrom(state: AppSettingsState) {
        enable.isSelected = state.enable
        when (state.language) {
            AppSettingsState.LanguageOption.CHINESE -> toChinese.isSelected = true
            AppSettingsState.LanguageOption.JAPANESE -> toJapanese.isSelected = true
            AppSettingsState.LanguageOption.FIRST_LANG -> toFirstLang.isSelected = true
        }
        updateLanguageEnableState()
    }

    fun applyTo(state: AppSettingsState) {
        state.enable = enable.isSelected
        state.language = when {
            toChinese.isSelected -> AppSettingsState.LanguageOption.CHINESE
            toJapanese.isSelected -> AppSettingsState.LanguageOption.JAPANESE
            else -> AppSettingsState.LanguageOption.FIRST_LANG
        }
    }

    fun isModified(state: AppSettingsState): Boolean =
        enable.isSelected != state.enable ||
                state.language != when {
            toChinese.isSelected -> AppSettingsState.LanguageOption.CHINESE
            toJapanese.isSelected -> AppSettingsState.LanguageOption.JAPANESE
            else -> AppSettingsState.LanguageOption.FIRST_LANG
        }

    val preferredFocusedComponent: JComponent
        get() = enable
}
