package ua.org.oa.gavrishs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.org.oa.gavrishs.dao.RequestFriendsDao;
import ua.org.oa.gavrishs.model.RequestFriends;

import java.util.List;

/**
 * Created by Anna on 02.04.2016.
 */

@Service
public class RequestFriendsService {
    @Autowired
    private RequestFriendsDao requestFriendsDao;

    @Transactional
    public RequestFriends create(RequestFriends requestFriends) {
        requestFriendsDao.create(requestFriends);
        return requestFriends;
    }

    @Transactional(readOnly = true)
    public List<RequestFriends> getAll() {
        return requestFriendsDao.getAll();
    }

    @Transactional(readOnly = true)
    public RequestFriends getById(int id) {
        return requestFriendsDao.getById(id);
    }

    @Transactional
    public void delete(int id) {

        requestFriendsDao.delete(requestFriendsDao.getById(id));
    }

    @Transactional
    public RequestFriends update(RequestFriends requestFriends) {
        return requestFriendsDao.update(requestFriends);
    }


}
