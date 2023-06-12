package hello2.core2.discount;

import hello2.core2.member.Grade;
import hello2.core2.member.Member;
import hello2.core2.member.MemberService;
import hello2.core2.member.MemberServiceImpl;
import hello2.core2.order.OrderService;
import hello2.core2.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10%할인이 적용되어야 한다.")
    void vip_o(){
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        int discount = discountPolicy.discount(memberA, 10000);

        assertThat(discount).isEqualTo(1000);
    }
    @Test
    @DisplayName("VIP가 아니면 10% 할인이 적용되지 않아야 한다.")
    void vip_x(){
        Member memberA = new Member(2L, "memberB", Grade.BASIC);
        int discount = discountPolicy.discount(memberA, 10000);

        assertThat(discount).isNotEqualTo(1000);
    }



}