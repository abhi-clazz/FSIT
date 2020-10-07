import java.util.Scanner;

import com.babytoy.exception.InvalidNameException;
import com.babytoy.model.Customer;
import com.babytoy.service.CustomerService;
import com.babytoy.service.Implementation.CustomerServiceImpl;

public class App {

	public static void main(String[] args) throws InvalidNameException {
		// TODO Auto-generated method stub
		

		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to BabyToys \n" + "Press 1 for Inserting toys \n" + "Press 2 for Search \n"
				+ "Press 3 for Display \n" + "Press 4 for deleting toys");
		System.out.println();
		System.out.println("****************************************************************************************************************************");
		System.out.println();
		try {
		int i=scan.nextInt();
		
		if(i==1)
		{
			
		System.out.println("You have Selected insert operation");
		System.out.println();
		System.out.println("****************************************************************************************************************************");
		System.out.println();
		
		System.out.println("Enter Customer Name");
		String name = scan.next();
		
		System.out.println("Input CustomerID");
		int id = scan.nextInt();

		System.out.println("Input Customer city");
		String city = scan.next();

		System.out.println("Input Customer zip");
		int zip = scan.nextInt();

		System.out.println("Input Customer country");
		String country = scan.next();

		System.out.println("Input Password");
		String password = scan.next();

		System.out.println("Input Customer State");
		String state = scan.next();
		
		scan.close();
		CustomerService serviceImpl = new CustomerServiceImpl();
		Customer customer = new Customer();

		customer.setCity(city);
		customer.setCountry(country);
		customer.setState(state);
		customer.setPassword(password);
		customer.setCustomerId(id);
		customer.setZip(zip);
		customer.setCustomerName(name);
		serviceImpl.insert(customer);

	}
		
		else {
			System.out.println("wrong choice");
		}
		}
		catch (Exception e) {
			System.out.println("hi");
		}
	}

}
