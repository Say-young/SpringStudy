package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}