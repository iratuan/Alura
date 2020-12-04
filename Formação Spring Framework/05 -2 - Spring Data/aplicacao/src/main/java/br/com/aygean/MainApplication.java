package br.com.aygean;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.aygean.model.Cargo;
import br.com.aygean.repository.CargoRepository;
import br.com.aygean.service.CrudCargoService;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {

	private final CrudCargoService cargoService;
	private boolean system = true;
	
	public MainApplication(CrudCargoService cargoService) {
		this.cargoService = cargoService;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		
		while(system) {
			System.out.println("Qual ação você quer executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			int action = scanner.nextInt();
			if(action==1) {
				cargoService.start(scanner);
			}
		}
		
	}

}
