package Calc.application;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Calc.model.Calculator;
import Calc.dao.CalcDaoImp;


@RestController
public class CalculatorController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/calculator")
    public Calculator calculator(@RequestParam(value="input", defaultValue="0") String input) {
        return new Calculator(input);
    }
     @RequestMapping("/calcSave")
    public Calculator calcSave(@RequestParam(value="input", defaultValue="0") String input) {
        Calculator c = new Calculator(input);
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/config/beanLocations.xml");
        CalcDaoImp calcdao = (CalcDaoImp) context.getBean("calcDao"); 
        calcdao.createCalc(c.getInPut(),c.getOutPut());
        return c;
    } 
    @RequestMapping("/open")
    public Calculator open(@RequestParam("id") int id) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/config/beanLocations.xml");
        CalcDaoImp calcdao = (CalcDaoImp) context.getBean("calcDao"); 
        return calcdao.selectCalc(id);
    }
}
