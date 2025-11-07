package com.tym.ui

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.*
import com.intellij.util.xmlb.XmlSerializerUtil

@State(
    name = "AppTranslationSettings",
    storages = [Storage("AppTranslationSettings.xml")]
)
class AppSettingsState : PersistentStateComponent<AppSettingsState> {

    enum class LanguageOption {
        CHINESE, JAPANESE, FIRST_LANG
    }

    var enable: Boolean = true
    var language: LanguageOption = LanguageOption.CHINESE

    override fun getState(): AppSettingsState = this

    override fun loadState(state: AppSettingsState) {
        XmlSerializerUtil.copyBean(state, this)
    }

    companion object {
        val instance: AppSettingsState
            get() =
                ApplicationManager.getApplication().getService(AppSettingsState::class.java)
    }
}
