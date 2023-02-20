package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!!");
        /**
         * 컨트롤러에서 리턴 값으로 문자를 반환하면 뷰 리졸버( viewResolver )가 화면을 찾아서 처리한다.
         * 스프링 부트 템플릿엔진 기본 viewName 매핑
         * resources:templates/ +{ViewName}+ .html
         */
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name , Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam(value = "name") String name){
        return "hello " + name; // hello spring
    }


    @GetMapping("hello-api")
    @ResponseBody
    public Hello heeloApi(@RequestParam(value = "name") String name){
        /**
         * @ResponseBody 를 사용
         * HTTP의 BODY에 문자 내용을 직접 반환
         * viewResolver 대신에 HttpMessageConverter 가 동작
         * 기본 문자처리: StringHttpMessageConverter
         * 기본 객체처리: MappingJackson2HttpMessageConverter
         * byte 처리 등등 기타 여러 HttpMessageConverter가 기본으로 등록되어 있음
         */
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //json 방식으로 나옴
    }


    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
