package fr.test.boot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bourges on 09/06/14.
 */
@Controller
public class SampleController {
    @RequestMapping("/app")
    public String doIt() {
        return "app";
    }

}
