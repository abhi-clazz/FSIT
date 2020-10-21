import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.babytoy.exception.InvalidAgeException;
import com.babytoy.exception.InvalidNameException;
import com.babytoy.model.Customer;
import com.babytoy.model.Toy;
import com.babytoy.model.ToyRental;
import com.babytoy.service.CustomerService;
import com.babytoy.service.ToyRentalService;
import com.babytoy.service.ToyService;
import com.babytoy.service.Implementation.CustomerServiceImpl;
import com.babytoy.service.Implementation.ToyRentalServiceImpl;
import com.babytoy.service.Implementation.ToyServiceImpl;

public class App {



	public static void main(String[] args) throws InvalidNameException, InvalidAgeException, SQLException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		CustomerService customerService=new CustomerServiceImpl();
		ToyService serviceImpl = new ToyServiceImpl();
		ToyRentalService toy=new ToyRentalServiceImpl();
		ToyRental r=new ToyRental();
		try 
		{
		int repeater=0;  int count=0;
		int repeater1=0;
		int repeater2=0;
		int repeater4=0;
		while(repeater==0)
		{
		System.out.println("Welcome to BabyToys \n" + "Press 1 to Login as Admin and to perform operations like inserting and updating toys information \n" + "Press 2 to Login as Customer and to book toy rental services \n"+ "Press 3 to Register as customer\n"+ "Press 4 to view available toys as guest user");
		
			int i=scan.nextInt();

			if(i==1)
			{
				while(count==0)
				{
				System.out.println();
				System.out.println("Enter UserId");
				String id1=scan.next();

				System.out.println("Enter password");
				String pw=scan.next();
				if(id1.contentEquals("admin")&& pw.contentEquals("admin"))
				{
					while(repeater1==0)
					{
					System.out.println("Welcome Admin\n"+"Press 1 to Insert Toys\n"+"Press 2 to delete Toys\n"+"Press 3 to display customers information\n"+"Press 4 to remove Customer\n"+"Press 5 to search customer\n"+"Press 6 to delete toy+\"Press 7 to update customer");
					int sel=scan.nextInt();
					if(sel==1)
					{
						System.out.println("You have Selected  Toys insert operation");


						System.out.println("Enter Toy Name");
						String name = scan.next();

						

						System.out.println("Input ToyType");
						String type = scan.next();



						System.out.println("Input Min Age");
						int min = scan.nextInt();

						System.out.println("InputMax Age");
						int max = scan.nextInt();

						System.out.println("Input price");
						float p = scan.nextFloat();
						System.out.println("Input qunatity");

						int q = scan.nextInt();

						System.out.println("Input amount");
						float amt = scan.nextFloat();


						
						Toy toy1 = new Toy();

						
						toy1.setToyName(name);
						toy1.setMaxAge(max);
						toy1.setMinAge(min);
						toy1.setToyType(type);
						toy1.setQuantity(q);
						toy1.setPrice(p);
						toy1.setRentalAmount(amt);
						serviceImpl.insertToys(toy1);

					}
					else if(sel==2)
					{
						try
						{
						
						System.out.println("Enter Toy ID");
						int toyid1 = scan.nextInt();
						if(serviceImpl.searchToy(toyid1).size()>0)
						{
						
						System.out.println("press 0 for fields that require no update ");
						System.out.println("Enter name ");
						String name = scan.next(); 
						System.out.println("Enter type:");
						String type = scan.next();
						System.out.println("Enter min age");
						int minage = scan.nextInt(); 
						System.out.println("Enter maxage");
						int maxage = scan.nextInt();
						System.out.println("Enter price");
						int price = scan.nextInt();
						System.out.println("Enter quantity");
						int qt = scan.nextInt();
						System.out.println("Enter amount");
						int a = scan.nextInt();
						Toy t=new Toy(toyid1,name,type,minage,maxage,price,qt,a);
						
						serviceImpl.updateToy(toyid1,t);
						}
						else
						{
							System.out.println("no toyid found");
						}
						}
						catch (Exception e) {
							System.out.println("enter valid data");						}
						
					}
						
					else if(sel==3)
					{
						
						List<Customer> list1=customerService.display();
						for(Customer custlist:list1)
						{
							System.out.println ("CustomerID="+custlist.getCustomerId()+" Name="+custlist.getCustomerName()+" State="+custlist.getState()+" City="+custlist.getCity()+" Country="+custlist.getCountry());
							System.out.println("-------------------------------------------------------------------------");
						}
					}
					else if(sel==4)
					{
						System.out.println("You have selected delete operation");
						System.out.println("Enter customerId to delete");
						
						int c=scan.nextInt();
						customerService.delete(c);
						System.out.println("deleted record with customerId "+c);
					}
					
					else if(sel==5)
					{
						System.out.println("to search with id press 1 with name 2");
						int c=scan.nextInt();
						if(c==1) 
						{

							System.out.println("Enter CustomerId to Search");
							int d=scan.nextInt();
							CustomerService customerService1=new CustomerServiceImpl();
							customerService1.search(d);
						}
						else if(c==2)
						{
							System.out.println("Enter Customer Name to Search");
							String z=scan.next();
							CustomerService customerService2=new CustomerServiceImpl();
							customerService2.search(z);
						}
						else
						{
							System.out.println("PLease Input Correct Choice");
						}
					}
					else if(sel==6)
					{
						System.out.println("enter toyid to delete");
						int t2=scan.nextInt();
						serviceImpl.deleteToy(t2);
						
					}
					else if(sel==7)
					{
						System.out.println("enter customerid to update");
						int t2=scan.nextInt();
						System.out.println("enter city to update");
						String c=scan.next();
						customerService.update(t2, c);
						
					}
					else {
						System.out.println("wrong select");
					}
					
					System.out.println("press 0 to go back");
					repeater1=scan.nextInt();
					}
				}
				else
				{
					System.out.println("invalid credntials");
					
				}
				System.out.println("press 0 to Login Again");
				count=scan.nextInt();
				}
				
			

			}

			else if (i==2)
			{
				System.out.println("Enter UserId");
				int id=scan.nextInt();

				System.out.println("Enter password");
				String p=scan.next();
				if(customerService.login(id,p))
				{
					while(repeater4==0)
					{
					System.out.println("Welcome Customer \n"+"Press 1 to Book Toys\n"+"Press 2 to return Toys\n"+"Press 3 to to get rental amount\n"+"press 4 to get toyrentdetails");
					System.out.println();

					int m=scan.nextInt();
					if(m==1)
					{
						System.out.println("You have Selected Book Toy operation");
						System.out.println();
						System.out.println("****************************************************************************************************************************");
						System.out.println();

						System.out.println("Input Toy_ID");
						int id3 = scan.nextInt();
						if(serviceImpl.searchToy(id3).size()>0)
						{
							
						System.out.println("Input CustomerID");
						int id2 = scan.nextInt();

						

						System.out.println("Enter Start DATE in  MM/dd/yyyy  format Only");
						String start = scan.next();

						System.out.println("Enter End Date in MM/dd/yyyy format only");
						String end = scan.next();
						
						
						
						double amt=serviceImpl.searchToy(id3).get(0).getRentalAmount();


						
					
						
						SimpleDateFormat format=new SimpleDateFormat("MM/dd/yyyy");
						try {
							long end1=format.parse(end).getTime();
							long start1=format.parse(start).getTime();
							//double d=(((end1-start1)*amt)/(1000*24*60*60));
							//r.setTotalAmount(d);
							r.setRentalStartDate(format.parse(start));
							r.setRentalEndDate(format.parse(end));

							r.setCustomerId(id2);
							
							r.setToyId(id3);

							r.setStatus("booked");

							r.setFine(0);
							r.setRentalAmountPerDay(amt);
							toy.bookToy(r);//booking 
						}
						catch (Exception e) {
							System.out.println("Enter  Date in MM/dd/yyyy format only");


						}
						}
						else
						{
							System.out.println("no toy available with "+id3);
						}
					}
					else if (m==2)
					{
						System.out.println("Enter Rental_ID");
						int rid=scan.nextInt();
						System.out.println("Enter ToyId to return");
						int tid=scan.nextInt();
						toy.returnToy(rid,tid,id);
						
					}
					else if (m==3)
					{
						System.out.println("enter toyid");
						int t=scan.nextInt();
						System.out.println("enter rentalid");
						int rd=scan.nextInt();
						
						toy.getRentalAmount(id,t,rd);
					}
					else if(m==4)
					{
						System.out.println("Enter Toy_id");
						int tid=scan.nextInt();
						serviceImpl.toyRentDetails(tid);
					}
					else
					{
						System.out.println("wrong selection");
					}
					System.out.println("press 0 to go to main console");
					repeater4=scan.nextInt();
					}
				}
				else {
					System.out.println("Please enter valid credntials");
				}
			}

			else if(i==3)
			{
				while(repeater2==0)
				{
				System.out.println("You have Selected insert operation");


				System.out.println("Enter Customer Name");
				String name = scan.next();

//			
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

				
				Customer customer = new Customer();

				customer.setCity(city);
				customer.setCountry(country);
				customer.setState(state);
				customer.setPassword(password);
			
				customer.setZip(zip);
				customer.setCustomerName(name);
				customerService.insert(customer);
				System.out.println("press 0 to go to main console");
				repeater2=scan.nextInt();
			}
				
			}
			else if(i==4)
			{
				System.out.println("Availble toys are");
				serviceImpl.getToys();

			}
		

			else {
				System.out.println("wrong choice");
			}
			System.out.println("press 0 to go to MAIN console");
			repeater=scan.nextInt();
		}
		}
		
		

		catch (InputMismatchException e) {
			System.out.println("please input valid data");
		}
	}

	
}
