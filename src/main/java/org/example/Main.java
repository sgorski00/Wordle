package org.example;


import org.example.game.Menu;
import org.example.repository.WordRepositoryImpl;
import org.example.util.HibernateUtil;

import org.example.words.website.WordExtractor;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.menu();

    }
}