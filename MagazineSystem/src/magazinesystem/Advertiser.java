package magazinesystem;

import magazinesystem.components.AdvertManagementSystemComponent;
import java.util.ArrayList;
import java.util.List;

public class Advertiser {
    
    private long id;
    private String name;
    private String phoneNumber;
    private String email;
    private List<Advert> adverts;
    private AdvertManagementSystemComponent amsc;
    
    //Empty constructor for advertiser
    public Advertiser() {
    }
    
    //Constructor for advertiser
    public Advertiser(long id, String name, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.adverts = new ArrayList();
        this.amsc = new AdvertManagementSystemComponent();
    }
    
    //Constructor for advertiser
    public Advertiser(long id, String name, String phoneNumber, String email, ArrayList<Advert> adverts) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.adverts = adverts;
        this.amsc = new AdvertManagementSystemComponent();
    }
    
    //Method to add a new advert
    public void addAdvert(Advert advert){
        adverts.add(advert);
    }
    
    //Getter for id
    public long getId() {
        return id;
    }
    
    //Setter for id
    public void setId(long id) {
        this.id = id;
    }
    
    //Getter for name
    public String getName() {
        return name;
    }
    
    //Setter for name
    public void setName(String name) {
        this.name = name;
    }
    
    //Getter for phone number
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    //Setter for phone number
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    //Getter for email
    public String getEmail() {
        return email;
    }
    
    //Setter for email
    public void setEmail(String email) {
        this.email = email;
    }
    
    //Getter for adverts
    public List<Advert> getAdverts() {
        return adverts;
    }
    
}
