package magazinesystem.components;

import magazinesystem.components.MarketingDepartmentComponent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import magazinesystem.Magazine;

public class EditingComponent implements EditingInterface {
    
    private MarketingDepartmentComponent mdc;
    private List<Magazine> magazines;
    
    //Constructor for editing component
    public EditingComponent(){
        this.mdc = new MarketingDepartmentComponent();
        this.magazines = new ArrayList();
    }
    
    //Method to delete an advert
    @Override
    public String deleteAdvert(String title) {
        //Array to store details about the adverts that do not have this title
        List<String> adverts = new ArrayList();
        String line;
        Boolean titleFound = false;
        
        try{
            FileReader fr = new FileReader("NewAdverts.txt");
            BufferedReader br = new BufferedReader(fr);
            line = br.readLine();
            //Check if there are still lines to read in the file
            while(line!=null){
                //If an advert with the same title exists, omit the details about it
                if(line.length()>4&&line.substring(0, 5).equals("Title") && line.substring(7).equals(title)){
                    
                    for(int i=0;i<10;i++){
                        line=br.readLine();
                        
                    }
                }
                //Add details about the adverts with a different title to the array
                adverts.add(line);
                line=br.readLine();
            }
            FileWriter fw = new FileWriter("NewAdverts.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            //Write the details of the adverts from the array to the file
            for(String s : adverts){
                bw.write(s);
            }
        }
        catch (FileNotFoundException x) {
            System.out.println(x.toString());
        } 
        catch (IOException x) {
            System.out.println(x.toString());
        }
        
        //OCL implementation to check if the advert has been deleted
        try{
            //Create a file reader to read from file
            FileReader fr = new FileReader("NewAdverts.txt");
            BufferedReader br = new BufferedReader(fr);
            line = br.readLine();
            //Check if there are still lines to read in the file
            while(line!=null){
                //Check if there is still an advert with the same title in the file
                if(line.length()>4&&line.substring(0, 5).equals("Title") && line.substring(7).equals(title)){
                    titleFound = true;
                }
                line = br.readLine();
            }
        } catch (FileNotFoundException x) {    
            System.out.println(x.toString());
        } catch (IOException x) {
            System.out.println(x.toString());
        }
        //Inform the user if an advert with the same title still exists
        if(titleFound){
            return "The advert could not be deleted or the advert does not exist!";
        }
        //Inform the user that the advert was deleted
        else{
            return "Advert deleted!";
        }
    }
    
    //Method to accept an advert
    @Override
    public String acceptAdvert(String title) {
        String line;
        
        //Variables to store the advert details
        String id = "";
        String name = null;
        String phoneNumb = null;
        String email = null;
        String description = "";
        String width = "";
        String height = "";
        String location = "";
        String otherDetails = "";
        
        //Method to check if the title matches
        Boolean titleFound = false;
        
        try{
            //Create a file reader to read from new adverts file
            FileReader fr = new FileReader("NewAdverts.txt");
            BufferedReader br = new BufferedReader(fr);
            line = br.readLine();
            //As long as the file has lines to read, check if any title match
            while(line!=null){
                //Check if the title match
                if(line.length()>4&&line.substring(0, 5).equals("Title") && line.substring(7).equals(title)){
                    titleFound = true;
                    
                    //Store the details of the advert in variables
                    id = br.readLine();
                    name = br.readLine();
                    phoneNumb = br.readLine();
                    email = br.readLine();
                    description = br.readLine();
                    width = br.readLine();
                    height = br.readLine();
                    location = br.readLine();
                    otherDetails = br.readLine();
                    break;
                }
                line = br.readLine();
            }
            
            br.close();
            fr.close();
            
            //If the advert was found in new adverts file, send it to accepted adverts file
            if(titleFound){
            FileWriter fw = new FileWriter("AcceptedAdverts.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            //Write the details of the advert to the file
            bw.write("Title: "+title);
            bw.newLine();
            bw.write(id);
            bw.newLine();
            bw.write(name);
            bw.newLine();
            bw.write(phoneNumb);
            bw.newLine();
            bw.write(email);
            bw.newLine();
            bw.write(description);
            bw.newLine();
            bw.write(width);
            bw.newLine();
            bw.write(height);
            bw.newLine();
            bw.write(location);
            bw.newLine();
            bw.write(otherDetails);
            bw.newLine();
            bw.newLine();
            bw.close();
            fw.close();
            //Delete the advert from new advert file
            deleteAdvert(title);
            }
        }
        catch (FileNotFoundException x) {
            System.out.println();
        } 
        catch (IOException x) {
            System.out.println(x.toString());
        }
        //Inform user that the advert details were stored
        if(titleFound){
            return "Advert details successfully stored!";
        }
        //Inform user that no advert was found
        else{
            return "No advert with this title was found!";
        }
    }
    
    //Method to send the advert to the adverts request file
    @Override
    public String sendAdvert(String title) {
        String line;
        
        //Variable for the advert details
        String id = "";
        String name = null;
        String phoneNumb = null;
        String email = null;
        String description = "";
        String width = "";
        String height = "";
        String location = "";
        String otherDetails = "";
        
        //Variable to check if the title match
        Boolean titleFound = false;
        
        try{
            //File reader to read from adverts request file
            FileReader fr = new FileReader("AdvertsReq.txt");
            BufferedReader br = new BufferedReader(fr);
            line = br.readLine();
            //Check if there are lines to read from file
            while(line!=null){
                //Check if the title match
                if(line.length()>4&&line.substring(0, 5).equals("Title") && line.substring(7).equals(title)){
                    titleFound = true;
                    
                    //Store the details of the advert in variables
                    id = br.readLine();
                    name = br.readLine();
                    phoneNumb = br.readLine();
                    email = br.readLine();
                    description = br.readLine();
                    width = br.readLine();
                    height = br.readLine();
                    location = br.readLine();
                    otherDetails = br.readLine();
                    break;
                }
                
                line = br.readLine();
            }
            br.close();
            fr.close();
            
            //If the advert was found in adverts file, send it to adverts request file
            if(titleFound){
            //File writer for new adverts file
            FileWriter fw = new FileWriter("NewAdverts.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            //Write the details of the advert to the file
            bw.write("Title: "+title);
            bw.newLine();
            bw.write(id);
            bw.newLine();
            bw.write(name);
            bw.newLine();
            bw.write(phoneNumb);
            bw.newLine();
            bw.write(email);
            bw.newLine();
            bw.write(description);
            bw.newLine();
            bw.write(width);
            bw.newLine();
            bw.write(height);
            bw.newLine();
            bw.write(location);
            bw.newLine();
            bw.write(otherDetails);
            bw.newLine();
            bw.newLine();
            bw.close();
            fw.close();
            }
        }
        catch (FileNotFoundException x) {
            System.out.println(x.toString());
        } 
        catch (IOException x) {
            System.out.println(x.toString());
        }
        
        //Inform user that the advert was sent
        if(titleFound){
            return "Advert sent!";
        }
        
        //Inform user that no advert with this title exists
        else{
            return "No advert with this title was found!";
        }
        
    }
    
    //Method to get the magazines
    public List<Magazine> getMagazines() {
        return magazines;
    }
    
    //Method to add a new magazine
    public void addMagazine(Magazine magazine){
        magazines.add(magazine);
    }
    
}
