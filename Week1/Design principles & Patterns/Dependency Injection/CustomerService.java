public class CustomerService {
    private final CustomerRepository customerRepository;

    // Constructor Injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void getCustomer(String id) {
        String customer = customerRepository.findCustomerById(id);
        System.out.println("Retrieved: " + customer);
    }
}
