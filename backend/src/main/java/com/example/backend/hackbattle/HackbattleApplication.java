package com.example.backend.hackbattle;

import com.example.backend.hackbattle.models.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HackbattleApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackbattleApplication.class, args);
	}

}
