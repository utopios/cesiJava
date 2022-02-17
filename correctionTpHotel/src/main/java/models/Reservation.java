package models;

import tools.ReservationStatus;
import tools.RoomStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private ReservationStatus status;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany
    @JoinTable(name = "reservation_room",
            joinColumns = {@JoinColumn(name = "reservation_id")},
            inverseJoinColumns = {@JoinColumn(name = "room_id")})
    private List<Room> rooms;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    public Reservation() {
        rooms = new ArrayList<>();
        status = ReservationStatus.CONFIRMED;
    }

    public Reservation(ReservationStatus status, Customer customer) {
        this();
        this.status = status;
        this.customer = customer;
    }

    public Reservation(int id, ReservationStatus status, Customer customer) {
        this(status, customer);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void addRoom(Room room) {
        rooms.add(room);
        room.setStatus(RoomStatus.BUSY);
    }
}
