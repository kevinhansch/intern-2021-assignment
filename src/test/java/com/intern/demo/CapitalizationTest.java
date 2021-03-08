package com.intern.demo;


import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CapitalizationTest {

    @Test
    public void convertToMapTest() {
        ImportedBook importedBook1 = new ImportedBook("joHN dOE", "IMPORTED book 1", "joHN dOE");
        ImportedBook importedBook2 = new ImportedBook("joHN dOE", "IMPORTED book 2", "joHN dOE");
        ImportedBook importedBook3 = new ImportedBook("joHN dOE", "IMPORTED book 3", "joHN dOE");
        ImportedBook importedBook4 = new ImportedBook("joHN dOE", "IMPORTED book 4", "joHN dOE");

        LocalBook localBook1 = new LocalBook("jaNE stARk", "loCal bOok 1", "gramEDia");
        LocalBook localBook2 = new LocalBook("jaNE stARk", "loCal bOok 2", "gramEDia");
        LocalBook localBook3 = new LocalBook("jaNE stARk", "loCal bOok 3", "gramEDia");
        LocalBook localBook4 = new LocalBook("jaNE stARk", "loCal bOok 4", "gramEDia");

        List<Book> books = Arrays.asList(importedBook1, importedBook2, importedBook3, importedBook4, localBook1, localBook2, localBook3, localBook4);

        Map<String, List<String>> result = Capitalization.convertToMap(books);

        int authorIndex = 0;
        for (String author : result.keySet()) { ;
            if (authorIndex == 0) {
                assertEquals("Jane Stark", author);

                int bookIndex = 0;
                for (String title : result.get(author)) {
                    if (bookIndex == 0) {
                        assertEquals("Local Book 1", title);
                    } else if (bookIndex == 1) {
                        assertEquals("Local Book 2", title);
                    } else if (bookIndex == 2) {
                        assertEquals("Local Book 3", title);
                    } else if (bookIndex == 3) {
                        assertEquals("Local Book 4", title);
                    }
                    bookIndex++;
                }
            } else if (authorIndex == 1) {
                assertEquals("John Doe", author);

                int bookIndex = 0;
                for (String title : result.get(author)) {
                    if (bookIndex == 0) {
                        assertEquals("Imported Book 1", title);
                    } else if (bookIndex == 1) {
                        assertEquals("Imported Book 2", title);
                    } else if (bookIndex == 2) {
                        assertEquals("Imported Book 3", title);
                    } else if (bookIndex == 3) {
                        assertEquals("Imported Book 4", title);
                    }
                    bookIndex++;
                }
            }
            authorIndex++;
        }

        System.out.println(result);
    }
}
