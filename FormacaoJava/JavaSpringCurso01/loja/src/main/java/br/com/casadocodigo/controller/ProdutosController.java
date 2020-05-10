package br.com.casadocodigo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.casadocodigo.dao.ProdutoDAO;
import br.com.casadocodigo.entity.Produto;

@Controller
public class ProdutosController {
	
	@Autowired
    private ProdutoDAO produtoDao;

    @RequestMapping("/produtos/form")
    public String form() {
        return "produtos/form";
    }

    @RequestMapping("/produtos/gravar")
    public String gravar(Produto produto) {        
        produtoDao.gravar(produto);
        return "/";
    }

}
