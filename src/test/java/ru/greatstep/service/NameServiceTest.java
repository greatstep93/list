package ru.greatstep.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.greatstep.exception.MemoryIsOverException;

class NameServiceTest {

    @Test
    @DisplayName("Ожидается успешное добавление элемента")
    void When_AddName_Expect_Success() {
        var expect = List.of("АЛИСА");
        Assertions.assertEquals(expect, NameService.addName("Алиса"));
    }

    @Test
    @DisplayName("Ожидается успешное добавление 10 элементов")
    void When_AddManyNames_Expect_Success() {
        var expect = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            expect.add("NAME " + i);
            NameService.addName("Name " + i);
        }
        Assertions.assertEquals(expect, NameService.getNames());
    }

    @Test
    @DisplayName("Ожидается MemoryIsOverException при добавлении 11 элементов")
    void When_AddManyNames_Expect_MemoryIsOverException() {
        Assertions.assertThrows(MemoryIsOverException.class, () -> {
            for (int i = 0; i < 11; i++) {
                NameService.addName("NAME " + i);
            }
        });
    }

    @Test
    @DisplayName("Ожидается успешное добавление 10 элементов")
    void When_AddDoubleNames_Expect_Success() {
        var expect = Collections.singletonList("АЛИСА");
        for (int i = 0; i < 10; i++) {
            NameService.addName("Алиса");
        }
        Assertions.assertEquals(expect, NameService.getNames());
    }


}