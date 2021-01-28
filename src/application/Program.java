package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter full file path: ");
		String path = sc.next();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			List <Employee> list = new ArrayList<>();
			
			System.out.print("Enter salary: ");
			Double sal = sc.nextDouble();
			
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				list.add(new Employee(fields[0],fields[1],Double.parseDouble(fields[2])));
				line = br.readLine();
			}
			
			List<String> mail = list.stream().filter(e -> e.getSalary() > sal).map(e -> e.getEmail()).sorted().collect(Collectors.toList());
			String[] mails = line.split(",");
			for (int i = 0;  i< mails.length ; i++) {
				System.out.println(mails[i]);
			}
			
		}
		catch(IOException e) {
			System.out.print("Error: "+ e.getMessage());
		}
		sc.close();
		
	}

}
