package ua.org.oa.gavrishs.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Anna on 01.04.2016.
 */

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMessage;
    @Column(name = "textMesage")
    private String textMesage;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeCreate = new Date(System.currentTimeMillis());

    @ManyToOne
    @JoinColumn(name = "AUTOR_ID")
    private User autorMessage;

    /*@ManyToOne
    @JoinColumn(name = "RECIPIENT_ID")
    private User recipient;*/

    public Message(){}

    public Message(String textMesage, User autorMassage/*, User recipient*/) {
        setTextMesage(textMesage);
        setAutorMessage(autorMassage);
//        setRecipient(recipient);

    }

    public int getId() {
        return idMessage;
    }

    public void setId(int idMessage) {
        this.idMessage = idMessage;
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

    public Date getTimeCreate() { return timeCreate; }

    public void setTimeCreate(Date timeCreate) {
        this.timeCreate = timeCreate;
    }

    /*
    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }
*/

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Message{");
        sb.append("id=").append(idMessage);
        sb.append(", textMesage='").append(textMesage).append('\'');
        sb.append(", timeCreate=").append(timeCreate);
        sb.append(", autorMassage=")
                .append(autorMessage.getId())
                .append(autorMessage.getFirstName())
                .append(autorMessage.getLastName());
//        sb.append(", recipient=").append(recipient);
        sb.append('}');
        return sb.toString();
    }
}
