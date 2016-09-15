package com.github.hisaichi5518.deeplinkdispatchdocumentor.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Documentor {
    private final Logger logger;

    public Documentor(Logger logger) {
        this.logger = logger;
    }

    public void write(File file, String document) throws IOException {
        File parent = file.getParentFile();

        if (parent != null) {
            boolean isCreated = parent.mkdirs();
            if (isCreated) {
                logger.note("Created parent directory.");
            }
        }

        FileWriter writer = new FileWriter(file);
        writer.write(document);
        writer.close();
    }
}
