package com.example.spatra_test_user_api.user.repository;

import com.example.spatra_test_user_api.user.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberInitializer implements ApplicationRunner {

    private final MemberRepository memberRepository;

    private String[] names = {"카리나", "윈터", "지젤", "닝닝", "슬기", "아이린", "웬디", "조이", "예리"};
    private String[] emails = {"katarina", "winter", "aerichan", "notningning", "ssuelgi", "rene", "wendy", "joy", "yerimiese"};

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (int i = 0; i < 99; i++) {
            int random = (int) (Math.random() * names.length);
            Member member = Member.builder()
                    .name(names[random]+(i+1))
                    .email(emails[random]+(i+1)+"@sm.town")
                    .pw("1234")
                    .build();
            memberRepository.save(member);
        }
    }
}
