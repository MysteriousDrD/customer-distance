import org.json.simple.JSONObject;
public class Customer implements Comparable<Customer>{
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

    public double distanceFrom(double targetLat, double targetLong)
    {
        double earthSize = 6371.0; //radius of earth in KM
        double diffLat = Math.toRadians(targetLat - this.latitude);
        double diffLong = Math.toRadians(targetLong - this.longitude);
        double sinLong = Math.sin(diffLong/2);
        double sinLat = Math.sin(diffLat/2);

        double term1 = Math.pow(sinLat, 2) + Math.pow(sinLong, 2)
                * Math.cos(Math.toRadians(this.latitude)) * Math.cos(Math.toRadians(targetLat));

        double term2 = 2 * Math.atan2(Math.sqrt(term1), Math.sqrt(1-term1));
        double dist = earthSize * term2;

        return dist;
    }

    @Override
    public int compareTo(Customer cust) {
        if(this.userid == cust.userid)
        {
            return 0;
        }
        else if (this.userid < cust.userid ){
            return -1;
        }
        else{
            return 1;
        }


    }
}
