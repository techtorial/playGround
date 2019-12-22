package DeserilaztionPojo;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class Users2 {
    @Test
    public void user2() throws IOException, URISyntaxException {

        ObjectMapper objectMapper = new ObjectMapper();
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")//protocol
                .setHost("reqres.in") //host
                .setPath("api/users/2");//path

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("Accept", "application/json");
        HttpResponse response = httpClient.execute(httpGet);
//objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        //deserialization using pojo
      Datapojo userInfo = objectMapper.readValue(response.getEntity().getContent(), Datapojo.class);


        System.out.println(userInfo.getData().get("first_name"));
       //System.out.println(userInfo.getData().get("first_name"));
//        System.out.println(userInfo.getFirst_name());
//        System.out.println(userInfo.getLast_name());
//        System.out.println(userInfo.getId());
//        System.out.println(userInfo.getAvatar());
//



    }

}
