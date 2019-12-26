package API;

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

public class SwaggerPetOrderTest {

    @Test

    public void newOrderSwagger() throws IOException, URISyntaxException {

        SwaggerPetOderPojo petOrderPojo=new SwaggerPetOderPojo();

        petOrderPojo.setId(1);
        petOrderPojo.setPetId(4);
        petOrderPojo.setQuantity(1);
        petOrderPojo.setShipDate("2019-12-24T00:53:17.618+0000");
        petOrderPojo.setStatus("placed");
        petOrderPojo.setComplete(true);



        ObjectMapper objectMapper=new ObjectMapper();

        String jsonUser= objectMapper.writeValueAsString(petOrderPojo);

        StringEntity userEntity= new StringEntity(jsonUser);

        HttpClient httpClient=HttpClientBuilder.create().build();
        URIBuilder uriBuilder= new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("petstore.swagger.io")
                .setPath("v2/store/order");  //https://petstore.swagger.io/v2/store/order

        // content type header is used to request api calls (body format specification)

        // accept   header is used to response  api calls (body format specification)


        HttpPost httpPost= new HttpPost(uriBuilder.build());
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.addHeader("Accept", "application/json");
        httpPost.setEntity(userEntity);

        System.out.println(jsonUser);

        HttpResponse response=httpClient.execute(httpPost);


        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());


        SwaggerPetOderPojo expectedPetOrderPojo= objectMapper.readValue(response.getEntity().getContent(), SwaggerPetOderPojo.class);


        Assert.assertEquals(expectedPetOrderPojo.getId(),petOrderPojo.getId());
        Assert.assertEquals(expectedPetOrderPojo.getPetId(),petOrderPojo.getPetId());
        Assert.assertEquals(expectedPetOrderPojo.getQuantity(),petOrderPojo.getQuantity());
        Assert.assertEquals(expectedPetOrderPojo.getStatus(),petOrderPojo.getStatus());
        Assert.assertEquals(expectedPetOrderPojo.getShipDate(),petOrderPojo.getShipDate());




    }

}
