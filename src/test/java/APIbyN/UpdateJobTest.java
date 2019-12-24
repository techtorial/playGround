package APIbyN;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class UpdateJobTest {

    @Test

    public void updateJobInfo() throws IOException, URISyntaxException {


        UpdateJobPojo updatedInfo= new UpdateJobPojo();


        updatedInfo.setName("morpheus");

        updatedInfo.setJob("zion resident");

        updatedInfo.setUpdatedAt("2019-12-24T00:21:56.760Z");

        ObjectMapper objectMapper=new ObjectMapper();

        String jsonUser= objectMapper.writeValueAsString(updatedInfo);

        StringEntity userEntity= new StringEntity(jsonUser);

        CloseableHttpClient httpClient=HttpClientBuilder.create().build();
        URIBuilder uriBuilder= new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("reqres.in")
                .setPath("api/users/2");

        // content type header is used to request api calls (body format specification)
        // accept   header is used to response  api calls (body format specification)


        HttpPut httpPut= new HttpPut(uriBuilder.build());
        httpPut.addHeader("Content-Type", "application/json");
        httpPut.addHeader("Accept", "application/json");
        httpPut.setEntity(userEntity);

        System.out.println(jsonUser);

        CloseableHttpResponse response=httpClient.execute(httpPut);

        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());

        UpdateJobPojo actualInfo= objectMapper.readValue(response.getEntity().getContent(), UpdateJobPojo.class);

        Assert.assertEquals(updatedInfo.getJob(),actualInfo.getJob());
        Assert.assertEquals(updatedInfo.getName(),actualInfo.getName());
        // Assert.assertEquals(updatedInfo.getUpdatedAt(),actualInfo.getUpdatedAt());   failing because of the time difference


    }


}
