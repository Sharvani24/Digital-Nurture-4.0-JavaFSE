public class Main {
    public static void main(String[] args) {
        // Manually inject dependency
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        // Use service
        service.getCustomer("C101");
    }
}
