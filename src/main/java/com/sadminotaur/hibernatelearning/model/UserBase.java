package com.sadminotaur.hibernatelearning.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "userBase")
@Inheritance(strategy = InheritanceType.JOINED)
public class UserBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "login")
    private String login;

    public UserBase(String login) {
        this.login = login;
    }

    public UserBase() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserBase)) return false;
        UserBase userBase = (UserBase) o;
        return getId() == userBase.getId() &&
                Objects.equals(getLogin(), userBase.getLogin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLogin());
    }
}
