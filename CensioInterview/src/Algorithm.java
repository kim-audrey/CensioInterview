// Audrey Kim
// Censio Intern Programming Assessment

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class Algorithm {

	public static Person closestPerson(Person person, Person[] people) {
		double lon = person.location.longitude;
		double lat = person.location.latitude;
		
		double shortestDistance = Double.MAX_VALUE;
		Person closestPerson = person;
		for (Person p : people) {
			double dist = calculateDistance(lon, lat, p.location.longitude, p.location.latitude);
			
			if(dist < shortestDistance) {
				shortestDistance = dist;
				closestPerson = p;
			}
		}

		return closestPerson;
	}
	
	
	
	// sources: https://www.geeksforgeeks.org/program-distance-two-points-earth/#:~:text=For%20this%20divide%20the%20values,is%20the%20radius%20of%20Earth.
	private static double calculateDistance(double lon1, double lon2, double lat1, double lat2) {
        final double earthRadius = 3958.8; 	// in miles
		
        lon1 = Math.toRadians(lon1); 
        lon2 = Math.toRadians(lon2); 
        lat1 = Math.toRadians(lat1); 
        lat2 = Math.toRadians(lat2); 
  
        double dlon = lon2 - lon1; 
        double dlat = lat2 - lat1;
        
        // Haversine formula  
        double a = Math.pow(Math.sin(dlat / 2), 2) 
                 + Math.cos(lat1) * Math.cos(lat2) 
                 * Math.pow(Math.sin(dlon / 2),2); 
        double c = 2 * Math.asin(Math.sqrt(a)); 
		
		return earthRadius * c;
	}
	
	
	
	public static ArrayList<Person> groupByAddress(Person[] people, String city, String state){
		ArrayList<Person> sameCity = new ArrayList<Person>();
		for(Person p : people) {
			if (p.address.state.equals(state) && p.address.city.equals(city)) 
				sameCity.add(p);
		}
		return sameCity;
	}
	
	
	
	/**************** random optional ****************/
	public static ArrayList<Person> groupByZodiac(Person[] people, String zodiac) {
		ArrayList<Person> sameZodiac = new ArrayList<>();
		
		int firstMonth = 0;
		int lastMonth = 0;
		int firstDay = 0;
		int lastDay = 0;
		
		// https://www.universetoday.com/38076/zodiac-signs-and-their-dates/
		switch(zodiac) {
		case "aries":
			firstMonth = 3;
			firstDay = 21;
			lastMonth = 4;
			lastDay = 19;
		case "taurus":
			firstMonth = 4;
			firstDay = 20;
			lastMonth = 5;
			lastDay = 20;
		case "gemini":
			firstMonth = 5;
			firstDay = 21;
			lastMonth = 6;
			lastDay = 20;
		case "cancer":
			firstMonth = 6;
			firstDay = 21;
			lastMonth = 7;
			lastDay = 22;
		case "leo":
			firstMonth = 7;
			firstDay = 23;
			lastMonth = 8;
			lastDay = 22;
		case "virgo":
			firstMonth = 8;
			firstDay = 23;
			lastMonth = 9;
			lastDay = 22;
		case "libra":
			firstMonth = 9;
			firstDay = 23;
			lastMonth = 10;
			lastDay = 22;
		case "scorpio":
			firstMonth = 10;
			firstDay = 23;
			lastMonth = 11;
			lastDay = 21;
		case "sagittarius":
			firstMonth = 11;
			firstDay = 22;
			lastMonth = 12;
			lastDay = 21;
		case "capricorn":
			firstMonth = 12;
			firstDay = 22;
			lastMonth = 1;
			lastDay = 19;
		case "aquarius":
			firstMonth = 1;
			firstDay = 20;
			lastMonth = 2;
			lastDay = 18;
		case "pisces":
			firstMonth = 2;
			firstDay = 19;
			lastMonth = 3;
			lastDay = 20;
		}
		
		for (Person p : people){
			int birthMonth = p.birthday.month;
			int birthDay = p.birthday.day;

			if(birthMonth > firstMonth && birthMonth < lastMonth && birthDay > firstDay && birthDay < lastDay)
				sameZodiac.add(p);
		}
		
		return sameZodiac;		
	}

}
