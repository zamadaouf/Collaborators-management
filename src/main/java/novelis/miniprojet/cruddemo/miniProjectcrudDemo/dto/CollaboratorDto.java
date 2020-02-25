package novelis.miniprojet.cruddemo.miniProjectcrudDemo.dto;

import java.util.Date;

import novelis.miniprojet.cruddemo.miniProjectcrudDemo.entity.Collaborator;

public class CollaboratorDto {

	private int id;

	private String firstName;

	private String lastName;

	private String email;

	private String phoneNumber;

	private Date birthDate;

	private String civility;

	public CollaboratorDto(int id ,String firstName, String lastName, String civility, String email, String phoneNumber,
			Date birthDate) {
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
		return "Collaborateur [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", birthDate=" + birthDate + ", civility=" + civility + "]";
	}

	public Collaborator convertToCollaborator() {

		return new Collaborator(id, firstName, lastName, civility, email, phoneNumber, birthDate);
	}

}
