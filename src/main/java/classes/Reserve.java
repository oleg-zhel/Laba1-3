package classes;

import org.hibernate.search.annotations.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Indexed
@Table(name = "reserv")
public class Reserve {
    @Id
    int id;

    @Field(index= Index.YES, analyze= Analyze.YES, store= Store.NO)
    int idClient;

    @Field(index= Index.YES, analyze= Analyze.YES, store= Store.NO)
    int idRoom;

    @Field(index= Index.YES, analyze= Analyze.YES, store= Store.NO)
    int length;

    public Reserve(int id, int idClient, int idRoom, int length) {
        this.id = id;
        this.idClient = idClient;
        this.idRoom = idRoom;
        this.length = length;
    }

    public Reserve() {
        id = -1;
        idClient = -1;
        idRoom = -1;
        length = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
