package paginas;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListaProdutosPage {
    private WebDriver navegador;

    public ListaProdutosPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public AdicionarProdutoPage acessarFormularioProduto(){
        navegador.findElement(By.linkText("ADICIONAR PRODUTO")).click();

        return new AdicionarProdutoPage(navegador);
    }

    public String capturarMensagemToast(){
        return navegador.findElement(By.cssSelector(".toast.rounded")).getText();

    }
}
