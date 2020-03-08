package com.sk.qna;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.sk.qna.service.QuestionAnswerServiceImpl;



@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"services.defaultRepository","com.sk.qna.dataaccessobject"})
@EntityScan("com.sk.qna.*")
public class QnAApplication {

  public static void main(String[] args) {
    SpringApplication.run(QnAApplication.class, args);
  }
  
 
}

