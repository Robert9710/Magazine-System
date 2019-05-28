package magazinesystem;

import java.util.Date;

public class Photograph extends Material {
    
    private String dateTaken;
    
    //Constructor for photograph
    public Photograph(String title, String description, String dateTaken) {
        super(title, description);
        this.dateTaken = dateTaken;
    }
    
    //Getter for the date when the photograph was taken
    public String getDateTaken() {
        return dateTaken;
    }
    
    //Setter for the date when the photograph was taken
    public void setDateTaken(String dateTaken) {
        this.dateTaken = dateTaken;
    }
    
    
}
