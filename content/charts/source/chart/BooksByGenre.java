package com.sample.library.entity;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.cuba.core.entity.AbstractNotPersistentEntity;

@MetaClass(name = "library$BooksByGenre")
public class BooksByGenre extends AbstractNotPersistentEntity {

    @MetaProperty
    private String genre;

    @MetaProperty
    private Long countOfBooks;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Long getCountOfBooks() {
        return countOfBooks;
    }

    public void setCountOfBooks(Long countOfBooks) {
        this.countOfBooks = countOfBooks;
    }
}
