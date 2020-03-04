package novelis.miniprojet.cruddemo.miniProjectcrudDemo.service;

import java.util.List;

import novelis.miniprojet.cruddemo.miniProjectcrudDemo.dto.CollaboratorDto;


public interface CollaboratorService {
	
	public List<CollaboratorDto> findAll();
	
	public CollaboratorDto findById(int theID);
	
	public CollaboratorDto save(CollaboratorDto theCollaborator);
	
	public void deleteById(int theId);
	
	public CollaboratorDto updateCollaborator(CollaboratorDto collaboratorDto);


}
