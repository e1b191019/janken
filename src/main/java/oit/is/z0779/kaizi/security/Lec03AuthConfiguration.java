package oit.is.z0779.kaizi.janken.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class Lec03AuthConfiguration extends WebSecurityConfigurerAdapter {

  /**
   * 認証処理に関する設定（誰がログインできるか）
   */
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    auth.inMemoryAuthentication().withUser("user1").password(passwordEncoder().encode("p@ss")).roles("USER");

    auth.inMemoryAuthentication().withUser("user2").password(passwordEncoder().encode("word")).roles("USER");

    auth.inMemoryAuthentication().withUser("ほんだ").password(passwordEncoder().encode("honda")).roles("USER");

    auth.inMemoryAuthentication().withUser("いがき").password(passwordEncoder().encode("igaki")).roles("USER");

    auth.inMemoryAuthentication().withUser("admin")
        .password("$2y$10$3e7Hs2QZ/p91yJVgP5y/1OC7AC8jfc6YDYDzMGK1XieDlNR2nBGDe").roles("ADMIN");

  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  /**
   * 認可処理に関する設定（認証されたユーザがどこにアクセスできるか）
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.formLogin();
    http.authorizeRequests().antMatchers("/lec02/**").authenticated();
    http.logout().logoutSuccessUrl("/");

    http.csrf().disable();
    http.headers().frameOptions().disable();

  }
}
