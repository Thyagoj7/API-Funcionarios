package br.com.thyagojose.sistemadegerenciamentodefuncionarios;

import br.com.thyagojose.sistemadegerenciamentodefuncionarios.controllers.FuncionarioController;
import br.com.thyagojose.sistemadegerenciamentodefuncionarios.repository.FuncionarioRepository;
import br.com.thyagojose.sistemadegerenciamentodefuncionarios.services.FuncionarioService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories
@SpringBootApplication
@ComponentScan//(basePackages ={"br.com.sistemadegerenciamentodefuncionarios.controllers"})
//@EntityScan( basePackages = {"br.com.sistemadegerenciamentodefuncionarios.entities"} )
public class SistemaDeGerenciamentoDeFuncionariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaDeGerenciamentoDeFuncionariosApplication.class, args);
	}

}
