package novelis.miniprojet.cruddemo.miniProjectcrudDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import novelis.miniprojet.cruddemo.miniProjectcrudDemo.dto.CollaboratorDto;

public interface CollaboratorRepository extends JpaRepository<CollaboratorDto, Integer>{

}
