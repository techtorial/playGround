package Kubat;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

public class Test {

@org.junit.Test
    public void registeringUser() throws IOException, URISyntaxException {
    Register newUser = new Register();
    newUser.setEmail("kakaka@gmail.com");
    newUser.setPassword("kubat");

    ObjectMapper objectMapper = new ObjectMapper();

    HttpClient httpClient = HttpClientBuilder.create().build();

    URIBuilder uriBuilder = new URIBuilder()
            .setScheme("https")
            .setHost("reqres.in")
            .setPath("api/register");
    HttpPost httpPost = new HttpPost(uriBuilder.build());
    httpPost.addHeader("Content-Type", "application/json");
    httpPost.addHeader("Accept","application/json");

    //serialized object to json
    String json = objectMapper.writeValueAsString(newUser);

    //constructed post request body
    StringEntity entity = new StringEntity(json);

    //set post request body
    httpPost.setEntity(entity);

    HttpResponse response = httpClient.execute(httpPost);

    Assert.assertEquals(HttpStatus.SC_OK,response.getStatusLine().getStatusCode());

    Register createdUser = objectMapper.readValue(response.getEntity().getContent(), Register.class);

    Assert.assertEquals(newUser.getEmail(),createdUser.getEmail());
    Assert.assertEquals(newUser.getPassword(),createdUser.getPassword());

}

    @org.junit.Test
    public void login() throws URISyntaxException, IOException {

        Login login = new Login();
        login.setEmail("420blazeit@mail.ru");
        login.setPassword("bangbang");

        ObjectMapper objectMapper = new ObjectMapper();

        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder()
                .setScheme("https")
                .setHost("reqres.in")
                .setPath("api/register");
        HttpPost httpPost = new HttpPost(uriBuilder.build());
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.addHeader("Accept","application/json");

        //serialized object to json
        String json = objectMapper.writeValueAsString(login);

        //constructed post request body
        StringEntity entity = new StringEntity(json);

        //set post request body
        httpPost.setEntity(entity);

        HttpResponse response = httpClient.execute(httpPost);

        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusLine().getStatusCode());

        Login createdLogin = objectMapper.readValue(response.getEntity().getContent(), Login.class);

        Assert.assertEquals(login.getEmail(),createdLogin.getEmail());
        Assert.assertEquals(login.getPassword(),createdLogin.getPassword());

    }


    @org.junit.Test
    public void put() throws URISyntaxException, IOException {
        Put put = new Put();
        put.setName("morpheus");
        put.setJob("zion resident");

        ObjectMapper objectMapper = new ObjectMapper();

        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder()
                .setScheme("https")
                .setHost("reqres.in")
                .setPath("api/register");
        HttpPost httpPost = new HttpPost(uriBuilder.build());
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.addHeader("Accept","application/json");

        //serialized object to json
        String json = objectMapper.writeValueAsString(put);

        //constructed post request body
        StringEntity entity = new StringEntity(json);

        //set post request body
        httpPost.setEntity(entity);

        HttpResponse response = httpClient.execute(httpPost);

        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusLine().getStatusCode());

        Put updated = objectMapper.readValue(response.getEntity().getContent(), Put.class);

        Assert.assertEquals(put.getName(), updated.getName());
        Assert.assertEquals(put.getJob(),updated.getJob());
    }

    @org.junit.Test
    public void placingOrder() throws URISyntaxException, IOException {
        OrderPlace order = new OrderPlace();
        order.setId(22);
        order.setPetId(22);
        order.setQuantity(1);
        order.setShipDate("2019-12-23T23:13:07.304Z");
        order.setComplete(true);

        ObjectMapper objectMapper = new ObjectMapper();

        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder()
                .setScheme("https")
                .setHost("petstore.swagger.io")
                .setPath("v2/store/order");
        HttpPost httpPost = new HttpPost(uriBuilder.build());
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.addHeader("Accept","application/json");

        //serialized object to json
        String json = objectMapper.writeValueAsString(order);

        //constructed post request body
        StringEntity entity = new StringEntity(json);

        //set post request body
        httpPost.setEntity(entity);

        HttpResponse response = httpClient.execute(httpPost);

        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusLine().getStatusCode());

        OrderPlace placedOrder = objectMapper.readValue(response.getEntity().getContent(), OrderPlace.class);

        Assert.assertEquals(order.getId(),placedOrder.getId());
    }
}
