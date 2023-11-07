package org.example.repository;

import org.example.entity.Word;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class WordRepositoryImpl implements WordRepository {
    private Transaction transaction = null;
    private SessionFactory sessionFactory;

    public WordRepositoryImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Word getWordById(Long id) {
        Word word = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            word = session.find(Word.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return word;
    }

    @Override
    public Word getWordByName(String name) {
        Word word = null;
        String hql = "FROM Word WHERE word=:name";
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Query<Word> query= session.createQuery(hql, Word.class);
            query.setParameter("name", name);
            word = query.uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return word;
    }

    @Override
    public void saveWord(Word word) {
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(word);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void deleteWord(Word word) {
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.remove(word);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Word> listAllWords() {
        List<Word> words = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            words = session.createQuery("from Word", Word.class).list();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return words;
    }

    @Override
    public boolean isWordInDB(String word) {
        Word finding = getWordByName(word);
        return finding != null;
    }


}
