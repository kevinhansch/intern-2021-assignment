package com.intern.demo;

import lombok.*;

@Data
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class LocalBook extends Book {
    private String store;

    public LocalBook(String author, String title, String store) {
        super(author, title);
        this.setStore(store);
    }
}
