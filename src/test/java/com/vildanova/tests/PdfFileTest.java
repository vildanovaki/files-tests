package com.vildanova.tests;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;
import static com.vildanova.tests.TestData.expectedNumberOfPages;

public class PdfFileTest {

    @Test
    void pfdFileCheck() throws Exception {
        int expectedData = expectedNumberOfPages;
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream stream = classLoader.getResourceAsStream("pdfFile.pdf");
        PDF actualData = new PDF(stream);
        assertThat(actualData.numberOfPages).isEqualTo(expectedData);
    }
}
