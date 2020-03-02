package novelis.miniprojet.cruddemo.miniProjectcrudDemo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/Collabs")
	public String showCollabs() {
		return "collaboratorsList";
	}
	
	@RequestMapping("/Collab/{id}")
	public String showSpecificCollab(@PathVariable int id) {
		return "informations";
	}
}
