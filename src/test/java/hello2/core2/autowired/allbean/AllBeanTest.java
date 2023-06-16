package hello2.core2.autowired.allbean;

import hello2.core2.AutoAppConfig;
import hello2.core2.discount.DiscountPolicy;
import hello2.core2.member.Grade;
import hello2.core2.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class AllBeanTest {
    @Test
    void findAllBean(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);
        DiscountService discountService = ac.getBean(DiscountService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        int discountPrice = discountService.discount(member, 10000, "fixDiscountPolicy");

        // 일단 서비스 객체가 잘 만들어졌는지부터 확인
        assertThat(discountService).isInstanceOf(DiscountService.class);

        // 할인된 가격이 같나요?
        assertThat(discountPrice).isEqualTo(1000);


        int rateDiscountPrice = discountService.discount(member, 20000, "rateDiscountPolicy");

        // 할인된 가격이 같나요?
        assertThat(rateDiscountPrice).isEqualTo(2000);

    }

    static class DiscountService{
        private Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);
        }
        public int discount(Member member,int price, String discountCode){
            DiscountPolicy discountPolicy = policyMap.get(discountCode);
            return discountPolicy.discount(member, price);
        }
    }
}
