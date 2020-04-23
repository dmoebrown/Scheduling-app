/**
 * Builds columns and fetches data
 * @author Dustin Brown
 */
package edu.tridenttech.cpt237.brown.scheduler.view;

import edu.tridenttech.cpt237.brown.scheduler.model.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class ScheduleHelper
{

public static TableColumn<Employee, String> getNameColumn()
{
	TableColumn<Employee, String> nameCol = new TableColumn<>("Name");
	PropertyValueFactory<Employee, String> nameCellValueFactory = new PropertyValueFactory<>("name");
	nameCol.setCellValueFactory(nameCellValueFactory);
	return nameCol;
	
}

public static TableColumn<Employee, String> getMondayColumn()
{
	TableColumn<Employee, String> mondayCol = new TableColumn<>("Monday");
	PropertyValueFactory<Employee, String> mondayCellValueFactory = new PropertyValueFactory<>("mondayRequest");
	mondayCol.setCellValueFactory(mondayCellValueFactory);
	return mondayCol;
	
}

public static TableColumn<Employee, String> getTuesdayColumn()
{
	TableColumn<Employee, String> tuesdayCol = new TableColumn<>("Tuesday");
	PropertyValueFactory<Employee, String> tuesdayCellValueFactory = new PropertyValueFactory<>("tuesdayRequest");
	tuesdayCol.setCellValueFactory(tuesdayCellValueFactory);
	return tuesdayCol;
	
}

public static TableColumn<Employee, String> getWednesdayColumn()
{
	TableColumn<Employee, String> wedCol = new TableColumn<>("Wednesday");
	PropertyValueFactory<Employee, String> wednesdayCellValueFactory = new PropertyValueFactory<>("wednesdayRequest");
	wedCol.setCellValueFactory(wednesdayCellValueFactory);
	return wedCol;
	
}

public static TableColumn<Employee, String> getThursdayColumn()
{
	TableColumn<Employee, String> thursCol = new TableColumn<>("Thursday");
	PropertyValueFactory<Employee, String> thursdayCellValueFactory = new PropertyValueFactory<>("thursdayRequest");
	thursCol.setCellValueFactory(thursdayCellValueFactory);
	return thursCol;
	
}

public static TableColumn<Employee, String> getFridayColumn()
{
	TableColumn<Employee, String> friCol = new TableColumn<>("Friday");
	PropertyValueFactory<Employee, String> fridayCellValueFactory = new PropertyValueFactory<>("fridayRequest");
	friCol.setCellValueFactory(fridayCellValueFactory);
	return friCol;
	
}

public static TableColumn<Employee, String> getSaturdayColumn()
{
	TableColumn<Employee, String> satCol = new TableColumn<>("Saturday");
	PropertyValueFactory<Employee, String> saturdayCellValueFactory = new PropertyValueFactory<>("saturdayRequest");
	satCol.setCellValueFactory(saturdayCellValueFactory);
	return satCol;
	
}

public static TableColumn<Employee, String> getSundayColumn()
{
	TableColumn<Employee, String> sunCol = new TableColumn<>("Sunday");
	PropertyValueFactory<Employee, String> idCellValueFactory = new PropertyValueFactory<>("sundayRequest");
	sunCol.setCellValueFactory(idCellValueFactory);
	return sunCol;
	
}

}
