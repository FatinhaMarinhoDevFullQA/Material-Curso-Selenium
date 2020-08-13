package br.com.treinaweb.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import com.sun.media.jfxmedia.events.NewFrameEvent;
// dica para iniciantes: atalho CTRL + SHIFT + O , remove os imports n�o utilizados, nessa pag. tem v�rios atalhos utilizados no eclipse https://karanalpe.com.br/tecnologia/teclas-de-atalho-eclipse/

public class CadastroUsuarioTest extends TreinaWebSeleniumTestBase {

//Inicia uma serie de CTs relacionados aquela p�gina do TreinaWeb Cadastro
// Em todas as classes de tests, eu vou ter que trabalhar com o SetURL [etUrl("file:///C:/Users/fah/Documents/TreinaWeb/Pagina/teste-selenium.html");	  ] que est� setada na Classe [TreinaWebSeliniumTestBase], MAS SER� que n�o tem um modo de chamar essa URL sem ter que SETAR o setUrl, toda vez que INICIAR meu CTs no Framewrk TestNG? existem SIM, e o Jeito � informar a [Nota��o\metodo [@BeforeMethod ] . vai constituir um [Metodo] que vai ser invocado ANTES dos demais CTS, que estiverem registrado na Classe [CadastroUsuarioTest] Vou chamar o Metodo[@beforeMethod] de [SetupPage] vai ficar assim, Public SetupPage () 
// entre 03:00 a 03:33 ensina chamar o Metodo[@BeforeMethod e como colocar nome nele atraves do plublic void SetupPag, e em sequecia INVOCAR ele atraves do SetURL que j� encontra na classe PRINCIPAL [TreinaWebSeliniumTestBase	] FEITO essas configura��es � hora de de iniciar meus Testes atrav�s do [@Test annotation] que � padr�o no mercado de trabalho iniciar as classes de testes com @test, � mais para deixar bem claro que ali inicia uma estrutura de Casos de Testes
@BeforeMethod
public void SetupPage() {
setUrl("file:///C:/Users/fah/Documents/TreinaWeb/Pagina/teste-selenium.html");	


}	

//@Test(priority = 2)
@Test
public void VerificarEmailsDiferentesTests() {
getDriver().findElement(By.id("txb-email" )).sendKeys("fatimamarinho@hotmail.com");
getDriver().findElement(By.id("txb-confirmar-email")).sendKeys("fatimamarinho@gmail.com");
getDriver().findElement(By.id("btn-salvar")).click();
AssertJUnit.assertTrue(getDriver().findElement(By.id("div-erro-cadastro-usuario")).isDisplayed());
AssertJUnit.assertTrue(getDriver().findElement(By.id("div-val-email")).isDisplayed());
AssertJUnit.assertEquals(getDriver().findElement(By.id("div-val-email")).getText(), "Os e-mails devem ser iguais");
		
		
//Assert.assertTrue(getDriver().findElement(By.id("div-val-confirmar-senha")).isDisplayed());
// aula [criando testes mais complexos com SeleniumWebDriver e TestNG]As linhas dos getDrive>findElement>sendKeys, representam o [Informar email] que encontra-se na primeira linha, e o [confirmar -emal que encontra-se na segunda LInha~], repare que s�o dois e-mails DIFERENTES, � porque nosso teste � para validar a [Confirmacao da alteracao] do cadastrado quando e-mails DIFERENTES
// 06:00 O getDrive � o driver do Selenium [ representa o carro que direciona os comandos do Selenium WebDriver, ent�o para cada a��o na tela, vc tem q usar o [GetDriver] esse metodo retorna Este m�todo retorna um objeto do tipo Drive, ou seja, Get (retorna\obtem) os dados do SeleniumWebDriver, ou seja, os comandos (verificar mais essa informacao),simplificando, retorna as APIs do selenium
// 06:30 O getDriver().findElement(By.id("btn-salvar")).click();  da aula [criando testes mais complexos com SeleniumWebDriver e TestNG
// 06:46 inicia as [ASSERTS (o comando que dizer, que vc vai verificar algo e comprovar  se EH VERDADE)] nossas ASSERCOES, ou seja, verificar se o que foi digitar na PRIMEIRA E SEGUDA OBTEN��O DE DADOS pelos [getDriver] (email fatimamarinho@gmail) e (fatimamarinho@hotmail.com) est�o corretas, apos clicar no bot�o [SALVAR], OU SEJA, ver se a [div ] de erro [ Verifique os erros abaixo! ] (descrita em vermelho) est� sendo exibida, isso e feita atrav�s do comando [ Assert TRUE] do [TestNG] (07:08 E 07:11) n�o � do [Junit] Lembrem-se que estamos usando as biblioteca do Framework do TestNG, esse comando � para verificar se � VERDADE
// 07:40 comando [isDisplayer Boolean -webElement] (verificar se os elementos est�o presentes na tela, s�o aquelas MENSAGENS na cor vermelha ou outra cores que ficam labeidas na tela para indicar error, fazer esse comando para todos os [diplayer] existentes na tela, no nosso caso � um [ID div]
// depois dos [Asserts] eu preciso garantir tamb�m se os textos em VERMELHOS sao REALMENTE os textos que est�o sendo apresentados na tela da p�gina, atrav�s do comando [AssertEquals] 08:50
//Assert.assertEquals 09:50 ensina como aplicar e verificar se aquelas descri��o [LABEL] na p�ginas s�o iguais, ou seja, � o que realmente � apresentado na tela
// 18:15 repare que os nossos testes sao EXECUTADOS na SEQUENCIA que s�o escritos, mas vc pode organizar-los usando o na frente do @Test o comando [priority = 1] exemplo, ou 2,para organizar a ordem que desejo executar meus CTs
/// video aula [ utilizando seletores baseados em expressoes xPath] inicio da aula, explica como verificar se os nossos  [inputs quando n�o est�o preenchidos] se eles est�o com a [CLASSE is-invalid], essa classe vc consegue enxergar ao inspecionar um campo que fica em [vermelho quando n�o est� preenchido] fica na frente do [id input] N�O � DEVIDAMENTE PREENCHIDO, que um [Input]???, eh um campo que espera algo informado exemplo que est� no  nosso site de teste s�o [Nome completo], [Email], [Confirmar e-mail], [Telefone], enfim s�o os campos que esperam alguma informa��o DENTRO DELES, vc inspeciona e  fica assim [ class='form-control is invalid] 
}
//@Test(priority = 1)
@Test

public void NomeNaoPreenchidoTest () {
getDriver().findElement(By.id("txb-nome")).sendKeys("");
getDriver().findElement(By.id("btn-salvar")).click();
AssertJUnit.assertTrue(getDriver().findElement(By.id("div-erro-cadastro-usuario")).isDisplayed());
AssertJUnit.assertTrue(getDriver().findElement(By.id("div-val-nome")).isDisplayed());
AssertJUnit.assertTrue(getDriver().findElement(By.id("txb-nome")).getAttribute("class").contains("is-invalid"));
// est� entre 1min at� 03:10 aula [utilizando seletores baseados em expressoes xPATH) Metodo para testar\verificar quando os [INPUTS] aquelas caixas de textos n�o preenchidos, na cor vermelha [Assert.assertTrue(condition) dentro da chaves onde esta a palavra (condition) colocar "" e chama meu Driver "getDriver()", tem que digitar, depois procurar o elemento atrave�s do .findElement(By), vai ficar assim : getDriver().findELement(by.id(String id)("txt-nome").daqui em diante eh um comando para recuperar um determinado ATRIBUTO, q vamos chamar o comando getAttribute(arg0); E qual atributo que eu quero recuperar? eh o atributo CLASS (fica no inspecionar campo), dentro desse comando, colocar "" no lugar da palavra arg0 e digitar "class" deve ficar assim,  getAttribute("class"))), e se no MEIO dessa "class" que acabamos de inspecionar tiver CONTAINS o texto "is-invalid", isso que dizer que aquele meu atributo contem CONTAINS a classe "is-invalid", lembrando que a gente pode usar esses comandos para verificar QUALQUER TIPO DE ELEMENTO DENTRO DE UMA CLASSE (PATH), Resumidamento quando o texto(CAIXA DE TEXTO NOME COMPLETO ou outra  ) N�O s�o PREENCHIDas ELas FICAm COM A class is-invalid 

// ATE QUI USAMOS OS METODOS PARA VERIFICAR SE ALGO DEU ERRO, OU SEJA, O N�O PREENCHIMENTO EXEMPLO (caixa de texto NOME COMPLETO), PREENCHIMENTO,E preenchimento de emails errados (eerro  
//est� entre 1min at� 03:10 ate 14:00 aula [utilizando seletores baseados em expressoes xPATH) DAQUI PARA BAIXO VAMOS FAZER UM TESTE POSITIVOS, atrav�s da nossa nova classe de teste [ verificarUsuarioPreenhidoTest], nessa classe vamos fazer a automacao do cadastro inteiro, ou seja, um test positivo, esse novo test inicia com @test (priority = 3)
// Basicamente o que eu preciso saber, quando fa�o um testes POSITIVO, se tem a mensagem exemplo "Incluido com sucesso" e quando se tratar de formul�rio se TEMOS ALGUMA LINHA PREENCHIDA, seja na tabela ou na PROPRIA TELA


}

//@Test(priority =3)
@Test
public void VerificarUsuarioPreenchidoTest () {
	getDriver().findElement(By.id("txb-nome")).sendKeys("fatima marinho");
	getDriver().findElement(By.id("txb-email")).sendKeys("fatimamarinho@hotmail.com");
	getDriver().findElement(By.id("txb-confirmar-email")).sendKeys("fatimamarinho@hotmail.com");
	getDriver().findElement(By.id("txb-senha")).sendKeys("1234");
	getDriver().findElement(By.id("txb-confirmar-senha")).sendKeys("1234");
	WebElement element = getDriver().findElement(By.id("rad-sexo-feminino"));
	Actions actions = new Actions(getDriver());
	actions.moveToElement(element).click().perform();
	new Select(getDriver().findElement(By.id("sel-estado"))).selectByValue("SP"); // est� em 10:15 da video aula ]Util.Seletores Baseados em XPATH)
    getDriver().findElement(By.id("btn-salvar")).click();
    Assert.assertTrue(getDriver().findElement(By.id("div-sucesso-cadastro-usuario")).isDisplayed());
    Assert.assertEquals(getDriver().findElement(By.xpath("//table[@id='tbl-usuarios']/tbody/tr[1]/td[1]")).getText(), "fatima marinho");

// a explicacao do comando SELECT est� na aula 	[utilizando seletores baseados em expressoes xPATH) 08:01 q inicia, eu preciso intepretar a selecao de um elemento quando [SP, RJ, MG ..] como SELECT mesmo, para isso, antes do getDriver colocamos\chamamos o comando New Select(getDriver) e o restante do c�digo, para que eu consiga DE FATO ir na pagina e selecionar a REGIAO de fato, nesse nosso caso, queremos o SP
//aula 	[utilizando seletores baseados em expressoes xPATH)  10:30 at� 11:58 ensina o assertrue do [div-sucesso-cadastro-usuario], APOS ENSINAR a usar o comando ]new Select] E [inspicionar o bot�o SALVAR atrav�s do Clik],  EH  hora de fazermos nossas ASSERCOES, atrav�s do ASSERTS, o que seria essas asser��es, s�o aqueles Labels no alto da tela, "Inclus�o realizada com sucesso" exemplo
// USANDO EXPRESSAO XPATH (ensina verificar o que realmente foi gravado na TABELA) : est� aula [utilizando seletores baseados em expressoes xPATH)  11:50 ensina verificar se o CADASTRO COM MEUS DADOS foi gravado corretamente na tabela, OU SEJA, ele verifica se NA PRIMEIRA LINHA DA PRIMEIRA CELULA DA MINHA TABELA, REALMENTE TEM OS DADOS DO CADASTRO REALIZADO COM SUCESSO, OU SEJA, SE OS DADOS GRAVADOS NA TABELA COENCIDEM COM OS DADOS IMPUTADOS E SELECINADOS ANTERIORMENTE, 
// EM 12:50 ENSINA TAMB�M COM USAR O XPATH, COMO USAR O // E QUANDO E O PORQUE
}
}
