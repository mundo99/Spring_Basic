package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(
        basePackages = "hello.core.member", // 이 경로 하위 패키지부터 찾아감
        // 지정 안하면? 디폴트 -> 이게 위치한 경로부터 하위 패키지 (hello.core.*)
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {


    @Bean(name = "memoeyMemberRepository")
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

}
