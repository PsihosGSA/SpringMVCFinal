package ua.org.oa.gavrishs.dao.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.org.oa.gavrishs.dao.MessageDao;
import ua.org.oa.gavrishs.model.Message;

import java.util.List;

/**
 * Created by Anna on 02.04.2016.
 */
@Repository
public class MessageDaoImp implements MessageDao{


    public static final String queryAllMessages = "from messages";

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Message create(Message message) {
        Session session = sessionFactory.getCurrentSession();
        session.save(message);
        session.close();
        return message;
    }

    @Override
    public Message getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Message message = (Message) session.get(Message.class, id);
        session.close();
        return message;
    }

    @Override
    public boolean delete(Message message) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(message);
        return true;
    }

    @Override
    public Message update(Message message) {
            Session session = sessionFactory.getCurrentSession();
            session.update(message);
            session.close();
            return message;
    }

    @Override
    public List<Message> getAll() {
        List<Message> messages = null;
        Session session = sessionFactory.getCurrentSession();
        Query q = session.createQuery(queryAllMessages);
        messages = (List<Message>) q.list();
        return messages;
    }
}
