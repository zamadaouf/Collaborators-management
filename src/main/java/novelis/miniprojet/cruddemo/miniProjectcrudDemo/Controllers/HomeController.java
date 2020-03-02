package novelis.miniprojet.cruddemo.miniProjectcrudDemo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String showCollabs() {
		return "collaboratorsList";
	}
}
