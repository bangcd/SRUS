package kr.co.ads.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberRepositoryImpl memberRepositoryImpl;

	// 본인 인증
	@Override
	public boolean selfCertification(Member member) throws Exception {

		return memberRepositoryImpl.comparePhoneNumber(member);
	}

	// 카드 정보 갱신
	@Override
	public boolean updateCardInfo(Member member) throws Exception {
		String cardUid = memberRepositoryImpl.receiveNfc();
		member.setCardUid(cardUid);

		return memberRepositoryImpl.modifyCardInfo(member);
	}
}
