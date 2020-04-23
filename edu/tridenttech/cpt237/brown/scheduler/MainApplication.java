/**
 * Starts ui
 * 
 * Contains main that talks to user before displaying schedule
 * @author Dustin Brown
 */
package edu.tridenttech.cpt237.brown.scheduler;

import java.util.Scanner;
import edu.tridenttech.cpt237.brown.scheduler.model.Employee;
import edu.tridenttech.cpt237.brown.scheduler.model.ScheduleBuilder;
import edu.tridenttech.cpt237.brown.scheduler.view.Schedule;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class MainApplication extends Application
{
	
	private static final String DISPLAY_MAIN_MENU =
			"What would you like to do?\n" +
			"A) View Employee Roster\n" +
			"B) Add Employee Schedule Request\n" +
			"C) Load Schedule\n" +
			"Q) Quit\n";
	private static final String VALID_MAIN_RESPONSES = "ABCQ";
	private static final int MAX_DAYS = 7;

	@Override
	public void start(Stage primaryStage) throws Exception
	{

		Schedule window = new Schedule(primaryStage);
		window.show();

	}
	
	public static void main(String[] args)
	{
		
		ScheduleBuilder s = new ScheduleBuilder();
		s.loadEmployees("employeeRoster.txt");
		
		char menuSelection;
		String[] avail;
		Employee e;
		Scanner input = new Scanner(System.in);
		menuSelection = validateSelection(DISPLAY_MAIN_MENU, VALID_MAIN_RESPONSES, input);

		while (menuSelection != 'Q')
		{
			switch (menuSelection) {
				case 'A': {
					printRoster(ScheduleBuilder.getEmployeeList());
				} break;
				case 'B': {
					e = getEmployee(input);
					if (e != null) {
						avail = addScheduleRequest(input);
						s.createSchedReq(e, avail);
					} else {
						System.out.println("No employee found by name entered\n");
					}
					
				} break;
				case 'C': {
					Application.launch(args);
					return;
				} 

				default: {
					System.err.println("ERR");
				} break;
			}
			menuSelection = validateSelection(DISPLAY_MAIN_MENU, VALID_MAIN_RESPONSES, input );
		}
		input.close();
			
	}
		
	private static char validateSelection(String menu, String validResponses, Scanner input) {
		char selection = Character.toUpperCase(getMenuSelection(menu, input));
		while (validResponses.indexOf(selection) < 0) {
			System.out.println("Invalid Selection");
			selection = Character.toUpperCase(getMenuSelection(menu, input));
		}
		return selection;
	}
	
	private static char getMenuSelection(String menu, Scanner input) {
		System.out.println(menu);
		return input.nextLine().charAt(0);
	}
	
	private static void printRoster(ObservableList<Employee> empView)
	{
		System.out.println("Employee List:");
		for(Employee e : empView) 
		{
			System.out.println(e.getName());
		}
		System.out.println("");
	}
	
	private static String[] addScheduleRequest(Scanner input)
	{
		String[] avail = new String[MAX_DAYS];
		for(int i = 0; i < MAX_DAYS; i++)
		{
			System.out.println(ScheduleBuilder.DAYS[i] + ": ");
			avail[i] = input.nextLine();
		}
		return avail;
	}
	
	private static Employee getEmployee(Scanner input)
	{
		Employee e;
		System.out.print("Enter an employee to add a schedule request: ");
		String name = input.nextLine();
		e = findEmpByName(name);
		
		return e;
	}
	
	private static Employee findEmpByName(String idStr)
	{

		String findStr = idStr.toUpperCase();
		int localIndex = 0;
		int localCount = ScheduleBuilder.getEmployeeList().size();
		Employee found = null;
		Employee localRental;

		while (localIndex < localCount)
		{
			localRental = ScheduleBuilder.getEmployeeList().get(localIndex);
			if (localRental.getName().toUpperCase().equals(findStr))
			{
				found = ScheduleBuilder.getEmployeeList().get(localIndex);
				localIndex = localCount;
			}
			else
			{
				localIndex++;
			}
		}
		return found;
	}

}
