package com.tym.idea.jni;


import org.junit.Test;

public class InputManagerJniTest {

    @Test
    public void testToChinese() {
        InputManagerJni.getSingleton().any2Chinese_1();
    }
}