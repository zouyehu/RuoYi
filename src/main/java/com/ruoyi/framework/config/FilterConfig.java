package com.ruoyi.framework.config;

import java.util.Map;
import javax.servlet.DispatcherType;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.common.collect.Maps;
import com.ruoyi.common.xss.XssFilter;

/**
 * Filter配置
 *
 * @author ruoyi
 */
@Configuration
public class FilterConfig
{
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    public FilterRegistrationBean xssFilterRegistration()
    {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.setFilter(new XssFilter());
        registration.addUrlPatterns("/*");
        registration.setName("xssFilter");
        registration.setOrder(Integer.MAX_VALUE);
        Map<String, String> initParameters = Maps.newHashMap();
        initParameters.put("excludes", "/system/notice/*,/img/*,/css/*,/fonts/*,/js/*,/ajax/*,/ruoyi/*");
        initParameters.put("xssEbabled", "false");
        registration.setInitParameters(initParameters);
        return registration;
    }
}
