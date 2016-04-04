package ua.org.oa.gavrishs.DTO;

import ua.org.oa.gavrishs.model.User;

import java.util.Date;

/**
 * Created by Anna on 03.04.2016.
 */
public class UserForList {
    private int id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private String email;

    public UserForList(int id, String fistName, String lastName, Date birthday) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setBirthday(birthday);

    }

    public UserForList(User user) {
        setId(user.getId());
        setFirstName(user.getFirstName());
        setLastName(user.getLastName());
        setBirthday(user.getBirthday());
        setEmail(user.getEmail());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fistName) {
        this.firstName = fistName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String emil) {
        this.email = emil;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserForList{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", birthday=").append(birthday);
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserForList that = (UserForList) o;

        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        return !(email != null ? !email.equals(that.email) : that.email != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
