import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import spittr.Spittle;
import spittr.web.HomeController;
import spittr.web.SpittleController;
import spittr.web.SpittleRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class HomeControllerTest {

    @Test
    public void testHomePage() throws Exception {
        HomeController homeController = new HomeController();
        MockMvc mockMvc = standaloneSetup(homeController).build();


        mockMvc.perform(get("/")).andExpect(view().name("home"));
    }

    @Test
    public void shouldShowRecentSpittles() throws Exception {
        List<Spittle> expectedSpittle = createSpittleList(20);

        SpittleRepository mockRepository = mock(SpittleRepository.class);

        when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedSpittle);

        SpittleController controller = new SpittleController(mockRepository);

        MockMvc mockMvc = standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();

        mockMvc.perform(get("/spittles"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittlelist", hasItems(expectedSpittle.toArray())));
    }

    private List<Spittle> createSpittleList(int count) {
        ArrayList<Spittle> spittles = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle "+i,new Date()));
        }
        return spittles;
    }

    @Test
    public void shouldShowPageSpittles() throws Exception {
        List<Spittle> expectedSpittle = createSpittleList(50);

        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findSpittles(238900, 50)).thenReturn(expectedSpittle);

        SpittleController controller = new SpittleController(mockRepository);

        MockMvc mockMvc = standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();

        mockMvc.perform(get("/spittles?max=238900&count=50"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittlelist", hasItems(expectedSpittle.toArray())));

    }

    @Test
    public void shouldShowRegistration() throws Exception{
        SpittleController controller = new SpittleController();
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/spittles/register"))
                .andExpect(view().name("registerForm"));
    }

    @Test
    public void shouldProcessRegistration() {
        SpittleRepository mockRepository = mock(SpittleRepository.class);

//        new Spitter("jbauer", "24hours", "Jack", "Bauer");
//        new Spitter(24L, "jbauer", "24hours", "Jack", "Bauer");
//
//        when(mockRepository.sa)

    }
}
