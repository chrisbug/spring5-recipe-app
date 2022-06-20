package guru.springframework.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.domain.UnitOfMeasure;

public interface UnitOfMesurementRepositories extends CrudRepository<UnitOfMeasure, Long> {
    
}
