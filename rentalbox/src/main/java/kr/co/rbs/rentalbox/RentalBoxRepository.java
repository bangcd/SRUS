package kr.co.rbs.rentalbox;

public interface RentalBoxRepository {
	// 모터 작동
	public boolean operateMotor(boolean isOpen) throws InterruptedException;
	// 이용내역 등록
	public void registerUsageHistory(char division);
	// 카드UID 대조
	public boolean compareCardUID(String authKey);
}
