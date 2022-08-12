package pl.kosmala.tfi;

import org.jsoup.nodes.Document;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TfiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TfiApplication.class, args);

	}
	@Bean
	CommandLineRunner commandLineRunner()
	{
		/*TODO:
		*  sciaganie glownych stron z olx i otodom
		*  sciaganie podstron
		*  szukanie */
		return args ->
		{
			IHtmlProvider iHtmlProvider = new JsoupHtmlProvider();

			Document document = iHtmlProvider.provideHtmlFromPage("https://www.olx.pl/d/nieruchomosci/mieszkania/mazowieckie/");
			IParser iParser = new OlxParser();

			System.out.println(iParser.extractOffertsUrlsFromDocument(document));
			System.out.println(iParser.extractNumOfPages(document));

		};
	}
}
