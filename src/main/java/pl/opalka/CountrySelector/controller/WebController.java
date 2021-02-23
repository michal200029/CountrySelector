package pl.opalka.CountrySelector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.opalka.CountrySelector.services.BasicInfoParser;

import java.io.IOException;

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
}
