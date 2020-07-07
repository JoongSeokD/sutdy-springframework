package me.ljseokd.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;

//public class SpringConfig implements WebApplicationInitializer {
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        // Spring MVC 프로젝트 설정을 위해 작성하는 클래스의 객체를 생성한다.
//        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//        context.register(ServletAppContext.class);
//
//        // 요청 발생 시 요청을 처리하는 서블릿을 DispatcherServlet으로 설정
//        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
//        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcherServlet", dispatcherServlet);
//
//        // 부가 설정
//        servlet.setLoadOnStartup(1);
//        servlet.addMapping("/");
//
//        // bean을 정의하는 클래스를 지정한다.
//        AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
//        rootAppContext.register(RootAppContext.class);
//
//        // ContextLoaderListener리스너 설정
//        ContextLoaderListener listener = new ContextLoaderListener(rootAppContext);
//        servletContext.addListener(listener);
//
//        // 파라미터 인코딩 설정
//        FilterRegistration.Dynamic filter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
//        filter.setInitParameter("encoding", "UTF-8");
//        filter.addMappingForServletNames(null, false, "dispatcher");
//    }
//}
public class SpringConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    // DispatcherServlet에 매필할 요청 주소 셋팅
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
    // Spring MVC 프로젝트 설정을 위한 클래스를 지정한다.
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ServletAppContext.class};
    }
    // 프로젝트에서 사용할 bean들을 정의하기 위한 클래스를 지정한다.
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootAppContext.class};
    }
    //파라미터 인코딩 필터 설정
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        return new Filter[]{encodingFilter};
    }
}