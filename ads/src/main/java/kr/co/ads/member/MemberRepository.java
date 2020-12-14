package kr.co.ads.member;

public interface MemberRepository {
	// 핸드폰 번호 대조
	public boolean comparePhoneNumber(Member member) throws Exception;
	
	// 카드 정보 수정
	public boolean modifyCardInfo(Member member) throws Exception;

	// NFC 수신
	public String receiveNfc();
}
