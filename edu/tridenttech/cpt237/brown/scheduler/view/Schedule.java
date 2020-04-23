/**
 * Shows table
 * @author Dustin Brown
 */
package edu.tridenttech.cpt237.brown.scheduler.view;

import java.util.ArrayList;

import edu.tridenttech.cpt237.brown.scheduler.model.Employee;
import edu.tridenttech.cpt237.brown.scheduler.model.ScheduleBuilder;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Schedule
{

	private Stage myStage;
	private TableView<Employee> table;
	private ArrayList<TableColumn<Employee, String>> viewableSchedule = new ArrayList<>();
	ScheduleBuilder sched;

	public Schedule(Stage stage)
	{
		table = buildColumns();
		VBox pane = new VBox();
		pane.getChildren().add(table);
		pane.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: blue;");

		myStage = stage;
		Scene scene = new Scene(pane);
		myStage.setTitle("Schedule");
		myStage.setScene(scene);

	}

	public void show()
	{
		myStage.show();
	}

	public TableView<Employee> buildColumns()
	{
		TableView<Employee> table = new TableView<>(ScheduleBuilder.getEmployeeList());
		viewableSchedule.add(ScheduleHelper.getNameColumn());
		viewableSchedule.add(ScheduleHelper.getMondayColumn());
		viewableSchedule.add(ScheduleHelper.getTuesdayColumn());
		viewableSchedule.add(ScheduleHelper.getWednesdayColumn());
		viewableSchedule.add(ScheduleHelper.getThursdayColumn());
		viewableSchedule.add(ScheduleHelper.getFridayColumn());
		viewableSchedule.add(ScheduleHelper.getSaturdayColumn());
		viewableSchedule.add(ScheduleHelper.getSundayColumn());

		table.getColumns().setAll(viewableSchedule);

		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		table.setEditable(true);
		table.getSelectionModel().cellSelectionEnabledProperty().set(true);

		table.setPlaceholder(new Label("No visible columns and/or data exist."));
		return table;
	}
}
