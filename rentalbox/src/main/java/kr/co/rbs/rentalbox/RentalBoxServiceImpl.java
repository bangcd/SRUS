package kr.co.rbs.rentalbox;

public class RentalBoxServiceImpl implements RentalBoxService {
	private RentalBoxRepository rentalBoxRepository;

	public RentalBoxServiceImpl() {
		this.rentalBoxRepository = new RentalBoxRepositoryImpl();
	}

	// 잠금 처리
	@Override
	public void processingLock() {
		boolean result = false;

		try {
			// 모터를 잠금 방향으로 동작시킨다.
			result = rentalBoxRepository.operateMotor(false);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (result) {
			// 이용내역(구분 = 'C'[닫힘])을 등록한다.
			rentalBoxRepository.registerUsageHistory('C');
		}
	}

	// 인증 처리
	@Override
	public void processingAuth(String authKey) {
		// SRUS 서버에게 카드 UID 대조 요청을 보낸다.
		boolean isMatched = false;
		boolean result = false;
		isMatched = rentalBoxRepository.compareCardUID(authKey);

		// 인증키 대조 결과가 참이면
		if (isMatched) {
			// 모터를 잠금해제 방향으로 동작시킨다.
			try {
				result = rentalBoxRepository.operateMotor(true);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

			if (result) {
				// 이용내역(구분 = 'O'[열림])을 등록한다.
				rentalBoxRepository.registerUsageHistory('O');
			}
		}
	}
}
