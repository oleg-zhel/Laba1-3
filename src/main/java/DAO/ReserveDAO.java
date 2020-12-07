package DAO;

import classes.Reserve;
import interfaces.DAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;

public class ReserveDAO implements DAO<Reserve> {
    @Override
    public void save(Reserve obj) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(obj);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Reserve obj) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(obj);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Reserve obj) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(obj);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Reserve> search(String fieldName, String value) throws InterruptedException {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        FullTextSession fullTextSession = Search.getFullTextSession(session);
        fullTextSession.createIndexer().startAndWait();

        QueryBuilder queryBuilder = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Reserve.class).get();

        org.apache.lucene.search.Query query = queryBuilder.keyword().onField(fieldName).matching(value).createQuery();
        org.hibernate.query.Query hibQuery = fullTextSession.createFullTextQuery(query, Reserve.class);

        List result = hibQuery.list();

        transaction.commit();
        session.close();

        return result;
    }

    @Override
    public Reserve getById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Reserve.class, id);
    }

    @Override
    public List<Reserve> findAll() {
        List<Reserve> objects = (List<Reserve>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Reserve ").list();
        return objects;
    }

    public List<Reserve> reserveList = new ArrayList<>();

    public List<Reserve> getReserveList() {
        return reserveList;
    }

    public ReserveDAO() {
        reserveList = findAll();
    }
}
