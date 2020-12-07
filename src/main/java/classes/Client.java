package classes;

import org.hibernate.search.annotations.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Indexed
@Table(name = "client")
public class Client {
    @Id
    int id;
    //test
    @Field(index= Index.YES, analyze= Analyze.YES, store= Store.NO)
    String firstName;

    @Field(index= Index.YES, analyze= Analyze.YES, store= Store.NO)
    String secondName;

    @Field(index= Index.YES, analyze= Analyze.YES, store= Store.NO)
    String phoneNumber;

    public Client(int id, String firstName, String secondName, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
    }

    public Client() {
        id = -1;
        firstName = "defaultC";
        secondName = "defaultC";
        phoneNumber = "defaultC";
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
