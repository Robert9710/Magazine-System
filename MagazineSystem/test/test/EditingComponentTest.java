package test;

import magazinesystem.components.EditingComponent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class EditingComponentTest {
    
    public EditingComponentTest() {
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
        EditingComponent ec = new EditingComponent();
        String message = ec.sendAdvert("Warbutons chips");
        assertSame("Advert sent!", message);
    }
    
    @Test
    public void sendNesquickAdvert(){
        EditingComponent ec = new EditingComponent();
        String message = ec.sendAdvert("Nesquick cereals");
        assertSame("Advert sent!", message);
    }
    
    @Test
    public void sendTescoAdvert(){
        EditingComponent ec = new EditingComponent();
        String message = ec.sendAdvert("Tesco");
        assertSame("Advert sent!", message);
    }
    
    @Test
    public void sendKFCAdvert(){
        EditingComponent ec = new EditingComponent();
        String message = ec.sendAdvert("KFC");
        assertSame("Advert sent!", message);
    }
    
    @Test
    public void sendAsdaAdvert(){
        EditingComponent ec = new EditingComponent();
        String message = ec.sendAdvert("Asda");
        assertSame("Advert sent!", message);
    }
    
    @Test
    public void sendAdidasAdvert(){
        EditingComponent ec = new EditingComponent();
        String message = ec.sendAdvert("Adidas");
        assertSame("No advert with this title was found!", message);
    }
    @Test
    public void acceptWarbutonsAdvert(){
        EditingComponent ec = new EditingComponent();
        String message = ec.acceptAdvert("Warbutons chips");
        assertSame("Advert details successfully stored!", message);
    }
    
    @Test
    public void acceptNesquickAdvert(){
        EditingComponent ec = new EditingComponent();
        String message = ec.acceptAdvert("Nesquick cereals");
        assertSame("Advert details successfully stored!", message);
    }
    
    @Test
    public void acceptAsdaAdvert(){
        EditingComponent ec = new EditingComponent();
        String message = ec.acceptAdvert("Asda");
        assertSame("Advert details successfully stored!", message);
    }
    
    
    @Test
    public void acceptWarbutonsBreadAdvert(){
        EditingComponent ec = new EditingComponent();
        String message = ec.acceptAdvert("Warbutons bread");
        assertSame("No advert with this title was found!", message);
    }
    
    @Test
    public void rejectTescoAdvert(){
        EditingComponent ec = new EditingComponent();
        String message = ec.deleteAdvert("Tesco");
        assertSame("Advert deleted!", message);
    }
    
    @Test
    public void rejectKFCAdvert(){
        EditingComponent ec = new EditingComponent();
        String message = ec.deleteAdvert("KFC");
        assertSame("Advert deleted!", message);
    }
    
    @Test
    public void rejectNikeAdvert(){
        EditingComponent ec = new EditingComponent();
        String message = ec.deleteAdvert("Nike");
    assertSame("The advert could not be deleted or the advert does not exist!", message);
    }
    
}
