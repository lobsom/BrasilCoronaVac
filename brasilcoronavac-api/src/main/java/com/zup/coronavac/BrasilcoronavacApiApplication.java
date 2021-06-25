package com.zup.coronavac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * {@link }
 * BrasilcoronavacApiApplication.java que é responsável por inicializar e lançar a aplicação.</br>
 * Por padrão, essa classe executa as seguintes etapas: 
 * <ol>
 * <li>	cria uma instância apropriada do ApplicationContext;</li> 
 * <li>	registra um CommandLinePropertySource para expor os argumentos da linha de comando como propriedades do Spring;</li> 
 * <li>	atualiza o contexto do aplicativo, carregando todos os beams singleton;</li>
 * <li>	aciona qualquer bean CommandLineRunner.</li>
 * </ol>
 * 
 * @author Marcelo Gomes
 *
 */
@SpringBootApplication
public class BrasilcoronavacApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrasilcoronavacApiApplication.class, args);
	}

}
