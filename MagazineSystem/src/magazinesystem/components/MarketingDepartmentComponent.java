package magazinesystem.components;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MarketingDepartmentComponent implements MarketingDepartmentInterface {
    
    private AdvertManagementSystemComponent amsc;
    private EditingComponent ec;
    
    //Constructor for marketing department component
    public MarketingDepartmentComponent(){
        this.amsc =new AdvertManagementSystemComponent();
        this.ec = new EditingComponent();
            if(amsc.getAdvertisers().size()<1){
               System.out.println("There cannot be less than 1 advertiser");
            }
    }
    
    //Method to send the advert to the adverts request file
    @Override
    public String sendAdvert(String title) {
        String line;
        
        //Variables for the advert details
        String id = null;
        String name = null;
        String phoneNumb = null;
        String email = null;
        String description = null;
        String width = null;
        String height = null;
        String location = null;
        String otherDetails = null;
        
        //Variable to check the title
        Boolean titleFound = false;
        
        try {
            //File reader for adverts file
            FileReader fr = new FileReader("Adverts.txt");
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
            //File writer for adverts request file
            FileWriter fw = new FileWriter("AdvertsReq.txt", true);
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
        catch(FileNotFoundException x) {
            System.out.println(x.toString());
        }
        catch(IOException y) {
            System.out.println(y.toString());
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
    
    //Method to delete an advert
    @Override
    public String deleteAdvert(String title) {
        //Array to store details about the adverts that do not have this title
        List<String> adverts = new ArrayList();
        String line;
        Boolean titleFound = false;
        
        try{
            //Create a file reader to read from adverts request file
            FileReader fr = new FileReader("AdvertsReq.txt");
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
            FileWriter fw = new FileWriter("AdvertsReq.txt");
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
            FileReader fr = new FileReader("AdvertsReq.txt");
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
            return "The advert could not be deleted!";
        }
        //Inform the user that the advert was deleted
        else{
            return "Advert deleted!";
        }
    }
    
    
    //Method to store the details of the advert
    @Override
    public String storeAdvertDetails(String title) {
        
        String line;
        
        //Variables to store details of the advert
        String id = null;
        String name = null;
        String phoneNumb = null;
        String email = null;
        String description = null;
        String width = null;
        String height = null;
        String location = null;
        String otherDetails = null;
        
        Boolean titleFound = false;
        
        try {
            FileReader fr = new FileReader("AdvertsReq.txt");
            BufferedReader br = new BufferedReader(fr);
            line = br.readLine();
            //Check if there are still lines to read in the file
            while(line!=null){
                //Check if the title match
                if(line.length()>4&&line.substring(0, 5).equals("Title") && line.substring(7).equals(title)){
                    titleFound = true;
                    
                    //Store the details about the advert
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
            
            //If the title of the advert match, store the details
            if(titleFound){
            FileWriter fw = new FileWriter("AdvertsDet.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            //Store the details about the advert in adverts details file
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
        catch (IOException x) {
            System.out.println(x.toString());
        }
        //Inform the user that the details of the advert were stored
        if(titleFound){
            return "The details were successfully stored!";
        }
        //Inform the user that there is no advert with this title
        else{
            return "No advert with this title was found!";
        }
    }
    
    //Get the number of new advert requests
    @Override
    public int getRequestsNumber() {
        String line;
        
        //Variable to count new requests
        int counter = 0;
        try {
            //Create file reader to read from file
            FileReader fr = new FileReader("AdvertsReq.txt");
            BufferedReader br = new BufferedReader(fr);
            line = br.readLine();
            //Check if there are still lines to read in the file
            while(line!=null){
                //If the line gets to a title, increase the counter
                if(line.length()>4&&line.substring(0, 5).equals("Title")){
                    counter++;
                }
                line = br.readLine();
            }
            br.close();
            fr.close();
        } catch (IOException x) {
            System.out.println(x.toString());
        }
        //Return the number of new requests
        return counter;
    }
    
    //Method to display the details of the adverts requests
    @Override
    public void checkRequests() {
        String line;
        
        try {
            //File reader to read from adverts request file
            FileReader fr = new FileReader("AdvertsReq.txt");
            BufferedReader br = new BufferedReader(fr);
            line = br.readLine();
            //Display all lines from file
            while(line!=null){
                System.out.println(line);
                line = br.readLine();
            }
            br.close();
            fr.close();
        }
        catch (IOException x) {
            System.out.println(x.toString());
        }
    }
}
