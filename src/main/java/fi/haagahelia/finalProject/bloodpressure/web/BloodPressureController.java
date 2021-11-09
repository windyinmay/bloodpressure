package fi.haagahelia.finalProject.bloodpressure.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.finalProject.bloodpressure.domain.BloodPressureRepository;

@Controller
public class BloodPressureController {
	
	@RequestMapping
	public @ResponseBody String hello() {
		return "Hello Spring";
	}
	
	@Autowired
	private BloodPressureRepository BPrepository;
	
	@GetMapping(value="/bloodpressurelist")
	public String BloodPressureList(Model model) {
		model.addAttribute("results", BPrepository.findAll());
		return "result-list";
	}
}
