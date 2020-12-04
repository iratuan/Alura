package br.com.aygean.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.aygean.model.Cargo;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Integer> {

}
