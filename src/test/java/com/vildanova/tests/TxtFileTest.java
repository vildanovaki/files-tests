package com.vildanova.tests;

import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;
import static com.vildanova.tests.TestData.expectedDataToTxtFileCheck;

public class TxtFileTest {

    @Test
    void txtFileCheck() throws Exception {
        String expectedData = expectedDataToTxtFileCheck;
        String actualData;
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("txtFile.txt")) {
            actualData = new String(stream.readAllBytes(), "UTF-8");
        }
        assertThat(actualData).contains(expectedData);
    }
}
