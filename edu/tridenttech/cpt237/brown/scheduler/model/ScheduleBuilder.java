/**
 * Builds schedule, loads employee file
 * @author Dustin Brown
 */
package edu.tridenttech.cpt237.brown.scheduler.model;

import java.util.List;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ScheduleBuilder
{

	private ArrayList<WorkDay> dayShifts = new ArrayList<>();
	private ArrayList<WorkDay> nightShifts = new ArrayList<>();
	public static final String[] DAYS = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday",
			"Sunday" };
	private static ObservableList<Employee> empView;

	public void loadEmployees(String fileName)
	{
		String localName;
		String[] localJobList;
		String localMinHours;
		empView = FXCollections.observableArrayList();

		try
		{
			Scanner infile = new Scanner(new FileInputStream(fileName));

			while (infile.hasNext() == true)
			{
				String line = infile.nextLine();
				String[] fields = line.split("[:]");
				String[] jobField = fields[1].split("[,]");

				localName = fields[0];

				localJobList = jobField;
				localMinHours = fields[2];

				Employee e = new Employee(localName, localJobList, Double.parseDouble(localMinHours));
				empView.add(e);
			}

			infile.close();

		}
		catch (IOException ex)
		{
			System.err.println(ex.getMessage());
		}
	}

	/**
	 * I honestly don't know why this is static, but the table kept giving me a
	 * nullpointer exception when it wasn't
	 * 
	 * @return List of employee roster
	 */
	public static ObservableList<Employee> getEmployeeList()
	{

		return empView;
	}

	public void createSchedReq(Employee e, String[] request)
	{
		List<String> avail = new ArrayList<String>();
		Collections.addAll(avail, request);

		e.setScheduleRequest(request);
	}

	public WorkDay buildWorkday(ArrayList<Employee> empList)
	{
		ArrayList<Employee> localList = new ArrayList<>();
		Employee newE = new Employee(empList.get(0).getName(), empList.get(0).getJobCapabilities(), empList.get(0).getMinHours(), empList.get(0).getMondayRequest());
		localList.add(newE);
		WorkDay monday = new WorkDay(localList);
		return monday;
	}
	
	public ArrayList<WorkDay> getDayShifts()
	{
		return dayShifts;
	}

	public ArrayList<WorkDay> getNightShifts()
	{
		return nightShifts;
	}
	
	public static void main(String[] args)
	{
		ScheduleBuilder s = new ScheduleBuilder();
		s.loadEmployees("employeeRoster.txt");
		ArrayList<Employee> empList = new ArrayList<>();
		empList.addAll(ScheduleBuilder.getEmployeeList());
		s.buildWorkday(empList); 
		for (Employee e : empList)
		{
			System.out.println(e);
		}
		
		
	}

}
