package telas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListaProdutosTela  extends BaseTela{

    public ListaProdutosTela(WebDriver app){
        super(app);
    }

    public AdicionarProdutosTela abrirTelaAdicaoProduto(){
        app.findElement(By.id("com.lojinha:id/floatingActionButton")).click();
        return new AdicionarProdutosTela(app);

    }

}


