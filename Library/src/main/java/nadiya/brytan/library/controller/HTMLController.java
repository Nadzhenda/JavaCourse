package nadiya.brytan.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HTMLController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/books")
    public String books() {
        return "books";
    }

    @GetMapping("/authors")
    public String authors() {
        return "authors";
    }

}
