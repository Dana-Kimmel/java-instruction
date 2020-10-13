package kimmel.app;

import java.text.NumberFormat;
import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class Reservation {

	private final double NIGHTLY_RATE = 145.0;

//fields
	private LocalDate arrivalDate;
	private LocalDate departureDate;

	// default constructors
	public Reservation() {
		arrivalDate = LocalDate.of(0, 0, 0);
		departureDate = LocalDate.of(0, 0, 0);
	}

	// constructors with parameters
	public Reservation(LocalDate arrivalDate, LocalDate departureDate) {
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
	}

	// getters and setters

	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	public String getArrivalDateFormatted() {
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		return dtf.format(arrivalDate);

	}

	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public String getDepartureDateFormatted() {
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		return dtf.format(departureDate);
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	// business methods
	public int getNumberOfNights() {
		int numberOfNights = (int) arrivalDate.until(departureDate, ChronoUnit.DAYS);
		return numberOfNights;
	}

	public String getPricePerNightFormatted() {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		String pricePerNight = currency.format(NIGHTLY_RATE);
		return pricePerNight;
	}

	public double getTotalPrice() {
		double totalPrice = NIGHTLY_RATE * getNumberOfNights();
		return totalPrice;
	}

	public String getTotalPriceFormatted() {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		String totalPriceFormatted = currency.format(getTotalPrice());
		return totalPriceFormatted;

	}
}
