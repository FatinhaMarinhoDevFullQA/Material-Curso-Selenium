package br.com.treinaweb.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

//dica para iniciantes: atalho CTRL + SHIFT + O , remove os imports não utilizados, nessa pag. tem vários atalhos utilizados no eclipse https://karanalpe.com.br/tecnologia/teclas-de-atalho-eclipse/

public class UploadTest extends TreinaWebSeleniumTestBase {
	
@Test
// para informar que é uma classe de testes, tem que colocar o @+espaco para apresentar opcao [org.testng.annotations.Test] e assim criar o [import org.testng.annotations.Test;
 
public void testUpload() {
	setUrl("http://demo.guru99.com/selenium/upload/");
	getDriver().findElement(By.id("uploadfile_0")).sendKeys("C:\\Users\\fah\\Documents\\TreinaWeb\\Pagina\\CV_Fátima Marinho_Julho_2020_v4.pdf");
// como manipular o arquivo para fazer upload? simples, basta dá enviar um [sendkeys] e informar o caminho onde está o arquivo para realizar o upload 
    getDriver().findElement(By.id("terms")).click();
    // para mapear o [check box termo de aceite] - chama o [WebDriver] mas a açao [ FindElement por ID] Depois a ação [Click) do Testng
    getDriver().findElement(By.name("send")).click();
    // uma forma diferenciada para mapear elemento, ao invés de chmar [By.id] eu chamei [By.name] pq se você mapear o botao [Submit file] ele também tem um elemento único na tela chamado [Send], que serve como guia para webdriver encontrar e tambem no final usei o [.clic]
    
    // comando WebDriveWait : está na aula [testando Upload 08:50] Antes dos Asserts abaixo, vamos criar um objeto da [API do Selenium] do tipo [WebDriverWait], que nos permite dá  um tempo para executarmos os próximos passos dos testes abaixos(os Asserts) que vai fica assim de inicio [    WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds) : perceba que dentro do WebdriverWait, temos o [Driver] significa que ele espera a [Instancia do Webdriver que deverá interpretar essa espera que que eh o meu [getDriver],e quanto tempo em segundos [timeOutInSeconds] que será essa espera, no caso no testes [30] o final da linha do código deve ficar assim:  
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("res")));
     // Metodo Until : Esse metodo permite passar uma situacao de espera(a linha desse código é logo abaixo do : preciso passar para o [wait] o que deve espera nos [30] segundos, então usamos o metodo [wait.until] que de inicio o código ficará assim:  . obs. a linha desse código deve vim abaixo da linha : WebDriverWait wait = new WebDriverWait(getDriver(), 30);
     // no Editor- FRAMEWORK TestNG: vai apresentar o metodo Wait.unil(true) - é só completar o codigo conforme descrito
     // PresenceOfElementLocated: Espera a presença de um elemento Locator - localizado por alguma coisa, nesse caso pelo ID conforme descrito na linha do codigo
        
    Assert.assertTrue(getDriver().findElement(By.id("res")).isDisplayed());
    //dica para iniciante:apos digitar o [. ponto] do [Assert], se você quiser o evento exemplo:assert.true, basta digitar [true] que você encurta o caminho, caso [assert.equals] digitar [equals]
    // Dica para iniciante, ao digitar ou usar o evento [ Assert.assertTrue] vai ficar assim de inicio [ Assert.assertTrue(condition); ] vc vai apagar a palavra [condition] e chamar\digitar no lugar o [getwebdriver] dentro que vai ficar assim [Assert.assertTrue(getDriver());] , no penultimo [)));] vc vai colocar um [.]ponto e chamar o evento inspeciona o elemento que vai ficar assim [Assert.assertTrue(getDriver().findElement(By.id(id)));], dentro do [(id)] vc chama o elemento que será mapeado, nesse caso o [ [("res")], e depois para mapea-lo vc aciona apos das duas )).isDisplayed vc chama o evento [isDiplayed]  
    //como mapear a mensagem [has been successfully uploaded.] pq mapear essa msg? para termos certeza que o [Upload] ocorreu com sucesso
    // Mas ao Inspecionar a msg [has been successfully uploaded.] na página de testes podemos perceber que ela encontra-se dentro de uma <H3> H3 este que possui o [id=res], então nesse caso eu preciso ver se esse elemento [res] está aparecendo para nosso WebDriver, como eu faço isso? através do [Assert.true]>depois eu recupero o driver [Webdriver] e buscando o elemento por [by.id "res"] e garantir que ele está sendo exibido com o [.isdiplayed]
    // O [isDisplayed] garante que o elemento\testo na tela, está sendo exibido
    // os comandos [Asserts true], [Assertequals] tem que vim primeiro que a chamada do [Webdriver] conforme linha de comando acima

    Assert.assertTrue(getDriver().findElement(By.id("res")).getText().contains("successfully"));
    // no primeiro [Assert.true] certificamos que o elemento [res]
}

}
