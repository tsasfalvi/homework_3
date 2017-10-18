package com;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;

@RestController
@RequestMapping("/pay")
public class PayWithCc {

    @RequestMapping(method = RequestMethod.POST)
    protected String pay(@RequestBody String body) throws IOException {
        return IOUtils.toString(this.getClass().getResourceAsStream("/payWithCcFullResponse.json"), UTF_8);
    }
}
