package kr.co.ads.authentication;

public interface AuthenticationService {
	// 인증 활성화
	public boolean activeAuth(AuthInfo authInfo) throws Exception;
}
