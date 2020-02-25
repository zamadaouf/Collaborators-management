package novelis.miniprojet.cruddemo.miniProjectcrudDemo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import novelis.miniprojet.cruddemo.miniProjectcrudDemo.dto.CollaboratorDto;

@Entity
@Table(name = "collaborators")
public class Collaborator{
	
	// define fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	
	@NotNull(message = "please enter your first name")
	@Pattern(    
			regexp = "([A-Za-z 'àäâéèêëôöùûüçÀÂÉÈÔÙÛÇ-]){2,30}",
			message = "the first name should has betwen 2 and 30 character")
	@Column(name = "first_name")
	private String firstName;

	
	@NotNull(message = "please enter your last name")
	@Pattern(    
			regexp = "([A-Za-z 'àäâéèêëôöùûüçÀÂÉÈÔÙÛÇ-]){2,30}",
			message = "the last name should has betwen 2 and 30 character")
	@Column(name = "last_name")
	private String lastName;

	
	@NotNull(message = "please enter your email address")
	@Email(message = "the email is not valid")
	@Column(name = "email")
	private String email;
	
	
	@NotNull(message = "please enter your phone number")
	@Pattern(    
			regexp = "(^0[0-9]{9}$|^00[0-9]{11,13}$)",
			message = "this phone number is not valide")
	@Column(name = "phone_number")
	private String phoneNumber;
	
	
	@NotNull(message = "please enter your birth date")
//	@Pattern(    
//			regexp = "((?:19|20)[0-9]{2})-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])",
//			message = "the date is not valide")
	@Column(name = "birth_date")
	private Date birthDate;

	
	@NotNull(message = "please enter your civility")
	@Pattern(    
			regexp = "(M.|Mme)",
			message = "the civility is not valide")
	@Column(name = "civility")
	private String civility;
	
	
	public Collaborator() {

	}

	// define constructor
	

	public Collaborator(int id, String firstName, String lastName, String civility,
			String email, String phoneNumber, Date birthDate) {
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

	//convert to/from DTO
	

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
