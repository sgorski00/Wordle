package org.example;

import org.example.game.Menu;
import org.example.repository.WordRepositoryImpl;
import org.example.util.HibernateUtil;
import org.example.words.website.WordExtractor;

public class Main {
    public static void main(String[] args) {
        WordRepositoryImpl repo = new WordRepositoryImpl(HibernateUtil.getSessionFactory());
        if (repo.listAllWords().size() < 1) {
            WordExtractor updateDB = new WordExtractor();
            updateDB.addWordsFromSetToDB();
        }

        Menu menu = new Menu();
        menu.menu();
    }
}