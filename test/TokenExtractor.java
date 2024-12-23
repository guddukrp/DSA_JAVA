package test;

public class TokenExtractor {
    public static void main(String[] args) {
        String tokenString = "{\"access_token\":\"dGVzdEBzdW5iYXNlZGF0YS5jb206VGVzdEAxMjM=\"}";

        // Find the index of the first occurrence of the token
        int startIndex = tokenString.indexOf(":") + 2; // Adding 2 to skip the ":\""

        // Find the index of the last occurrence of the token
        int endIndex = tokenString.lastIndexOf("\"");

        // Extract the token substring
        String token = tokenString.substring(startIndex, endIndex);

        System.out.println("Token: " + token);
    }
}
