package Kira;

import gherkin.lexer.Pl;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

public class TestClass {
    @org.junit.Test
    public void RegisterTest() throws URISyntaxException, IOException {

        Register register=new Register("kira.zhanibek@gmail.com","12345");

        HttpClient httpClient=HttpClientBuilder.create().build();

        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("reqres.in")
                .setPath("api/register");

        HttpPost httpPost=new HttpPost(uriBuilder.build());
        ObjectMapper objectMapper=new ObjectMapper();
        httpPost.addHeader("Content-Type","application/json");
        httpPost.addHeader("Accept","application/json");

        String json=objectMapper.writeValueAsString(register);

        StringEntity entity=new StringEntity(json);

        httpPost.setEntity(entity);

        HttpResponse response=httpClient.execute(httpPost);

        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusLine().getStatusCode());

        Register createdRegister=objectMapper.readValue(response.getEntity().getContent(),Register.class);


        Assert.assertEquals(register.getEmail(),createdRegister.getEmail());
        Assert.assertEquals(register.getPassword(),createdRegister.getPassword());
    }

    @Test
    public void Login() throws URISyntaxException, IOException {
        LogIn logIn=new LogIn();
        HttpClient httpClient=HttpClientBuilder.create().build();

        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("reqres.in")
                .setPath("api/login");


        HttpPost httpPost=new HttpPost(uriBuilder.build());
        ObjectMapper objectMapper=new ObjectMapper();
        httpPost.addHeader("Content-Type","application/json");
        httpPost.addHeader("Accept","application/json");
        String json=objectMapper.writeValueAsString(logIn);
        StringEntity entity=new StringEntity(json);
        httpPost.setEntity(entity);

        HttpResponse response=httpClient.execute(httpPost);

        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusLine().getStatusCode());

        LogIn createdLogin=objectMapper.readValue(response.getEntity().getContent(),LogIn.class);

        Assert.assertEquals(logIn.getEmail(),createdLogin.getEmail());
        Assert.assertEquals(logIn.getPassword(),createdLogin.getPassword());

    }
    @Test
    public void PlaceOrder() throws URISyntaxException, IOException {
        PlaceOrder placeOrder=new PlaceOrder();
        placeOrder.setId(456);
        placeOrder.setPetId(22);
        placeOrder.setQuantity(2);
        placeOrder.setShipDate("2019-12-23T23:23:53.147Z");
        placeOrder.setStatus("placed");
        placeOrder.setComplete(true);


        HttpClient httpClient=HttpClientBuilder.create().build();

        URIBuilder uriBuilder=new URIBuilder()
                .setScheme("https")
                .setHost("petstore.swagger.io")
                .setPath("v2/store/order");


        HttpPost httpPost=new HttpPost(uriBuilder.build());
        ObjectMapper objectMapper=new ObjectMapper();
        httpPost.addHeader("Content-Type","application/json");
        httpPost.addHeader("Accept","application/json");
        String json=objectMapper.writeValueAsString(placeOrder);
        StringEntity entity=new StringEntity(json);
        httpPost.setEntity(entity);
        HttpResponse response=httpClient.execute(httpPost);

        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusLine().getStatusCode());

        PlaceOrder createdOrder=objectMapper.readValue(response.getEntity().getContent(),PlaceOrder.class);

        Assert.assertEquals(placeOrder.getId(),createdOrder.getId());












    }



}
