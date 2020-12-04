package br.com.aygean.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.aygean.model.Cargo;
import br.com.aygean.repository.CargoRepository;

@Service
public class CrudCargoService {

	private final CargoRepository cargoRepository;
	
	public CrudCargoService(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}
	
	public void start(Scanner scanner) {
		save(scanner);
	}
	
	private void save(Scanner scanner) {
		System.out.println("Descrição do cargo:");
		String descricao = scanner.next();
		System.out.println(descricao);
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("Cargo salvo com sucesso!");
	}

}
