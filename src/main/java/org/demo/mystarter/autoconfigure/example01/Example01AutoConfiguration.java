package org.demo.mystarter.autoconfigure.example01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = Example01Properties.class)
@ConditionalOnClass(value = {Example01Service.class})
@ConditionalOnProperty(
        prefix = "spring.mystarter.example01",
        value = {"enabled"},
        matchIfMissing = true
)
public class Example01AutoConfiguration {

    @Autowired
    private Example01Properties example01Properties;

    @Bean
    @ConditionalOnMissingBean(value = Example01Service.class)
    public Example01Service example01Service() {
        Example01Service example01Service = new Example01Service();
        example01Service.setMessage(example01Properties.getMessage());
        return example01Service;
    }

}
