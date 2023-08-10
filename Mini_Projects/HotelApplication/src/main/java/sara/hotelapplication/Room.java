/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sara.hotelapplication;

import java.util.List;
import java.time.LocalDate;
import java.time.Month;
/**
 *
 * @author saraqin
 */
public class Room {
    
    private int roomNumber;
    private int capacity;
    private RoomType type;
    private List<LocalDate> unavailableDates;
    
    public Room (int roomNumber, int capacity, RoomType type, List<LocalDate> unavailableDates)
    {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.type = type;
        this.unavailableDates = unavailableDates;
    }
    
    public void setUnavailableDates(LocalDate checkin, LocalDate checkout) 
    {
        for (LocalDate date = checkin; date.isBefore(checkout); date.plusDays(1))
        {        
            unavailableDates.add(date);
        }     
    }
    
    public int getRoomNumber()
    {
        return roomNumber;
    }
    
    public int getCapacity()
    {
        return capacity;
    }
      
    public RoomType getRoomType()
    {
        return type;
    }
    
    public List<LocalDate> getUnavailableDates()
    {
        return unavailableDates;
    }
    
    public void setRoomNumber (int roomNumber)
    {
        this.roomNumber = roomNumber;
    }
    
    public void setCapacity (int capacity)
    {
        this.capacity = capacity;
    }
    
    
    public void setRoomType (RoomType type)
    {
        this.type = type;
    }
    
    public void setUnavailableDates(List<LocalDate> unavailableDates)
    {
        this.unavailableDates = unavailableDates;
    }
}
