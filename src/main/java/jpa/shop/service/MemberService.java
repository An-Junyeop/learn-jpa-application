package jpa.shop.service;

import jpa.shop.domain.Member;
import jpa.shop.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    /*
    * 회원 가입
    * */
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    /*
    * 회원 중복 검사
    * */
    private void validateDuplicateMember(Member member) {
        List<Member> findMembers =
                memberRepository.findByName(member.getName());

        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    /*
    * 전체 회원 조회
    * */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /*
    * ID로 회원 조회
    * */
    public Member findOne(Long id) {
        return memberRepository.findOne(id);
    }

    /*
    * 이름으로 회원 조회
    * */
    public List<Member> findByName(String name) {
        return memberRepository.findByName(name);
    }
}
