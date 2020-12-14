package kr.co.ads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.ads.interceptor.CertificationInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	@Autowired
	CertificationInterceptor certificationInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(certificationInterceptor)
				.addPathPatterns("/authentication/**")
				.addPathPatterns("/member/**")
				.addPathPatterns("/rental");
	}

}
