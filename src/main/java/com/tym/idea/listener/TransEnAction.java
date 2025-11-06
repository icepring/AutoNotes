package com.tym.idea.listener;

import com.tym.idea.jni.InputManagerJni;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

public class TransEnAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        System.out.println("¿ì½Ý¼üÇÐ»»ÎªÓ¢ÎÄ");
        InputManagerJni.getSingleton().any2English_1();
    }
}
