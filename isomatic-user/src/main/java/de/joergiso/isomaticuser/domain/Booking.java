package de.joergiso.isomaticuser.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Booking {
    @Id
    private Long id;

    public Booking() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
