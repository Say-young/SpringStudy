package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findById(Long id); //null일 경우 optional로 감싸서 반환하는 방법을 많이 사용함
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
