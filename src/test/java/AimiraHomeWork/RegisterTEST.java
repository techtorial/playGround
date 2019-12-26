package AimiraHomeWork;

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
import java.net.URISyntaxException;

public class RegisterTEST {

    @Test
    public void registerTest() throws URISyntaxException, IOException {

        RegisterPOJO registerPOJO = new RegisterPOJO();

        registerPOJO.setEmail("eve.holt@reqres.in");
        registerPOJO.setPassword("pistol");
        registerPOJO.setId(4);
        registerPOJO.setToken("QpwL5tke4Pnpja7X4");

        ObjectMapper objectMapper = new ObjectMapper();

        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("reqres.in")
                .setPath("api/register");

        HttpPost httpPost = new HttpPost(uriBuilder.build());
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.addHeader("Accept", "application/json");


        String json = objectMapper.writeValueAsString(registerPOJO);
        System.out.println(json);

        StringEntity entity = new StringEntity(json);

        httpPost.setEntity(entity);

        HttpResponse response = httpClient.execute(httpPost);
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());

        RegisterPOJO user = objectMapper.readValue(response.getEntity().getContent(), RegisterPOJO.class);

        Assert.assertEquals(registerPOJO.getId(), user.getId());
        Assert.assertEquals(registerPOJO.getToken(), user.getToken());

    }
}

