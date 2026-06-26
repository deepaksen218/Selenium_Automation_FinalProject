package utilities;

import com.github.javafaker.Faker;

public class FakerUtility {
	Faker fakerObj = new Faker();
	
	public String generateRandomUserName() {
		return fakerObj.name().username(); //  this will randomly generate username
	}
	
	public String generateRandomPassword() {
		return fakerObj.internet().password();
	}
	
	public String generateRandomFullName() {
		return fakerObj.name().firstName();
	}
	
	public String generateEmailAddress() {
		return fakerObj.internet().emailAddress();
	}
	
	public String generateAddress() {
		return fakerObj.address().fullAddress();
	}
	
	public String generateRandomText() {
		return fakerObj.lorem().sentence(); // for generating random words'lorem is used'
	}

}
