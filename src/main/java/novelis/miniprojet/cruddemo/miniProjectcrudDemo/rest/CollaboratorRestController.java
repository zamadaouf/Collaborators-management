package novelis.miniprojet.cruddemo.miniProjectcrudDemo.rest;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import novelis.miniprojet.cruddemo.miniProjectcrudDemo.dao.CollaboratorRepository;
import novelis.miniprojet.cruddemo.miniProjectcrudDemo.dto.CollaboratorDto;
import novelis.miniprojet.cruddemo.miniProjectcrudDemo.entity.Collaborator;
import novelis.miniprojet.cruddemo.miniProjectcrudDemo.exceptionHandler.NotFoundException;
import novelis.miniprojet.cruddemo.miniProjectcrudDemo.pagination.AppResponse;
import novelis.miniprojet.cruddemo.miniProjectcrudDemo.pagination.CollaboratorListResponse;
import novelis.miniprojet.cruddemo.miniProjectcrudDemo.pagination.PageMeta;
import novelis.miniprojet.cruddemo.miniProjectcrudDemo.service.CollaboratorService;

@Api( value = "Collaborator",description = "Collaborators management ", tags = { "Collaborators" })
@RestController
public class CollaboratorRestController {

	private CollaboratorService collaboratorService;

	@Autowired
	private CollaboratorRepository collaboratorRepository;
	
	@Autowired
	public CollaboratorRestController(CollaboratorService theCollaboratorService) {
		collaboratorService = theCollaboratorService;
	}

	
	@ApiOperation(value = "pagination")
	@GetMapping("/Collaborators/page")
	public AppResponse index(@RequestParam(value = "page", defaultValue = "1") int page,
            				@RequestParam(value = "page_size", defaultValue = "4") int pageSize,
            				HttpServletRequest request) {
		
		Pageable pageable = getPageable(page, pageSize);
		Page<Collaborator> collaborators = this.collaboratorRepository.findAll(pageable);
		Collection<CollaboratorDto> collaboratorDTOs = buildCollaborators(collaborators);
		return new CollaboratorListResponse(PageMeta.build(collaborators, request.getRequestURI()), collaboratorDTOs);
	
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

	
	/* Step 4 : Update Collaborator by put*/

	@ApiOperation(value = "to update a collaborator")
	@PutMapping("/Collaborators")
	public CollaboratorDto updateCollaborator(@RequestBody CollaboratorDto theCollaboratorDto, BindingResult result) {
		if(result.hasErrors()) {
			
			new NotFoundException();
		}
		return collaboratorService.updateCollaborator(theCollaboratorDto);

	}

	/* Step 4 : Update Collaborator by post */

	@ApiOperation(value = "Update a collaborator's informations on the condition that he exists!")
	@PostMapping("/Collaborators/{id}")
	public ModelAndView updateCollaborator(@PathVariable("id") int id, @Valid Collaborator collaborator, Model model) {
		
		ModelAndView modelAndView = new ModelAndView("informations");
		collaboratorRepository.save(collaborator);
		model.addAttribute("collaborators", collaboratorRepository.findAll());
			return modelAndView;
	}
	
	
	/*Step 5 : Delete an Collaborator*/

	@ApiOperation(value = "to delete an existed collaborator by his ID!")
	@DeleteMapping("/Collaborators/{collaboratorId}")
	public ResponseEntity<Collaborator> deleteCollaborator(@PathVariable int collaboratorId) {

		CollaboratorDto theCollaboratorDto = collaboratorService.findById(collaboratorId);

		// throw exception if null

		if (theCollaboratorDto == null) {

			new NotFoundException();
		}

		collaboratorService.deleteById(collaboratorId);

		return ResponseEntity.accepted().build();
	}
	
	
	/*Pagination*/
	
	private Pageable getPageable(int page, int pageSize) {
        if (page <= 0)
            page = 1;

        if (pageSize <= 0)
            pageSize = 2;

        PageRequest pageRequest = PageRequest.of(page - 1, pageSize, Sort.Direction.ASC,"id");
        
        return pageRequest;
    }
	
	private List<CollaboratorDto> buildCollaborators(Page<Collaborator> collaborator) {
        List<CollaboratorDto> collaboratorDTOs = collaborator.getContent().stream().map(CollaboratorDto::build).collect(Collectors.toList());
        return collaboratorDTOs;
    }
	
	
}
