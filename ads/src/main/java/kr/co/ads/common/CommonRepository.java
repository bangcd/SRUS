package kr.co.ads.common;

import kr.co.ads.member.Member;

public interface CommonRepository {
	// 회원 검증
	public boolean validMember(Member member) throws Exception;
}
