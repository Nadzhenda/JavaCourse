package nadiya.brytan.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HTMLController {
    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
