
public class main {

    public static void main(String[] args)
    {
        Customer customers[] = InputHandler.getArrayofCustomers("customers.json");

        for(Customer cust : customers)
        {
            System.out.println(cust.getName());
        }


    }
}
