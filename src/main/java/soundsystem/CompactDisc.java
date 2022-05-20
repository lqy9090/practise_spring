package soundsystem;

import org.springframework.stereotype.Component;


public interface CompactDisc {
    void play();

    void playTrack(int track);
}
