package models;

import tools.RoomStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private RoomStatus status;
    private BigDecimal price;
    private int capacity;

    @ManyToOne
    private Hotel hotel;

    @ManyToMany(mappedBy = "rooms")
    private List<Reservation> reservations;
    public Room() {
    }

    public Room(RoomStatus status, BigDecimal price, int capacity) {

        this.status = status;
        this.price = price;
        this.capacity = capacity;
    }

    public Room(int id, RoomStatus status, BigDecimal price, int capacity) {
        this(status, price, capacity);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
