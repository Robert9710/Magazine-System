package magazinesystem;

public class Material {
    
    private String title;
    private String description;
    private Magazine magazine;
    
    //Empty constructor for material
    public Material() {
        
    }
    
    //Constructor for material
    public Material(String title, String description) {
        this.title = title;
        this.description = description;
        this.magazine = new Magazine();
    }
    
    //Getter for title
    public String getTitle() {
        return title;
    }
    
    //Setter for title
    public void setTitle(String title) {
        this.title = title;
    }
    
    //Getter for description
    public String getDescription() {
        return description;
    }
    
    //Setter for description
    public void setDescription(String description) {
        this.description = description;
    }
    
    //Getter for magazine
    public Magazine getMagazine() {
        return magazine;
    }
    
}
