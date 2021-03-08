package com.intern.demo;

import lombok.*;

@Data
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ImportedBook extends Book {
    private String translator;

    public ImportedBook(String author, String title, String translator) {
        super(author, title);
        this.setTranslator(translator);
    }
}
