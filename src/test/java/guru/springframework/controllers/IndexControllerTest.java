package guru.springframework.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import guru.springframework.repositories.RecipeRepository;
import guru.springframework.services.RecipeServiceImpl;

public class IndexControllerTest {

    RecipeServiceImpl recipeService;
    IndexController indexController;

    @Mock
    RecipeRepository recipeRepository;
    @Mock
    Model model;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
        indexController = new IndexController(recipeService);
        model.addAttribute("Test", true);
    }


    @Test
    public void testGetIndexPage() {
        assertEquals("index", indexController.getIndexPage(model));
        assertEquals(true, model.containsAttribute("Test"));
    }
}
