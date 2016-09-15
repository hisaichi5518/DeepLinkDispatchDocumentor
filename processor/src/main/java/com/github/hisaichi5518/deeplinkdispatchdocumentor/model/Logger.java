package com.github.hisaichi5518.deeplinkdispatchdocumentor.model;

import javax.annotation.processing.Messager;
import javax.tools.Diagnostic;

public class Logger {
    private final Messager messager;

    public Logger(Messager messager) {
        this.messager = messager;
    }

    public void note(String message) {
        logging(Diagnostic.Kind.NOTE, message);
    }

    public void error(String message) {
        logging(Diagnostic.Kind.ERROR, message);
    }

    private void logging(Diagnostic.Kind kind, String message) {
        if (messager == null || kind == null) {
            System.out.print(message);
            return;
        }

        messager.printMessage(kind, message);
    }
}
