package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
//    private SpitterRepository spitterRepository;

//    @Autowired
//    public SpitterController(SpitterRepository spitterRepository) {
//        this.spitterRepository = spitterRepository;
//    }

    @RequestMapping(value = "/register", method = GET)
    public String showRegistrationForm() {
        return "registerForm";
    }

//    @RequestMapping(value = "/register", method = POST)
//    public String ProcessRegistration(Spitter spitter) {
//        spitterRepository.save(spitter);
//
//        return "redirect:/spitter/"+spitter.getUsername();
//    }
}
