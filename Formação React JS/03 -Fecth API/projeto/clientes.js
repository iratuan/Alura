const informacoesClientes = [
  {
    cpf: 86410768320,
    nome: "Iratuan Junior",
  },
  {
    cpf: 56410768320,
    nome: "Erika Rosal",
  },
];

montaCorpoTabela = () => {
  let corpoTabela = ``;
  informacoesClientes.map((item) => {
    corpoTabela += `
        <tr>
        <td scope="col">${item.cpf}</td>
        <td scope="col">${item.nome}</td>
        <td scope="col">Ações</td>
        </tr>
    `;
  });
  return corpoTabela;
};

const corpoTabela = document.querySelector("[data-conteudo-tabela]");
corpoTabela.innerHTML = montaCorpoTabela();
