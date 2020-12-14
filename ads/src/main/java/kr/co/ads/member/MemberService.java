package kr.co.ads.member;

public interface MemberService {
	// 본인 인증
	public boolean selfCertification(Member member) throws Exception;

	// 카드 정보 갱신
	public boolean updateCardInfo(Member member) throws Exception;
}
