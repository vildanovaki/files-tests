package com.vildanova.utils;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Files {

    public static String readTextFromFile(File file) throws IOException {
        return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
    }

    public static String readTextFromPath(String path) throws IOException {
        return readTextFromFile(getFile(path));
    }

    public static File getFile(String path) {
        return new File(path);
    }

    public static String readDocxFromPath(String path) throws IOException {
        FileInputStream fis = new FileInputStream(path);
        XWPFDocument document = new XWPFDocument(fis);
        return new XWPFWordExtractor(document).getText();
    }

    public static String readDocFromPath(String path) throws IOException {
        FileInputStream fis = new FileInputStream(path);
        HWPFDocument document = new HWPFDocument(fis);
        return document.getDocumentText();
    }
}
