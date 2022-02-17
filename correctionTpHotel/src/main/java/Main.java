import models.Hotel;
import models.Room;
import org.hibernate.Session;
import repositories.HotelRepository;
import tools.HibernateUtil;
import tools.RoomStatus;

import java.math.BigDecimal;

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
        Hotel hotel = new HotelRepository(session).find(6);
    }
}
