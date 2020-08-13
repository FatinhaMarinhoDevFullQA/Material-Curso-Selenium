package br.com.treinaweb.selenium.test;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HelloSeleniumTest extends TreinaWebSeleniumTestBase {
@Test
public void testHelloSelenium( ) {
setUrl("file:///C:/Users/fah/Documents/TreinaWeb/Pagina/teste-selenium.html");	
getDriver().findElement(By.id("txb-nome")).sendKeys("TreinaWeb cursos");
String textoInput = getDriver().findElement(By.id("txb-nome")).getAttribute("value");
Assert.assertEquals(textoInput, "TreinaWeb cursos");

}
}

//HelloSeleniumTest � meio que padr�o no Mercado, as [Classes terminarem com o Sufixo [Test] entre 15:50  16:43 
// Eu quero que essa classe [HelloSeleniumTest] siga todos siga todos os procedimentos que foram determinados na classe  [public abstract class  TreinaWebSeleniumTestBase] para isso vou utilizar o [extends e nome da classe que vc deseja extender] (informar\digitar "extends TreinaWebSeleniumTestBase" na frente da classe), o [extends funciona como HERAN�A]
// No [TestNG, quando tenho um [METODO] que vai fazer o papel de um [TESTE] � necessario colocar a [ANNOTATION @TEST], LEMBRANDO MAIS UMA VEZ PARA N�O UTILIZAR [Test- org unit] PQ n�o estamos UTILIZANDO [JUNIT] ESTAMOS utilizando o TestNG, ent�o temos que selecionar o   [Test- org.testng.annotations]	que vai ficar assim [@Test], depois vc cria um [Medodo void] [public void testHelloSelenium( ) {], depois inicia o desenvolvimentos dos testes. A primeira coisa a fazer � fazer a COM QUE O  [WEBDRIVER NAVEGUE] Na nossa p�gina [file:///C:/Users/fah/Documents/TreinaWeb/Pagina/teste-selenium.html], para que isso ocorra eu posso [INVOCAR O METODO "setUrl(String url") J� CRIADO NA CLASSE " TreinaWebSeleniumTestBase.java] que j� est� em 18:00 entre 18:35 da aula Primeiro contatos com Selenium WebDriver e TestNG: COMO INVOCAR?, BASTA DIGITAR set minusculo e control+espaco, que vai aparecer o met�do e o nome da classe, ai basta selecionar, vai ficar assim [setUrl(url);	] ai dentro e no lugar de url vc vai digitar " " e informar o [ENDEREO DA URL] 18:50
// Toda NAVEGACAO Do site\p�gina tem que ser realizado pelo [Webdriver] por isso vamos usar o [public WebDriver getDriver() {] J� CONFIGURADO na classe [TreinaWebSeleniumTestBase ] ele que expoe o WEBDRIVER para gente, que vai ficar assim [getDriver()] entre 19:20 e 19:39> depois come�amos a chamar os [METODOS DA API DO SELENIUM] exemplo [FINDELEMENT]  [findElement(by),que procura um Elemento na P�gina, perceba que o FindElement procura um objeto por "argumento" BY, ou seja POR:	E essa classe [BY] (quando digitar e espa�o) apresenta v�rios tipos POR = BY exemplo ByName, ByLInk, ById, ByCSSselector, ByLinkText (esse met�dos que o sistema apresenta quando CONTROL+ESPACO, OU digitar (. ponto) sao chamados METODOS EST�TICOS) 19:50 e 20:10, DEPOIS QUE VC SELECIONAR o metodo Estatico ById, vamos ter que enviar um TEXTO para esse m�todo ent�o utilizamos o METODO ESTATICO [sendkeys] que vai ficar assim [sendKeys ("")] 20:0 e 20:42, [sendkeys char sequency...] esse eh o met�do ESTATICO que temos que chamar  [Assert.assertEquals(textoInput, "TreinaWeb cursos");] 23:15
// depois tempo que configurar se o TEXTO\valor digitado no [sendkey] � correspondente ao texto digitado vou realmetne para meu [ value do meu INPUT ], como fazer isso? temos que usar o comando [String], COMO TRATA-SE DENOVO DE UMA NAVEGACAO NA PAGINA, temos que invocar novamente o [GetDriver] da classe [TreinaWebSeleniumTestBase] (String textoInput =getDriver()) 21:15 entre 21:25, pedi NOVAMENTE PARA BUSCAR UM ELEMENTO (pelo by.id) () selecionar o by.id minusculo (findElement(By.id(id))> depois eu vou querer VALUE desse meu txb-name, como consegui?, vamos usar o [GetAtribute (String arg() ] que vai pegar o  [ATRIBUTO] desse meu [Elemento txb-name], esse metodo o [Atribute] espera justamente o NOME DO ATRIBUTO, e nome desse atributo chama se justamente [VALUE]