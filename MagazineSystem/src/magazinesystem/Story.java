package magazinesystem;

import java.util.Date;

public class Story extends Material {
    
    private String dateWritten;
    
    //Constructor for story
    public Story(String title, String description, String dateWritten) {
        super(title, description);
        this.dateWritten = dateWritten;
    }
    
    //Getter for the date when the story was written
    public String getDateWritten() {
        return dateWritten;
    }
    
    //Setter for the date when the story was written
    public void setDateWritten(String dateWritten) {
        this.dateWritten = dateWritten;
    }
    
}
