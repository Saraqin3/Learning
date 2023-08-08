/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sara.hotelapplication;

import java.time.LocalDate;
import java.time.Month;
/**
 *
 * @author saraqin
 */
public class Reservation {
    
    private String reservationID;
    private Guest guest;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    
    public Reservation(String reservationID, Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate)
    {
        this.reservationID = reservationID;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }
    
    public String getReservationID()
    {
        return reservationID;
    }
    
    public Guest getGuest()
    {
        return guest;
    }
    
    public Room getRoom()
    {
        return room;
    }
    
    public LocalDate getCheckInDate()
    {
        return checkInDate;
    }
    
    public LocalDate getCheckOutDate()
    {
        return checkOutDate;
    }
    
    public void setReservationID(String reservationID)
    {
        this.reservationID = reservationID;
    }
    
    public void setGuest(Guest guest)
    {
        this.guest = guest;
    }
    
    public void setRoom(Room room)
    {
        this.room = room;
    }
    
    public void setCheckInDate(LocalDate checkInDate)
    {
        this.checkInDate =  checkInDate;
    }
    
    public void setCheckOutDate(LocalDate checkOutDate)
    {
        this.checkOutDate = checkOutDate;
    }
}
