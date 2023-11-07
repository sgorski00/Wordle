package org.example.repository;

import org.example.entity.Word;

import java.util.List;

public interface WordRepository {
    Word getWordById(Long id);

    Word getWordByName(String name);

    void saveWord(Word word);

    void deleteWord(Word word);

    List<Word> listAllWords();

    boolean isWordInDB(String word);
}
