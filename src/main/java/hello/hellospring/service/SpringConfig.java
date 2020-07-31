package hello.hellospring.service;

//import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//정형화되지 않거나, 상황에 따라 구현 클래스를 변경해야 할 경우 직접 스프링 빈에 등록하는 것이 좋다
@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    /*
    @Bean
    public TimeTraceAop TimeTraceAop() {
        return new TimeTraceAop();
    }
     */
}
