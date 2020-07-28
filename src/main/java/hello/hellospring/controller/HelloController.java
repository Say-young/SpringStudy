package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    //web application에서 /hello라고 들어오면 이 method를 호출

    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        //html에서 data가 아닌 다른 변수명을 사용할 경우 데이터가 넘어가지 않으므로 null로 남음
        return "hello"; //resources의 hello를 찾아서 실행(랜더링)해라~(viewResolver가 'resources:templates/'의 뷰.html을 찾아 처리함)
    }

    //spring-boot-devtools 라이브러리 찾아보기

    @GetMapping("hello-mvc")
    //http://localhost:8080/hello-mvc?name=어쩌구
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-spring")
    @ResponseBody //response body 부분에 아래 return 내용을 직접 넣어주겠다는 뜻
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; //hello name이 요청한 client한테 그대로 내려감(html없음. 즉, view가 없고 문자가 그대로 내려감)
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //객체(json - key/value로 이루어짐) 넘김
    }
    
    static class Hello {
        private String name; //private을 외부에서 접근하기 위해 getter/setter 사용(property 접근 방식)

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }
}