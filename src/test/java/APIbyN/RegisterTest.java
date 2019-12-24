package APIbyN;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;

public class RegisterTest {

    @Test

    public void registerNewUser() throws URISyntaxException, IOException {


        RegisterPojo newUser= new RegisterPojo();


        newUser.setEmail("eve.holt@reqres.in");

        newUser.setPassword("pistol");

        newUser.setId(4);

        newUser.setToken("QpwL5tke4Pnpja7X4");

        ObjectMapper objectMapper=new ObjectMapper();

        String jsonUser= objectMapper.writeValueAsString(newUser);

        StringEntity userEntity= new StringEntity(jsonUser);

        HttpClient httpClient=HttpClientBuilder.create().build();
        URIBuilder uriBuilder= new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("reqres.in")
                .setPath("api/register");

        // content type header is used to request api calls (body format specification)
        // accept   header is used to response  api calls (body format specification)


        HttpPost httpPost= new HttpPost(uriBuilder.build());
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.addHeader("Accept", "application/json");
        httpPost.setEntity(userEntity);

        System.out.println(jsonUser);

        HttpResponse response=httpClient.execute(httpPost);

        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());

        RegisterPojo actualUser= objectMapper.readValue(response.getEntity().getContent(), RegisterPojo.class);

        Assert.assertEquals(newUser.getId(),actualUser.getId());
        Assert.assertEquals(newUser.getToken(),actualUser.getToken());

    }

}
