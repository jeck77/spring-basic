package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * JpaRepository
 * 첫번째는 멤버
 * 두번째는 식별자 타입
 */
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    /**
     * JpaRepository 제공된 함수 외의는 아래처럼 명명 규칙을 지켜주면 된다.
     * 아래 예시 :
     * select m from member m where m.name = ?
     */
    @Override
    Optional<Member> findByName(String name);

    // select m from member m where m.name = ? and m.id = ?
    //Optional<Member> findByNameAndId(String name, Long id);
}
