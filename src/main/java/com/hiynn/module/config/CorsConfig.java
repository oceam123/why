package com.hiynn.module.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * description 全局ajax跨域配置方案
 *
 * @author LouLvLin
 * @version 1.0
 * @date 2019年05月09日 11:35
 */
@SuppressWarnings("unchecked")
@Configuration
public class CorsConfig {
	/**
	 * description  corsFilter
	 * @author LouLvLin
	 * @date  2019/5/13  17:14
	 * @return org.springframework.boot.web.servlet.FilterRegistrationBean
	 */
	@Bean
	public FilterRegistrationBean corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(0);
		return bean;
	}
}


