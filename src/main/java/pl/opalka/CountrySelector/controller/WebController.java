package pl.opalka.CountrySelector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.expression.Lists;
import pl.opalka.CountrySelector.model.Info;
import pl.opalka.CountrySelector.services.BasicInfoParser;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {

    private final BasicInfoParser basicInfoParser;

    @Autowired
    public WebController(BasicInfoParser basicInfoParser) {
        this.basicInfoParser = basicInfoParser;
    }

    @GetMapping("/basic")
    public String getMap(Model model) throws IOException {
        model.addAttribute("points", basicInfoParser.getBasicData());
        return "map";
    }



    @GetMapping("/info")
    public Model postInfo(Model model, @RequestParam(name = "name") String name) throws IOException {
        model.addAttribute("info",basicInfoParser.getInfo(name)[0]);
        return model;

    }

}
