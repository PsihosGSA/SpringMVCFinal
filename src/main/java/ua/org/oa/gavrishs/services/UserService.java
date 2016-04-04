package ua.org.oa.gavrishs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.org.oa.gavrishs.DTO.UserForList;
import ua.org.oa.gavrishs.dao.UserDao;
import ua.org.oa.gavrishs.model.User;

import java.util.LinkedList;
import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public UserForList create(User user) {
        userDao.create(user);
        return new UserForList(user);
    }

    @Transactional(readOnly = true)
    public UserForList getById(int id) {
        return new UserForList(userDao.getById(id));
    }

    @Transactional(readOnly = true)
    public User getUserById(int id) {
        return userDao.getById(id);
    }



    @Transactional
    public void delete(int id) {

        userDao.delete(userDao.getById(id));
    }

    @Transactional
    public User update(User user) {
        return userDao.update(user);
    }

    @Transactional(readOnly = true)
    public List<UserForList> getAll(User user) {
        List<UserForList> userForLists = new LinkedList<>();
        userDao.getAll().forEach(user1 -> {
            userForLists.add(new UserForList(user1));
        });

        userForLists.removeAll(this.getFriends(user));
        userForLists.remove(new UserForList(user));
        return userForLists;
    }

    @Transactional(readOnly = true)
    public User getByLogin(String login) {
        return userDao.getByLogin(login);
    }

    @Transactional
    public List<UserForList> getFriends(User user){
        List<UserForList> userForLists = new LinkedList<>();
        userDao.getFriends(user).forEach(friend -> {
            userForLists.add(new UserForList(friend));
        });
        return userForLists;
    }

    @Transactional
    public boolean addFriends(int userId, int friendId){
        return userDao.addFriends(userId, friendId);
    }

}
