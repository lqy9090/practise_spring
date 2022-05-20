package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import soundsystem.BlankDisc;
import soundsystem.CompactDisc;
import soundsystem.SgtPeppers;
import soundsystem.TrackCounter;

import java.util.ArrayList;

@Configuration
@EnableAspectJAutoProxy
public class TrackCounterConfig {

    @Bean(name = "blankDisc")
    public CompactDisc blankDisc() {
        BlankDisc cd = new BlankDisc();
        cd.setTitle("Sgt. Pepper's Lonely Hearts Club Band");
        cd.setArtist("The Beatles");
        ArrayList<String> tracks = new ArrayList<>();
        tracks.add("Sgt. Pepper's Lonely Hearts Club Band");
        tracks.add("With a Little Help From My Friends");
        tracks.add("Lucy in the Sky with Diamonds");
        tracks.add("Getting Better");
        tracks.add("Fixing a Hole");

        cd.setTracks(tracks);
        return cd;
    }

    @Bean
    public TrackCounter trackCounter(){
        return new TrackCounter();
    }

}
