import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import config.CDPlayerConfig;
import soundsystem.CompactDisc;
import soundsystem.MediaPlayer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= CDPlayerConfig.class)
public class CDPlayerTest {
    @Rule
   public StandardOutputStreamLog log =  new StandardOutputStreamLog();


    @Qualifier("cdPlayer")
    @Autowired
    private MediaPlayer player;


    @Qualifier("randomBeatlesCD")
    @Autowired
    private CompactDisc cd;

    @Test
    public void sdShouldNotBeNull() {
        assertNotNull(cd);
    }


    @Test
    public void play() {
        player.play();;
        assertEquals("Playing Sgt. Pepper's Lonely Hearts Club Band" +
                " by The Beatles\n", log.getLog());
    }

}

