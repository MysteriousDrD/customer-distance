import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class CustomerTest {

    Customer cust;
    Customer cust2;
    @Before
    public void setUp() throws Exception {
        JSONObject testCustomer = (JSONObject) new JSONParser().parse("{\"latitude\": \"52.986375\", \"user_id\": 12, \"name\": \"Christina McArdle\", \"longitude\": \"-6.043701\"}");
        cust = new Customer(testCustomer);

        JSONObject testCustomer2 = (JSONObject) new JSONParser().parse("{\"latitude\": \"51.92893\", \"user_id\": 1, \"name\": \"Alice Cahill\", \"longitude\": \"-10.27699\"}");
        cust2 = new Customer(testCustomer2);
    }

    @Test
    public void getName(){
        Assert.assertEquals("Christina McArdle", cust.getName());
    }

    @Test
    public void getUserid(){
        Assert.assertEquals(12, cust.getUserid());
    }

    @Test
    public void getLatitude(){
        Assert.assertEquals(52.986375, cust.getLatitude(), 0);
    }

    @Test
    public void getLongitude(){
        Assert.assertEquals(-6.043701, cust.getLongitude(), 0);
    }

    @Test
    public void distanceFrom() throws Exception {
        Assert.assertEquals(41.67683909574447, cust.distanceFrom(53.3381985, -6.2592576), 0);
    }

    @Test
    public void compareTo() throws Exception {
        Assert.assertEquals(1, cust.compareTo(cust2));
    }

}