package modulos.produto;


//MOBILE - APPIUM

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import telas.LoginTela;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@DisplayName("Testes Mobile do Produto")
public class ProductTest {

    private WebDriver app;

    @BeforeEach
    public void beforeEach() throws MalformedURLException{
        DesiredCapabilities capacidades = new DesiredCapabilities();
        //abre o genymotion e settings nos 3 pontinhos do emulador
        capacidades.setCapability("deviceName","Google Pixel 3");
        capacidades.setCapability("platformName","Android");
        capacidades.setCapability("udid","192.168.56.104:5555");
        //abre o emulador abre o cmd e digita adb shell dumpsys window | findstr  -i "mCurrentFocus"
        capacidades.setCapability("appPackage","com.lojinha");
        capacidades.setCapability("appActivity","com.lojinha.ui.MainActivity");
        capacidades.setCapability("app", "C:\\Users\\rebec\\Videos\\Captures\\modulo_12_Testes_Mobile\\Aula2_Material de apoio ao modulo\\Lojinha Android Nativa\\lojinha-nativa.apk");

        this.app = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub", capacidades)); //URL do Appium
        app.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @DisplayName("Validar produto com valor incorreto")
    @Test
    public void testValidarValorIncorreto() {
        /*
         * Passo a passo:
         *
         * 1. abrir browser
         * 2. ir para Lojinha Web
         * 3. Login
         * 4. Tela registro de produto
         * 5. preencher dados e valor igual a zero
         * 6. tentar salvar
         *
         * */

        String mensagem = new LoginTela(app)
                .preencherUsuario("reh")
                .preencherSenha("reh")
                .submeter()
                .abrirTelaAdicaoProduto()
                .preencherNome("Produto mobile")
                .preencherValor("700001")
                .preencherCor("cor,mobile")
                .submeterErro()
                .mensagemErroToast();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagem);
    }

    @AfterEach
    public void afterEach(){

    }
}
