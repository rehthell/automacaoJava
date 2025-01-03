package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EdicaoProdutoPage {
    private WebDriver navegador;

    public EdicaoProdutoPage(WebDriver navegador){
            this.navegador = navegador;
        }
    public String capturarMensagemToast(){
        return navegador.findElement(By.cssSelector(".toast.rounded")).getText();

    }
}
