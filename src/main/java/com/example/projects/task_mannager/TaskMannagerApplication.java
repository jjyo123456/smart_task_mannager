package com.example.projects.task_mannager;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Scanner;

import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class TaskMannagerApplication {

	public static void main(String[] args) {
		

			try (// Bootstrapping Spring and retrieving the service bean
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(task_config.class)) {
				Task_service taskService = context.getBean(Task_service.class);
	
				try (Scanner scanner = new Scanner(System.in)) {
					System.out.println("Enter Task Details:");

					System.out.print("Task ID (int): ");
					int id = Integer.parseInt(scanner.nextLine());

					System.out.print("Title: ");
					String taskTitle = scanner.nextLine();

					System.out.print("Description: ");
					String description = scanner.nextLine();

					System.out.print("Due Date (yyyy-mm-dd): ");
					Date dueDate = Date.valueOf(scanner.nextLine());

					System.out.print("Start Date & Time (yyyy-mm-dd hh:mm:ss): ");
					Timestamp startDate = Timestamp.valueOf(scanner.nextLine());

					System.out.print("End Date & Time (yyyy-mm-dd hh:mm:ss): ");
					Timestamp endDate = Timestamp.valueOf(scanner.nextLine());

					System.out.print("Status: ");
					String status = scanner.nextLine();

					System.out.print("Priority: ");
					String priority = scanner.nextLine();

					task newTask = new task(id, taskTitle, description, dueDate, startDate, endDate, status, priority);

					// Adding task using service
					taskService.add_task(newTask);
				}
			} catch (BeansException | NumberFormatException e) {
                            

			}
			System.out.println(" Task inserted successfully!");

	}
}


