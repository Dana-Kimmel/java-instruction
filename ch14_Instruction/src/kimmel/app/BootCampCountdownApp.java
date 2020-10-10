package kimmel.app;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class BootCampCountdownApp {

	public static void main(String[] args) {

		LocalDate bootCampStart = LocalDate.of(2020, Month.AUGUST, 10);
		LocalDate bootCampGraduation = LocalDate.of(2021, Month.FEBRUARY, 24);

		LocalDate currentDate = LocalDate.now();

		Long bootCampStartDaysAgo = bootCampStart.until(currentDate, ChronoUnit.DAYS);
		System.out.println("Bootcamp started " + bootCampStartDaysAgo + " days ago");

		Long bootCampDaysRemaining = currentDate.until(bootCampGraduation, ChronoUnit.DAYS);
		System.out.println("There are " + bootCampDaysRemaining + " days remaining");

		long totalBootCampDays = bootCampStartDaysAgo + bootCampDaysRemaining;
		double percentComplete = (double) bootCampStartDaysAgo / totalBootCampDays;

		NumberFormat percentFormatter = NumberFormat.getPercentInstance();

		System.out.println("We are " + percentFormatter.format(percentComplete) + " complete!! AAAaaaaaggghhhh!!!");

	}

}
