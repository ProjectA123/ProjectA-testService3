package com.projectA.testService1.controllers;

import com.projectA.testService1.payloads.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test")
public class Test {

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public Data getTestData(){

        Data payload = new Data(9999, "");


        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Data> response = restTemplate
                .getForEntity("https://projecta-testservice1.herokuapp.com/test/get", Data.class);

        Data body = response.getBody();
        payload.setStr("Data from service1 - " + body.getStr());
        payload.setStr(payload.getStr() + "\nData from service2 - " + payload.getA());

        return payload;
    }

}
