package com.example.buildservice.member;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import com.example.buildservice.config.TestcontainersConfig;
import com.example.buildservice.config.jpa.JpaConfig;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import({ TestcontainersConfig.class, JpaConfig.class })
@ActiveProfiles("test")
@Transactional
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void test() {
        Member member = new Member(1L, "test", "test@test.com");
        memberRepository.save(member);

        Member findMember = memberRepository.findById(1L).orElseThrow();
        assertThat(findMember.getName()).isEqualTo("test");
        assertThat(findMember.getEmail()).isEqualTo("test@test.com");
    }

    @Test
    void test2() {
        Member member = Member.builder()
                .name("test2")
                .email("test2@test.com")
                .build();

        memberRepository.save(member);

        Member findMember = memberRepository.findById(2L).orElseThrow();
        assertThat(findMember.getName()).isEqualTo("test2");
        assertThat(findMember.getEmail()).isEqualTo("test2@test.com");
    }

    @Test
    void test3() {
        Member member = Member.builder()
                .name("test3")
                .email("test3@test.com")
                .build();

        memberRepository.save(member);

        Member findMember = memberRepository.findById(3L).orElseThrow();
        assertThat(findMember.getName()).isEqualTo("test3");
        assertThat(findMember.getEmail()).isEqualTo("test3@test.com");
    }

    // @Test
    // void test4() {
    // Member member = Member.builder()
    // .name("test4")
    // .email("test4@test.com")
    // .build();
    //
    // memberRepository.save(member);
    //
    // JMemberRecord findMember = jMemberRepository.findAll().get(3);
    //
    // assertThat(findMember).isNotNull();
    // assertThat(findMember.getName()).isEqualTo("test4");
    // assertThat(findMember.getEmail()).isEqualTo("test4@test.com");
    // }
}
