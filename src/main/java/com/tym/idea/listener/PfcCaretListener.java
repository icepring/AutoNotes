package com.tym.idea.listener;

import com.intellij.ide.highlighter.JavaFileType;
import com.tym.idea.Process;
import com.intellij.openapi.editor.event.CaretEvent;
import com.intellij.openapi.editor.event.CaretListener;
import com.intellij.openapi.editor.event.DocumentEvent;
import com.intellij.openapi.editor.event.DocumentListener;
import com.tym.idea.Util;
import com.tym.ui.AppSettingsState;
import org.jetbrains.annotations.NotNull;

public class PfcCaretListener implements CaretListener, DocumentListener {
    int CaretIndex;

    @Override
    public void caretPositionChanged(@NotNull CaretEvent event) {
        if(AppSettingsState.Companion.getInstance().getEnable()){
            Process.caretPositionChanged(event);
        }
    }

    @Override
    public void documentChanged(@NotNull DocumentEvent event) {

//        JudgeService.judgement(event, this);
    }

    @Override
    public void beforeDocumentChange(@NotNull DocumentEvent event) {

//        JudgeService.beforeJudge(event, this);
    }


}
