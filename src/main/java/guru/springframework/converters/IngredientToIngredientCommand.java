package guru.springframework.converters;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import guru.springframework.commands.IngredientCommand;
import guru.springframework.domain.Ingredient;
import lombok.Synchronized;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {
  private final UnitOfMeasureToUnitOfMeasureCommand uomConverter;

  public IngredientToIngredientCommand(UnitOfMeasureCommandToUnitOfMeasure uomConverter) {
    this.uomConverter = uomConverter;
  }

  @Synchronized
  @Nullable
  @Override
  public IngredientCommand convert(Ingredient ingredient) {
    if(ingredient == null) {
      return null;
    }

    IngredientCommand ingredientCommand = new IngredientCommand();
    ingredientCommand.setId(ingredient.getId());
    ingredientCommand.setAmount(ingredient.getAmount());
    ingredientCommand.setUnitOfMeasure(uomConverter.convert(ingredient.getUom()));
    return ingredientCommand;
  }
}
