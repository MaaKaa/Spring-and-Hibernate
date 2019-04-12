package pl.coderslab.app.publisher;

import javax.persistence.*;

@Entity
@Table(name="publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Publisher() {
    }

    //Za pomocą atrybutu adnotacji OneToMany o nazwie mappedBy - wskazujemy nazwę pola, które odpowiada drugiej stronie relacji:
    @OneToMany(mappedBy = "publisher")
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
