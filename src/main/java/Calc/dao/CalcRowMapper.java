package Calc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
 
import Calc.model.Calculator;
 
public class CalcRowMapper implements RowMapper<Calculator> {
 
    public Calculator mapRow(ResultSet resultSet, int arg1) throws SQLException {
        Calculator c = new Calculator();
        c.setId(resultSet.getInt(1));
        c.setInPut(resultSet.getString(2));
        c.setOutPut(resultSet.getString(3));
        return c;
    }
}