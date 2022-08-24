package guru.springframework.converters;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.util.Converter;

import guru.springframework.commands.UnitOfMeasureCommand;
import guru.springframework.domain.UnitOfMeasure;
import lombok.Synchronized;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

  @Synchronized
  @Nullable
  @Override
  public UnitOfMeasureCommand convert(UnitOfMeasure source) {

    if(source != null) {
      final UnitOfMeasureCommand uomc = new UnitOfMeasureCommand();
      uomc.setId(source.getId());
      uomc.setDescription(source.getDescription());
      return uomc;
    }
    return null;
  }

}
