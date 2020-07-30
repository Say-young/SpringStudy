package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller //componentScan
public class MemberController {

    private final MemberService memberService;

    @Autowired  //dependency injection - 생성자주입 / 필드주입 / setter 주입
    //의존관계가 실행중에 동적으로 변하는 경우는 없으므로 생성자 주입을 사용하자
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
    
    /*
    @Autowired //setter injection의 경우 public으로 열어놔야 하기 때문에 위험
    public void setMemberService(MemberService memberService){
        this.memberService = memberService;
    }
     */

}
