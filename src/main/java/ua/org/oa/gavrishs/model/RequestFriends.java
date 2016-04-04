package ua.org.oa.gavrishs.model;

import javax.persistence.*;

/**
 * Created by Anna on 01.04.2016.
 */

@Entity
@Table(name = "request_friends")
public class RequestFriends {

    @Id
    @GeneratedValue
    private int idRequestFriend;

    @Column(name = "textRequest")
    private String textMesage;

    @ManyToOne
    @JoinColumn(name = "AUTOR_ID")
    private User autorMessage;

    @ManyToOne
    @JoinColumn(name = "RECIPIENT_ID")
    private User recipient;

    @Column (name="ignoring")
    private boolean ignoring;

    public RequestFriends(){}

    public RequestFriends(String textMesage, User autorMassage, User recipient) {
        setTextMesage(textMesage);
        setAutorMessage(autorMassage);
        setRecipient(recipient);
    }

    public int getId() {
        return idRequestFriend;
    }

    public void setId(int id) {
        this.idRequestFriend = id;
    }

    public String getTextMesage() {
        return textMesage;
    }

    public void setTextMesage(String textMesage) {
        this.textMesage = textMesage;
    }

    public User getAutorMessage() {
        return autorMessage;
    }

    public void setAutorMessage(User autorMassage) {
        this.autorMessage = autorMassage;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public boolean getIgnore() {
        return ignoring;
    }

    public void setIgnore(boolean ignore) {
        this.ignoring = ignore;
    }

    public boolean isIgnore() { return ignoring; }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RequestFriends{");
        sb.append("id=").append(idRequestFriend);
        sb.append(", textMesage='").append(textMesage).append('\'');
        sb.append(", autorMassage=")
                .append(autorMessage.getId())
                .append(autorMessage.getFirstName())
                .append(autorMessage.getLastName());

        sb.append(", recipient=")
                .append(recipient.getId())
                .append(recipient.getFirstName())
                .append(recipient.getLastName());

        sb.append(", ignore=").append(ignoring);
        sb.append('}');
        return sb.toString();
    }

}
