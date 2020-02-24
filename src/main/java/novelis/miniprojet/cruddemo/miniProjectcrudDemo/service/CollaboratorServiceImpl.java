package novelis.miniprojet.cruddemo.miniProjectcrudDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import novelis.miniprojet.cruddemo.miniProjectcrudDemo.dao.CollaboratorRepository;
import novelis.miniprojet.cruddemo.miniProjectcrudDemo.dto.CollaboratorDto;

@Service
public class CollaboratorServiceImpl implements CollaboratorService {

private CollaboratorRepository CollaboratorRepository;
	
	@Autowired
	public CollaboratorServiceImpl(CollaboratorRepository theCollaboratorRepository) {
		CollaboratorRepository = theCollaboratorRepository;
	}

	@Override
	public List<CollaboratorDto> findAll() {
		
		return CollaboratorRepository.findAll();
	}
	
	private void mapperCollab() {
		// TODO Auto-generated method stub

	}

	@Override
	public CollaboratorDto findById(int theId) {
		
		Optional<CollaboratorDto> result = CollaboratorRepository.findById(theId);
		
		CollaboratorDto theCollaborator = null;
		
		if(result.isPresent()) {
			theCollaborator = result.get();
		}else {
			// Collaborator not found 
			throw new RuntimeException("Did not find Collaborator id - "+theId);
		}
		
		return theCollaborator;
	}

	@Override
	public void save(CollaboratorDto theCollaborator) {
		CollaboratorRepository.save(theCollaborator);
	}

	@Override
	public void deleteById(int theId) {
		CollaboratorRepository.deleteById(theId);
	}

}
