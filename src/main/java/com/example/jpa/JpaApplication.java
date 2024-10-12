package com.example.jpa;

import com.example.jpa.model.Author;
import com.example.jpa.model.Video;
import com.example.jpa.repository.AuthorRepository;
import com.example.jpa.repository.VideoRepository;
import com.example.jpa.specification.AuthorSpecification;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AuthorRepository authorRepository, VideoRepository videoRepository) {
		return args -> {
//			var author = Author.builder().firstName("sai").lastName("dhanukonda").age(50).email("sai.dhanukonda@gmail.com").build();
//			authorRepository.save(author);

//			var video = Video.builder().name("video-1").length(10).build();
//			videoRepository.save(video);

			Specification<Author> spec = Specification.where(AuthorSpecification.hasAge(34))
					.and(AuthorSpecification.firstNameContains("li"));

			authorRepository.findAll(spec).forEach(System.out::println);

			Specification<Author> spec1 = Specification.where(AuthorSpecification.hasAge(34))
					.or(AuthorSpecification.firstNameContains("li"));

			authorRepository.findAll(spec1).forEach(System.out::println);
		};
	}

}
