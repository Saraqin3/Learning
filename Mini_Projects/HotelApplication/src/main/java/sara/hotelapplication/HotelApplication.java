/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package sara.hotelapplication;

import java.util.List;
import java.time.LocalDate;
import java.time.Month;
/**
 *
 * @author saraqin
 */
public class HotelApplication {

    private String hotelName;
    private String hotelAddress;
    private List<Room> rooms;
    
    
    
    public void run ()
    {
        
    }
    
    public static void main(String[] args) {
        System.out.println("Welcome to Hotel!"); 
    }
    
    public HotelApplication(String hotelName, String hotelAddress, List<Room> rooms)
    {
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.rooms = rooms;
    }
    
    public String getHotelName()
    {
        return hotelName;
    }
    
    public String getHotelAddress()
    {
        return hotelAddress;
    }
    
    public List<Room> getRooms()
    {
        return rooms;
    }
    
    public void setHotelName (String hotelName)
    {
        this.hotelName = hotelName;
    }
    
    public void setHotelAddress(String hotelAddress)
    {
        this.hotelAddress = hotelAddress;
    }
    
    public void setRooms (List<Room> rooms)
    {
        this.rooms = rooms;
    }
    
    public Boolean isAvailable (Room room, LocalDate checkin, LocalDate checkout)
    {
        List<LocalDate> reservedDates = null;
        Boolean boo = true;
        for (LocalDate date = checkin; date.isBefore(checkout); date.plusDays(1))
        {        
            reservedDates.add(date);
        } 

                for (LocalDate date : room.getUnavailableDates())
                {
                    for (LocalDate reservedDate : reservedDates)
                    {
                        if (date.equals(reservedDate))
                        {
                            boo = false;
                            break;
                        }
                    }
                    
                    if (boo == false)
                    {
                        break;
                    }
                }
        return boo;
    }
    
    public List<Room> findRooms (RoomType type)
    {
        List <Room> rightRooms = null;
        for (Room room : rooms)
        {
            if (room.getRoomType().equals(type))
            {
                rightRooms.add(room);
            }
           
        }
        return rightRooms;
    }
    
    public Boolean validReservation (Reservation reservation)//A valid reservation meets 2 requirments: roomtype and dates
    {
        RoomType type = reservation.getType();
        LocalDate checkin = reservation.getCheckInDate();
        LocalDate checkout = reservation.getCheckOutDate();
        List<Room> rightRooms = findRooms(type);
        Boolean boo = true;
        
        for (Room room : rightRooms)
        {
            boo = isAvailable(room, checkin, checkout);
                    
        }
        return boo;
    }
    
    
}
