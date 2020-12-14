package kr.co.ads.common;

import kr.co.ads.member.Member;

public interface CommonService {
	// 로그인
	public boolean login(Member member) throws Exception;
}
