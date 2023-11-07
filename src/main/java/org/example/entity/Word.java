package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "words", uniqueConstraints = {@UniqueConstraint(columnNames = {"word"})})
public class Word {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 5)
    private String word;

    private Word(){}

    public Word(String word) {
        this.word = word;
    }

    public long id() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String word() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return word;
    }
}
