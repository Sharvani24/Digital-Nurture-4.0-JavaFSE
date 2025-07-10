import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class JwtGenerator {
    public static void main(String[] args) {
        Algorithm algorithm = Algorithm.HMAC256("secretkey");
        String token = JWT.create()
                .withClaim("sub", "1234567890")
                .withClaim("name", "John Doe")
                .withClaim("admin", true)
                .sign(algorithm);

        System.out.println("Generated JWT:");
        System.out.println(token);
    }
}
