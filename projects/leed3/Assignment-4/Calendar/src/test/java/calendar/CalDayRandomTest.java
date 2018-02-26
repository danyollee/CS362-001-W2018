package calendar;


import org.junit.Test;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	private static final long TestTimout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS = 100;

    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {

	 	long startTime = Calendar.getInstance().getTimeInMillis();
	 	long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

	 	System.out.println("Start testing...");

	 	try{
	 		for (int iteration = 0; elapsed < TestTimout; iteration++) {
	 			long randomseed = System.currentTimeMillis();
	 			Random random = new Random(randomseed);

	 			//Creates random variables for 2 new appointments
				int startHour = ValuesGenerator.getRandomIntBetween(random, -10, 34); //Randomizes input for the start hour to include values out of bounds
				int startMinute = ValuesGenerator.getRandomIntBetween(random, -20, 80);
				int startDay = ValuesGenerator.getRandomIntBetween(random, -20, 50);
				int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int startYear = ValuesGenerator.RandInt(random);
				String title = "Birthday Party";
				String description = "This is my birthday party";

				//Construcrt a new Appointment object with the initial data
				Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

				int startHour2 = ValuesGenerator.getRandomIntBetween(random, -10, 34); //Randomizes input for the start hour to include values out of bounds
				int startMinute2 = ValuesGenerator.getRandomIntBetween(random, -20, 80);
				int startDay2 = ValuesGenerator.getRandomIntBetween(random, -20, 50);
				int startMonth2 = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int startYear2 = ValuesGenerator.RandInt(random);
				String title2 = "Birthday Party two";
				String description2 = "This is my second birthday party";

				//Construcrt a new Appointment object with the initial data
				Appt appt2 = new Appt(startHour2, startMinute2, startDay2, startMonth2, startYear2, title2, description2);

				//Creates a calDay object
				Calendar cal = Calendar.getInstance();
				int day = cal.get(Calendar.DAY_OF_MONTH);
				int month = cal.get(Calendar.MONTH);
				int year = cal.get(Calendar.YEAR);

				GregorianCalendar gregCal = new GregorianCalendar(year, month, day);

				CalDay calday1 = new CalDay(gregCal);


				assertTrue(calday1.isValid());

				calday1.addAppt(appt);
				calday1.addAppt(appt2);




				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if((iteration%10000)==0 && iteration != 0) {
					System.out.println("elapsed time: " + elapsed + " of " + TestTimout);
				}


			}
		}catch(NullPointerException e) {

		}

		System.out.println("Done testing....");
		 
		 
	 }


	
}
