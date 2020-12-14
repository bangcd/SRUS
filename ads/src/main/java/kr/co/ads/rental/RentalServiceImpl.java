package kr.co.ads.rental;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalServiceImpl implements RentalService {
	@Autowired
	RentalRepositoryImpl rentalRepositoryImpl;

	// 대여 정보 조회
	@Override
	public List<Rental> searchRentalInfo(String id) throws Exception {

		return rentalRepositoryImpl.searchRentalInfo(id);
	}
}
