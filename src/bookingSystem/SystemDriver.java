package bookingSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import users.User;

/** System driver class - contains menus and functions used to run the system */
public class SystemDriver
{
	private Scanner keyboard = new Scanner(System.in);
    private String customerInfoFileName = "src/users/customerinfo";

    /** list to hold user data (may use one list for all 
     * people type objects customer/owner/employee and differentiate with a field) */
	List<User> userList = new ArrayList<User>();
	
	public SystemDriver()
	{
		
	}
	
	/** loads the system at start up, call functions to load users currently
	 *  will be used to load all data
	 */
    public void loadSystem()
    {
        loadFromFile(customerInfoFileName);
        registerAndLogin();
    }
	
    /** boolean running keeps menus looping until quit is selected */
	static Boolean running = true;
	
	public void registerAndLogin()
	{
		while (running)
		{
			System.out.println("======================\n"
							 + "1. Log In\n"
							 + "2. Register\n"
							 + "3. Quit\n"
							 + "4. owner menu (testing)\n"
							 + "5. customer menu (testing)\n");
			
			int answer = Integer.parseInt(keyboard.nextLine());
			
			switch (answer)
			{
			case 1: login();                   break;
			case 2: register();                break;
			case 3: running = false;           break;
			case 4: ownerMenu();               break;
			case 5: customerMenu();            break;
			default: System.out.println("no"); break;
			}
		}
	}

	/** Customer specific menu, user sent here when valid customer account used*/
	private void customerMenu()
	{
		while (running)
		{
			System.out.println("======================\n"
							 + "1. View Bookings\n"
							 + "2. Make Booking\n"
							 + "3. Quit\n"
							 + "4. register/login menu (testing)\n"
							 + "5. owner menu (testing)\n");
			
			int answer = Integer.parseInt(keyboard.nextLine());
			
			switch (answer)
			{
			case 1: viewCoustomerBooking();    break;
			case 2: addBooking();              break;
			case 3: running = false;           break;
			case 4: registerAndLogin();        break;
			case 5: customerMenu();            break;
			default: System.out.println("no"); break;
			}
		}
	}

	/** Owner specific menu - only accessible with owner user name and password */
	private void ownerMenu()
	{
		while (running)
		{
			System.out.println("======================\n"
							 + "1. View Bookings\n"
							 + "2. View Employees\n"
							 + "3. Add Employee\n"
							 + "4. Remove Employee\n"
							 + "5. Quit\n"
							 + "6. ...\n"
							 + "7. register/login menu (testing)\n"
							 + "8. customer menu (testing)\n");
			
			int answer = Integer.parseInt(keyboard.nextLine());
			
			switch (answer)
			{
			case 1: viewBooking();             break;
			case 2: viewEmployee();            break;
			case 3: addEmployee();             break;
			case 4: removeEmployee();          break;
			case 5: running = false;           break;
			case 6: superSecretMenu();         break;
			case 7: registerAndLogin();        break;
			case 8: customerMenu();            break;
			default: System.out.println("no"); break;
			}
		}
	}

	/** super secret menu... 'nuff said */
	private void superSecretMenu()
	{
		while (running)
		{
			System.out.println("======================\n"
							 + "1. Quit\n"
							 + "2. ...\n"
							 + "3. Profit\n"
							 + "4. owner menu (testing)"
							 + "5. register/login menu (testing)\n"
							 + "6. customer menu (testing)\n");
			
			int answer = Integer.parseInt(keyboard.nextLine());
			
			switch (answer)
			{
			case 1: running = false;           break;
			case 4: ownerMenu();               break;
			case 5: registerAndLogin();        break;
			case 6: customerMenu();            break;
			default: System.out.println("no"); break;
			}
		}
	}

	private void addBooking()
	{
		// TODO Auto-generated method stub
		
	}

	private void viewCoustomerBooking()
	{
		// TODO Auto-generated method stub
		
	}

	private void removeEmployee()
	{
		// TODO Auto-generated method stub
		
	}

	private void addEmployee()
	{
		// TODO Auto-generated method stub
		
	}

	private void viewEmployee()
	{
		// TODO Auto-generated method stub
		
	}

	private void viewBooking()
	{
		// TODO Auto-generated method stub
		
	}

	private void register()
	{
		// TODO Auto-generated method stub
		
	}

	private void login()
	{
		// TODO Auto-generated method stub
		
	}

	/** load data from file - currently loads customer data only, will be refactored to be more general */
    public boolean loadFromFile(String customerInfoFileName)
    {
        Scanner customerInputStream = null;

        try
        {
            customerInputStream = new Scanner(new File(customerInfoFileName));
            customerInputStream.useDelimiter(",");
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error opening " + customerInfoFileName);
            return false;
        }

        while (customerInputStream.hasNextLine())
        {
            String customerName = customerInputStream.next();
            String customerPassword = customerInputStream.next();

            User newUser = new User(customerName, customerPassword);

            userList.add(newUser);

        }
        customerInputStream.close();
        return true;
    }

}
