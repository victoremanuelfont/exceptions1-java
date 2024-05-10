package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	/*
	 * throws ParseException surge pois "sdf.parse(sc.next())" indica que pode haver
	 * uma exceção que precisa ser tratada ou propagada no método, e nesse caso, foi
	 * propagada. Portanto, o método main pode lançar uma exceção.
	 */
	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		/*
		 * Para testar se a data de checkIn não é posterior a data de CheckOut
		 */
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Entrt data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			/*
			 * reservation.updateDates() vai retornar um string, então criou-se uma variável
			 * "error" para receber essa string. Se "error" retornar null, não tem erro, mas
			 * se ela retornar diferente de null, vai ser imprimido o tipo de erro
			 */

			String error = reservation.updateDates(checkIn, checkOut);
			if (error != null) {
				System.out.println("Error in reservation : " + error);

			} else {

				System.out.println("Reservation: " + reservation);
			}

		}

	}
}
