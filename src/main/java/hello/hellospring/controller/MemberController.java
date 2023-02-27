package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    // 스프링 방식이 아님
    // private final MemberService memberService = new MemberService();
    /**
     * 스프링을 등록하는 2가지 방법
     * 컴포넌트 스캔과 자동 의존관계 설정 (@Service, @controller, @repository 이유는 안에 @Conponent가 등록되어 있음)
     * 자바 코드로 직접 스프링 빈 등록하기
     */
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
