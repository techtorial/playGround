package APIbyN;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;


import java.io.IOException;
import java.net.URISyntaxException;

public class PetStatusTest {
    @Test
    public void getFactById() throws URISyntaxException, IOException {
        org.apache.http.client.HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("petstore.swagger.io")
                .setPath("v2/pet/findByStatus")
                .setCustomQuery("status=pending");
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("Accept", "application/json");
        org.apache.http.HttpResponse response = httpClient.execute(httpGet);
        ObjectMapper objectMapper = new ObjectMapper();

        ByStatusPojo ByStatusPOJO = objectMapper.readValue(response.getEntity().getContent(), ByStatusPojo.class);
        int petId= ByStatusPOJO.getListOfPetsStatus().get(1).getId();
        System.out.println(petId);

        System.out.println(" hello ");
    }

}
