package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String rue;

    private String ville;

    private String codePostal;

    @ManyToMany
    @JoinTable(name = "contact_adresse",
            joinColumns = {@JoinColumn(name = "adresse_id")},
            inverseJoinColumns = {@JoinColumn(name = "contact_id")})
    private List<Contact> contacts;

    public Adresse() {
        contacts = new ArrayList<>();
    }

    public Adresse(String rue, String ville, String codePostal) {
        this();
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
    }

    public Adresse(int id, String rue, String ville, String codePostal) {
        this(rue, ville, codePostal);
        this.id = id;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
