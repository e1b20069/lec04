package oit.is.z1661.group.lec04.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class Sample3AuthConfiguration {

  @Bean
  public InMemoryUserDetailsManager userDetailsService() {
    UserBuilder users = User.builder();

    // $ sshrun htpasswd -nbBC 10 user1 p@ss
    UserDetails user3 = users
        .username("user3")
        .password("$2y$10$HMdkq6mFUu8vk5EOj4F4Nuzssk8W49LkGL5jOJxiKzhESWFe7zf3a")
        .roles("USER")
        .build();
    UserDetails admin = users
        .username("admin")
        .password("$2y$10$lRGwHAY/elb87NBDoK3AWeiQKHrho.mTABmdbxJ4e3nFweCFInGQ6")
        .roles("ADMIN")
        .build();

    return new InMemoryUserDetailsManager(user3, admin);
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.formLogin();
    http.authorizeHttpRequests()
        .mvcMatchers("/sample4/**").authenticated();

    http.logout().logoutSuccessUrl("/");
    return http.build();
  }

  /**
   * @return
   */
  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
