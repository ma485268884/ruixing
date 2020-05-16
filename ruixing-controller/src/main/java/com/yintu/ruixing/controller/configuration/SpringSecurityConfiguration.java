package com.yintu.ruixing.controller.configuration;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import java.io.IOException;

@Configuration // 里面已经包含了@Component 所以不用再上下文中在引入入了
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
    // spring自带的
    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * configure(HttpSecurity)方法定义了哪些URL路径应该被保护
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()// 该方法所返回的对象的方法来配置请求级别的安全细节
                .antMatchers("/druid/**").permitAll()
                .antMatchers("/api/**").permitAll() // 调用api不需要拦截
                .antMatchers("/login").permitAll() // 登录页面不拦截
                .antMatchers(HttpMethod.POST, "/checkLogin").permitAll().anyRequest().authenticated()// 对于登录路径不进行拦截
                .and().formLogin()// 配置登录页面
                .loginPage("/login")// 登录页面的访问路径;
                .loginProcessingUrl("/checkLogin")// 登录页面下表单提交的路径
                .failureUrl("/login?paramserror=true")// 登录失败后跳转的路径,为了给客户端提示
                .defaultSuccessUrl("/index")// 登录成功后默认跳转的路径;
                .and().logout()// 用户退出操作
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST"))// 用户退出所访问的路径，需要使用Post方式
                .permitAll().logoutSuccessUrl("/login?logout=true")/// 退出成功所访问的路径
                .and().exceptionHandling().accessDeniedPage("/403")
                .and()
                .csrf().disable()
                .headers().frameOptions()// 允许iframe内呈现。
                .sameOrigin()
                .and().sessionManagement()
                /*如果用户在不退出登录的情况下使用用户名进行身份验证，并试图对“用户”进行身份验证，
                 * 那么第一个会话将被强制终止并发送到/login?expired页面。
                 */
                .maximumSessions(1)
//.expiredUrl("/login?expired=true")//如果是异步请求。无法进行页面跳转;
// session过期处理策
                .expiredSessionStrategy(new SessionInformationExpiredStrategy() {
                    @SneakyThrows
                    @Override
                    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
                        String header = event.getRequest().getHeader("X-Requested-With");
                        System.out.println("header:" + header);
                        if (header != null && header.equals("XMLHttpRequest")) {//异步请求
                            JSONObject jo = new JSONObject();
                            jo.put("resultCode", 302);
                            jo.put("redirectUrl", "login?expired=true");
                            //返回严格的json数据
                            event.getResponse().getWriter().write(jo.toString());
                        } else {
                            event.getResponse().sendRedirect("/myweb/login?expired=true");
                        }

                    }
                });

    }

    /**
     * 忽略静态资源
     */

    @Override
    public void configure(WebSecurity web) throws Exception {
        /*
         * 在springboot中忽略静态文件路径，直接写静态文件的文件夹 springboot默认有静态文件的放置路径，如果应用spring
         * security，配置忽略路径 不应该从springboot默认的静态文件开始
         * 如：在本项目中，所有的js和css都放在static下，如果配置忽略路径，则不能以static开始
         * 配置成web.ignoring().antMatchers("/static/*");这样是不起作用的
         */
        web.ignoring().antMatchers("/themes/**", "/script/**");

    }

    /**
     * 配置自定义用户服务
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
//.passwordEncoder(passwordEncoder());

    }

/**
 * 密码加密
 */
    /*
     * @Bean public BCryptPasswordEncoder passwordEncoder() { return new
     * BCryptPasswordEncoder(); }
     */

}
