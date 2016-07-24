package Calc.dao;

import java.util.List;

import Calc.model.Calculator;


public abstract interface CalcDao {

  public abstract void createCalc(String inPut, String outPut);
  public abstract Calculator selectCalc(int id);
}