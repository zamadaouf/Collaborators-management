package novelis.miniprojet.cruddemo.miniProjectcrudDemo.rest;

import java.util.List;

import javax.validation.Valid;

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

@Api(description = "Collaborators management ")
@RestController
//@RequestMapping("/crud")
public class CollaboratorRestController {

	private CollaboratorService collaboratorService;

	@Autowired
	public CollaboratorRestController(CollaboratorService theCollaboratorService) {
		collaboratorService = theCollaboratorService;
	}

	/*Step 1 : Read all Collaborators*/
	
	@ApiOperation(value = "to retrieve all the collaborators")
	@GetMapping("/Collaborators")
	public List<CollaboratorDto> findAll() {
		return collaboratorService.findAll();
	}

	/*Step 2 : Read a Single Collaborator*/
	
	@ApiOperation(value = "to retrieve an existed collaborator")
	@GetMapping("/Collaborators/{collaboratorId}")
	public CollaboratorDto getCollaborator(@PathVariable int collaboratorId) {

		return collaboratorService.findById(collaboratorId);

	}

	/*Step 3 : Add a new Collaborator*/
	
	@ApiOperation(value = "to add a new collaborator")
	@PostMapping("/Collaborators")
	public ResponseEntity<Void> addCollaborator(@Valid @RequestBody CollaboratorDto theCollaboratorDto) {
//		// also just in case they pass an id in JSON ... set id to 0
//		// this is to force a save of new item ... instead of update
//
//		theCollaborator.setId(0);

		collaboratorService.save(theCollaboratorDto);

		return new ResponseEntity<Void>(HttpStatus.CREATED);

	}

	/* Step 4 : Update Collaborator */

	@ApiOperation(value = "to update a collaborator")
	@PutMapping("/Collaborators")
	public CollaboratorDto updateCollaborator(@RequestBody CollaboratorDto theCollaboratorDto) {

		return collaboratorService.updateCollaborator(theCollaboratorDto);

	}
	
	/*Step 5 : Delete an Collaborator*/

	@ApiOperation(value = "to delete an existed collaborator by his ID!")
	@DeleteMapping("/Collaborators/{collaboratorId}")
	public ResponseEntity<Collaborator> deleteCollaborator(@PathVariable int collaboratorId) {

		CollaboratorDto theCollaboratorDto = collaboratorService.findById(collaboratorId);

		// throw exception if null

		if (theCollaboratorDto == null) {
			throw new RuntimeException("Collaborator id not found - " + collaboratorId);
		}

		collaboratorService.deleteById(collaboratorId);

		return ResponseEntity.accepted().build();
	}

}
