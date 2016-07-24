package Calc.dao;


import javax.sql.DataSource;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import Calc.model.Calculator;


public class CalcDaoImp implements CalcDao{

  DataSource dataSource;
  
  public void createCalc(String inPut, String outPut) {
    JdbcTemplate template = new JdbcTemplate(dataSource);
    template.update("INSERT INTO CALCULOS (INPUT,OUTPUT) VALUES (?,?)",
        new Object[]{inPut,outPut});
  }

  public Calculator selectCalc(int id) {
    JdbcTemplate template = new JdbcTemplate(dataSource);
    List<Calculator> l = template.query("SELECT * FROM CALCULOS WHERE ID=?",
        new Object[] {id},new CalcRowMapper());
    return l.get(0);
  }

  public List<Calculator> getAll(){
    JdbcTemplate template = new JdbcTemplate(dataSource);
    return template.query("SELECT * FROM CALCULOS",new CalcRowMapper());
  }
  
  public void setDataSource(DataSource dataSource){
    this.dataSource = dataSource;
  }

}