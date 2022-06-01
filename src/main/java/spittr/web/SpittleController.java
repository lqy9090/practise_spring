package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spittr.Spittle;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private SpittleRepository spittleRepository;
    private static final String MAX_LONG_AS_STRING = Long.MAX_VALUE + ""; //long.tostring会报错

    public SpittleController() {
    }

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    public String spittles(Model model) {
        model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
        return "spittles";
    }

    @RequestMapping(method = GET)
    public List<Spittle> spittles(@RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING)
                                              long max,
                                  @RequestParam("count") int count){
        return spittleRepository.findSpittles(max, count);
    }

    @RequestMapping(value = "/register", method = GET)
    public String showRegistrationForm(){
        return "registerForm";
    }

}
