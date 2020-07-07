package me.ljseokd.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 스프링 MVC 프로젝트에 관련된 설정을 하는 클래스
@Configuration
// Controller 애노테이션이 셋팅되어 있는 클래스를 Controller로 등록한다.
@EnableWebMvc // <mvc:annotation-driven/>
// 스캔할 패키지를 지정한다.
@ComponentScan(basePackages = "me.ljseokd.controller") // <context:component-scan base-package="me.ljseokd.controller"/>
public class ServletAppContext implements WebMvcConfigurer {
    //Controller의 메소드가 반환화는 jsp의 이름 앞뒤에 경로와 확장자를 붙혀주도록 설정한다.
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
    }
    //정적 파일의 경로를 매핑한다.
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("/resources/");
    }
}
