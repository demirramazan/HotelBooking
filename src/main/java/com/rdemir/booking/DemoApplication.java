package com.rdemir.booking;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ramazan on 27.04.2017.
 */
@RestController
public class DemoApplication {

    @RequestMapping(value = "/hello/{mesaj}",method = RequestMethod.GET)
    public String hello(@PathVariable String mesaj){
        return "Hello " +mesaj;
    }
}
