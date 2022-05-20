package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import soundsystem.CDPlayer;
import soundsystem.CompactDisc;
import soundsystem.SgtPeppers;

import javax.sql.DataSource;

@Configuration
//@ComponentScan("soundsystem")
@PropertySource("classpath:/app.properties")
public class CDPlayerConfig {

    @Bean(name = "lonelyHeartsClubBand")
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }

    @Bean
    public CompactDisc randomBeatlesCD() {
        int choice = (int) Math.floor(Math.random() * 4);
        if (choice == 0) {
            return new SgtPeppers();
        }
        return new SgtPeppers();
    }

    @Bean
    public CDPlayer cdPlayer() {
        /**
         * 构造器注入bean
         *    sgtPeppers()添加了bean注解，
         *    Spring将会拦截所有对它的调用，
         *    并确保直接返回该方法所创建的bean, 而不是每次都对其进行实际的调用
         *   默认情况下，Spring中的bean都是单例的
         */
        return new CDPlayer(sgtPeppers());
    }

//    @Bean
//    public CDPlayer anotherPlayer() {
//        /**
//         * 两个CDPlayer bean 会得到相同的SgtPeppers实例
//         */
//        return new CDPlayer(sgtPeppers());
//    }
//
//    /**
//     * Spring自动装配CompactDisc到配置方法中
//     *
//     */
////    @Bean
////    public CDPlayer cdPlayer(CompactDisc compactDisc) {
////        return new CDPlayer(compactDisc); //构造器实现DI
////    }
//
//    @Bean
//    public DataSource dataSource() {
//        return new EmbeddedDatabaseBuilder()
//                .addScript("classpath:schema.sql")
//                .addScript("classpath:test-data.sql")
//                .build();
//    }

    @Autowired
    Environment env;


}
