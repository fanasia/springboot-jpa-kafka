package com.fanasia.phase2learn;


import com.fanasia.phase2learn.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Phase2LearnApplication implements CommandLineRunner{

	@Autowired
	CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Phase2LearnApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// clear all record if existed before do the tutorial with new data
		repository.deleteAll();
	}
}