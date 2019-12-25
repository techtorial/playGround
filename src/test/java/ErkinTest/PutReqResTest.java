package ErkinTest;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class PutReqResTest {

    @Test
    public void updateTest() throws URISyntaxException, IOException {
        PutReqRes update=new PutReqRes();
        update.setJob("zion resident");
        update.setName("morpheus");
        update.setUpdatedAt("2019-12-24T02:22:02.015Z");
        ObjectMapper objectMapper = new ObjectMapper();
        HttpClient httpClient = HttpClientBuilder.create().build();
      //  HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("reqres.in")
                .setPath("api/users/2");
        HttpPut httpPut = new HttpPut(uriBuilder.build());
        httpPut.addHeader("Content-Type", "application/json");
        httpPut.addHeader("Accept", "application/json");
        String json = objectMapper.writeValueAsString(update);
        System.out.println(json);
        StringEntity entity = new StringEntity(json);
        httpPut.setEntity(entity);
        HttpResponse response = httpClient.execute(httpPut);
      //  HttpResponse response = httpClient.execute(httpPut);
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
        PutReqRes UpdateUser = objectMapper.readValue(response.getEntity().getContent(), PutReqRes.class);
        Assert.assertEquals(update.getJob(), UpdateUser.getJob());
        Assert.assertEquals(update.getName(), UpdateUser.getName());
    }
}


