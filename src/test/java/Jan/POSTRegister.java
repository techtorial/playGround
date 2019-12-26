package Jan;

import Gulaiym.HomeWork_PostPojo.RegisterPojo;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
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


    public class POSTRegister {

        @Test
        public void registerUser() throws IOException, URISyntaxException {
           RegisterPojo register = new RegisterPojo("eve.holt@reqres.in","pistol");
            register.setId(4);
            register.setToken("QpwL5tke4Pnpja7X4");
            ObjectMapper objectMapper = new ObjectMapper();


            HttpClient httpClient = HttpClientBuilder.create().build();

            URIBuilder uriBuilder = new URIBuilder()
                    .setScheme("https")
                    .setHost("reqres.in")
                    .setPath("api/register");

            HttpPost httpPost = new HttpPost(uriBuilder.build());
            httpPost.addHeader("Content-type", "application/json");
            httpPost.addHeader("Accept", "application/json");

            String json = objectMapper.writeValueAsString(register);

            StringEntity entity = new StringEntity(json);

            httpPost.setEntity(entity);

            HttpResponse response = httpClient.execute(httpPost);
            Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());


          RegisterPojo registerPojo = objectMapper.readValue(response.getEntity().getContent(),RegisterPojo.class);

            Assert.assertEquals(register.getId(),registerPojo.getId());
            Assert.assertEquals(register.getToken(),registerPojo.getToken());
        }

        @Test
        public void loginUser() throws IOException, URISyntaxException {
            RegisterPojo register = new RegisterPojo("eve.holt@reqres.in","pistol");
            register.setToken("QpwL5tke4Pnpja7X4");
            ObjectMapper objectMapper = new ObjectMapper();


            HttpClient httpClient = HttpClientBuilder.create().build();

            URIBuilder uriBuilder = new URIBuilder()
                    .setScheme("https")
                    .setHost("reqres.in")
                    .setPath("api/login");

            HttpPost httpPost = new HttpPost(uriBuilder.build());
            httpPost.addHeader("Content-type", "application/json");
            httpPost.addHeader("Accept", "application/json");

            String json = objectMapper.writeValueAsString(register);

            StringEntity entity = new StringEntity(json);

            httpPost.setEntity(entity);

            HttpResponse response = httpClient.execute(httpPost);
            Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
            //deserialization
            objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
         RegisterPojo registerPojo = objectMapper.readValue(response.getEntity().getContent(),RegisterPojo.class);

            Assert.assertEquals(register.getToken(),registerPojo.getToken());
        }

        @Test
        public void updateUser() throws IOException, URISyntaxException {
           RegisterPojo register = new RegisterPojo("jan@reqres.in","pistol");
            register.setUpdatedAt("2019-12-24T01:38:54.089Z");

            ObjectMapper objectMapper = new ObjectMapper();


            HttpClient httpClient = HttpClientBuilder.create().build();

            URIBuilder uriBuilder = new URIBuilder()
                    .setScheme("https")
                    .setHost("reqres.in")
                    .setPath("api/login");

            HttpPut httpPut = new HttpPut(uriBuilder.build());
            httpPut.addHeader("Content-type", "application/json");
            httpPut.addHeader("Accept", "application/json");

            String json = objectMapper.writeValueAsString(register);

            StringEntity entity = new StringEntity(json);

            httpPut.setEntity(entity);

            HttpResponse response = httpClient.execute(httpPut);
            Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());

            //deserialization
            objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
          RegisterPojo registerPojo = objectMapper.readValue(response.getEntity().getContent(), RegisterPojo.class);

            Assert.assertEquals(register.getEmail(),registerPojo.getEmail());
            //Assert.assertEquals(register.getUpdatedAt(),registerPojo.getUpdatedAt());
        }

    }

