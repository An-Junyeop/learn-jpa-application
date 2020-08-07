package jpa;

import jpa.shop.domain.Member;
import jpa.shop.repository.MemberRepository;
import jpa.shop.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {

        // Given
        Member member = new Member();
        member.setName("Kim");

        // When
        Long saveId = memberService.join(member);

        // Then
        assertEquals(member.getId(), saveId);
    }

    @Test
    public void 중복_회원_예외() {
        // Given
        Member member = new Member();
        member.setName("An");

        try {
            // When
            memberService.join(member);
            System.out.println(member.getId());

            // Then
            fail("회원 중복 검사 실패");
        } catch (IllegalStateException e) {
            // Then
            Assert.isTrue(true, e.getMessage());
        }
    }

    @Test
    public void 이름으로_회원조회() {
        List<Member> findMembers =
                memberService.findByName("An");

        for (Member member : findMembers) {
            System.out.println(member.getId() + " : " + member.getName());
        }

        assertTrue(!findMembers.isEmpty());
    }

}
