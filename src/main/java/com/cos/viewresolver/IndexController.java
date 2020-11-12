package com.cos.viewresolver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // IoC

public class IndexController {

	@GetMapping({"", "/"})
	public String index(Model model) { // Model - DI (함수 파라미터에 넣기)
		
		String name = "cos";
		int num = 10;
		String password = "1234";
		model.addAttribute("name", name); // Key 값으로 name 들고감
		model.addAttribute("num", num); 
		model.addAttribute("password", password);
		
		// => /viewresolver/src/main/resource/templates/index.mustache → viewresolver 발동시 자동으로 찾아감
		return "index";
	}
	
	@GetMapping("/model/data")
	public String modelData(Model model) { // Model - DI
		Member member = Member.builder()
				.id(1)
				.username("hongcha")
				.phone("01012345678")
				.build();
		model.addAttribute("member", member);
		
		return "modelData";
	}
	
	@GetMapping("/model/array")
	public String modelArray(Model model) { // Model - DI
		Member member1 = Member.builder()
				.id(1)
				.username("hongcha")
				.phone("01012345678")
				.build();
		
		Member member2 = Member.builder()
				.id(2)
				.username("scone")
				.phone("01033337777")
				.build();
		
		List<Member> members = new ArrayList<>();
		members.add(member1);
		members.add(member2);		
		model.addAttribute("members", members);
		model.addAttribute("user", true);
		
		return "modelArray";
	}
	
	@GetMapping("/layout")
	public String layout() { // Model - DI
		
		return "layout";
	}

}
