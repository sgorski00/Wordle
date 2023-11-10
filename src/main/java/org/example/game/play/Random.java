package org.example.game.play;

import org.example.repository.WordRepositoryImpl;
import org.example.util.HibernateUtil;

import java.util.List;

public class Random {
    public static long getRandomNumber() {
        WordRepositoryImpl repo = new WordRepositoryImpl(HibernateUtil.getSessionFactory());
        java.util.Random random = new java.util.Random();
        List<Long> list = repo.listAllIds();
        return list.get(random.nextInt(list.size()));
    }
}
