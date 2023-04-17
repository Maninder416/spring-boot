//package io.reactivestax.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
//import org.springframework.security.ldap.authentication.BindAuthenticator;
//import org.springframework.security.ldap.authentication.LdapAuthenticationProvider;
//import org.springframework.security.ldap.search.FilterBasedLdapUserSearch;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class LdapSecurityConfiguration {
//
//    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .anyRequest()
//                .fullyAuthenticated()
//                .and()
//                .formLogin();
//        http.authenticationProvider(ldapAuthenticationProvider());
//        return http.build();
//    }
//    @Bean
//    LdapAuthenticationProvider ldapAuthenticationProvider(){
//        return new LdapAuthenticationProvider(authenticator());
//    }
//    @Bean
//    BindAuthenticator authenticator(){
//        FilterBasedLdapUserSearch search = new FilterBasedLdapUserSearch("ou=groups", "(uid={0})", contextSource());
//        BindAuthenticator authenticator = new BindAuthenticator(contextSource());
//        authenticator.setUserSearch(search);
//        return authenticator;
//    }
//    @Bean
//    public DefaultSpringSecurityContextSource contextSource(){
//        DefaultSpringSecurityContextSource source = new DefaultSpringSecurityContextSource
//                ("ldap://localhost:8389/dc=springframework,dc=org");
//        source.setUserDn("uid={0},ou=people");
//        return source;
//    }
//}
