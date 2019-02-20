package com.joesamyn.giflib.data;

import com.joesamyn.giflib.model.Gif;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


// Spring scans the entire project for packages with this annotation.  When the GifRepo is needed it will create one for us
// or use one that has already been created.
// By allowing Spring to wire our dependencies together without us having to create a constructor or initialize the class
// is called Dependency Injection, or DI. Spring wires these objects together through Autowired.
@Component
public class GifRepository {

    // We use Arrays.asList so we can just add array items and have them converted to a list instead of having to "add" every
    // Item individually.
    // This should be replaced with a database, but for prototyping a list will work fine.
    private static final List<Gif> ALL_GIFS = Arrays.asList(
        new Gif("android-explosion", 1, LocalDate.of(2015,2,13), "Chris Ramacciotti", false),
        new Gif("ben-and-mike", 1, LocalDate.of(2015,10,30), "Ben Jakuben", true),
        new Gif("book-dominos", 2, LocalDate.of(2015,9,15), "Craig Dennis", false),
        new Gif("compiler-bot",2, LocalDate.of(2015,2,13), "Ada Lovelace", true),
        new Gif("cowboy-coder",3, LocalDate.of(2015,2,13), "Grace Hopper", false),
        new Gif("infinite-andrew",3, LocalDate.of(2015,8,23), "Marissa Mayer", true)
    );

    public Gif FindByName(String Name){

        // In this method, an enhanced for loop could have worked to loop through the list and find the proper gif.
        // The lambda is more concise and allows a simple or Else implementation which you can check with a print line
        // to see if it is working.
        // We assign the stream to a new gif instance.
        Gif gif = ALL_GIFS.stream()
                // filer looking for a gif that has the Name that was passed in as an argument.
                .filter( GIF -> Name.equals(GIF.getName()))
                // FindFirst finds the first match and returns it.
                .findFirst()
                // If it doesnt find a match it returns null.
                .orElse(null);
        return gif;
    }

    public List<Gif> getAllGifs(){
        return new ArrayList<>(ALL_GIFS);
    }

    public List<Gif> FindByCategoryId(int id){
        List<Gif> gif = ALL_GIFS.stream()
                .filter(GIF -> id == GIF.getCategoryId())
                .collect(Collectors.toList());
        return gif;
    }
}
