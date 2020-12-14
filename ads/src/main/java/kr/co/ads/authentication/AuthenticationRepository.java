package kr.co.ads.authentication;

public interface AuthenticationRepository {
	// 인증 정보 부여
	public boolean grantAuthInfo(AuthInfo authInfo) throws Exception;
}
