package com.cyberoxi.sevadathink;

import com.cyberoxi.sevadathink.payload.UploadedPicture;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableConfigurationProperties({
        UploadedPicture.class
})
@EnableJpaAuditing
@SpringBootApplication
public class SevadaThinkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SevadaThinkApplication.class, args);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
