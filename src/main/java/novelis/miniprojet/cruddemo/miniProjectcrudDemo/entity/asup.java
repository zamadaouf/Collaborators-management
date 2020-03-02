package novelis.miniprojet.cruddemo.miniProjectcrudDemo.entity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class asup {
	Date birthDate;
	
	public String sDate() {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateOfBirth = formatter.format(birthDate);
		return dateOfBirth;
		
	}
	
	Date getBirthDate() {
		
		Date result = null;
		try {
			result = new SimpleDateFormat("dd/MM/yyyy").parse(this.sDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return result;
		
		
	}
	void setBirthDate(Date d) {
		birthDate=d;
	}
	public static void main(String[] args) {
		asup a = new asup();
		a.setBirthDate(new Date());
		System.out.println(a.getBirthDate());
		
	}

}
