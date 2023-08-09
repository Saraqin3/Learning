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
    private Boolean isAvailable;
    private RoomType type;
    private List<LocalDate> unavailableDates;
    
    public Room (int roomNumber, int capacity, Boolean isAvailable, RoomType type, List<LocalDate> unavailableDates)
    {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.type = type;
        this.isAvailable = isAvailable;
        this.unavailableDates = unavailableDates;
    }
    
    public void setUnavailableDates(LocalDate checkin, LocalDate checkout) 
    {
        for (LocalDate date = checkin; date.isEqual(checkout); date.plusDays(1))
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
    
    public Boolean getIsAvailable()
    {
        return isAvailable;
    }
    
    public RoomType getRoomType()
    {
        return type;
    }
    
    public void setRoomNumber (int roomNumber)
    {
        this.roomNumber = roomNumber;
    }
    
    public void setCapacity (int capacity)
    {
        this.capacity = capacity;
    }
    
    public void setIsAvailable (Boolean isAvailable)
    {
        this.isAvailable = isAvailable;
    }
    
    public void setRoomType (RoomType type)
    {
        this.type = type;
    }
}
