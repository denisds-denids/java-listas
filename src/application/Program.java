package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employees;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();
		
		Employees employee = new Employees();
		List<Employees> list = new ArrayList<>();
				
		for (int i = 0 ; i<n ; i++) {
			Boolean checkId = false;
			int id;
			do {
				System.out.printf("\nEmployee #%d:\nId: ", i+1);
				id = sc.nextInt();
				checkId = false;
				for (Employees obj : list) {
					if(id == obj.getId()) {
						System.out.println("Id already exists!");
						checkId = true;
					}
				}	
			} while(checkId);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			
			employee = new Employees(id, name, salary);
			list.add(employee);
			System.out.println();
			
			
		}
		
		System.out.print("Enter the employee id that will have salary increase: ");
		int idIncrease = sc.nextInt();
	/*	boolean control = false;
		
		for (Employees obj : list) {
			if (idIncrease == obj.getId()) {
				System.out.print("Enter the percentage: ");
				double percentage = sc.nextDouble();
				obj.setIncrease(percentage);
				control = true;
			}
		}
		
		if (!control) {
			System.out.println("This id does not exists!");
		}*/
		
		
		  Employees emp = list.stream().filter(x -> x.getId() == idIncrease).findFirst().orElse(null);
		  if(emp == null){
		  		System.out.println("This id does not exists!");
		  }
		  else{
		  		System.out.print("Enter the percentage: ");
		  		double percentage = sc.nextDouble();
				emp.setIncrease(percentage);
		  }
		  
		 
		

		
		System.out.printf("\nList of employees: \n");
		
		for (Employees obj : list) {
			System.out.printf(obj.getId()
								+ ", "
								+ obj.getName()
								+ ", "
								+ String.format("%.2f", obj.getSalary())
								+ "\n");
		}
		
						
		sc.close();
		

	}

}
