package hh.finalproject.bloodpressure.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.finalproject.bloodpressure.domain.BPRepository;
import hh.finalproject.bloodpressure.domain.BloodPressure;

@Controller
public class BloodPressureController {
	@RequestMapping("/hello")
	public @ResponseBody String Hello(@RequestParam(name= "firstname") String firstName, @RequestParam(name ="age") String age) {
		return "Hello "  + firstName + ", you are " + age + " right now.";
	}
	
	@Autowired
	private BPRepository bprepository;
	
	@RequestMapping(value="/bloodpressure")
	public String bloodPressureList(Model model) {
		model.addAttribute("bloodpressures", bprepository.findAll());
		return "results";
	}
	
	@RequestMapping(value="/add")
	public String addBP(Model model) {
		model.addAttribute("bloodpressure", new BloodPressure());
		return "add-bp";
	}
	
	@PostMapping(value = "/save")
	public String save(BloodPressure bloodpressure) {
		bprepository.save(bloodpressure);
		return "redirect:bloodpressure";
	}
	
	//Delete
	@GetMapping(value="/delete/{id}")
	public String deleteBP(@PathVariable("id") Long BPId, Model model) {
		bprepository.deleteById(BPId);
		return "redirect:../bloodpressure";
	}
}
