package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    /**
     * 요청이 오면 스프링 컨테이너에 있는 것을 먼저 찾기 떄문에
     * index.html로 이동 안한다.
     */
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
