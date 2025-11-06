package com.tym.idea.listener;

import com.tym.idea.Process;
import com.intellij.openapi.editor.event.CaretEvent;
import com.intellij.openapi.editor.event.CaretListener;
import com.intellij.openapi.editor.event.DocumentEvent;
import com.intellij.openapi.editor.event.DocumentListener;
import org.jetbrains.annotations.NotNull;

public class PfcCaretListener implements CaretListener, DocumentListener {
    int CaretIndex;

    @Override
    public void caretPositionChanged(@NotNull CaretEvent event) {
        Process.caretPositionChanged(event);
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
