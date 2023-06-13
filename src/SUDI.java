import java.util.*;
import java.sql.*;
public class SUDI {
	public static void main(String[] args) {
		int loop=0,choice2;
		String choice,enroll,schno,name,mobile,branch,email,sem,add,vacc,dues,ins,del,up,ser;
		Scanner input = new Scanner(System.in);
		

		while(loop==0) {
		System.out.println("\n\n+--------WELCOME TO STUDENT RECORD MANAGEMENT SYSTEM--------+");
		System.out.println("|\t1.) Insert In Student Record                        |");
		System.out.println("|\t2.) Update In Student Record                        |");
		System.out.println("|\t3.) Delete From Student Record                      |");
		System.out.println("|\t4.) Search In Student Record                        |");
		System.out.println("|\t5.) Exit                                            |");
		System.out.println("+-----------------------------------------------------------+");
		System.out.print("\nEnter the operation you want to perform (insert/update/delete/search/exit) : ");
		choice = input.next();
		 
		switch (choice.toLowerCase()){
		case "insert": {
			System.out.println("You Are In Insert");
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sanket","root","");
				int lp=0;
				do
				{
					System.out.println("Enter The Following Details Of Student: ");
					System.out.print("Enrollment Number : ");
					enroll = input.next();
					System.out.print("Scholor Number : ");
					schno = input.next();
					
					input.nextLine();
					System.out.print("Student Name : ");
					name = input.nextLine();
					System.out.print("Branch : ");
					branch = input.nextLine();
					System.out.print("Email Id : ");
					email = input.next();
					System.out.print("Mobile Number : ");
					mobile = input.next();
					
					input.nextLine();
					System.out.print("Semester : ");
					sem = input.nextLine();
					System.out.print("Address : ");
					add = input.nextLine();
					System.out.print("Vaccination Status : ");
					vacc = input.nextLine();
					System.out.print("Fees Dues : ");
					dues = input.nextLine();
					
					String s = "insert into Students(EnrollmentNumber, ScholorNumber, StudentName, Branch, Email, Mobile, Semester, Address, VaccinationStatus, Dues) values(?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement st = con.prepareStatement(s);
					st.setString(1, enroll);
					st.setString(2, schno);
					st.setString(3, name);
					st.setString(4, branch);
					st.setString(5, email);
					st.setString(6, mobile);
					st.setString(7, sem);
					st.setString(8, add);
					st.setString(9, vacc);
					st.setString(10, dues);
					System.out.println("Student Record Inserted Successfully");
					st.execute();
					System.out.print("\nDo you want to store more student record (y/n): ");
					ins = input.next();
					ins.toLowerCase();
					
					if (ins.equals("n")) {
					lp  = 1;	
					}
					
				}while(lp==0);
				con.close();
			}
			catch(Exception e){
				System.out.println(e);
			}
			break;
			
		}
		case "update": {
			System.out.println("You Are In Update");
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sanket","root","");
				int lp0=0;
				do
				{
					System.out.println("Enter The Enrollment Number Of Student: ");
					enroll = input.next();
					
					String s = "Select * From Students where EnrollmentNumber='"+enroll+"' ";
					Statement st = con.createStatement();
					ResultSet res = st.executeQuery(s);
					
					//Showing Result
					while(res.next()) {
						System.out.println("1.) ScholorNumber : "+res.getString(2));
						System.out.println("2.) StudentName : "+res.getString(3));
						System.out.println("3.) Branch : "+res.getString(4));
						System.out.println("4.) Email : "+res.getString(5));
						System.out.println("5.) Mobile : "+res.getString(6));
						System.out.println("6.) Semester : "+res.getString(7));
						System.out.println("7.) Address : "+res.getString(8));
						System.out.println("8.) VaccinationStatus : "+res.getString(9));
						System.out.println("9.) Dues : "+res.getString(10));
						System.out.println("10.) Change In All Records");
					}
					System.out.print("Enter the field which you want to edit form (1-10): ");
					choice2 = input.nextInt();
					switch (choice2) {
					case 1: {
						System.out.print("Enter Updated Scholor Number : ");
						schno = input.next();
						String query = "Update Students set ScholorNumber=? where EnrollmentNumber=?";
						PreparedStatement set = con.prepareStatement(query);
						set.setString(1, schno);
						set.setString(2,enroll);
						System.out.println("Student Scholor Number Record Updated Successfully");
						set.execute();
						break;
					}

					case 2: {
						input.nextLine();
						System.out.print("Enter Updated Student Name : ");
						name = input.nextLine();
						String query = "Update Students set StudentName=? where EnrollmentNumber=?";
						PreparedStatement set = con.prepareStatement(query);
						set.setString(1, name);
						set.setString(2,enroll);
						System.out.println("Student Name Record Updated Successfully");
						set.execute();
						break;
					}
					case 3: {
						input.nextLine();
						System.out.print("Enter Updated Branch : ");
						branch = input.nextLine();
						String query = "Update Students set Branch=? where EnrollmentNumber=?";
						PreparedStatement set = con.prepareStatement(query);
						set.setString(1, branch);
						set.setString(2,enroll);
						System.out.println("Student Branch Record Updated Successfully");
						set.execute();
						break;
					}
					case 4: {
						System.out.print("Enter Updated Email Id : ");
						email = input.next();
						String query = "Update Students set Email=? where EnrollmentNumber=?";
						PreparedStatement set = con.prepareStatement(query);
						set.setString(1, email);
						set.setString(2,enroll);
						System.out.println("Student Email Record Updated Successfully");
						set.execute();
						break;
					}
					case 5: {
						System.out.print("Enter Updated Mobile Number : ");
						mobile = input.next();
						String query = "Update Students set Mobile=? where EnrollmentNumber=?";
						PreparedStatement set = con.prepareStatement(query);
						set.setString(1, mobile);
						set.setString(2,enroll);
						System.out.println("Student Mobile Record Updated Successfully");
						set.execute();
						break;
					}
					case 6: {
						input.nextLine();
						System.out.print("Enter Updated Semester : ");
						sem = input.nextLine();
						String query = "Update Students set Semester=? where EnrollmentNumber=?";
						PreparedStatement set = con.prepareStatement(query);
						set.setString(1, sem);
						set.setString(2,enroll);
						System.out.println("Student Semester Record Updated Successfully");
						set.execute();
						break;
					}
					case 7: {
						input.nextLine();
						System.out.print("Enter Updated Address : ");
						add = input.nextLine();
						String query = "Update Students set Address=? where EnrollmentNumber=?";
						PreparedStatement set = con.prepareStatement(query);
						set.setString(1, add);
						set.setString(2,enroll);
						System.out.println("Student Address Record Updated Successfully");
						set.execute();
						break;
					}
					case 8: {
						input.nextLine();
						System.out.print("Enter Updated Vaccination Status : ");
						vacc = input.nextLine();
						String query = "Update Students set VaccinationStatus=? where EnrollmentNumber=?";
						PreparedStatement set = con.prepareStatement(query);
						set.setString(1, vacc);
						set.setString(2,enroll);
						System.out.println("Student Vaccination Status Record Updated Successfully");
						set.execute();
						break;
					}
					case 9: {
						input.nextLine();
						System.out.print("Enter Updated Fees Dues : ");
						dues = input.nextLine();
						String query = "Update Students set Dues=? where EnrollmentNumber=?";
						PreparedStatement set = con.prepareStatement(query);
						set.setString(1, dues);
						set.setString(2, enroll);
						System.out.println("Student Dues Record Updated Successfully");
						set.execute();
						break;
					}
					case 10:{
						System.out.print("Scholor Number : ");
						schno = input.next();

						input.nextLine();
						System.out.print("Student Name : ");
						name = input.nextLine();
						System.out.print("Branch : ");
						branch = input.nextLine();
						System.out.print("Email Id : ");
						email = input.next();
						System.out.print("Mobile Number : ");
						mobile = input.next();

						input.nextLine();
						System.out.print("Semester : ");
						sem = input.nextLine();
						System.out.print("Address : ");
						add = input.nextLine();
						System.out.print("Vaccination Status : ");
						vacc = input.nextLine();
						System.out.print("Fees Dues : ");
						dues = input.nextLine();

						String query = "Update Students set ScholorNumber=?, StudentName=?, Branch=?, Email=?, Mobile=?, Semester=?, Address=?, VaccinationStatus=?, Dues=? where EnrollmentNumber=?";
						PreparedStatement set = con.prepareStatement(query);
						set.setString(1, schno);
						set.setString(2, name);
						set.setString(3, branch);
						set.setString(4, email);
						set.setString(5, mobile);
						set.setString(6, sem);
						set.setString(7, add);
						set.setString(8, vacc);
						set.setString(9, dues);
						set.setString(10, enroll);
						System.out.println("Student Records Updated Successfully");
						set.execute();
						break;
					}
					default:
						System.out.println("INVALID OPERATION");
						break;
					}
					
					System.out.print("\nDo you want to update another student record (y/n): ");
					up = input.next();
					up.toLowerCase();
					
					if (up.equals("n")) {
					lp0  = 1;	
					}
					
				}while(lp0==0);
				con.close();
			}
			catch(Exception e){
				System.out.println(e);
			}
			break;
		}
		case "delete": {
			System.out.println("You Are In Delete");
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sanket","root","");
				int lp1=0;
				do 
				{
					System.out.println("Enter The Enrollment Number Of Student : ");
					enroll = input.next();
					
					Statement st = con.createStatement();
					st.executeUpdate("Delete From Students where EnrollmentNumber='"+enroll+"' ");
					System.out.println("Student Record Deleted Successfully");
					
					System.out.print("\nDid you want to delete more student record (y/n): ");
					del = input.next();
					del.toLowerCase();
					
					if (del.equals("n")) 
						lp1 = 1;	
					
				}while(lp1==0);
				con.close();
			}
			catch(Exception e){
				System.out.println(e);
			}
			break;
		}
		case "search": {
			System.out.println("You Are In Search");
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sanket","root","");
				int lp2=0;
				do 
				{
					System.out.println("Enter The Enrollment Number Of Student : ");
					enroll = input.next();
					
					String s = "Select * From Students where EnrollmentNumber='"+enroll+"' ";
					Statement st = con.createStatement();
					ResultSet res = st.executeQuery(s);
					
					//Showing Result
					while(res.next()) {
						System.out.println("\nScholorNumber : "+res.getString(2));
						System.out.println("StudentName : "+res.getString(3));
						System.out.println("Branch : "+res.getString(4));
						System.out.println("Email : "+res.getString(5));
						System.out.println("Mobile : "+res.getString(6));
						System.out.println("Semester : "+res.getString(7));
						System.out.println("Address : "+res.getString(8));
						System.out.println("VaccinationStatus : "+res.getString(9));
						System.out.println("Dues : "+res.getString(10));
					}
					
					System.out.print("\nDo you want to search another student record (y/n): ");
					ser = input.next();
					ser.toLowerCase();
					
					if (ser.equals("n")) 
						lp2 = 1;	
					
				}while(lp2==0);
				con.close();
			}
			catch(Exception e){
				System.out.println(e);
			}
			break;
		}
		case "exit": {
			loop =1;
			break;
		}
		default:
			System.out.println("INVALID OPERATION");
			break;
		}
	}	
	}

}
