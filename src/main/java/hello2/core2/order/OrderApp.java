package hello2.core2.order;

import hello2.core2.member.Grade;
import hello2.core2.member.Member;
import hello2.core2.member.MemberService;
import hello2.core2.member.MemberServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId= 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        memberService.join(member);

        Order order = orderService.createOrder(memberId, "아이템", 10000);
        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}
