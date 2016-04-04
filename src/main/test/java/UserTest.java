

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.org.oa.gavrishs.DTO.UserForList;
import ua.org.oa.gavrishs.model.RequestFriends;
import ua.org.oa.gavrishs.model.Role;
import ua.org.oa.gavrishs.model.User;
import ua.org.oa.gavrishs.services.UserService;

import java.util.*;

/**
 * Created by Anna on 17.02.2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:appContext.xml")
public class UserTest {
    @Autowired
    private SessionFactory sessionFactory;

    Session tmpSession;
    Transaction tmpTransaction;
    UserService userService;


    @Before
    public void setUp() throws Exception{
        tmpSession = sessionFactory.openSession();
        tmpTransaction = tmpSession.getTransaction();
    }



    /*@Test
    public void testAllUsers(){
        UserDaoImpl udi = new UserDaoImpl();
        udi.getAll();
    }*/


    @Test
    public void testCreate() {

        tmpTransaction.begin();

        User user = new User();
        user.setLogin("admin2");
        user.setPassword("111");
        user.setEmail("Psihos4@yandex.ua");
        user.setFirstName("Vasay");
        user.setLastName("Pupkin");
        user.setRole(Role.ROLE_ADMIN);
        user.setBirthday(new Date(82,6,21));

        User user1= new User();
        user1.setLogin("user12");
        user1.setPassword("111");
        user1.setEmail("Psihos12@yandex.ua");
        user1.setFirstName("Peter");
        user1.setLastName("Ivanov");
        user1.setRole(Role.ROLE_USER);
        user1.setBirthday(new Date(82,6,21));

        User user2 = new User();
        user2.setLogin("user22");
        user2.setPassword("111");
        user2.setEmail("Psihos22@yandex.ua");
        user2.setFirstName("Ivan");
        user2.setLastName("Petrov");
        user2.setRole(Role.ROLE_USER);
        user2.setBirthday(new Date(82,6,21));

//        user.getUserFriends().add(user1);
//        user.getUserFriends().add(user2);


/*        List<Message> messages =  new LinkedList<Message>();
        messages.add(new Message("hdhdh",user1));
        user.setMessages(messages);*/

//        tmpSession.save(messages);
//        tmpTransaction.commit();
        tmpSession.save(user);
        tmpSession.save(user1);
        tmpSession.save(user2);

        tmpTransaction.commit();
        tmpSession.close();

//        assertEquals(1L, user.getId());
    }

    @Test
    public void testCreateFriends() {

        tmpTransaction.begin();
        User user1 = tmpSession.get(User.class,1);
        User user8 = tmpSession.get(User.class, 2);
        User user9 = tmpSession.get(User.class, 3);

        Set <User> usersFriends = user1.getUserFriends();
        usersFriends.add(user8);
        usersFriends.add(user9);
        tmpSession.save(user1);
        tmpTransaction.commit();

    }

    @Test
    public void testCreateRequestFriedns() {
        tmpTransaction.begin();
        User user1 = tmpSession.get(User.class,1);
        User user8 = tmpSession.get(User.class,2);
        User user9 = tmpSession.get(User.class,3);

        RequestFriends requestFriends = new RequestFriends();
        requestFriends.setTextMesage("11111");
        requestFriends.setAutorMessage(user8);
        requestFriends.setRecipient(user1);

        user1.getRequestFriends().add(requestFriends);

        tmpSession.save(requestFriends);

        tmpSession.save(user1);
        tmpTransaction.commit();

    }

    @Test
    public void testReadUsers() {
//        tmpTransaction.begin();
        User lastUser = (User) tmpSession.get(User.class, 1);
        System.out.println(lastUser.getBirthday());
        System.out.println(lastUser.getEmail());
        System.out.println(lastUser.getFirstName());
        System.out.println(lastUser.getLastName());
        System.out.println(lastUser.getId());
        System.out.println(lastUser.getLogin());
        System.out.println(lastUser.getPassword());
        System.out.println(lastUser.getMessages());
        System.out.println(lastUser.getRequestFriends());
        System.out.println(lastUser.getUserFriends());
        System.out.println(lastUser.getRole());
        System.out.println();
        System.out.println(lastUser);
//        tmpTransaction.

    }

    @Test
    public void testReadUsersFriends() {
//        tmpTransaction.begin();
        User lastUser = (User) tmpSession.get(User.class, 1);
        List<UserForList> userForLists = userService.getFriends(lastUser);
        System.out.println(userForLists);
//        tmpTransaction.
    }
}
