package com.joesamyn.giflib.data;


import com.joesamyn.giflib.model.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CategoryRepository {
    // this allows it to not be changed.
   private static final List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category(1, "Funny"),
            new Category(2, "People"),
            new Category(3, "Tech")
    );

    // I am returning a copy of a list here because I do not want to take the chance of this list being altered
    // since it is acting as our database.
    public List<Category> getAllCategories(){
        return new ArrayList<>(ALL_CATEGORIES);
    }

    public Category FindById(int id){
        Category category = ALL_CATEGORIES.stream()
                .filter(cat -> id == cat.getId())
                .findFirst()
                .orElse(null);
        return category;
    }

}
