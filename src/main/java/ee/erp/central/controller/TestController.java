package ee.erp.central.controller;

import org.springframework.web.bind.annotation.*;

/**
 * Created by Artyom on 12/20/2015.
 */

@RestController
@RequestMapping("api")
public class TestController {


    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "test")
    String home() {
        return "Hello World!";
    }
}
