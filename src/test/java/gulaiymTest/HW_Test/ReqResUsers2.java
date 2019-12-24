package gulaiymTest.HW_Test;

import gulaiymTest.HW_Pojo.dataPojo;
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

public class ReqResUsers2 {

    @Test
    public void getUsers() throws IOException, URISyntaxException {
        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("reqres.in")
                .setPath("/api/users/2");

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("Accept", "application/json");
        HttpResponse response = httpClient.execute(httpGet);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        dataPojo dPojo = objectMapper.readValue(response.getEntity().getContent(), dataPojo.class);
        System.out.println("Avatar : "+dPojo.getData().getAvatar());
        System.out.println("First name : "+dPojo.getData().getFirst_name());
        System.out.println("Last name : "+dPojo.getData().getLast_name());
        System.out.println("Id : "+dPojo.getData().getId());
        System.out.println("email : "+dPojo.getData().getEmail());
    }
}
