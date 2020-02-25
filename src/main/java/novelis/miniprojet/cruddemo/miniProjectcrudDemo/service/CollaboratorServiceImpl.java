package novelis.miniprojet.cruddemo.miniProjectcrudDemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import novelis.miniprojet.cruddemo.miniProjectcrudDemo.dao.CollaboratorRepository;
import novelis.miniprojet.cruddemo.miniProjectcrudDemo.dto.CollaboratorDto;
import novelis.miniprojet.cruddemo.miniProjectcrudDemo.entity.Collaborator;

@Service
public class CollaboratorServiceImpl implements CollaboratorService{

private CollaboratorRepository CollaboratorRepository;

private CollaboratorDto cdt;

	@Autowired
	public CollaboratorServiceImpl(CollaboratorRepository theCollaboratorRepository) {
		CollaboratorRepository = theCollaboratorRepository;
	}
	
	@Override
	public List<CollaboratorDto> findAll() {
		
		List<Collaborator> collaborators = CollaboratorRepository.findAll();

        List<CollaboratorDto> collaboratorDtos = new ArrayList<>();

        for (Collaborator c : collaborators) {

        	collaboratorDtos.add(new CollaboratorDto(c.getFirstName(), c.getLastName(), c.getCivility(), c.getEmail(), c.getPhoneNumber(), c.getBirthDate()));
        }

        return collaboratorDtos;
	}
	
	
	
	public void mapperCollab() {
	}

	@Override
	public CollaboratorDto findById(int theId) {
		
		Optional<Collaborator> result = CollaboratorRepository.findById(theId);
		
		if(result.isPresent()) {
			return (new CollaboratorDto(result.get().getFirstName(), result.get().getLastName(), result.get().getCivility(), result.get().getEmail(), result.get().getPhoneNumber(), result.get().getBirthDate()));
		}else {
			// Collaborator not found 
			throw new RuntimeException("Did not find Collaborator id - "+theId);
		}
		
	}

	@Override
	public CollaboratorDto save(CollaboratorDto theCollaboratorDto) {
		
		Collaborator save = CollaboratorRepository.save(theCollaboratorDto.convertToCollaborator());
        return save.convertToDto(); 
        
	}

	@Override
	public void deleteById(int theId) {
		if (CollaboratorRepository.existsById(theId)) {

			CollaboratorRepository.deleteById(theId);

        } else {
            throw new RuntimeException("Did not find Collaborator id - "+theId);
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

            throw new RuntimeException("Could not find a Coollaborator with id " + collaboratorDto.getId());
        }

    }



}
