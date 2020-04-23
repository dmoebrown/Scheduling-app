package edu.tridenttech.cpt237.brown.scheduler.model;

import java.util.ArrayList;

public class WorkDay
{
	private String day;
	private ArrayList<Employee> empList;
	
	public WorkDay(ArrayList<Employee> empList)
	{
		this.empList = empList;
	}
	
	@Override
	public String toString()
	{
		
		return String.format("%-15s%n", getEmpList());
	}

	public String getDay()
	{
		return day;
	}

	public void setDay(String day)
	{
		this.day = day;
	}

	public ArrayList<Employee> getEmpList()
	{
		return empList;
	}



}
