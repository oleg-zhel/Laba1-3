package classes;

import org.hibernate.annotations.NamedQuery;
import org.hibernate.search.annotations.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Indexed
@Table(name = "user")
@NamedQuery(name = "Find user",query = "from User where login = : login")
public class User {
    @Id
    int id;

    @Size(min = 2,max = 15, message = "wrong size")
    @Field(index= Index.YES, analyze= Analyze.YES, store= Store.NO)
    String login;

    @NotNull
    @Field(index= Index.YES, analyze= Analyze.YES, store= Store.NO)
    String password;

    @Max(1)
    @Field(index= Index.YES, analyze= Analyze.YES, store= Store.NO)
    int role;

    public User(int id, String login, String password, int role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User() {
        id = -1;
        login = "defaultC";
        password = "defaultC";
        role = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
