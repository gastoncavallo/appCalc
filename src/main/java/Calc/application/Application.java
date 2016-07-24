package Calc.application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Calc.dao.CalcDaoImp;


@SpringBootApplication
public class Application { 

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
 