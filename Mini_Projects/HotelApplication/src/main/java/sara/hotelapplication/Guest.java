/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sara.hotelapplication;

/**
 *
 * @author saraqin
 */
public class Guest {
    
    
    private String guestID;
    private String name;
    private String contactNumber;
    
    public Guest (String guestID, String name, String contactNumber)
    {
        this.guestID = guestID;
        this.name = name;
        this.contactNumber = contactNumber;
    }
    
    public String getGuestID()
    {
        return guestID;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getContactNumber()
    {
        return contactNumber;
    }
    
    public void setGuestID(String guestID)
    {
        this.guestID = guestID;
    }
    
    public void setName (String name)
    {
        this.name = name;
    }
    
    public void setcontactNumber(String contactNumber)
    {
        this.contactNumber = contactNumber;
    }
    
    
}
