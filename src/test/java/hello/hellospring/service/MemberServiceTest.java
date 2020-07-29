package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

//ctrl+shift+t test 자동 생성 단축키
//test는 예외 테스트가 더 중요하다!

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();    //같은 memorymemberRepository를 사용하도록(dependency injection)
        memberService = new MemberService(memberRepository);
    }

    @AfterEach //각 method가 끝날 때마다 콜백
    public void afterEach(){
        memberRepository.clearStore();    //test시마다 공용 데이터 비워줘야 문제 발생하지 않음
    }

    @Test
    void 회원가입() {   //우와 메서드 이름 한글로 해도 되네
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }


    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring1");

        Member member2 = new Member();
        member2.setName("spring2");

        //when
        memberService.join(member1);
        //IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2); //오류 발생
        //assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        /*
        try{
            memberService.join(member2);
            fail(); //test 예외가 발생
        }catch(IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
        */

        //then
    }



    @Test
    void findMembers() {

    }

    @Test
    void findOne() {

    }
}