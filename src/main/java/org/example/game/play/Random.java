package org.example.game.play;

import org.example.repository.WordRepositoryImpl;
import org.example.util.HibernateUtil;

public class Random {
    public static long getRandomNumber() {
        java.util.Random random = new java.util.Random();
        WordRepositoryImpl repo = new WordRepositoryImpl(HibernateUtil.getSessionFactory());
        long maxRange = repo.listAllWords().size();
        return random.nextLong(maxRange);
    }
}
