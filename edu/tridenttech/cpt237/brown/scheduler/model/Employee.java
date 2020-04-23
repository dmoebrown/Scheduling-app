package edu.tridenttech.cpt237.brown.scheduler.model;

public class Employee
{
	private final double MAX_HOURS = 40.0;
	private double minHours;
	private String name;
	private String[] jobCapabilities;
	private String mondayRequest;
	private String tuesdayRequest;
	private String wednesdayRequest;
	private String thursdayRequest;
	private String fridayRequest;
	private String saturdayRequest;
	private String sundayRequest;
	private String dayRequest;


	public Employee(String name, String[] jobCapabilities, double minHours)
	{
		this.name = name;
		this.jobCapabilities = jobCapabilities;
		this.minHours = minHours;

	}
	
	public Employee(String name, String[] jobCapabilities, double minHours, String dayRequest)
	{
		this.name = name;
		this.jobCapabilities = jobCapabilities;
		this.minHours = minHours;
		this.dayRequest = dayRequest;

	}

	public String getDayRequest()
	{
		return dayRequest;
	}

	public String getName()
	{
		return name;
	}

	public double getMinHours()
	{
		return minHours;
	}

	public String[] getJobCapabilities()
	{
		return jobCapabilities;
	}

	public void setScheduleRequest(String[] request)
	{
		mondayRequest = request[0];
		tuesdayRequest = request[1];
		wednesdayRequest = request[2];
		thursdayRequest = request[3];
		fridayRequest = request[4];
		saturdayRequest = request[5];
		sundayRequest = request[6];
	}

	public double getMAX_HOURS()
	{
		return MAX_HOURS;
	}
	
	public String getMondayRequest()
	{
		return mondayRequest;
	}

	public String getTuesdayRequest()
	{
		return tuesdayRequest;
	}

	public String getWednesdayRequest()
	{
		return wednesdayRequest;
	}

	public String getThursdayRequest()
	{
		return thursdayRequest;
	}

	public String getFridayRequest()
	{
		return fridayRequest;
	}

	public String getSaturdayRequest()
	{
		return saturdayRequest;
	}

	public String getSundayRequest()
	{
		return sundayRequest;
	}

	public String getToString()
	{
		// TODO Auto-generated method stub
		return String.format("%-8s", getName());
	}

	public void setMondayRequest(String value)
	{
		mondayRequest = value;
		
	}

}
