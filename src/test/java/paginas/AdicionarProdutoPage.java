package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdicionarProdutoPage {
    private WebDriver navegador;

    public AdicionarProdutoPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public AdicionarProdutoPage nomeProduto(String produtoNome){
        navegador.findElement(By.id("produtonome")).sendKeys(produtoNome);

        return this;
    }

    public AdicionarProdutoPage valorProduto(String produtoValor){
        navegador.findElement(By.name("produtovalor")).sendKeys(produtoValor);

        return this;
    }

    public AdicionarProdutoPage corProduto(String produtoCores){
        navegador.findElement(By.id("produtocores")).sendKeys(produtoCores);

        return this;
    }

    public ListaProdutosPage botaoSubmeterErro(){
        navegador.findElement(By.cssSelector("button[type='submit']")).click();

        return new ListaProdutosPage(navegador);
    }

    public EdicaoProdutoPage submeterProdutoSucesso(){
        navegador.findElement(By.cssSelector("button[type='submit']")).click();

        return new EdicaoProdutoPage(navegador);
    }
}






