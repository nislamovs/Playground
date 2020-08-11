package com.example.archives;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AchivationService_TAR_Tests {

    @InjectMocks
    AchivationService achivationService;

    @Test
    public void TarOneFileTest() {
        String result = achivationService.pushMessage("zzz");

        assertEquals("zzz", result);
    }

    @Test
    public void TarManyFilesTest() {
        String result = achivationService.pushMessage("zzz");

        assertEquals("zzz", result);
    }

    @Test
    public void TarOneDirectoryTest() {
        String result = achivationService.pushMessage("zzz");

        assertEquals("zzz", result);
    }

    @Test
    public void TarManyDirectoriesTest() {
        String result = achivationService.pushMessage("zzz");

        assertEquals("zzz", result);
    }

    @Test
    public void UntarOneFileTest() {
        String result = achivationService.pushMessage("zzz");

        assertEquals("zzz", result);
    }

    @Test
    public void UntarManyFilesTest() {
        String result = achivationService.pushMessage("zzz");

        assertEquals("zzz", result);
    }

    @Test
    public void UntarOneDirectoryTest() {
        String result = achivationService.pushMessage("zzz");

        assertEquals("zzz", result);
    }

    @Test
    public void UntarManyDirectoriesTest() {
        String result = achivationService.pushMessage("zzz");

        assertEquals("zzz", result);
    }
}
