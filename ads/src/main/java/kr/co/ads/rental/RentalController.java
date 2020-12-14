package kr.co.ads.rental;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/rental")
public class RentalController {
	@Autowired
	RentalServiceImpl rentalServiceImpl;

	@Autowired
	HttpSession session;

	// 대여 정보 조회
	@GetMapping
	public ModelAndView searchRentalInfo() {
		ModelAndView mav = null;

		try {
			mav = new ModelAndView();
			String id = (String) session.getAttribute("id");

			mav.addObject("rows", rentalServiceImpl.searchRentalInfo(id));
			mav.setViewName("/rental/list");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;
	}
}
