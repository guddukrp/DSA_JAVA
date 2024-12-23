package test;

import java.io.*;
import java.net.*;

public class SunbaseUtility {

    public static void main(String[] args) {
        String bearerToken = authenticate("https://qa.sunbasedata.com/sunbase/portal/api/assignment_auth.jsp", "test@sunbasedata.com", "Test@123");
        if (bearerToken != null) {
            fetchCustomerList("https://qa.sunbasedata.com/sunbase/portal/api/assignment.jsp?cmd=get_customer_list", bearerToken);
        } else {
            System.out.println("Authentication failed. Cannot fetch customer list.");
        }
    }

    private static String authenticate(String authUrl, String loginId, String password) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(authUrl).openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            try (OutputStream outputStream = connection.getOutputStream()) {
                outputStream.write(("{\"login_id\":\"" + loginId + "\",\"password\":\"" + password + "\"}").getBytes());
            }

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String tokenString = reader.readLine();
                    return tokenString.substring(tokenString.indexOf(":") + 2, tokenString.lastIndexOf("\""));
                }
            } else {
                System.out.println("Authentication failed. Response code: " + connection.getResponseCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
 
    private static void fetchCustomerList(String customerListUrl, String bearerToken) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(customerListUrl).openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Bearer " + bearerToken);

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    System.out.println("Customer list:");
                    reader.lines().forEach(System.out::println);
                }
            } else {
                System.out.println("Failed to fetch customer list. Response code: " + connection.getResponseCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
