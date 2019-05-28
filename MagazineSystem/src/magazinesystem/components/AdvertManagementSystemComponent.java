package magazinesystem.components;

import magazinesystem.components.MarketingDepartmentComponent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import magazinesystem.Advert;
import magazinesystem.Advertiser;

public class AdvertManagementSystemComponent implements AdvertManagementInterface {
    
    private MarketingDepartmentComponent mdc;
    private List<Advertiser> advertisers;
    
    //Contructor for advert management component
    public AdvertManagementSystemComponent(){
        this.mdc = new MarketingDepartmentComponent();
        this.advertisers = new ArrayList();
    }
    
    //Contructor for advert management component
    public AdvertManagementSystemComponent(ArrayList<Advertiser> advertisers, MarketingDepartmentComponent mdc){
        this.mdc = mdc;
        //OCL implementation to check that there is at least
        //one advert for each advertiser
        for(Advertiser adv : advertisers){
            if(adv.getAdverts().size()<1){
                System.out.println("There must be at least 1 advert to manage");
                break;
            }
        }
        this.advertisers = advertisers;
    }
    
    //Method to create an advert
    @Override
    public String createAdvert(String title) {
        //Variable to check if an advert with the same title already exists
        Boolean titleFound = false;
        
        String line;
        
        //OCL implementation to see if 
        //an advert with the same title already exists before creation
        try{
            //Create a file reader to read from adverts file
            FileReader fr = new FileReader("Adverts.txt");
            BufferedReader br = new BufferedReader(fr);
            line = br.readLine();
            //As long as the file has lines to read, check if any title match
            while(line!=null){
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
        
        //If the title has not been found, ask user for the other details of the advert
        if(!titleFound){
        //Create a scanner to read user input
        Scanner s = new Scanner(System.in);
        System.out.println("Please introduce your ID number:");
        long id = s.nextLong();
        s.nextLine();
        System.out.println("Please introduce your name:");
        String name = s.nextLine();
        System.out.println("Please introduce your phone number:");
        String phoneNumb = s.nextLine();
        System.out.println("Please introduce your email:");
        String email = s.nextLine();
        System.out.println("Please introduce the description:");
        String description = s.nextLine();
        System.out.println("Please introduce the width of the advert:");
        double width = s.nextDouble();
        System.out.println("Please introduce the height of the advert:");
        double height = s.nextDouble();
        s.nextLine();
        System.out.println("Please introduce the preffered location for the advert:");
        String location = s.nextLine();
        System.out.println("Please provide any other details for the advert:");
        String otherDetails = s.nextLine();
        
        try{
           //Create a file writer to write the details of the advert to the file
           FileWriter fw = new FileWriter("Adverts.txt", true);
           BufferedWriter bw = new BufferedWriter(fw);
           bw.write("Title: "+title);
           bw.newLine();
           bw.write("ID: "+id);
           bw.newLine();
           bw.write("Name: "+name);
           bw.newLine();
           bw.write("Phone Number: "+phoneNumb);
           bw.newLine();
           bw.write("Email: "+email);
           bw.newLine();
           bw.write("Description: "+description);
           bw.newLine();
           bw.write("Width: "+width);
           bw.newLine();
           bw.write("Height: "+height);
           bw.newLine();
           bw.write("Location: "+location);
           bw.newLine();
           bw.write("OtherDetails: "+otherDetails);
           bw.newLine();
           bw.newLine();
           bw.close();
           fw.close();
        }
        catch(IOException x){
            System.out.println(x.toString());
        }
        }
        //Message to inform user that an advert with the same title already exists
        else{
            return "An advert with the same title already exists. "; 
        }
        titleFound = false;
        //OCL implementation to see if 
        //an advert with the same title already exists after creation
        try{
            //Create a file reader to read from the file
            FileReader fr = new FileReader("Adverts.txt");
            BufferedReader br = new BufferedReader(fr);
            line = br.readLine();
            //As long as the file has lines to read, check if any title match
            while(line!=null){
                if(line.length()>4&&line.substring(0,5).equals("Title") && line.substring(7).equals(title)){
                    titleFound = true;
                }
                line = br.readLine();
            }
        } catch (FileNotFoundException x) {    
            System.out.println(x.toString());
        } catch (IOException x) {
            System.out.println(x.toString());
        }
        //Inform the user if the advert was created
        if(titleFound){
            return "Advert created";
        }
        //Inform the user if the advert creation failed
        else{
            return "Advert creation failed! Please try again!";
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
            //Create a file reader to read from file
            FileReader fr = new FileReader("Adverts.txt");
            BufferedReader br = new BufferedReader(fr);
            line = br.readLine();
            //Check if there are still lines to read in the file
            while(line!=null){
                //If an advert with the same title exists, omit the detaild about it
                if(line.length()>4&&line.substring(0, 5).equals("Title") && line.substring(7).equals(title)){
                    for(int i=0;i<10;i++){
                        line=br.readLine();
                    }
                }
                //Add details about the adverts with a different title to the array
                adverts.add(line);
                //Move to the next line of the file
                line=br.readLine();
            }
            FileWriter fw = new FileWriter("Adverts.txt");
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
            FileReader fr = new FileReader("Adverts.txt");
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
            return "The advert was not deleted!";
        }
        //Inform the user if the advert was deleted
        else{
            return "Advert deleted!";
        }
    }
    
    //Method to get the advertisers
    public List<Advertiser> getAdvertisers() {
        return advertisers;
    }
    
    //Method to add a new advertiser
    public void addAdvertiser(Advertiser advertiser){
        advertisers.add(advertiser);
    }
    
}
