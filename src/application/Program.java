package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		System.out.println("Enter Rental Data:");
		System.out.print("Car Model: ");
		String carModel = sc.nextLine();
		System.out.print("Pickup (dd/MM/yyyy HH:ss): ");
		Date start = sdf.parse(sc.nextLine());
		System.out.print("Return (dd/MM/yyyy HH:ss): ");
		Date finish = sdf.parse(sc.nextLine());
		
		CarRental cr = new CarRental(start, 
									 finish, 
									 new Vehicle(carModel));
		
		System.out.print("Enter Price Per Hour: ");
		double pricePerHour = sc.nextDouble();
		System.out.print("Enter Price Per Day: ");
		double pricePerDay = sc.nextDouble();
		
		// Instanciando o Serviço
		RentalService rs = new RentalService(pricePerDay,
											 pricePerHour, 
											 new BrazilTaxService());
		
		// Processando o Aluguel
		rs.ProcessInvoice(cr);
		
		// Impriminto
		System.out.println("INVOICE::");
		System.out.println("Basic Payment: " + String.format("%.2f", cr.getInvoice().getBasicPaiment()));
		System.out.println("TAX: " + String.format("%.2f",cr.getInvoice().getTax()));
		System.out.println("Total Payment: " + String.format("%.2f",cr.getInvoice().getTotalPayment()));

		
		sc.close();

	}

}
