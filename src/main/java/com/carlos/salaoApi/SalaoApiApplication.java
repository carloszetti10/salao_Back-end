package com.carlos.salaoApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // Ativa o agendamento de tarefas
public class SalaoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalaoApiApplication.class, args);
	}

}
