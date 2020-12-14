package kr.co.ads.error;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomErrorController implements ErrorController{
    private final String PATH = "/errors/";

    @RequestMapping("/error")
    public ModelAndView handleError(HttpServletRequest request) {
        ModelAndView mav = null;
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            int statusCode = Integer.valueOf(status.toString());
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                mav = new ModelAndView(PATH + "404");
            }
            if (statusCode == HttpStatus.FORBIDDEN.value()) {
                mav = new ModelAndView(PATH + "500");
            }
        }
        return mav;
    }

    @Override
    public String getErrorPath() {
        return null;
    }

}