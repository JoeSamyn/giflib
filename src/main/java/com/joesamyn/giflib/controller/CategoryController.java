package com.joesamyn.giflib.controller;

import com.joesamyn.giflib.data.CategoryRepository;
import com.joesamyn.giflib.data.GifRepository;
import com.joesamyn.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepository catRepo;
    @Autowired
    GifRepository gifRepo;

    @RequestMapping("/categories")
    public String ListCategories(ModelMap modelMap){
        modelMap.put("categories", catRepo.getAllCategories());
        System.out.println(catRepo.getAllCategories());
        return "categories";
    }

    @RequestMapping("/category/{id}")
    public String Category(@PathVariable int id, ModelMap modelMap){
        modelMap.put("category", catRepo.FindById(id));

        List<Gif> gif = gifRepo.FindByCategoryId(id);
        modelMap.put("gifs", gif);
        return "category";
    }

}
