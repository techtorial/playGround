package DeserilaztionPojo;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FindStatus {
    @Test
    public void mystatus() throws IOException, URISyntaxException {
        ObjectMapper objectMapper = new ObjectMapper();///for deserialization we use ->Jackson library

        HttpClient httpClient = HttpClientBuilder.create().build();// HttpClieant is interface
        // constructing URL
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("petstore.swagger.io")
                .setPath("pet/findByStatus")
                .setCustomQuery("status");

        // defining a Get method
        HttpGet httpGet = new HttpGet(uriBuilder.build());// it is class   also get  DEserilization
        httpGet.addHeader("Accept", "application/json");
        //executing the api call
        HttpResponse response = httpClient.execute(httpGet);

        //Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
        // jackson libraries
       FindStatusPojo findStatusPojo=objectMapper.readValue(response.getEntity().getContent(),FindStatusPojo.class);
        //for (Map<String,Object> list:findStatusPojo.getStatus().) {
        System.out.println(findStatusPojo);
        }




    }

