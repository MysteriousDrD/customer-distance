import org.json.simple.JSONObject;
public class Customer {
    private long userid;
    private String name;
    private double latitude;
    private double longitude;

    public Customer(JSONObject cust)
    {
        this.name = cust.get("name").toString();
        this.userid = (long) cust.get("user_id");
        this.latitude = Double.parseDouble(cust.get("latitude").toString());
        this.longitude = Double.parseDouble(cust.get("longitude").toString());
    }

    public String getName()
    {
        return this.name;
    }

    public long getUserid()
    {
        return this.userid;
    }

    public double getLatitude()
    {
        return this.latitude;
    }

    public double getLongitude()
    {
        return this.longitude;
    }
}
