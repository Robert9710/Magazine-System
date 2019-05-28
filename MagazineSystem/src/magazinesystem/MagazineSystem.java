package magazinesystem;

import magazinesystem.components.AdvertManagementSystemComponent;

public class MagazineSystem {


    public static void main(String[] args) {
        AdvertManagementSystemComponent amsc = new AdvertManagementSystemComponent();
        String mcDonalds = amsc.createAdvert("Classic burger");
        String warbutons = amsc.createAdvert("Warbutons chips");
        String nesquick = amsc.createAdvert("Nesquick cereals");
        String tesco = amsc.createAdvert("Tesco");
        String kfc = amsc.createAdvert("KFC");
        String nesquickAdv = amsc.createAdvert("Nesquick hot chocolate");
        String warbutonsAdv = amsc.createAdvert("Warbutons bread");
        String asda = amsc.createAdvert("Asda");
    }
    
}
