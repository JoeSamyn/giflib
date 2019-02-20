package com.joesamyn.giflib.controller;

import com.joesamyn.giflib.data.GifRepository;
import com.joesamyn.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;


// This indicated to the spring framework that this is a controller class.
@Controller
// This annotation could be used, it combines the @Controller annotation and the @ResponseBody annotation.
//@RestController
public class GifController {

    // This tells spring to assign a GifRepository field to this instance as soon as IT IS NEEDED.
    @Autowired
    GifRepository gifRepo;

    // This is the annotation shows what method to execute when the URI value is requested.  In this case,
    // it will call this method when the homepage is requested.
    @RequestMapping(value = "/")
    // This response body allows this method to be executed without any further processing. This is not needed if
    // @RestController is being used.
    // @ResponseBody We do not need this if we are trying to process a HTML file.
    public String ListGifs(ModelMap modelMap){

        List<Gif> gif = gifRepo.getAllGifs();
        modelMap.put("gifs", gif);
        // This is simply the name of our html file we want to reference.  This is enough for the Thymeleaf resolver
        // to find the correct html file.
        return "home";
    }

    // here we add a path variable to direct the page more dynamically based on the name of the gif.
    @RequestMapping("/gif/{name}")
    // in order to map this to the thymeleaf template, we need to include a model parameter in the GifDetails method.
    // When the "/gif" URI is requested spring will pass in an instance of a model map into this parameter.
    // This @PathVariable is the variable we will use in the URI to create URI's based on the name if the gif.
    public String GifDetails(@PathVariable String name,  ModelMap modelMap){
        // Here we create an instance of out Gif object so we can pass these details into the Thymeleaf template engine.
        Gif gif = gifRepo.FindByName(name);
        // Just like in spark, we use maps to pass data between java code and HTML thymeleaf render engine. Here we
        // put our gif object with the keyword of "gif" into the modelMap that was created in the argument of this method.
        modelMap.put("gif", gif);
        // Again we return the name of our HTML file that we wish to render when this URI is requested.
        return "gif-details";
    }

}
