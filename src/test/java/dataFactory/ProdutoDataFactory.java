package dataFactory;

import pojo.ComponentePojo;
import pojo.ProdutoPojo;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDataFactory {
    public static ProdutoPojo criarProdutoValor(double valor){
        ProdutoPojo produto = new ProdutoPojo();
        produto.setProdutoNome("ProdutoReh");
        produto.setProdutoValor(valor);

        List<String> cores = new ArrayList<>();
        cores.add("preto");

        produto.setProdutoCores(cores);
        produto.setProdutoUrlMock("");

        List<ComponentePojo> componentes = new ArrayList<>();

        ComponentePojo componente = new ComponentePojo();
        componente.setComponenteNome("ComponenteReh");
        componente.setComponenteQuantidade(1);
        /*
        ComponentePojo outroComponente = new ComponentePojo();
        outroComponente.setComponenteNome("ComponenteReh");
        outroComponente.setComponenteQuantidade(1);
        componentes.add(outroComponente);
        */
        componentes.add(componente);
        produto.setComponentes(componentes);

        return produto;
    }
}
