package br.org.rfdouro.prjJPA01;

import br.org.rfdouro.prjJPA01.modelo.Pessoa;
import br.org.rfdouro.prjJPA01.persistencia.PessoaRepositorio;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication(scanBasePackages = {"br.org.rfdouro.prjJPA01"})
public class PrjJpa01Application {

 private static final Logger log = LoggerFactory.getLogger(PrjJpa01Application.class);

 @Autowired
 DataSource dataSource;

 @Autowired
 PessoaRepositorio repositorio;

 //https://spring.io/guides/gs/accessing-data-jpa/
 //http://www.springboottutorial.com/spring-boot-and-h2-in-memory-database
 public static void main(String[] args) {
  SpringApplication.run(PrjJpa01Application.class, args);
 }
 
}
