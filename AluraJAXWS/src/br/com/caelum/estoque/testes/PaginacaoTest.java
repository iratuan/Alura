package br.com.caelum.estoque.testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.caelum.estoque.modelo.item.Item;

class PaginacaoTest {

	@Test
	void testandoCalculoPaginacao() {
		PaginateBulder.setPaginas(10000);
		List<Integer> paginas = PaginateBulder.paginas;

		assertEquals(10000, paginas.size());
		assertEquals(PaginateBulder.getResult(20, 1000, 1).size(), 999);
		assertTrue(PaginateBulder.getResult(2, 1000, 1).contains(1350));

	}

	static class PaginateBulder {

		private static List<Integer> paginas = new ArrayList<>();

		public static void setPaginas(int limite) {
			for (int i = 1; i <= limite; i++) {
				paginas.add(i);
			}
		}

		public static List<Integer> getResult(Integer page, Integer size, Integer filtro) {
			Integer totalPaginas = paginas.size();
			Integer inicio = (page - 1) * size;
			Integer fim = page * size - 1;
			List<Integer> resultado = new ArrayList<Integer>();

			if (filtro != null) {
				for (Integer pagina : paginas) {
					if (pagina.equals(filtro)) {
						resultado.add(pagina);
					}
				}
			} else {

				if (fim <= totalPaginas && inicio <= totalPaginas) {
					resultado = paginas.subList(inicio, fim);
				} else {
					resultado = paginas.subList(paginas.size() - size, paginas.size() - 1);
				}
			}
			
			return resultado;
		}
	}
}
