package novelis.miniprojet.cruddemo.miniProjectcrudDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import novelis.miniprojet.cruddemo.miniProjectcrudDemo.entity.Collaborator;

public interface CollaboratorRepository extends JpaRepository<Collaborator, Integer>, PagingAndSortingRepository<Collaborator, Integer>{

}
