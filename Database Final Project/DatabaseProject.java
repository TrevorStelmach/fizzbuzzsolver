import java.util.Scanner;
import java.sql.*;

public class DatabaseProject{

   public static void main(String args[]) throws Exception{
   
      Class.forName("com.mysql.jdbc.Driver");
    	Connection conn =
       DriverManager.getConnection("jdbc:mysql://cs.neiu.edu:3306/db_Spr16_tstelmach?" +
                                   "user=tstelmach&password=tstelmach");
      Statement stmt = conn.createStatement();
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Enter 1 to Insert into Customer.");
      System.out.println("Enter 2 to to Insert into Part.");
      System.out.println("Enter 3 to Insert into Order."); 
      System.out.println("Enter 4 to Select from Customer."); 
      System.out.println("Enter 5 to Select from Part."); 
      System.out.println("Enter 6 to Select from Order.");    
      int choice = keyboard.nextInt();
      
      if (choice == 1){
         System.out.println("Enter custID");
         int id = keyboard.nextInt();
         System.out.println("Enter customer first name:");
         String fName = keyboard.next();
         System.out.println("Enter customer last name:");
         String lName = keyboard.next();
         System.out.println("Enter customer address:");
         String address = keyboard.next();
         System.out.println("Enter customer city:");
         String city = keyboard.next();
         System.out.println("Enter customer e-mail:");
         String email = keyboard.next();
         stmt.executeUpdate("Insert into Customer values("+id+ ", '"+fName+"','"+lName+"','"+address+"','"+city+"','"+email+"')");
         
      }
      
      else if (choice == 2){
         System.out.println("Enter partID");
         int id = keyboard.nextInt();
         System.out.println("Enter part name:");
         String partName = keyboard.next();
         System.out.println("Enter manufacturer:");
         String man = keyboard.next();
         System.out.println("Enter part price:");
         double price = keyboard.nextDouble();
         stmt.executeUpdate("Insert into Part values("+id+ ", '"+partName+"','"+man+"',"+price+")");
      }
      
      else if (choice == 3){
         System.out.println("Enter shipID");
         int shipId = keyboard.nextInt();
         System.out.println("Enter custID:");
         int custId = keyboard.nextInt();
         System.out.println("Enter partID");
         int partID = keyboard.nextInt();
         System.out.println("Enter total price:");
         double price = keyboard.nextDouble();
         stmt.executeUpdate("Insert into Orders values("+shipId+ ", "+custId+","+totalParts+","+price+")");
      }
      
      else if (choice == 4){
          ResultSet res = stmt.executeQuery("select * from Customer");
          
          while(res.next()){
            System.out.println("custID: " + res.getInt(1) + "\t" + "fName: " + res.getString(2) + "\t" + "lName: " + res.getString(3) + "\t" + "address: " + res.getString(4) + "\t" + "city: " + res.getString(5) + "\t" + "email: " + res.getString(6));
          }
      }
      
      else if (choice == 5){
          ResultSet res = stmt.executeQuery("select * from Part");
          
          while(res.next()){
            System.out.println("partID: " + res.getInt(1) + "\t" + "partName: " + res.getString(2) + "\t" + "manufacturer: " + res.getString(3) + "\t" + "price: " + res.getDouble(4));
          }
      }
      
      else if (choice == 6){
          ResultSet res = stmt.executeQuery("select * from Orders");
          
          while(res.next()){
            System.out.println("shipId: " + res.getInt(1) + "\t" + "custID: " + res.getInt(2) + "\t" + "partID: " + res.getInt(3) + "\t" + "totalPrice: " + res.getDouble(4));
          }
          
          res.close();
      }
      
      stmt.close();
      conn.close();


      
   
   
   
  
}
}