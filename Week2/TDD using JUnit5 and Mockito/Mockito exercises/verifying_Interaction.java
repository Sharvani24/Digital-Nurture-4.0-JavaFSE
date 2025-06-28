
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

// Simulated external dependency
interface ExternalApi {
    void getData();
}

// Service that uses the ExternalApi
class MyService {
    private final ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public void fetchData() {
        api.getData();
    }
}

// Test class to verify method interaction
public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.fetchData();

        // Verify that getData() was called
        verify(mockApi).getData();
    }

    // Optional: A main method for demo purposes (does not run the test)
    public static void main(String[] args) {
        ExternalApi realApi = new ExternalApi() {
            @Override
            public void getData() {
                System.out.println("Real getData() called");
            }
        };

        MyService service = new MyService(realApi);
        service.fetchData(); // Outputs: Real getData() called
    }
}
