package novelis.miniprojet.cruddemo.miniProjectcrudDemo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import novelis.miniprojet.cruddemo.miniProjectcrudDemo.dto.CollaboratorDto;

@Entity
@Table(name = "collaborators")
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

	@Column(name = "email")
	private String email;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "birth_date")
	private Date birthDate;

	@Column(name = "civility")
	private String civility;

	public Collaborator() {

	}

	// define constructor

	public Collaborator(int id, String firstName, String lastName, String civility, String email, String phoneNumber,
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

	// convert to/from DTO

	public CollaboratorDto convertToDto() {
		return new CollaboratorDto(id, firstName, lastName, civility, email, phoneNumber, birthDate);
	}

	public Collaborator updateFromDto(CollaboratorDto collaboratorDto) {

		this.setId(collaboratorDto.getId());
		this.setFirstName(collaboratorDto.getFirstName());
		this.setLastName(collaboratorDto.getLastName());
		this.setCivility(collaboratorDto.getCivility());
		this.setEmail(collaboratorDto.getEmail());
		this.setPhoneNumber(collaboratorDto.getPhoneNumber());

		return this;
	}

}
