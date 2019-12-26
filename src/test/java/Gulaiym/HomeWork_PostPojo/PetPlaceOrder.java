package Gulaiym.HomeWork_PostPojo;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class PetPlaceOrder {

    @Test
    public void placePetOrder() throws IOException, URISyntaxException {
        src.test.java.Gulaiym.HomeWork_PostPojo.PetOrderPojo placeOrder = new src.test.java.Gulaiym.HomeWork_PostPojo.PetOrderPojo(1992,11,9,"gulaiym_placed",true);
        placeOrder.setShipDate("2019-12-24T02:03:10.648Z");

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
        objectMapper.writeValue(new File("src/test/java/Gulaiym/HomeWork_PostPojo/petOrderPlace.json"), placeOrder);

        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder()
                .setScheme("https")
                .setHost("petstore.swagger.io")
                .setPath("v2/store/order");

        HttpPost httpPost = new HttpPost(uriBuilder.build());
        httpPost.addHeader("Content-type", "application/json");
        httpPost.addHeader("Accept", "application/json");

        String json = objectMapper.writeValueAsString(placeOrder);

        StringEntity entity = new StringEntity(json);

        httpPost.setEntity(entity);

        HttpResponse response = httpClient.execute(httpPost);
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());

        objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        src.test.java.Gulaiym.HomeWork_PostPojo.PetOrderPojo petOrderPojo= objectMapper.readValue(response.getEntity().getContent(), src.test.java.Gulaiym.HomeWork_PostPojo.PetOrderPojo.class);

        Assert.assertEquals(placeOrder.getId(),petOrderPojo.getId());
        Assert.assertEquals(placeOrder.getPetId(),petOrderPojo.getPetId());
        Assert.assertEquals(placeOrder.getQuantity(),petOrderPojo.getQuantity());
        Assert.assertEquals(placeOrder.getStatus(),petOrderPojo.getStatus());
        Assert.assertEquals(placeOrder.isComplete(),petOrderPojo.isComplete());
        //Assert.assertEquals(placeOrder.getShipDate(),petOrderPojo.getShipDate());

    }
}
