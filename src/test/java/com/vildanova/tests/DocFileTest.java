package com.vildanova.tests;

import org.junit.jupiter.api.Test;

import static com.vildanova.tests.TestData.expectedDataToDocCheck;
import static com.vildanova.tests.TestData.expectedDataToDocsCheck;
import static com.vildanova.utils.Files.readDocFromPath;
import static com.vildanova.utils.Files.readDocxFromPath;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class DocFileTest {

    @Test
    public void docxTest() throws Exception {
        String actualData = "./src/test/resources/docsFile.docx";
        String expectedData = expectedDataToDocCheck;
        assertThat(readDocxFromPath(actualData), containsString(expectedData));
    }

    @Test
    public void docTest() throws Exception {
        String actualData = "./src/test/resources/docFile.doc";
        String expectedData = expectedDataToDocsCheck;
        assertThat(readDocFromPath(actualData), containsString(expectedData));
    }
}
