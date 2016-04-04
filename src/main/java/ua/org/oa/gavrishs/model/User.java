package ua.org.oa.gavrishs.model;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Anna on 15.02.2016.
 */

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUser;

    @Column (name = "login", length = 20, unique = true, nullable = false)
    private String login;

    @Column (name = "password", length = 20)
    private String password;

    @Column(name="email")
    private String email;

    @Column(name="user_surname")
    private String firstName;

    @Column(name="user_lastName")
    private String lastName;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable (name="id_users_friends", joinColumns = {@JoinColumn(name="User_ID")}, inverseJoinColumns = {@JoinColumn(name="ID_FRIENDS")})
    private Set<User> userFriends;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn (name="users_messages")
    private List<Message> messages;

    @OneToMany
    @JoinColumn (name="requestFriends")
    private Set <RequestFriends> requestFriends;

    @Column(name="role")
    @Enumerated(EnumType.STRING)
    private Role role = Role.ROLE_USER;

    public User(){}

    public User(String login, String password, String email, String firstName, String lastName, Date birthday) {
        setLogin(login);
        setPassword(password);
        setEmail(email);
        setFirstName(firstName);
        setLastName(lastName);
        setBirthday(birthday);
    }

    public User(User user) {
        this();
        setId(user.getId());
        setLogin(user.getLogin());
        setPassword(user.getPassword());
        setEmail(user.getEmail());
        setFirstName(user.getFirstName());
        setLastName(user.getLastName());
        setBirthday(user.getBirthday());
        setUserFriends(user.getUserFriends());
        setRequestFriends(user.getRequestFriends());
        setMessages(user.getMessages());
    }

    public int getId() { return idUser; }

    public void setId(int id) {
        this.idUser = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Set<User> getUserFriends() {
        return userFriends;
    }

    public void setUserFriends(Set<User> userFriends) {
        this.userFriends = userFriends;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Set<RequestFriends> getRequestFriends() {
        return requestFriends;
    }

    public void setRequestFriends(Set<RequestFriends> requestFriends) {
        this.requestFriends = requestFriends;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(idUser);
        sb.append(", login='").append(login).append("\'\n");
        sb.append(", password='").append(password).append("\'\n");
        sb.append(", email='").append(email).append("\'\n");
        sb.append(", firstName='").append(firstName).append("\'\n");
        sb.append(", lastName='").append(lastName).append("\'\n");
        sb.append(", birthday=").append(birthday).append("\'\n");
        sb.append(", id friends: ").append("\n");
        this.getUserFriends().forEach(user -> {
            sb.append(user.getId())
                    .append(user.getFirstName())
                    .append(user.getLastName());
            sb.append('\n');
        });
        sb.append(", messages=").append(messages).append("\'\n");;
        sb.append(", requestFriends=").append(requestFriends).append("\'\n");;
        sb.append(", role=").append(role).append("\'\n");;
        sb.append('}');
        return sb.toString();
    }

    public void setDate(String dateStr){
        int[] dateInt = new int[3];
        int i = 0;
        for (String s : dateStr.split("-")) {
            dateInt[i++] = Integer.parseInt(s);
        }
        this.setBirthday(new Date(dateInt[0]-1990, dateInt[1],dateInt[2]));
    }
}
