package modulos.produto;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import paginas.LoginPage;

import java.io.File;
import java.time.Duration;

//WEBDRIVER
@DisplayName("Teste web")
public class ProdutosTests {

    private WebDriver navegador;

    @BeforeEach
    public void beforeEach() {
        EdgeDriverService service = new EdgeDriverService.Builder()
                .usingDriverExecutable(new File("C:\\drive_testes\\edgedriver_win64\\msedgedriver.exe"))
                .usingAnyFreePort()
                .build();
        this.navegador = new EdgeDriver(service);
        this.navegador.manage().window().maximize();
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        this.navegador.get("http://165.227.93.41/lojinha-web/v2");
    }

    @Test
    @DisplayName("Não permite valor igual a zero")
    public void testProdutoValorZero(){
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

        String mensagemToast = new LoginPage(navegador)
                .informarUsuario("reh")
                .informarSenha("reh")
                .submeter()
                .acessarFormularioProduto()
                .nomeProduto("Produto Rehh")
                .valorProduto("000")
                .corProduto("cor,cor")
                .botaoSubmeterErro()
                .capturarMensagemToast();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemToast);

    }

    @Test
    @DisplayName("Nao permite valor acima de 7 mil")
    public void testNaoPermiteValorAcimaSeteMil(){
        String mensagemToast = new LoginPage(navegador)
                .informarUsuario("reh")
                .informarSenha("reh")
                .submeter()
                .acessarFormularioProduto()
                .nomeProduto("Produto Rehh")
                .valorProduto("700001")
                .corProduto("cor,cor")
                .botaoSubmeterErro()
                .capturarMensagemToast();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemToast);
    }

    @Test
    @DisplayName("Nao permite valor entre 0,01 e 7 mil")
    public void testPermiteValorLimites(){
        String mensagemToast = new LoginPage(navegador)
                .informarUsuario("reh")
                .informarSenha("reh")
                .submeter()
                .acessarFormularioProduto()
                .nomeProduto("Produto Rehh")
                .valorProduto("30000")
                .corProduto("cor")
                .submeterProdutoSucesso()
                .capturarMensagemToast();
        Assertions.assertEquals("Produto adicionado com sucesso", mensagemToast);

    }

    @AfterEach
    public void afterEach(){
        navegador.quit();
    }
}
