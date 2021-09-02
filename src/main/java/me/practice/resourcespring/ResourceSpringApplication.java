package me.practice.resourcespring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.context.support.ServletContextResource;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@SpringBootApplication
public class ResourceSpringApplication implements CommandLineRunner {

    private final ResourceLoader resourceLoader;

    public ResourceSpringApplication(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public static void main(String[] args) {
        SpringApplication.run(ResourceSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Resource resource = resourceLoader.getResource("classpath:home.txt");
        System.out.println(resource.getFile());
        BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));

        reader.lines()
                .forEach(System.out::print);


    }
}
