package htwberlin.webtech;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Plant {

    @Id
    private Long id;
    private String name;
    private String duration;


    public Plant() {
        this.name = name;
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
}
