package ua.org.oa.gavrishs.dao;

import java.util.List;

import ua.org.oa.gavrishs.model.User;

public interface UserDao {

	User create(User user);
	User getById(int id);
	boolean delete(User user);
	User update(User user);
	List<User> getAll();
	User getByLogin(String login);
	List<User> getFriends(User user);
	boolean addFriends(int userId, int friendId);
}
