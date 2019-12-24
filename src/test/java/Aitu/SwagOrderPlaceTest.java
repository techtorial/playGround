package Aitu;

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

public class SwagOrderPlaceTest {

    @Test
    public void PlaceOrderTest() throws URISyntaxException, IOException {
        SwagPlaceOrderPojo placeOrder=new SwagPlaceOrderPojo();

        placeOrder.setId(0);
        placeOrder.setPetId(0);
        placeOrder.setQuantity(0);
        placeOrder.setShipDate("2019-12-24T02:32:57.188+0000");
        placeOrder.setStatus("placed");
        placeOrder.setComplete(true);

        ObjectMapper objectMapper = new ObjectMapper();

        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("petstore.swagger.io")
                .setPath("v2/store/order");
        //https://petstore.swagger.io/#/store/placeOrder
        HttpPost httpPost = new HttpPost(uriBuilder.build());
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.addHeader("Accept", "application/json");
        String json = objectMapper.writeValueAsString(placeOrder);
        System.out.println(json);
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        HttpResponse response = httpClient.execute(httpPost);
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
        SwagPlaceOrderPojo create = objectMapper.readValue(response.getEntity().getContent(), SwagPlaceOrderPojo.class);
        Assert.assertEquals(placeOrder.getStatus() , create.getStatus());
        Assert.assertEquals(placeOrder.getShipDate(), create.getShipDate());
        Assert.assertEquals(placeOrder.getId(),create.getId());
        Assert.assertEquals(placeOrder.getPetId(),create.getPetId());
        Assert.assertEquals(placeOrder.getQuantity(),create.getQuantity());
        Assert.assertEquals(placeOrder.isComplete(),create.isComplete());
    }
}
