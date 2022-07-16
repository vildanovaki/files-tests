package com.vildanova.tests;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;
import static com.vildanova.tests.TestData.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class XlsFileTest {

    @Test
    void xlsSimpleTest() throws Exception {
        String expectedData = expectedDataToXlsFileSimpleCheck;
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream stream = classLoader.getResourceAsStream("xlsFile.xls");
        XLS xls = new XLS(stream);
        assertThat(xls, XLS.containsText(expectedData));
    }

    @Test
    void xlsCellTest() throws Exception {
        String expectedData = expectedDataToXlsFileCellCheck;
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream stream = classLoader.getResourceAsStream("xlsFile.xls");
        XLS xls = new XLS(stream);
        String actualData = xls.excel.getSheetAt(0).getRow(5).getCell(4).toString();
        assertThat(actualData, containsString(expectedData));
    }

    @Test
    void simpleXlsxFileCheck() throws Exception {
        String expectedData = expectedDataToXlsxFileCheck;
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream stream = classLoader.getResourceAsStream("xlsxFile.xlsx");
        XLS xlsx = new XLS(stream);
        String actualData = xlsx.excel.getSheetAt(0).getRow(2).getCell(1).toString();
        assertThat(actualData).contains(expectedData);
    }
}
