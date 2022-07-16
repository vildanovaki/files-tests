package com.vildanova.tests;

import net.lingala.zip4j.exception.ZipException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.vildanova.utils.Files.readTextFromPath;
import static com.vildanova.utils.Zip.unzip;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;


public class ZipFileTest {

    @Test
    void zipWithPasswordTest() throws Exception, ZipException {
        String zipFilePath = "./src/test/resources/zipFile.zip";
        String unzipFolderPath = "./src/test/resources/files/unzip";
        String zipPassword = "123";
        String unzipTxtFilePath = "./src/test/resources/files/unzip/zipFile.txt";
        String expectedData = "Zip архив";

        unzip(zipFilePath, unzipFolderPath, zipPassword);
        String actualData = readTextFromPath(unzipTxtFilePath);
        assertThat(actualData, containsString(expectedData));
    }
}
