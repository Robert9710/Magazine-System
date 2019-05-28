package magazinesystem;

import magazinesystem.components.EditingComponent;
import java.util.ArrayList;
import java.util.List;

public class Magazine {
    
    public long id;
    private int issueNo;
    private List<Material> content;
    private EditingComponent ec;
    
    //Empty constructor for magazine
    public Magazine() {
        
    }
    
    //Constructor for magazine
    public Magazine(long id, int issueNo) {
        this.id = id;
        //OCL implementation to check that issue number is greater or equal to 1
        if(issueNo<1){
            System.out.println("Issue number cannot be less than 1");
        }
        else{
        this.issueNo = issueNo;
        }
        content = new ArrayList<>();
        ec = new EditingComponent();
        //OCL implementation to check that content has at least one element
        if(content.size()<1){
            System.out.println("There must be at least 1 advert to manage");
        }
        
    }
    
    //Method to add an advert in the magazine
    public void addAdvert(String title, String description, double dimensionX, double dimensionY, String location, String otherDetails, Advertiser advertiser){
        Advert advert = new Advert(title, description, dimensionX, dimensionY, location, otherDetails, advertiser);
        content.add(advert);
    }
    
    //Method to add a photograph in the magazine
    public void addPhotograph(String title, String description, String dateTaken){
        Photograph photograph = new Photograph(title, description, dateTaken);
        content.add(photograph);
    }
    
    //Method to add a story in the magazine
    public void addStory(String title, String description, String dateWritten){
        Story story = new Story(title, description, dateWritten);
        content.add(story);
    }
    
    //Getter for id
    public long getId() {
        return id;
    }
    
    //Setter for id
    public void setId(long id) {
        this.id = id;
    }
    
    //Getter for issue number
    public int getIssueNo() {
        return issueNo;
    }
    
    //Setter for issue number
    public void setIssueNo(int issueNo) {
        this.issueNo = issueNo;
    }
    
    //Getter for materials
    public List<Material> getMaterials() {
        return content;
    }
    
}
