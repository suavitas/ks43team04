
package ks43team04.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks43team04.dto.MuinMachienSpec;
import ks43team04.dto.MuinMachine;
import ks43team04.service.LaundryService;
import ks43team04.service.YeyakService;

@Controller
@RequestMapping("/admin")
public class MachineController {

	private final LaundryService laundryService;
	private final YeyakService yeyakService;

	public MachineController(LaundryService laundryService,YeyakService yeyakService) {
		this.laundryService = laundryService;
		this.yeyakService = yeyakService;

	}
	

	@GetMapping("/machine")
	public String muinYeyak(Model model) {
		List<MuinMachine> muinMachineList = yeyakService.muinMachineList();
		
		System.out.println(muinMachineList);
		
		model.addAttribute("muinMachineList", muinMachineList);
		
		return "/admin/machine";
	}
	
	
	

	/*전 매장 장비 스팩*/

	@GetMapping("/machineState")
	public String machineState(Model model) {

		List<MuinMachienSpec> MachineSpecList = laundryService.machineSpecList();
		model.addAttribute("MachineSpecList", MachineSpecList);
		return "admin/machineState";
		}
	
	/* 전 매장 장비 수정을 위해 정보를 불러오는 컨트롤러 */
	@GetMapping("/machineStateChange")
	public String machineStateChange(Model model) {

		
		List<MuinMachienSpec> MachineSpecList = laundryService.machineSpecList();
		model.addAttribute("MachineSpecList", MachineSpecList);
		return "admin/machineStateChange";
	}


	
}
