package gulaiymTest.HW_Test;

import gulaiymTest.HW_Pojo.all;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;


public class CatFactsTest {

    @Test
    public void catKeyword() throws URISyntaxException, IOException {

        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("http")
                .setHost("cat-fact.herokuapp.com")
                .setPath("facts")
                .setCustomQuery("amount=1000");

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("Accept", "application/json");

        HttpResponse response = httpClient.execute(httpGet);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        all all=objectMapper.readValue(response.getEntity().getContent(), all.class);
        System.out.println(all.getAll().get(1).getId());

        //int count = 0;
//        for (Map<String, Object> map: catsList) {
//            String fact=(String) map.get("text");
//            if(!fact.toLowerCase().contains("cat")){ //checking how many people facts doe not contains word cat
//                count++;
//            }
//        }
//        System.out.println(count+" facts");
    }
}
