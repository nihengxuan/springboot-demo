//package com.sdjzu.group.utils;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// *
// *
// * @Package: com.*.*.config
// * @ClassName: LoginConfig
// * @Description:拦截器配置
// * @author: zk
// * @date: 2019年9月19日 下午2:18:35
// */
//@Configuration//定义此类为配置文件
//public class LoginConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
////        //注册TestInterceptor拦截器
////        InterceptorRegistration registration = registry.addInterceptor(new UserLoginInterceptor());
////        registration.addPathPatterns("/**"); //所有路径都被拦截
////        registration.excludePathPatterns(    //添加不拦截路径
////                "/login",                    //登录路径
////                "/**/*.html",                //html静态资源
////                "/**/*.js",                  //js静态资源
////                "/**/*.css",                  //css静态资源
////                "/register"
////
////        );
////    }
//        String[] addPathPatterns ={
//                "/**"
//        };
//        String[] excludePathPatterns = {
//                "/user/login",
//                "/user/register"
//        };
//        registry.addInterceptor(new UserLoginInterceptor()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);
//    }
//}
