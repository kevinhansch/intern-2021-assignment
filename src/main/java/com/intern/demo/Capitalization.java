package com.intern.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class Capitalization {

    private static String capitalize (String input) {
        boolean foundSpace = true;
        char[] inputCharArray = input.toCharArray();

        for (int i = 0; i < inputCharArray.length; i++) {
            if (Character.isLetter(inputCharArray[i])) {
                if (foundSpace) {
                    inputCharArray[i] = Character.toUpperCase(inputCharArray[i]);
                    foundSpace = false;
                } else {
                    inputCharArray[i] = Character.toLowerCase(inputCharArray[i]);
                }
            } else {
                foundSpace = true;
            }
        }

        return String.valueOf(inputCharArray);
    }

    public static Map<String, List<String>> convertToMap (List<Book> inputs) {

        if (inputs.isEmpty()) {
            return null;
        }

        return inputs.stream()
                .collect(Collectors.groupingBy(book -> capitalize(book.getAuthor()),
                        Collectors.mapping(book -> capitalize(book.getTitle()), Collectors.toList())));
    }
}
