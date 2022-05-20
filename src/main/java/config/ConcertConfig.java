package config;

import concert.Audience;
import concert.AudienceWithoutNote;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
public class ConcertConfig {

    @Bean
    public AudienceWithoutNote audience() {
        return new AudienceWithoutNote();
    }
}
