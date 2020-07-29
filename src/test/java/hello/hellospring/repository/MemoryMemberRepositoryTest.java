package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Optional;

//틀을 먼저 만드는 것 - 테스트 주도 개발 - TDD
class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach //각 method가 끝날 때마다 콜백
    public void afterEach(){

        repository.clearStore();    //test시마다 공용 데이터 비워줘야 문제 발생하지 않음
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");
        repository.save(member);

        Member result = repository.findById(member.getId()).get(); //get으로 바로 꺼내는 것이 좋은 방법은 아님
        assertThat(member).isEqualTo(result);   //asserj
        //assertEquals(member, result); //저장했던 member가 find했을 때 나와야
        //System.out.println("result = " + (result == member));
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get(); //get nullPoint 뜨는 이유 찾기 - MemoryMemberRepository에서 findByName의 return값이 잘못되어 있었음
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring1");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);     //result의 개수와 일치하면 성공
    }
}
