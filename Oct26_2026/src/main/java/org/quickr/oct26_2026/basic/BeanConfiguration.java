package org.quickr.oct26_2026.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public BasicBean basicBean() {
        return new BasicBean("Spring Bean");
    }

}
