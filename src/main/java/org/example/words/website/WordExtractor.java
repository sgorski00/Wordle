package org.example.words.website;

import org.example.entity.Word;
import org.example.repository.WordRepositoryImpl;
import org.example.util.HibernateUtil;
import org.example.words.IsWordValid;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class WordExtractor {
    private static final String LINK_TO_PAGE_WITH_WORDS = "https://7esl.com/5-letter-words/";
    private final Set<String> words = new HashSet<>();
    private final WordRepositoryImpl repo = new WordRepositoryImpl(HibernateUtil.getSessionFactory());

    public WordExtractor() {
        try {
            initializeSet();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addWordsFromSetToDB() {
        for (String w: words) {
            repo.saveWord(new Word(w));
        }
    }

    private void initializeSet() throws IOException {
        StringBuilder content = WebsiteReader.read(LINK_TO_PAGE_WITH_WORDS);
        String word;
        int indexStart = content.indexOf("<li>");
        int indexEnd;

        for (int i = indexStart; i < content.length(); i++) {
            try {
                indexStart = content.indexOf("<li>", i);
                indexEnd = content.indexOf("</li>", i);
                word = content.substring(indexStart + 4, indexEnd);
                i = indexEnd;
                addWordToSetIfValid(word.toLowerCase());
            } catch (StringIndexOutOfBoundsException ignored) {}
        }
    }

    private void addWordToSetIfValid(String word){
        if (IsWordValid.isValid(word)) {
            words.add(word);
        }
    }
}
