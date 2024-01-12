package htwberlin.webtech.web.api;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String duration;
    private boolean watered;


    protected Plant() {
    }

    public Plant(String name, String duration, boolean watered) {
        this.name = name;
        this.duration = duration;
        this.watered = watered;
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

    public boolean getWatered() {return watered;}
    public void setWatered(boolean watered) {this.watered = watered;}

    @Override
    public String toString() {
        return "Plant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }

    @Override
    public boolean equals (Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Plant plant)) return false;

        if(getDuration() != plant.getDuration()) return false;
        if(getId() != null ? !getId().equals(plant.getId()) : plant.getId() != null) return false;
        return getName() != null ? getName().equals(plant.getName()) : plant.getName() == null;
    }

    @Override
    public int hashCode(){
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() !=null ? getName().hashCode() : 0);
        result = Integer.parseInt(31 * result + getDuration());
        return result;
    }
}
