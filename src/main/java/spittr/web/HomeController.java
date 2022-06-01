package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping({"/", "homepage"}) //类级别 注解会应用到控制器的所有处理器方法上
public class HomeController {

    @RequestMapping(method = GET)
    public String home() {
        return "home";
    }
}
