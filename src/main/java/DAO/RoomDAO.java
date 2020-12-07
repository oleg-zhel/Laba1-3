package DAO;

import classes.Room;
import interfaces.DAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;

public class RoomDAO implements DAO<Room> {
    @Override
    public void save(Room obj) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(obj);
        transaction.commit();
        session.close();
    }
    //Tes
    @Override
    public void update(Room obj) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(obj);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Room obj) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(obj);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Room> search(String fieldName, String value) throws InterruptedException {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        FullTextSession fullTextSession = Search.getFullTextSession(session);
        fullTextSession.createIndexer().startAndWait();

        QueryBuilder queryBuilder = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Room.class).get();

        org.apache.lucene.search.Query query = queryBuilder.keyword().onField(fieldName).matching(value).createQuery();
        org.hibernate.query.Query hibQuery = fullTextSession.createFullTextQuery(query, Room.class);

        List result = hibQuery.list();

        transaction.commit();
        session.close();

        return result;
    }

    @Override
    public Room getById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Room.class, id);
    }

    @Override
    public List<Room> findAll() {
        List<Room> objects = (List<Room>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Room").list();
        return objects;
    }

    public List<Room> roomList = new ArrayList<>();

    public List<Room> getRoomList() {
        return roomList;
    }

    public RoomDAO() {
        roomList = findAll();
    }
}
