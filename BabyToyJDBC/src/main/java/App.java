import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.babytoy.DAO.CustomerDAO;
import com.babytoy.DAO.Implementation.CustomerDAOImpl;
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
		else if (i==2)
		{
		System.out.println("You Have Selected Search\n");
		System.out.println("Enter 1 to search CustomerID \n\n"+"Enter 2 to search CustomerName");
		int c=scan.nextInt();
		if(c==1) 
		{
			
			System.out.println("Enter CustomerId to Search");
			int d=scan.nextInt();
			CustomerService customerService=new CustomerServiceImpl();
			customerService.search(d);
		}
		else if(c==2)
		{
			System.out.println("Enter CustomerName to Search");
			String z=scan.next();
			CustomerService customerService=new CustomerServiceImpl();
			customerService.search(z);
		}
		else
		{
			System.out.println("PLease Input Correct Choice");
		}
		}
		
		else if(i==3)
		{
			CustomerService customerService=new CustomerServiceImpl();
			List<Customer> list1=customerService.display();
			for(Customer custlist:list1)
			{
			System.out.println ("CustomerID="+custlist.getCustomerId()+" Name="+custlist.getCustomerName()+" State="+custlist.getState()+" City="+custlist.getCity()+" Country="+custlist.getCountry());
			System.out.println("-------------------------------------------------------------------------");
			}
		}
		else if(i==4)
		{
			System.out.println("You have selected delete operation");
			System.out.println("Enter customerId to delete");
			CustomerService customerService=new CustomerServiceImpl();
			int c=scan.nextInt();
			customerService.delete(c);
			System.out.println("deleted record with customerId "+c);

		}

		else {
			System.out.println("wrong choice");
		}
		}
		catch (InputMismatchException e) {
			System.out.println("please input valid data");
		}
	}

}
