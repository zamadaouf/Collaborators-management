package novelis.miniprojet.cruddemo.miniProjectcrudDemo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import novelis.miniprojet.cruddemo.miniProjectcrudDemo.dao.CollaboratorRepository;
import novelis.miniprojet.cruddemo.miniProjectcrudDemo.entity.Collaborator;
import novelis.miniprojet.cruddemo.miniProjectcrudDemo.service.CollaboratorService;

@Controller
public class HomeController {
	
	@Autowired
	CollaboratorService collaboratorService;
	
	@Autowired
	CollaboratorRepository collaboratorRepository;
	
	
	public HomeController(CollaboratorService collaboratorService) {
		this.collaboratorService = collaboratorService;
	}

	@RequestMapping("/")
	public String goHome() {
		return "home";
	}
	
	@RequestMapping("/Collabs")
	public String showCollabs() {
		return "collaboratorsList";
	}
	
	@RequestMapping("/Collab/{id}")
	public ModelAndView showSpecificCollab(@PathVariable int id) {
		
		 ModelAndView modelAndView = new ModelAndView("informations");
		    modelAndView.addObject("id", id);
		
		return modelAndView;
	}
	
	@GetMapping("Collab/add")
    public String showAddForm() {
//		ModelAndView modelAndView = new ModelAndView("form");
//		return modelAndView;
		return "form";
    }
    	
	@GetMapping("Collab/edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		Collaborator collaborator = collaboratorRepository.findById(id)
			      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));    
		model.addAttribute("collaborator", collaborator);
		    return "update";
	}
	
	
	

}
