public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(String id) {
        // Simulate fetching from DB
        return "Customer[ID: " + id + ", Name: John Doe]";
    }
}
