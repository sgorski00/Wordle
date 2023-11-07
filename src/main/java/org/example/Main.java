package org.example;


import org.example.repository.WordRepositoryImpl;
import org.example.util.HibernateUtil;

import org.example.words.website.WordExtractor;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome in game!");
        WordRepositoryImpl repository = new WordRepositoryImpl(HibernateUtil.getSessionFactory());
        WordExtractor extractor = new WordExtractor();
        try {
            extractor.addWordsFromPageToDB();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println(repository.listAllWords().size());
            HibernateUtil.shutdown();
        }
    }
}