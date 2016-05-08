import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
public class main {

    public static void main(String[] args)
    {
        Customer customers[] = JsonHandler.getArrayofCustomers("customers.json");

        List<Customer> customersWithinRange  = new ArrayList<>();
        for(Customer cust : customers)
        {
            if(cust.distanceFrom(53.3381985,  -6.2592576) <= 100)
            {
                customersWithinRange.add(cust);
            }
        }
        Collections.sort(customersWithinRange);

        for(Customer cust : customersWithinRange)
        {
            System.out.println("Name: " + cust.getName() + " UserID: " + cust.getUserid() + " " + cust.distanceFrom(53.3381985,  -6.2592576) + " is km away");
        }


        //helper sort comparator for ArrayList
        Collections.sort(customersWithinRange, new Comparator<Customer>() {
            @Override
            public int compare(Customer cust1, Customer cust2) {

                return cust1.compareTo(cust2);
            }
        });


    }

}
