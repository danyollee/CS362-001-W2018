package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());
	 }

	 @Test
	  public void test02()  throws Throwable  {
		 Appt appt = new Appt(12,  1, 5, 10, 2018, "test", "testDesc");
		 assertEquals(12, appt.getStartHour());
		 assertEquals(1, appt.getStartMinute());
		 assertEquals(5, appt.getStartDay());

		 Appt appt2 = new Appt(-1, -1, 1, 1, 2018, "test", "testDesc");
		 assertEquals(false, appt2.getValid());

		 Appt appt3 = new Appt(1, -1, 1, 1, 2018, "test", "testDesc");
		 assertEquals(false, appt3.getValid());

		 Appt appt4 = new Appt(1, 1, -1, 1, 2018, "test", "testDesc");
		 assertEquals(false, appt4.getValid());


	 }
//add more unit tests as you needed
	@Test
	  public void test03() throws Throwable {
		int startHour=18;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title=null;
		String description=null;
	 	Appt appt = new Appt(18, 30, 15, 01, 2018, "Valid test", "valid description");
		Appt appt1 = new Appt(1, 400, 1, 01, 1, "Valid test", "valid description");
		Appt appt2 = new Appt(1, 1, 50, 01, 1, "Valid test", "valid description");

		assertEquals(true, appt.getValid());
		assertEquals(false, appt1.getValid());
		assertEquals(false, appt2.getValid());

	  }

	  @Test
	public void test04() throws Throwable {
		Appt appt = new Appt(10,30,15,01,2018,"This is my wedding day","Day to get married");
		String check= "\t" + 01 + "/" + 15 + "/" + 2018 + " at " + 10 + ":" + 30 + "am ," + "This is my wedding day" + ", " + "Day to get married" + "\n";
		assertEquals(check, appt.toString());

		Appt appt2 = new Appt (15, 1, 1, 1, 2018, "Test", "Desk");
		String check2 = "\t" + 1 + "/" + 1 + "/" + 2018 + " at " + 3 + ":" + 1 + "pm ," + "Test" + ", " + "Desk" + "\n";
		assertEquals(check2, appt2.toString());

		Appt appt3 = new Appt (0, 1, 1, 1, 2018, "Test", "Desk");
		String check3 = "\t" + 1 + "/" + 1 + "/" + 2018 + " at " + 12 + ":" + 1 + "am ," + "Test" + ", " + "Desk" + "\n";
		assertEquals(check3, appt3.toString());

		Appt appt4 = new Appt(-1, -1, -1, 1, 2018, "test", "desk");
		assertEquals(null, appt4.toString());


	}

	@Test
		public void test05() throws Throwable {
			int startHour1=3;
			int startMinute1=24;
			int startDay1=19;
			int startMonth1=6;
			int startYear1=1997;
			String title1="This is my birthday";
			String description1="This is the day I was born";

			int startHour2=7;
			int startMinute2=53;
			int startDay2=15;
			int startMonth2=8;
			int startYear2=1988;
			String title2="This is my brothers birthday";
			String description2="This is the day my brother was born";

			Appt appt = new Appt (startHour1, startMinute1, startDay1, startMonth1, startYear1, title1, description1);
			Appt appt2 = new Appt (startHour2, startMinute2, startDay2, startMonth2, startYear2, title2, description2);

        assertEquals(-22, appt.compareTo(appt2));


    }



	 @Test
	public void test06() throws Throwable {
	 	Appt appt = new Appt(1, 1, 1, 1, 1, null, "desk");
	 	appt.setStartHour(90);
	 	appt.setStartMinute(2);
	 	appt.setStartDay(2);
	 	appt.setStartMonth(2);
	 	appt.setStartYear(2);

	 	assertEquals(false, appt.getValid());
	 }

	 @Test
	public void test07() throws Throwable {
	 	Appt appt = new Appt(1, 1, 1, 1, 1, "test", "desk");
		int recurDays[] = {2}; //Day of the week the appointment recurs on
		int recurBy = 0; //Recurs weekly
		int recurIncrement = 1; //Recurs every 1 week
		int recurNumber = 0; //Recurs forever

		 appt.setRecurrence(null, recurBy, recurIncrement, recurNumber);
		 assertEquals(0, appt.getRecurNumber());
		 assertEquals(0, appt.getRecurBy());
	 }

	 @Test
	public void	test08() throws Throwable {
	 	Appt appt = new Appt(1, 1, 1, 1, 2018, "test", "desk");
	 	int recurDay[] = {2};
	 	int recurBy = 1;
	 	int recurIncrement = 1;
	 	int recurNumber = -1;

	 	appt.setRecurrence(recurDay, recurBy, recurIncrement, recurNumber);
	 	assertTrue(appt.isRecurring());
	 	assertEquals(1, appt.getRecurIncrement());
	 }

	 @Test
	public void	test09() throws Throwable {
	 	Appt appt = new Appt(11, 1, 1, 1, 2018, "test", "desk");

	 }


}
