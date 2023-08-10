/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sara.hotelapplication;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
/**
 *
 * @author saraqin
 */
public class Reservation {
    
    private String reservationID;
    private List<Guest> guests;
    private RoomType type;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    
    public Reservation(String reservationID, List<Guest> guests, RoomType type, LocalDate checkInDate, LocalDate checkOutDate)
    {
        this.reservationID = reservationID;
        this.guests = guests;
        this.type = type;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }
    
    public String getReservationID ()
    {
        return reservationID;
    }
    
    public List<Guest> getGuests ()
    {
        return guests;
    }
    
    public RoomType getType ()
    {
        return type;
    }
    
    public LocalDate getCheckInDate ()
    {
        return checkInDate;
    }
    
    public LocalDate getCheckOutDate ()
    {
        return checkOutDate;
    }
    
    public void setReservationID (String reservationID)
    {
        this.reservationID = reservationID;
    }
    
    public void setGuests (List<Guest> guests)
    {
        this.guests = guests;
    }
    
    public void setType(RoomType type)
    {
        this.type = type;
    }
    
    public void setCheckInDate (LocalDate checkInDate)
    {
        this.checkInDate =  checkInDate;
    }
    
    public void setCheckOutDate (LocalDate checkOutDate)
    {
        this.checkOutDate = checkOutDate;
    }
    
    public Boolean isLessThan4 (List<Guest> guests)
    {
        int totalNumber = 0;
        Boolean boo = true;
        for (Guest guest : guests)
        {
            totalNumber = totalNumber + 1;
        }
        if (totalNumber > 4)
        {
            boo = false;
        }
        return boo;
    }
    
    public void printWarning (Boolean boo)
    {
        if (boo==false)
        {
            System.out.println("Please select additional room(s). One room can accomodate maximum 4 guests");
        }
    }
    
    
}
