package com.yintu.ruixing.controller.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfiguration {
    @Bean
   // @ConfigurationProperties("spring.datasource")
    public DataSource druid() {
        return new DruidDataSource();
    }
    //配置druid的监控
    //1.配置一个管理后台的Servlet

    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String, String> initParameters = new HashMap<>();
        initParameters.put("loginUsername", "admin");
        initParameters.put("loginPassword", "123456");
        initParameters.put("allow", "");//默认允许所有访问
        initParameters.put("deny", "192.168.1.5");
        servletRegistrationBean.setInitParameters(initParameters);
        return servletRegistrationBean;
    }

    //2.配置一个Web监控的filter
    @Bean
    public FilterRegistrationBean WebStatFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        Map<String, String> initParameters = new HashMap<>();
        initParameters.put("exclusions", "*.html,*.css,*.js,/druid/*");
        filterRegistrationBean.setInitParameters(initParameters);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        return filterRegistrationBean;
    }
}
