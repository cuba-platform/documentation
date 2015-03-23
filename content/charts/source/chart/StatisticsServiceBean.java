package com.sample.library.service;

import com.google.common.collect.Lists;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.sample.library.entity.BooksByGenre;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service(StatisticsService.NAME)
public class StatisticsServiceBean implements StatisticsService {

    @Inject
    private Persistence persistence;


    @Override
    public List<BooksByGenre> getCountOfBooksByGenre() {
        List<BooksByGenre> result = new ArrayList<>();
        String query = "select ltype.name, count(book) " +
                       "from library$Book book join book.literatureType ltype " +
                       "group by ltype.name order by ltype.name";
        Transaction transaction = persistence.createTransaction();
        try {
            EntityManager em = persistence.getEntityManager();
            List<Object[]> resultList = em.createQuery(query, Object[].class).getResultList();

            for (Object[] row : resultList) {
                BooksByGenre entity = new BooksByGenre();
                entity.setGenre((String) row[0]);
                entity.setCountOfBooks((Long) row[1]);
                result.add(entity);
            }
        } finally {
            transaction.end();
        }

        return result;
    }

    @Override
    public List<String> getTopPublishers(final int count) {
        List<String> result = Lists.newArrayList();
        String query = "select instance.bookPublication.publisher.name, count(instance) " +
                "from library$BookInstance instance " +
                "group by instance.bookPublication.publisher.name order by count(instance) desc";
        Transaction transaction = persistence.createTransaction();
        try {
            EntityManager em = persistence.getEntityManager();
            List resultList = em.createQuery(query).getResultList();

            for (int i = 0; i < resultList.size(); i++) {
                if (i == count) {
                    break;
                }
                Object[] data = (Object[]) resultList.get(i);
                result.add((String) data[0]);
            }
        } finally {
            transaction.end();
        }

        return result;
    }

    @Override
    public Map<Integer, Map<String, Long>> getCountOfBooksByPublisherAndYear() {
        Map<Integer, Map<String, Long>> result = new LinkedHashMap<>();
        String query = "select instance.bookPublication.publisher.name, instance.bookPublication.year, count(instance) " +
                "from library$BookInstance instance " +
                "group by instance.bookPublication.year, instance.bookPublication.publisher.name " +
                "order by instance.bookPublication.year, instance.bookPublication.publisher.name";
        Transaction transaction = persistence.createTransaction();
        try {
            EntityManager em = persistence.getEntityManager();
            List resultList = em.createQuery(query).getResultList();

            for (Object row : resultList) {
                Object[] data = (Object[]) row;

                String publisher = (String) data[0];
                Integer year = (Integer) data[1];
                Long quantity = (Long) data[2];

                if (result.get(year) == null) {
                    result.put(year, new LinkedHashMap<String, Long>());
                }
                result.get(year).put(publisher, quantity);
            }
        } finally {
            transaction.end();
        }

        return result;
    }
}
