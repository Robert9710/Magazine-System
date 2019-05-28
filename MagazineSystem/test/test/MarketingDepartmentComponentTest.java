package test;

import magazinesystem.components.MarketingDepartmentComponent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MarketingDepartmentComponentTest {
    
    public MarketingDepartmentComponentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void sendWarbutonsAdvert(){
        MarketingDepartmentComponent mdc = new MarketingDepartmentComponent();
        String message = mdc.sendAdvert("Warbutons chips");
        assertSame("Advert sent!", message);
    }
    
    @Test
    public void sendNesquickAdvert(){
        MarketingDepartmentComponent mdc = new MarketingDepartmentComponent();
        String message = mdc.sendAdvert("Nesquick cereals");
        assertSame("Advert sent!", message);
    }
    
    @Test
    public void sendTescoAdvert(){
        MarketingDepartmentComponent mdc = new MarketingDepartmentComponent();
        String message = mdc.sendAdvert("Tesco");
        assertSame("Advert sent!", message);
    }
    
    @Test
    public void sendKFCAdvert(){
        MarketingDepartmentComponent mdc = new MarketingDepartmentComponent();
        String message = mdc.sendAdvert("KFC");
        assertSame("Advert sent!", message);
    }
    
    @Test
    public void sendAsdaAdvert(){
        MarketingDepartmentComponent mdc = new MarketingDepartmentComponent();
        String message = mdc.sendAdvert("Asda");
        assertSame("Advert sent!", message);
    }
    
    @Test
    public void sendSelfridgesAdvert(){
        MarketingDepartmentComponent mdc = new MarketingDepartmentComponent();
        String message = mdc.sendAdvert("Selfridges");
        assertSame("No advert with this title was found!", message);
    }
    
    @Test
    public void sendNikeAdvert(){
        MarketingDepartmentComponent mdc = new MarketingDepartmentComponent();
        String message = mdc.sendAdvert("Nike");
        assertSame("No advert with this title was found!", message);
    }
    
    @Test
    public void sendAdidasAdvert(){
        MarketingDepartmentComponent mdc = new MarketingDepartmentComponent();
        String message = mdc.sendAdvert("Adidas");
        assertSame("No advert with this title was found!", message);
    }
    
    @Test
    public void storeWarbutonsDetails(){
        MarketingDepartmentComponent mdc = new MarketingDepartmentComponent();
        String message = mdc.storeAdvertDetails("Warbutons chips");
        assertSame("The details were successfully stored!", message);
    }
    
    @Test
    public void storeNesquickDetails(){
        MarketingDepartmentComponent mdc = new MarketingDepartmentComponent();
        String message = mdc.storeAdvertDetails("Nesquick cereals");
        assertSame("The details were successfully stored!", message);
    }
    
    @Test
    public void storeTescoDetails(){
        MarketingDepartmentComponent mdc = new MarketingDepartmentComponent();
        String message = mdc.storeAdvertDetails("Tesco");
        assertSame("The details were successfully stored!", message);
    }
    
    @Test
    public void storeKFCDetails(){
        MarketingDepartmentComponent mdc = new MarketingDepartmentComponent();
        String message = mdc.storeAdvertDetails("Warbutons chips");
        assertSame("The details were successfully stored!", message);
    }
    
    @Test
    public void storeAsdaDetails(){
        MarketingDepartmentComponent mdc = new MarketingDepartmentComponent();
        String message = mdc.storeAdvertDetails("Warbutons chips");
        assertSame("The details were successfully stored!", message);
    }
    
    @Test
    public void storeSelfridgesDetails(){
        MarketingDepartmentComponent mdc = new MarketingDepartmentComponent();
        String message = mdc.storeAdvertDetails("Selfridges");
        assertSame("No advert with this title was found!", message);
    }
    
    
    @Test
    public void storeNikeDetails(){
        MarketingDepartmentComponent mdc = new MarketingDepartmentComponent();
        String message = mdc.storeAdvertDetails("Nike");
        assertSame("No advert with this title was found!", message);
    }
    
    
    @Test
    public void advertRequests(){
        MarketingDepartmentComponent mdc = new MarketingDepartmentComponent();
        int requestNumber = mdc.getRequestsNumber();
        assertEquals(5, requestNumber);
    }
    
}
