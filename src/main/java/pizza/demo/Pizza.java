package pizza.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pizza {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;

    private Float price;

    private String commandToPrepare;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getCommandToPrepare() {
        return commandToPrepare;
    }

    public void setCommandToPrepare(String commandToPrepare) {
        this.commandToPrepare = commandToPrepare;
    }

    public String toString(){
        return id+" | " + name+ " | "+ commandToPrepare +" | "+ price;
    }
}
