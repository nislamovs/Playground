package com.example.archives;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AchivationService_RAR_Tests {

    @InjectMocks
    AchivationService achivationService;

    @Test
    public void RarOneFileTest() {
        String result = achivationService.pushMessage("zzz");

        assertEquals("zzz", result);
    }

    @Test
    public void RarManyFilesTest() {
        String result = achivationService.pushMessage("zzz");

        assertEquals("zzz", result);
    }


    @Test
    public void RarOneDirectoryTest() {
        String result = achivationService.pushMessage("zzz");

        assertEquals("zzz", result);
    }

    @Test
    public void RarManyDirectoriesTest() {
        String result = achivationService.pushMessage("zzz");

        assertEquals("zzz", result);
    }

    @Test
    public void UnrarOneFileTest() {
        String result = achivationService.pushMessage("zzz");

        assertEquals("zzz", result);
    }

    @Test
    public void UnrarManyFilesTest() {
        String result = achivationService.pushMessage("zzz");

        assertEquals("zzz", result);
    }

    @Test
    public void UnrarOneDirectoryTest() {
        String result = achivationService.pushMessage("zzz");

        assertEquals("zzz", result);
    }

    @Test
    public void UnrarManyDirectoriesTest() {
        String result = achivationService.pushMessage("zzz");

        assertEquals("zzz", result);
    }
}
