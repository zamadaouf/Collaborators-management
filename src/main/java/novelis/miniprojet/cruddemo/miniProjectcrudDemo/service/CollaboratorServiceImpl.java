package novelis.miniprojet.cruddemo.miniProjectcrudDemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import novelis.miniprojet.cruddemo.miniProjectcrudDemo.dao.CollaboratorRepository;
import novelis.miniprojet.cruddemo.miniProjectcrudDemo.dto.CollaboratorDto;
import novelis.miniprojet.cruddemo.miniProjectcrudDemo.entity.Collaborator;
import novelis.miniprojet.cruddemo.miniProjectcrudDemo.exceptionHandler.NotFoundException;
import novelis.miniprojet.cruddemo.miniProjectcrudDemo.exceptionHandler.ValidationException;

@Service
public class CollaboratorServiceImpl implements CollaboratorService{

private CollaboratorRepository CollaboratorRepository;

	@Autowired
	public CollaboratorServiceImpl(CollaboratorRepository theCollaboratorRepository) {
		CollaboratorRepository = theCollaboratorRepository;
	}
	
	
	@Override
	public List<CollaboratorDto> findAll() {
		
		List<Collaborator> collaborators = CollaboratorRepository.findAll();

        List<CollaboratorDto> collaboratorDtos = new ArrayList<>();

        for (Collaborator c : collaborators) {

        	collaboratorDtos.add(new CollaboratorDto(c.getId(), c.getFirstName(), c.getLastName(), c.getCivility(), c.getBirthDate(), c.getEmail(), c.getPhoneNumber()));
        }

        return collaboratorDtos;
	}
	

	@Override
	public CollaboratorDto findById(int theId) {
		
		Optional<Collaborator> result = CollaboratorRepository.findById(theId);
		
		if(result.isPresent()) {
			return (new CollaboratorDto(result.get().getId(), result.get().getFirstName(), result.get().getLastName(), result.get().getCivility(), result.get().getBirthDate(), result.get().getEmail(), result.get().getPhoneNumber()));
		}else {
			throw new NotFoundException();
		}
		
	}

	@Override
	public CollaboratorDto save(CollaboratorDto theCollaboratorDto) {
		
		if(theCollaboratorDto.isEmpty()) {
			throw new ValidationException();
		}
		Collaborator save = CollaboratorRepository.save(theCollaboratorDto.convertToCollaborator());
        return save.convertToDto(); 
        
	}

	
	@Override
	public void deleteById(int theId) {
		if (CollaboratorRepository.existsById(theId)) {

			CollaboratorRepository.deleteById(theId);

        } else {
        	throw new NotFoundException();//throw new RuntimeException("Could not find a Collaborator id - "+theId);
        }
	}
	
	@Override
	public CollaboratorDto updateCollaborator(CollaboratorDto collaboratorDto) {

        Optional<Collaborator> optionalCollaborator = CollaboratorRepository.findById(collaboratorDto.getId());

        if (optionalCollaborator.isPresent()) {

        	Collaborator p = optionalCollaborator.get().updateFromDto(collaboratorDto);

        	Collaborator saved = CollaboratorRepository.save(p);

            return saved.convertToDto();

        } else {

        	throw new ValidationException();//throw new RuntimeException("Could not find a Collaborator with id " + collaboratorDto.getId());
        }

    }
	

}
