package com.test.config;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

import static com.alibaba.fastjson.serializer.SerializerFeature.*;


@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {

    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer contentNegotiationConfigurer) {

    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer asyncSupportConfigurer) {

    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer) {

    }

    @Override
    public void addFormatters(FormatterRegistry formatterRegistry) {

    }

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {

    }

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {

    }

    @Override
    public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {

    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {

    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {

    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) {

    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        //序列化配置
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(
                QuoteFieldNames,// 输出key时是否使用双引号
                WriteMapNullValue,// 是否输出值为null的字段
                WriteNullNumberAsZero,//数值字段如果为null,输出为0,而非null
                WriteNullListAsEmpty,//List字段如果为null,输出为[],而非null
                WriteNullStringAsEmpty,//字符类型字段如果为null,输出为"",而非null
                //WriteNullBooleanAsFalse,//Boolean字段如果为null,输出为false,而非null
                //WriteNullStringAsEmpty,// null String不输出
                //WriteMapNullValue,//null String也要输出
                //WriteDateUseDateFormat,//Date的日期转换器
                DisableCircularReferenceDetect//禁止循环引用
        );
        converter.setFastJsonConfig(config);
        converters.add(converter);
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> list) {

    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

    }

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

    }

    @Override
    public Validator getValidator() {
        return null;
    }

    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        return null;
    }

    //解决跨域
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration conf = new CorsConfiguration();
        conf.addAllowedHeader("*");
        conf.addAllowedMethod("*");
        conf.addAllowedOrigin("*");
        conf.setAllowCredentials(true);
        conf.setMaxAge(3600L);
        conf.addExposedHeader("set-cookie");
        conf.addExposedHeader("access-control-allow-headers");
        conf.addExposedHeader("access-control-allow-methods");
        conf.addExposedHeader("access-control-allow-origin");
        conf.addExposedHeader("access-control-max-age");
        conf.addExposedHeader("X-Frame-Options");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", conf); // 4 对接口配置跨域设置
        return new CorsFilter(source);
    }


}