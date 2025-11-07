package com.tym.idea.listener;

import com.intellij.openapi.Disposable;
import com.intellij.openapi.project.VetoableProjectManagerListener;
import com.intellij.openapi.startup.ProjectActivity;
import com.tym.idea.Util;
import com.tym.idea.jni.InputManagerJni;
import com.intellij.openapi.editor.EditorFactory;
import com.intellij.openapi.editor.event.CaretListener;
import com.intellij.openapi.editor.event.DocumentListener;
import com.intellij.openapi.editor.event.EditorEventMulticaster;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManagerListener;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class MyProjectManagerListener implements ProjectActivity, Disposable {
    private final Object pfcCaretListener = new PfcCaretListener();

    @Nullable
    @Override
    public Object execute(@NotNull Project project, @NotNull Continuation<? super Unit> continuation) {
        Util.notify("init");
        EditorFactory instance = EditorFactory.getInstance();
        EditorEventMulticaster eventMulticaster = instance.getEventMulticaster();
        eventMulticaster.addCaretListener((CaretListener) pfcCaretListener);
        eventMulticaster.addDocumentListener((DocumentListener) pfcCaretListener);
        InputManagerJni.getSingleton().any2English_1();
        return 1;
    }

    @Override
    public void dispose() {
        EditorEventMulticaster eventMulticaster = EditorFactory.getInstance().getEventMulticaster();
        eventMulticaster.removeCaretListener((CaretListener) pfcCaretListener);
        eventMulticaster.removeDocumentListener((DocumentListener) pfcCaretListener);
    }
}
