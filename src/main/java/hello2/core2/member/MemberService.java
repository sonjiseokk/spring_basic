package hello2.core2.member;

public interface MemberService {
    void join(Member member);
    Member findMember(Long memberId);
}
