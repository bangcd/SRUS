package kr.co.ads.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ads.member.Member;

@Service
public class CommonServiceImpl implements CommonService {
	@Autowired
	CommonRepositoryImpl commonRepositoryImpl;

	// 로그인
	@Override
	public boolean login(Member member) throws Exception {

		return commonRepositoryImpl.validMember(member);
	}

}
