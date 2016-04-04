package ua.org.oa.gavrishs.dao;

import ua.org.oa.gavrishs.model.Message;

import java.util.List;

/**
 * Created by Anna on 02.04.2016.
 */
public interface MessageDao {

    Message create(Message message);
    Message getById(int id);
    boolean delete(Message message);
    Message update(Message message);
    List<Message> getAll();
}
