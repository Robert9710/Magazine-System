package magazinesystem;

public class Advert extends Material {
    
    private double dimensionX;
    private double dimensionY;
    private String locationOnPage;
    private String otherDetails;
    private Advertiser advertiser;
    
    //Constructor for advert
    public Advert(String title, String description, double dimensionX, double dimensionY, String locationOnPage, String otherDetails, Advertiser advertiser) {
        super(title, description);
        //OCL implementation to check that the length and width
        //of the advert are greater than zero
        if(dimensionX<=0){
            System.out.println("Length must be greater than zero");
        }
        else{
        this.dimensionX = dimensionX;
        }
        if(dimensionY<=0){
            System.out.println("Width must be greater than zero");
        }
        else{
        this.dimensionY = dimensionY;
        }
        this.locationOnPage = locationOnPage;
        this.otherDetails = otherDetails;
        this.advertiser = advertiser;
        
    }
    
    //Getter for length
    public double getDimensionX() {
        return dimensionX;
    }
    
    //Setter for length
    public void setDimensionX(double dimensionX) {
        //Code to check that length of the advert is greate than zero
        if(dimensionX<=0){
            System.out.println("Length must be greater than zero");
        }
        else{
        this.dimensionX = dimensionX;
        }
    }
    
    //Getter for width
    public double getDimensionY() {
        return dimensionY;
    }
    
    //Setter for width
    public void setDimensionY(double dimensionY) {
        //Code to check that width of the advert is greate than zero
        if(dimensionY<=0){
            System.out.println("Width must be greater than zero");
        }
        else{
        this.dimensionY = dimensionY;
        }
    }
    
    //Getter for location
    public String getLocationOnPage() {
        return locationOnPage;
    }
    
    //Setter for location
    public void setLocationOnPage(String locationOnPage) {
        this.locationOnPage = locationOnPage;
    }
    
    //Getter for details
    public String getOtherDetails() {
        return otherDetails;
    }
    
    //Setter for details
    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }
    
    //Getter for advertiser
    public Advertiser getAdvertiser() {
        return advertiser;
    }
    
}
