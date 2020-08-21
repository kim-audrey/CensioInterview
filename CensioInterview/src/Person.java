// Audrey Kim
// Censio Intern Programming Assessment

public class Person {
	public String name;
	public Day birthday;
	public GeoCoordinate location;
	public Address address;
	
	public Person(String name, Day birthday, GeoCoordinate location, Address address) {
		this.name = name;
		this.birthday = birthday;
		this.location = location;
		this.address = address;
	}
	
	
	public class Address{
		public int houseNumber;
		public String streetName;
		public String city;
		public String country;
		public String state;
		public int zipCode;
		
		public Address(int houseNum, String street, String city, String country, String state, int zipCode) {
			this.houseNumber = houseNum;
			this.streetName = street;
		}
	}
	
	public class GeoCoordinate {
		public double longitude;
		public double latitude;
		
		public GeoCoordinate(double lon, double lat) {
			this.longitude = lon;
			this.latitude = lat;
		}
	}
	
	public class Day {
		public int month;
		public int day;
		public int year;
		
		public Day(int month, int day, int year) {
			this.month = month;
			this.day = day;
			this.year = year;
		}
	}
}
