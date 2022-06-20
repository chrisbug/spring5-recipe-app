package guru.springframework.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.domain.Recipe;

public interface RecipeRepositories extends CrudRepository<Recipe, Long> {
    
}
