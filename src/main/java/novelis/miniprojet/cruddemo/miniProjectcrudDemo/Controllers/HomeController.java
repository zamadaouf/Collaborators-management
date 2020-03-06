package novelis.miniprojet.cruddemo.miniProjectcrudDemo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import novelis.miniprojet.cruddemo.miniProjectcrudDemo.service.CollaboratorService;

@Controller
public class HomeController {
	
	@Autowired
	CollaboratorService collaboratorService;
	
	
	
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
	

}
