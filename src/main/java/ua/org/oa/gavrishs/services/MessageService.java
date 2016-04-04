package ua.org.oa.gavrishs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.org.oa.gavrishs.dao.MessageDao;
import ua.org.oa.gavrishs.model.Message;

import java.util.List;

/**
 * Created by Anna on 02.04.2016.
 */
@Service
public class MessageService {

    @Autowired
    private MessageDao messageDao;

    @Transactional
    public Message create(Message message) {
        messageDao.create(message);
        return message;
    }

    @Transactional(readOnly = true)
    public List<Message> getAll() {
        return messageDao.getAll();
    }

    @Transactional(readOnly = true)
    public Message getById(int id) {
        return messageDao.getById(id);
    }

    @Transactional
    public void delete(int id) {

        messageDao.delete(messageDao.getById(id));
    }

    @Transactional
    public Message update(Message message) {
        return messageDao.update(message);
    }
}
