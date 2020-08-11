package com.example.archives;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AchivationService_ZIP_Tests {

    @InjectMocks
    AchivationService achivationService;

    @Test
    public void ZipOneFileTest() {
        String result = achivationService.pushMessage("zzz");

        assertEquals("zzz", result);
    }

    @Test
    public void ZipManyFilesTest() {
        String result = achivationService.pushMessage("zzz");

        assertEquals("zzz", result);
    }


    @Test
    public void ZipOneDirectoryTest() {
        String result = achivationService.pushMessage("zzz");

        assertEquals("zzz", result);
    }

    @Test
    public void ZipManyDirectoriesTest() {
        String result = achivationService.pushMessage("zzz");

        assertEquals("zzz", result);
    }

    @Test
    public void UnzipOneFileTest() {
        String result = achivationService.pushMessage("zzz");

        assertEquals("zzz", result);
    }

    @Test
    public void UnzipManyFilesTest() {
        String result = achivationService.pushMessage("zzz");

        assertEquals("zzz", result);
    }

    @Test
    public void UnzipOneDirectoryTest() {
        String result = achivationService.pushMessage("zzz");

        assertEquals("zzz", result);
    }

    @Test
    public void UnzipManyDirectoriesTest() {
        String result = achivationService.pushMessage("zzz");

        assertEquals("zzz", result);
    }
}
