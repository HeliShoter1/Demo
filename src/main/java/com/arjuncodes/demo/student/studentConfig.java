package com.arjuncodes.demo.student;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class studentConfig {
    @Bean
    CommandLineRunner commandLineRunner(studentRepository StR){
        return args->{
            student marian  = new student("HeliShoter","Caophuc1909@gmail.com",LocalDate.of(2003,9,19));
            student marian1  = new student("HeliShoter1","Caophuc1909@gmail.com",LocalDate.of(2003,9,19));
            StR.saveAll(List.of(marian,marian1));
        };
    }
}
