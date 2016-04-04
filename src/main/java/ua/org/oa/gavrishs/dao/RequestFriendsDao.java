package ua.org.oa.gavrishs.dao;

import ua.org.oa.gavrishs.model.RequestFriends;

import java.util.List;

/**
 * Created by Anna on 02.04.2016.
 */
public interface RequestFriendsDao {

    RequestFriends create(RequestFriends requestFriends);
    RequestFriends getById(int id);
    boolean delete(RequestFriends requestFriends);
    RequestFriends update(RequestFriends requestFriends);
    List<RequestFriends> getAll();
}
