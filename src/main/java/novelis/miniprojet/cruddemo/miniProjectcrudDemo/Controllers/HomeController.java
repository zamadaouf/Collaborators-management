package novelis.miniprojet.cruddemo.miniProjectcrudDemo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import novelis.miniprojet.cruddemo.miniProjectcrudDemo.service.CollaboratorService;

@Controller
public class HomeController {
	
	@Autowired
	CollaboratorService collaboratorService;
	
	
	
	public HomeController(CollaboratorService collaboratorService) {
		this.collaboratorService = collaboratorService;
	}

	@RequestMapping("/Collabs")
	public String showCollabs() {
		return "collaboratorsList";
	}
	
	@RequestMapping("/Collab/{id}")
	public String showSpecificCollab(@PathVariable int id) {
		return "informations";
	}
	

}
