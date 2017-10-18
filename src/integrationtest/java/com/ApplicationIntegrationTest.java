package com;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.MultiValueMap;

import static com.google.common.net.HttpHeaders.CONTENT_TYPE;
import static java.net.HttpURLConnection.HTTP_OK;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;
import static org.skyscreamer.jsonassert.JSONCompare.compareJSON;
import static org.skyscreamer.jsonassert.JSONCompareMode.NON_EXTENSIBLE;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class, PayWithCc.class, }, webEnvironment = DEFINED_PORT)
// TODO use port injection instead @LocalServerPort
@TestPropertySource(properties = {"payWithCc.host=http://localhost:20000"})
public class ApplicationIntegrationTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void payWithCcSmoke() throws Exception {
        Class<? extends ApplicationIntegrationTest> thisClass = this.getClass();
        String requestBody = IOUtils.toString(thisClass.getResourceAsStream("/payWithCcFullRequest.json"), UTF_8);
        String expectedResponse = IOUtils.toString(thisClass.getResourceAsStream("/payWithCcFullResponse.json"), UTF_8);
        // @formatter:off
        MultiValueMap<String, String> headers =  new HttpHeaders();
        headers.add(CONTENT_TYPE, APPLICATION_JSON_VALUE);
        HttpEntity httpEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<String> response = testRestTemplate.postForEntity("http://localhost:20000/payWithCc", httpEntity, String.class);

        assertThat(response.getStatusCode().value()).isEqualTo(HTTP_OK);
        compareJSON(expectedResponse, response.getBody(), NON_EXTENSIBLE);
        // @formatter:on
    }
}
