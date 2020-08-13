package br.com.treinaweb.selenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

// A explica��o do pq tornei essa classe abstrata est� na aula [Primeiro contatos com Selenium WebDriver e TestNG entre os minutos 14:00 e 15:00]: resumidamente a classe foi tornada abstract para que a mesma n�o seja por engano [INSTANCIADA DIRETAMENTE] por algun desenvolvedor, OU SEJA, criar uma instancia de  [ MANEIRA DIRETA], sen�o quebra toda proten��o quando deixamos um [Driver] de modo [Privado], e asim tamb�m n�o violar os nossos [Met�dos e Setups], [@Before] e [@AfterClass @AfterTest
public abstract class  TreinaWebSeleniumTestBase {
	private WebDriver driver;
	
	public WebDriver getDriver() {
		return this.driver;
	}
// Metodo void [ ] que seta\receber uma string que �  o site/pagina onde meus Testes ser�o realizados 
// esse get direciona o selenium para uma p�gina, ou seja, faz a navegacao para uma p�gina, vai para URL que foi passada como [Par�mentro]			
	public void setUrl(String url) {
		this.driver.get(url);
}
//usar o BeforeClasseTestnganotation
//O @before garanti que antes de todos os testes serem realizados, eu preciso que objeto [private WebDriver driver] que est� acima seja inicializado corretamente al�m disso depois que os testes forem realizados eu preciso desconectar [@after]
// o Metodo [ public void setup()  vai ser invocado toda vez que uma [Classe] com uma suite de teste for invocada pelo testng
// O firefox precisa do driver [ gecko  ] para ser inicializado corretamente utilizamos a classe do Sistema chamada [System] e para setar vamos usar o [SetProprety(key, string value);String System] � um [Metodo Statico] que serve para setar configura��es dentro do ambiente da nossa configura��o
// onde est� [Key] vc vai digitar "" e informar entre "webdriver.gecko.driver": isso � uma configu��o ESPECIFICA do [Driver do Firefox] [WebDriver do Firefox	], lembrando que cada [Webdriver de cada Browser EX. IE,Chrome] tem  as suas configuracao especifica
// onde [Value] : Eh onde vc ir� indicar o caminho que seu o seu driver [ gecko] est�. No lugar de [Value] vc vai digitar "" apas e dentro das "" vc vai informar o caminho que encontrada o driver do [gecko]. Se tiver usando o Windows no final vc informa [ .exe ] como no nosso exemplo abaixo
// Depois que vc setou ou seja indicou o caminho do seu [Gecko driver], � hora de [Inicializar ] o [private WebDriver driver] atrav�s do [this.driver:webDriver-TreinaWebSeleniumTestBase] e na frente inicillizar com [New] e selecionar o [FirefoxDriver()- org.openqa.selenium.firefoxDriver], o Firefox ser� inicializado [New], n�o esque�a do [;] no final do comando da inicializa��o. Se um dia eu quiser trocar de Browser, basta eu informar o [Endere�o] do novo Driver (IE, Chrome) informa uma nova inicializacao EX.[New CrhomeDriver.exe] o restante do campos ACIMA exemplo DO [private WebDriver driver;] N�O precisa alterar, pq todos eles [Implementam a interface WEBDRIVER] ou seja, serve para os demais BROWSERS
// This.driver. : configura��o que � feita no [Driver "Gecko" para [Esperar\Aguarda] ANTES de d� um erro. Exemplo, ao tentar localizar algum [Elemento] na p�gina atrav�s do [Testng]nas nossas p�ginas por [ID] por exemplo, mas se eu errar? a localiza��o por um [Determinado ID], O [Selenium] e o [Testng] n�o possui mecanismos para LIDAR com essa situacao, e com certeza poder� gerar uma [EXCESS�O], essa situacao pode ocosionar alguns problemas pq �s vezes o [Elemento] n�o foi [Localizado] na P�gina, pq poder est� ainda[ Processamento] pelo Browser ou sendo [Renderizado], essa configura��o serve para quando ele cair nesse cen�rio de erro, n�o � para apresentar o erro de uma vez, � para [ESPERAR\AGUARDAR] um determinado intervalo de TEMPO, para ver se realmente aquele [SELECTOR], aquela SITUACAO onde estamos tentando desenvolver dentro dos nossos testes Unit�rios se � de fato um [ERRO], PASSOU se o tempo, se aquele [ELEMENTO] realmente n�o foi [Localizado] ai sim o [Selenium e o WebDriver] devem LAN�AR uma [EXCESS�O]
// OS METODOS para [Aguardar antes de realizar a EXCESSAO] EST� entre 11:50 e 11:56 da video aula rimeiro contatos com Selenium WebDriver e TestNG
// o metodo [Implicity Wait] ASSUME o [WebDrive] que quando encontrar uma situacao de erro, ele vai sempre [Aguardar] o [tempo] que est� espeficicado dentro dos [Argumentos] do Metodo [.implicitlyWait(time, unit)], para certificar que realmente trata se de uma [EXECESS�O] [PRIMEIRO ARGUMENTO QUE � O "|TIME| vou informar [ 5 segundos] e [Segundo Argumeneto que eh um UNITnit  que vem da API de CONCORRENCIA do JAVA) vou pedir em SEGUNDOS (Esta em 12:30 at� 13:33)
// da Mesma maneira que preciso [Inicializar e aguardar] � preciso tamb�m configurar para que o WebDriver se [DESCONECTE] da Instancia do Firefox, ou seja, � necess�rio um [Met�do] que ser� invocado [DEPOIS] que todos os [Casos de testes] de uma [Determinada Classe] sejam devidamente Executado, da mesma maneira que tenho o [@before classe] eu tenho a ANOTACAO [@after class - org testNG annotations] 14:00
//o IF eh uma verificacao se this.driver � diferente de Nulo 14:20 [this.driver !#Null ] 14:20 at� 14:31 , os met�dos [this.close e this null] est� 14:20 e 14:35: Esses metodos [Fecham a conex�o dos Drivers que iremos usar para fazer os testes]
// ate o metodo [ this.driver.close();	] contem as intru��es [Metodos] que fecham a conex�o do WebDriver com o browser que iremos fazer os testes

@BeforeClass
public void setup() {
 System.setProperty("webdriver.gecko.driver", "C:/Users/fah/Selenium/geckodriver.exe");  	
 this.driver = new FirefoxDriver();
 this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

}

@AfterClass 
public  void afterTests() {
if (this.driver != null)	{
   this.driver.close();	
	
}
	
	
}

}


