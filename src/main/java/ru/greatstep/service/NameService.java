package ru.greatstep.service;

import ru.greatstep.exception.MemoryIsOverException;

import javax.print.attribute.standard.MediaSize;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Spliterator;

public class NameService {

    private static final List<String> NAMES = new ArrayList<>();

    public static List<String> addName(String name) {
        if (NAMES.size() == 10) {
            throw new MemoryIsOverException("Места нет");
        }
        if (!NAMES.contains(name.toUpperCase())) {
            NAMES.add(name.toUpperCase());
            return NAMES;
        }

        return NAMES;
    }

    public static List<String> getNames() {
        return NAMES;
    }


}

