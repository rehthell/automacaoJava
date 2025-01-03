package telas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdicionarProdutosTela extends BaseTela{

    public AdicionarProdutosTela(WebDriver app){
        super(app);
    }

    public AdicionarProdutosTela preencherNome(String produtoNome){
        app.findElement(By.id("com.lojinha:id/productName")).click();
        app.findElement(By.id("com.lojinha:id/productName")).findElement(By.id("com.lojinha:id/editText")).sendKeys(produtoNome);
        return this;
    }

    public AdicionarProdutosTela preencherValor(String produtoValor){
        app.findElement(By.id("com.lojinha:id/productValue")).click();
        app.findElement(By.id("com.lojinha:id/productValue")).findElement(By.id("com.lojinha:id/editText")).sendKeys(produtoValor);
        return this;
    }

    public AdicionarProdutosTela preencherCor(String produtoCor){
        app.findElement(By.id("com.lojinha:id/productColors")).click();
        app.findElement(By.id("com.lojinha:id/productColors")).findElement(By.id("com.lojinha:id/editText")).sendKeys(produtoCor);
        return this;

    }

    public AdicionarProdutosTela submeterErro(){
        app.findElement(By.id("com.lojinha:id/saveButton")).click();
        return this;
    }

    public String mensagemToast(){
        return mensagemErroToast();
    }

}
