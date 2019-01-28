import java.util.Scanner;

public class ICA1Conversion {
   public static void main(String[] args) {
	   Scanner s = new Scanner(System.in);
	   double in  = -1;
	   while(in < 0) {
		   System.out.println("Enter a distance in meters: ");
		   in = s.nextDouble();
	   }
	   
	   getOption(s, in);
   }
   
   public static void getOption(Scanner s, double in) {
	   
	   while(true) {
		   menu();
		   int opt = s.nextInt();
		   executeOption(opt, in);
		   System.out.println();
	   }
   }
   
   public static void menu() {
	   System.out.println("1. Convert to kilometers");
	   System.out.println("2. Convert to inches");
	   System.out.println("3. Convert to feet");
	   System.out.println("4. Quit the program");
	   System.out.println();
	   System.out.println("Enter your choice: ");
   }
   
   public static void executeOption(int option, double num) {
	   
	   if(option == 1) {
		   System.out.println(num + " meters is " + toKm(num) + " kilometers.");
	   }
	   
	   if(option == 2) {
		   System.out.println(num + " meters is " + toInches(num) + " inches.");
	   }
	   
	   if(option == 3) {
		   System.out.println(num + " meters is " + toFeet(num) + " feet.");
	   }
	   
	   if(option == 4) {
		   Quit();
	   }
	   
	   else 
		   System.out.println("Invalid Option");
   }
   
   public static double toInches(double num) {
	   return num * 39.37;
   }
   
   public static double toKm(double num) {
	   return num * .001;
   }
   
   public static double toFeet(double num) {
	   return num * 3.281;
   }
   
   public static void Quit() {
	   System.exit(0);
   }
}