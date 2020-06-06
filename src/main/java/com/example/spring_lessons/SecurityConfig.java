package com.example.spring_lessons;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        //静的リソースへのセキュリティー除外
        web.ignoring().antMatchers("/webjars/**", "/css/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
            authorizeRequests()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/signup").permitAll()
                .anyRequest().authenticated();
                //ログイン処理
                http
                .formLogin()
                .loginProcessingUrl("/login")//ログイン処理のパス
                .loginPage("/login")//ログインページの指定
                .failureUrl("/login")//ログイン失敗時の遷移先
                .usernameParameter("userId")//ログインページのユーザーID
                .passwordParameter("password")//ログインページのパスワード
                .defaultSuccessUrl("/home", true);//ログイン成功時の遷移先
                //CSRF対策を無効（一時的）
                http.csrf().disable();
    }

    
}