package ua.org.oa.gavrishs.dao.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.org.oa.gavrishs.dao.RequestFriendsDao;
import ua.org.oa.gavrishs.model.RequestFriends;

import java.util.List;

/**
 * Created by Anna on 02.04.2016.
 */
@Repository
public class RequestFriendsDaoImp implements RequestFriendsDao {


    public static final String queryStrAllCor = "from request_friends";

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public RequestFriends create(RequestFriends message) {
        Session session = sessionFactory.getCurrentSession();
        session.save(message);
        session.close();
        return message;
    }

    @Override
    public RequestFriends getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        RequestFriends message = (RequestFriends) session.get(RequestFriends.class, id);
        session.close();
        return message;
    }

    @Override
    public boolean delete(RequestFriends message) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(message);
        return true;
    }

    @Override
    public RequestFriends update(RequestFriends message) {
        Session session = sessionFactory.getCurrentSession();
        session.update(message);
        session.close();
        return message;
    }

    @Override
    public List<RequestFriends> getAll() {
        List<RequestFriends> messages = null;
        Session session = sessionFactory.getCurrentSession();
        Query q = session.createQuery(queryStrAllCor);
        messages = (List<RequestFriends>) q.list();
        return messages;
    }
}
