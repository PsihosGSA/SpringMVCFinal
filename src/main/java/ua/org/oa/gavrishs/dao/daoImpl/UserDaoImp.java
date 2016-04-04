package ua.org.oa.gavrishs.dao.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.org.oa.gavrishs.DTO.UserForList;
import ua.org.oa.gavrishs.dao.UserDao;
import ua.org.oa.gavrishs.model.User;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Repository
public class UserDaoImp implements UserDao {
    public static final String queryAllUsers = "from User as user";
    public static final String queryUserLogin = "from User as user where user.login =:login";

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User create(User user) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        return user;
    }

    @Override
    public User getById(int id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        return user;
    }

    @Override
    public boolean delete(User user) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        return true;
    }

    @Override
    public User update(User user) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        return user;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAll() {
        List<User> userList = null;
        Session session = sessionFactory.openSession();
        Query q = session.createQuery(queryAllUsers);
        userList = (List<User>) q.list();
        session.close();
        return userList;
    }

    @Override
    public User getByLogin(String login) {
        Session session = sessionFactory.openSession();
        Query q = session.createQuery(queryUserLogin);
        q.setParameter("login", login);
        List<User> userList = (List<User>) q.list();

        session.close();

        if (userList.size() == 1) {
            return userList.get(0);
        }
        return null;
    }

    @Override
    public List<User> getFriends(User user) {
        List<User> userList = new ArrayList<>();
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        User userAndFriends = (User) session.get(User.class, user.getId());

        userAndFriends.getUserFriends().forEach(friends -> {
            userList.add(friends);
        });

        session.close();
        return userList;
    }

    @Override
    public boolean addFriends(int userId, int friendId) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        User user = session.get(User.class, userId);

        Set<User> friends = user.getUserFriends();
        System.out.println(friendId);
        friends.add(session.get(User.class, friendId));
        user.setUserFriends(friends);
        System.out.println(user);
        session.update(user);
        transaction.commit();
        return true;
    }

}

