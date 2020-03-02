package com.nssol.config;


import com.nssol.web.system.service.user.IUserService;
import com.nssol.web.security.filter.JwtLoginFilter;
import com.nssol.web.security.filter.JwtVerifyFilter;
import com.nssol.web.util.user.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private IUserService userService;
    @Resource
    private RsaKeyProperties rsaKeyProperties;
    @Resource
    private UserDetailsService userDetailsService;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/getPlanningInfoListByLine",
                        "/getPlanningInfoListByPage", "/getPackListByPage", "/deletePackInfo",
                        "/insertPackAndDetail", "/getPackingCartonByPage", "/getSetInfoBysetCode",
                        "/getProductionLineList","/getMaxFileName","/insertOperationalLog",
                        "/getLogListByPage","/getDownLoadFiles","/setplanningdata","/getPacKDetailIsExist","/insertPrintReord","/getPackNumByHandlingUnitID",
                        "/v2/api-docs",
                        "/configuration/ui",
                        "/swagger-resources",
                        "/configuration/security",
                        "/swagger-ui.html", "/webjars/**",
                        "/swagger-resources/configuration/ui",
                        "/webjars/springfox-swagger-ui/**",
                        "/backUpBaggingAndMetalcheck"); // #3
    }

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                // 设置UserDetailsService
                .userDetailsService(this.userDetailsService)
                // 使用BCrypt进行密码的hash
                .passwordEncoder(new PasswordEncoder(){
                    public String encode(CharSequence rawPassword) {
                        return UserUtil.getEncryptPassword((String)rawPassword);
                    }
                    public boolean matches(CharSequence rawPassword, String encodedPassword) {//rawPassword用户输入的，encodedPassword数据库查出来的
                        return encodedPassword.equals(UserUtil.getEncryptPassword((String)rawPassword));
                    }}
                );
    }
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.
                csrf().disable()
                //采用JWT,所以不需要Session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers("/v2/api-docs",
                        "/configuration/ui",
                        "/swagger-resources",
                        "/configuration/security",
                        "/swagger-ui.html", "/webjars/**",
                        "/swagger-resources/configuration/ui",
                        "/webjars/springfox-swagger-ui/**").permitAll()


                // 禁用其余所有请求
                .anyRequest().authenticated()
                .and()
                .addFilter(new JwtLoginFilter(super.authenticationManager(),rsaKeyProperties))
                .addFilter(new JwtVerifyFilter(super.authenticationManager(),rsaKeyProperties,userService));


        //禁用缓存
        httpSecurity.headers().cacheControl();
    }


}
