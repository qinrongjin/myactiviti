package cn.tiny77.config;

import cn.tiny77.config.mvc.AuthInterceptor;
import cn.tiny77.config.mvc.ParamInterceptor;
import cn.tiny77.constant.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration {

	@Bean(value = "authInterceptor")
	public HandlerInterceptor getAuthInterceptor(){
		return new AuthInterceptor();
	}

	@Bean(value = "paramInterceptor")
	public HandlerInterceptor getParamInterceptor(){
		return new ParamInterceptor();
	}

	@Bean
	public WebMvcConfigurer getMyConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				registry.addInterceptor(getAuthInterceptor()).excludePathPatterns(Url.INDEX, Url.LOGIN);
				registry.addInterceptor(getParamInterceptor());
			}
		};
	}
}