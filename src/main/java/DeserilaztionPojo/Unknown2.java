package DeserilaztionPojo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class Unknown2 {

    @Test
    public void unknown() throws URISyntaxException, IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("reqres.in")
                .setPath("api/unknown/2");
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("Accept", "application/json");
        HttpResponse response = httpClient.execute(httpGet);
        Data1pojo userInfo1 = objectMapper.readValue(response.getEntity().getContent(), Data1pojo.class);
        System.out.println(userInfo1.getData().get("id"));
        System.out.println(userInfo1.getData().get("name"));
        System.out.println(userInfo1.getData().get("color"));
        System.out.println(userInfo1.getData().get("pantone_value"));
        System.out.println(userInfo1.getData().get("year"));
    }
}