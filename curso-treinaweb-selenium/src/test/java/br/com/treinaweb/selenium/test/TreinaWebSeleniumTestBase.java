package br.com.treinaweb.selenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

// A explicação do pq tornei essa classe abstrata está na aula [Primeiro contatos com Selenium WebDriver e TestNG entre os minutos 14:00 e 15:00]: resumidamente a classe foi tornada abstract para que a mesma não seja por engano [INSTANCIADA DIRETAMENTE] por algun desenvolvedor, OU SEJA, criar uma instancia de  [ MANEIRA DIRETA], senão quebra toda protenção quando deixamos um [Driver] de modo [Privado], e asim também não violar os nossos [Metódos e Setups], [@Before] e [@AfterClass @AfterTest
public abstract class  TreinaWebSeleniumTestBase {
	private WebDriver driver;
	
	public WebDriver getDriver() {
		return this.driver;
	}
// Metodo void [ ] que seta\receber uma string que é  o site/pagina onde meus Testes serão realizados 
// esse get direciona o selenium para uma página, ou seja, faz a navegacao para uma página, vai para URL que foi passada como [Parâmentro]			
	public void setUrl(String url) {
		this.driver.get(url);
}
//usar o BeforeClasseTestnganotation
//O @before garanti que antes de todos os testes serem realizados, eu preciso que objeto [private WebDriver driver] que está acima seja inicializado corretamente além disso depois que os testes forem realizados eu preciso desconectar [@after]
// o Metodo [ public void setup()  vai ser invocado toda vez que uma [Classe] com uma suite de teste for invocada pelo testng
// O firefox precisa do driver [ gecko  ] para ser inicializado corretamente utilizamos a classe do Sistema chamada [System] e para setar vamos usar o [SetProprety(key, string value);String System] é um [Metodo Statico] que serve para setar configurações dentro do ambiente da nossa configuração
// onde está [Key] vc vai digitar "" e informar entre "webdriver.gecko.driver": isso é uma configução ESPECIFICA do [Driver do Firefox] [WebDriver do Firefox	], lembrando que cada [Webdriver de cada Browser EX. IE,Chrome] tem  as suas configuracao especifica
// onde [Value] : Eh onde vc irá indicar o caminho que seu o seu driver [ gecko] está. No lugar de [Value] vc vai digitar "" apas e dentro das "" vc vai informar o caminho que encontrada o driver do [gecko]. Se tiver usando o Windows no final vc informa [ .exe ] como no nosso exemplo abaixo
// Depois que vc setou ou seja indicou o caminho do seu [Gecko driver], é hora de [Inicializar ] o [private WebDriver driver] através do [this.driver:webDriver-TreinaWebSeleniumTestBase] e na frente inicillizar com [New] e selecionar o [FirefoxDriver()- org.openqa.selenium.firefoxDriver], o Firefox será inicializado [New], não esqueça do [;] no final do comando da inicialização. Se um dia eu quiser trocar de Browser, basta eu informar o [Endereço] do novo Driver (IE, Chrome) informa uma nova inicializacao EX.[New CrhomeDriver.exe] o restante do campos ACIMA exemplo DO [private WebDriver driver;] NÃO precisa alterar, pq todos eles [Implementam a interface WEBDRIVER] ou seja, serve para os demais BROWSERS
// This.driver. : configuração que é feita no [Driver "Gecko" para [Esperar\Aguarda] ANTES de dá um erro. Exemplo, ao tentar localizar algum [Elemento] na página através do [Testng]nas nossas páginas por [ID] por exemplo, mas se eu errar? a localização por um [Determinado ID], O [Selenium] e o [Testng] não possui mecanismos para LIDAR com essa situacao, e com certeza poderá gerar uma [EXCESSÃO], essa situacao pode ocosionar alguns problemas pq ás vezes o [Elemento] não foi [Localizado] na Página, pq poder está ainda[ Processamento] pelo Browser ou sendo [Renderizado], essa configuração serve para quando ele cair nesse cenário de erro, não é para apresentar o erro de uma vez, é para [ESPERAR\AGUARDAR] um determinado intervalo de TEMPO, para ver se realmente aquele [SELECTOR], aquela SITUACAO onde estamos tentando desenvolver dentro dos nossos testes Unitários se é de fato um [ERRO], PASSOU se o tempo, se aquele [ELEMENTO] realmente não foi [Localizado] ai sim o [Selenium e o WebDriver] devem LANÇAR uma [EXCESSÃO]
// OS METODOS para [Aguardar antes de realizar a EXCESSAO] ESTÁ entre 11:50 e 11:56 da video aula rimeiro contatos com Selenium WebDriver e TestNG
// o metodo [Implicity Wait] ASSUME o [WebDrive] que quando encontrar uma situacao de erro, ele vai sempre [Aguardar] o [tempo] que está espeficicado dentro dos [Argumentos] do Metodo [.implicitlyWait(time, unit)], para certificar que realmente trata se de uma [EXECESSÃO] [PRIMEIRO ARGUMENTO QUE É O "|TIME| vou informar [ 5 segundos] e [Segundo Argumeneto que eh um UNITnit  que vem da API de CONCORRENCIA do JAVA) vou pedir em SEGUNDOS (Esta em 12:30 até 13:33)
// da Mesma maneira que preciso [Inicializar e aguardar] é preciso também configurar para que o WebDriver se [DESCONECTE] da Instancia do Firefox, ou seja, é necessário um [Metódo] que será invocado [DEPOIS] que todos os [Casos de testes] de uma [Determinada Classe] sejam devidamente Executado, da mesma maneira que tenho o [@before classe] eu tenho a ANOTACAO [@after class - org testNG annotations] 14:00
//o IF eh uma verificacao se this.driver é diferente de Nulo 14:20 [this.driver !#Null ] 14:20 até 14:31 , os metódos [this.close e this null] está 14:20 e 14:35: Esses metodos [Fecham a conexão dos Drivers que iremos usar para fazer os testes]
// ate o metodo [ this.driver.close();	] contem as intruções [Metodos] que fecham a conexão do WebDriver com o browser que iremos fazer os testes

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


