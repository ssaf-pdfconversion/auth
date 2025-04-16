package co.edu.upb.authServer.Model;
import co.edu.upb.authServer.utils.Environment;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jws;

public class ValidateModel {

   
    public boolean validateJWT(String JWT) {
        try {
            
        	 String secretKey =  Environment.getInstance().getDotenv().get("JWT_SECRET");


            
            Jws<Claims> claims = Jwts.parserBuilder()
                                     .setSigningKey(secretKey.getBytes())
                                     .build()
                                     .parseClaimsJws(JWT);

   		 
            return true;  

        } catch (JwtException e) {
            
            System.err.println("Invalid JWT: " + e.getMessage());
            return false;
        }
    }
}
