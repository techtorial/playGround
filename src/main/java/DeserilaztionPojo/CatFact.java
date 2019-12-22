package DeserilaztionPojo;
import org.junit.Assert;


import org.apache.http.HttpResponse;

import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.Asserts;
import org.codehaus.jackson.map.ObjectMapper;


import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class CatFact {
    @Test
    public void catfact1() throws IOException, URISyntaxException {
        ObjectMapper objectMapper = new ObjectMapper();///for deserialization we use ->Jackson library


        //Creating client( like postman)

        HttpClient httpClient = HttpClientBuilder.create().build();// HttpClieant is interface
        // constructing URL
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("http")
                .setHost("cat-fact.herokuapp.com")
                .setPath("facts")
        .setCustomQuery("amaount=1000");

        // defining a Get method
        HttpGet httpGet = new HttpGet(uriBuilder.build());// it is class   also get  DEserilization
        httpGet.addHeader("Accept", "application/json");
        //executing the api call
        HttpResponse response = httpClient.execute(httpGet);


        // jackson libraries
  Allpojo catlist = objectMapper.readValue(response.getEntity().getContent(),Allpojo.class);
        System.out.println(catlist.getAll().get(0).getUser());
        int count = 0;
        for (Allpojo map1 : catlist.getAll()){
           String fact = (String) map1.getText();
                ++count;
                System.out.println(count + "facts"+fact);
            }
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
        }
    }

