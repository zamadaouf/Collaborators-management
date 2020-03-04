package novelis.miniprojet.cruddemo.miniProjectcrudDemo.entity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import novelis.miniprojet.cruddemo.miniProjectcrudDemo.dto.CollaboratorDto;

@Entity
@Table(name = "collaborators")
@JsonPropertyOrder(value = {"id","firstName","lastName","civility","birthDate","email","phoneNumber"})
public class Collaborator {

	// define fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "civility")
	private String civility;

	@Column(name = "email")
	private String email;

	@Column(name = "phone_number")
	private String phoneNumber;

	
	@Column(name = "birth_date")
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date birthDate;



	public Collaborator() {

	}

	// define constructor

	public Collaborator(int id, String firstName, String lastName, String civility, Date birthDate, String email, String phoneNumber) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.birthDate = birthDate;
		this.civility = civility;
	}

	// define getter/setter

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getBirthDate() {
//		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//        String dateOfBirth = formatter.format(birthDate);
//		try {
//			birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirth);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}  
		return birthDate;
	}
	
	

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCivility() {
		return civility;
	}

	public void setCivility(String civility) {
		this.civility = civility;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Collaborateur [ id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", civility=" + civility + ", birthDate=" + birthDate + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + "]";
	}

	// convert to/from DTO

	public CollaboratorDto convertToDto() {
		return new CollaboratorDto(id, firstName, lastName, civility, birthDate, email, phoneNumber);
	}

	public Collaborator updateFromDto(CollaboratorDto collaboratorDto) {

		this.setId(collaboratorDto.getId());
		this.setFirstName(collaboratorDto.getFirstName());
		this.setLastName(collaboratorDto.getLastName());
		this.setCivility(collaboratorDto.getCivility());
		this.setBirthDate(collaboratorDto.getBirthDate());
		this.setEmail(collaboratorDto.getEmail());
		this.setPhoneNumber(collaboratorDto.getPhoneNumber());

		return this;
	}

}
