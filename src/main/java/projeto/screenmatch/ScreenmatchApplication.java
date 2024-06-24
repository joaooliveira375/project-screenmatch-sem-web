package projeto.screenmatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import projeto.screenmatch.model.DadosSerie;
import projeto.screenmatch.service.ConsumoApi;
import projeto.screenmatch.service.ConverteDados;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner
{

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		var json =  consumoApi.obterDados("https://www.omdbapi.com/?t=Suits&apikey=41f9bcfe");
		System.out.println(json);
		ConverteDados conversor  = new ConverteDados();
		DadosSerie dados  = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
	}
}
