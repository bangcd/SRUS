package kr.co.rbs.rentalbox;

// 무인 대여함 서비스
public interface RentalBoxService {
	// 잠금 처리
	public void processingLock();
	// 인증 처리
	public void processingAuth(String authKey);
}
