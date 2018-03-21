package com.zgj.study;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.zgj.study.filter.HTTPBearerAuthorizeAttribute;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringbootFastjsonApplication {
	@Bean
	public FilterRegistrationBean jwtFilterRegistrationBean(){
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		HTTPBearerAuthorizeAttribute httpBearerFilter = new HTTPBearerAuthorizeAttribute();
		registrationBean.setFilter(httpBearerFilter);
		List<String> urlPatterns = new ArrayList<String>();
		urlPatterns.add("/api/user/*");
		registrationBean.setUrlPatterns(urlPatterns);
		return registrationBean;
	}
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		FastJsonConfig fastJsonConfig = new FastJsonConfig();

		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);

		fastConverter.setFastJsonConfig(fastJsonConfig);

		HttpMessageConverter<?> converter = fastConverter;

		return new HttpMessageConverters(converter);
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootFastjsonApplication.class, args);
	}
/*	@Bean
	public FilterRegistrationBean basicFilterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		HTTPBasicAuthorizeAttribute httpBasicFilter = new HTTPBasicAuthorizeAttribute();
		registrationBean.setFilter(httpBasicFilter);
		List<String> urlPatterns = new ArrayList<String>();
		urlPatterns.add("/user/getuser");
		registrationBean.setUrlPatterns(urlPatterns);
		return registrationBean;
	}*/


}
