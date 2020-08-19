package com.sadminotaur.hibernatelearning.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "autos")
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "model")
    private String model;

    @Column(name = "color")
    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Auto(String model, String color) {
        this.model = model;
        this.color = color;
    }

    public Auto() {
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Auto)) return false;
        Auto auto = (Auto) o;
        return getId() == auto.getId() &&
                Objects.equals(getModel(), auto.getModel()) &&
                Objects.equals(getColor(), auto.getColor()) &&
                Objects.equals(getUser(), auto.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getModel(), getColor(), getUser());
    }
}
