package com.seabooks.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author 14745
 * @date 2023/12/4 22:13
 */
//拦截器
// 拦截未登录
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport{
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(jwtInterceptor())
//    拦截所有请求
                .addPathPatterns("/**")
// 放通登录操作 放通多个路径 .excludePathPatterns("/user/login","/user/select",...); ,"/file/upload"
//                虽然说静态资源(static)是默认放通的,但这里还是不能拦截
                .excludePathPatterns("/user/login","/img/**","/comic/**","/movies/**","/book/**","/Administrators/adminLogin","/file/upload");
        super.addInterceptors(registry);
    }

//    放通静态资源 必须存在这个方法
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        问题原因: 上传图片后需要重新运行项目才能显示
//        原
//        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
//        改 解决办法: 将"/**"改成"/img/**", "classpath:/static/" 改成计算机绝对路径  如果需要显示多个文件夹的图片路径,在.addResourceLocations("图片路径1","图片路径2")之后继续加路径即可
        registry.addResourceHandler("/img/**").addResourceLocations("file:D:\\Demo\\sea-booksQueen\\sea-books\\src\\main\\resources\\static\\img\\user","file:D:\\Demo\\sea-booksQueen\\sea-books\\src\\main\\resources\\static\\img\\books","file:D:\\Demo\\sea-booksQueen\\sea-books\\src\\main\\resources\\static\\img\\manhua","file:D:\\\\Demo\\\\sea-booksQueen\\sea-books\\src\\main\\resources\\static\\img\\authorsImg","file:D:\\Demo\\src\\main\\resources\\static\\img\\user");
    }

    // 将JwtInterceptor注入Spring容器中,由Spring进行操作
    @Bean
    public JwtInterceptor jwtInterceptor(){
        return new JwtInterceptor();
    }

}
