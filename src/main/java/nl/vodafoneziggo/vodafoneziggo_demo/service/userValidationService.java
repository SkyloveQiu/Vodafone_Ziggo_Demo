package nl.vodafoneziggo.vodafoneziggo_demo.service;


import nl.vodafoneziggo.vodafoneziggo_demo.models.Order;
import org.apache.http.client.utils.URIBuilder;
import org.json.*;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class userValidationService {
    public static Order validateUser(String user_email, String productID) throws Exception {
        URI service_URI = new URI("https://reqres.in/api/users");
        HttpRequest request = HttpRequest.newBuilder(service_URI).GET().build();
        if (!request.uri().equals(service_URI)) {
            throw new Exception("Server error");
        }
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject json = new JSONObject(response.body());
        int num_pages = json.getInt("total_pages");
        for (int i = 1; i <= num_pages; i++) {
            URI new_URI = new URIBuilder(service_URI).addParameter("page", Integer.toString(i)).addParameter("per_page", "6").build();
            request = HttpRequest.newBuilder(new_URI).GET().build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONArray dataList = new JSONObject(response.body()).getJSONArray("data");
            for (int j = 0; j < dataList.length(); j++) {
                JSONObject data = dataList.getJSONObject(j);
                String current_email = data.getString("email");
                if (current_email.equals(user_email)) {
                    return new Order(user_email, data.getString("first_name"), data.getString("last_name"),productID);
                }
            }
        }
        return null;
    }
}
