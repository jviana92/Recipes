package com.jv.recipes.controllers;


import com.jv.recipes.domain.Category;
import com.jv.recipes.domain.UnitOfMeasure;
import com.jv.recipes.repositories.CategoryRepository;
import com.jv.recipes.repositories.UnitOfMeasureRepository;
import com.jv.recipes.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Slf4j
@Controller
public class indexController {

    private final RecipeService recipeService;

    public indexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model){
        log.debug("Getting index page");
        model.addAttribute("recipes",recipeService.getRecipes());
        return "index";
    }
}
