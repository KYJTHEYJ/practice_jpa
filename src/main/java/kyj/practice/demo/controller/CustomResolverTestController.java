package kyj.practice.demo.controller;

import kyj.practice.demo.config.CustomPathVariable;
import kyj.practice.demo.config.CustomRequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomResolverTestController {
    @GetMapping("/request")
    public String requestParamDemo(@CustomRequestParam String name) {
        return "name=" + name;
    }

    @GetMapping("/path/{id}")
    public String pathVariableDemo(@CustomPathVariable Long id) {
        return "id=" + id;
    }

}
