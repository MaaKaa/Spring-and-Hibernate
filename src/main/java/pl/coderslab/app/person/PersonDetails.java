package pl.coderslab.app.person;

import javax.persistence.*;

@Entity
@Table(name="person-details")
public class PersonDetails {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long Id;
    private String firstName;
    private String lastName;
    private String streetNumber;
    private String street;
    private String city;

    public PersonDetails() {
    }

    public long getId() {
        return Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public void setId(long id) {
        Id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
