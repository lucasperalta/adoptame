package ar.edu.davinci.adoptame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller    // This means that this class is a Controller
@RequestMapping(path="/") // This means URL's start with /demo (after Application path)
public class    PublicController {




@RequestMapping("/")
public String index(Model model){



    return "public/index";

    }





}
