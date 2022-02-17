import models.Customer;
import models.Hotel;
import models.Room;
import org.hibernate.Session;
import repositories.CustomerRepository;
import repositories.HotelRepository;
import repositories.RoomRepository;
import tools.HibernateUtil;
import tools.RoomStatus;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        //Session hiberanate
        Session session = HibernateUtil.getSessionFactory().openSession();

        //Création d'un fake hotel
        /*Hotel hotel = new Hotel();
        hotel.setName("Hotel F1");
        for(int i=1; i <= 10; i++) {
            Room room;
            if(i%2 == 0) {
                room = new Room(RoomStatus.FREE, BigDecimal.valueOf(40), 5);
            }
            else {
                room = new Room(RoomStatus.FREE, BigDecimal.valueOf(35), 3);
            }
            hotel.getRooms().add(room);
        }


        //Création de l'hotel repository
        HotelRepository hotelRepository = new HotelRepository(session);
        hotelRepository.create(hotel);*/

        //Récupérer un hotel
        //Hotel hotel = new HotelRepository(session).find(6);
        //Créer un client
        //CustomerRepository customerRepository = new CustomerRepository(session);
        /*Customer customer = new Customer("toto","tata", "0606060606");
        customer.getHotels().add(hotel);
        customerRepository.create(customer);*/
        //Récupérer les client d'un hotel
        //List<Customer> customers = customerRepository.findAllByHotelId(6);

        //Test du roomRepository
        RoomRepository roomRepository = new RoomRepository(session);
        /*Room room = roomRepository.find(1);
        room.setStatus(RoomStatus.BUSY);
        roomRepository.update(room);*/
        List freeRooms = roomRepository.findByHotelIdAndStatus(6, RoomStatus.BUSY);
    }
}
