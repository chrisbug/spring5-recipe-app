package guru.springframework.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import guru.springframework.commands.IngredientCommand;
import guru.springframework.converters.IngredientToIngredientCommand;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {

  private final IngredientToIngredientCommand ingredientToIngredientCommand;
  private final RecipeRepository recipeRepository;

  /**
   * @param ingredientToIngredientCommand
   * @param recipeRepository
   */
  public IngredientServiceImpl(IngredientToIngredientCommand ingredientToIngredientCommand,
      RecipeRepository recipeRepository) {
    this.ingredientToIngredientCommand = ingredientToIngredientCommand;
    this.recipeRepository = recipeRepository;
  }

  @Override
  public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {
    Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

    if (!recipeOptional.isPresent()) {
      log.error("recipe id not found, id:" + recipeId);
    }

    Recipe recipe = recipeOptional.get();

    Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
        .filter(ingredient -> ingredient.getId().equals(ingredientId))
        .map(ingredient -> ingredientToIngredientCommand.convert(ingredient)).findFirst();

    if(!ingredientCommandOptional.isPresent()){
      log.error("ingredient id not found" + ingredientId);
    }

    return ingredientCommandOptional.get();
  }

}
