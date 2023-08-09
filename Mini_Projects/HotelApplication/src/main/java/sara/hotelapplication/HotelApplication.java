/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package sara.hotelapplication;

import java.util.List;
/**
 *
 * @author saraqin
 */
public class HotelApplication {

    private String hotelName;
    private String hotelAddress;
    private List<Room> rooms;
    private List<Reservation> reservations;
    
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
    
    
}
