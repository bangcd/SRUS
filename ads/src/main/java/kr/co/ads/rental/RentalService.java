package kr.co.ads.rental;

import java.util.List;

public interface RentalService {
	// 대여 정보 조회
	public List<Rental> searchRentalInfo(String id) throws Exception;
}
