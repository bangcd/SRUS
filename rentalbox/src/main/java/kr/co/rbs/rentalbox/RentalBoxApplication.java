package kr.co.rbs.rentalbox;

import java.io.IOException;

// 실행 클래스
public class RentalBoxApplication {
	public static void main(String[] args) throws IOException, InterruptedException {
		// NFC 리더 동작 (인증키 수신)
		new Thread(new NFCReader()).start();
		// 잠금 정보 수신 동작 (닫힘 이벤트 수신)
		new Thread(new CloseEventReceiver()).start();
	}
}
