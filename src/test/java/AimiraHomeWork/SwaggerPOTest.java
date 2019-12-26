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

public class SwaggerPOTest {
    @Test
    public void order() throws URISyntaxException, IOException {

        SwaggerPlaceOrderPOJO placeOrder=new SwaggerPlaceOrderPOJO();

        placeOrder.setId(810);
        placeOrder.setPetId(996);
        placeOrder.setQuantity(3);
        placeOrder.setShipDate("2019-12-24T00:00:00.000+0000");
        placeOrder.setStatus("placed");
        placeOrder.setComplete(true);

        ObjectMapper objectMapper = new ObjectMapper();

        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("petstore.swagger.io")
                .setPath("v2/store/order");


        HttpPost httpPost = new HttpPost(uriBuilder.build());
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.addHeader("Accept", "application/json");


        String json = objectMapper.writeValueAsString(placeOrder);
        System.out.println(json);

        StringEntity entity = new StringEntity(json);

        httpPost.setEntity(entity);

        HttpResponse response = httpClient.execute(httpPost);

        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());

        SwaggerPlaceOrderPOJO create = objectMapper.readValue(response.getEntity().getContent(), SwaggerPlaceOrderPOJO.class);

        Assert.assertEquals(placeOrder.getStatus() , create.getStatus());
        Assert.assertEquals(placeOrder.getShipDate(), create.getShipDate());
        Assert.assertEquals(placeOrder.getQuantity(),create.getQuantity());
        Assert.assertEquals(placeOrder.getPetId(),create.getPetId());
        Assert.assertEquals(placeOrder.getId(),create.getId());
    }
}










