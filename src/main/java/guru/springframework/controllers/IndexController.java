package guru.springframework.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMesurementRepository;

/**
 * Created by jt on 6/1/17.
 */
@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMesurementRepository unitOfMesurementRepository;

    

    public IndexController(CategoryRepository categoryRepository,
            UnitOfMesurementRepository unitOfMesurementRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMesurementRepository = unitOfMesurementRepository;
    }



    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){
        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMesureOptonal = unitOfMesurementRepository.findByDescription("Teaspoon");

        System.out.println("category id is: "  + categoryOptional.get().getId());
        System.out.println("UOM id is: "  + unitOfMesureOptonal.get().getId());

        return "index";
    }
}
