package pl.coderslab.app.person;

import javax.persistence.*;

@Entity
@Table(name="persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long Id;
    private String login;
    private String password;
    private String email;

    @OneToOne
    @JoinColumn(name = "person-details_id", unique=true)
    private PersonDetails personDetails;

    public Person() {
    }

    public long getId() {
        return Id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setId(long id) {
        Id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

