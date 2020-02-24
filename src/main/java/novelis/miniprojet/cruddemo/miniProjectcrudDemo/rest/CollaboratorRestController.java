package novelis.miniprojet.cruddemo.miniProjectcrudDemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import novelis.miniprojet.cruddemo.miniProjectcrudDemo.dto.CollaboratorDto;
import novelis.miniprojet.cruddemo.miniProjectcrudDemo.entity.Collaborator;
import novelis.miniprojet.cruddemo.miniProjectcrudDemo.service.CollaboratorService;

@Api(description = "API pour les opérations CRUD sur les collaborateurs ")
@RestController
//@RequestMapping("/crud")
public class CollaboratorRestController {

	private CollaboratorService collaboratorService;

	@Autowired
	public CollaboratorRestController(CollaboratorService theCollaboratorService) {
		collaboratorService = theCollaboratorService;
	}

	/*Step 1 : Read all Collaborators*/
	
	@ApiOperation(value = "Récupère la liste des collaborateurs")
	@GetMapping("/Collaborators")
	public List<CollaboratorDto> findAll() {
		return collaboratorService.findAll();
	}

	/*Step 2 : Read a Single Collaborator*/
	
	@ApiOperation(value = "Récupère un collaborateur grâce à son ID à condition que celui-ci existe!")
	@GetMapping("/Collaborators/{collaboratorId}")
	public CollaboratorDto getCollaborator(@PathVariable int collaboratorId) {

		CollaboratorDto theCollaborator = collaboratorService.findById(collaboratorId);

		if (theCollaborator == null) {
			throw new RuntimeException("Collaborator id not found - " + collaboratorId);
		}

		return theCollaborator;
	}

	/*Step 3 : Add a new Collaborator*/
	
	@ApiOperation(value = "ajoute un collaborateur")
	@PostMapping("/Collaborators")
	public ResponseEntity<Void> addCollaborator(@RequestBody CollaboratorDto theCollaborator) {
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update

		theCollaborator.setId(0);

		collaboratorService.save(theCollaborator);

		return new ResponseEntity<Void>(HttpStatus.CREATED);
//		return theCollaborator;

	}

	/* Step 4 : Update Collaborator */

	@ApiOperation(value = "modifie un collaborateur")
	@PutMapping("/Collaborators")
	public CollaboratorDto updateCollaborator(@RequestBody CollaboratorDto theCollaborator) {

		collaboratorService.save(theCollaborator);

		return theCollaborator;
	}
	
	/*Step 5 : Delete an Collaborator*/

	@ApiOperation(value = "supprime un collaborateur grâce à son ID à condition que celui-ci existe!")
	@DeleteMapping("/Collaborators/{collaboratorId}")
	public String deleteCollaborator(@PathVariable int collaboratorId) {

		CollaboratorDto theCollaborator = collaboratorService.findById(collaboratorId);

		// throw exception if null

		if (theCollaborator == null) {
			throw new RuntimeException("Collaborator id not found - " + collaboratorId);
		}

		collaboratorService.deleteById(collaboratorId);

		return "Deleted Collaborator id - " + collaboratorId;
	}

}
