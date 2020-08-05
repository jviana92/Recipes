package com.jv.recipes.controllers;

import com.jv.recipes.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class indexControllerTest {
    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    IndexController controller;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        controller = new IndexController(recipeService);
    }

    @Test
    public void getIndexPage() {

        String viewName = controller.getIndexPage(model);
        assertEquals("index",viewName);

        verify(recipeService, times(1)).getRecipes();
        verify(model,times(1)).addAttribute(eq("recipes"),anySet());
    }
}