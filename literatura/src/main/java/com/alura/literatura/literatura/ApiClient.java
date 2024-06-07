package com.alura.literatura.literatura;
    import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

public class ApiClient {
    private static final String API_URL = "https://gutendex.com/books/";

    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> jsonMap = mapper.readValue(response.body(), Map.class);
            System.out.println(jsonMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
}
