package br.com.casadocodigo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.casadocodigo.entity.Produto;

@Repository
@Transactional
public class ProdutoDAO {
	
	@PersistenceContext 
	private EntityManager manager;

	public void gravar(Produto produto) {
		manager.persist(produto);
	}
}
