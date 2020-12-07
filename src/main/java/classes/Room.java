package classes;

import org.hibernate.search.annotations.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Indexed
@Table(name = "room")
public class Room {
    @Id
    int id;

    @Field(index= Index.YES, analyze= Analyze.YES, store= Store.NO)
    String location;

    @Field(index= Index.YES, analyze= Analyze.YES, store= Store.NO)
    String number;

    @Field(index= Index.YES, analyze= Analyze.YES, store= Store.NO)
    int price;

    public Room(int id, String location, String number, int price) {
        this.id = id;
        this.location = location;
        this.number = number;
        this.price = price;
    }

    public Room() {
        id = -1;
        location = "defaultC";
        number = "defaultC";
        price = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
