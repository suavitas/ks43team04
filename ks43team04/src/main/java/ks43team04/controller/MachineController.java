
package ks43team04.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ks43team04.dto.MuinMachienSpec;
import ks43team04.dto.MuinMachine;
import ks43team04.service.LaundryService;
import ks43team04.service.MachineService;
import ks43team04.service.YeyakService;

@Controller
@RequestMapping("/admin")
public class MachineController {

	private final LaundryService laundryService;
	private final YeyakService yeyakService;
	private final MachineService machineService;

	public MachineController(MachineService machineService, LaundryService laundryService, YeyakService yeyakService) {
		this.laundryService = laundryService;
		this.yeyakService = yeyakService;
		this.machineService = machineService;

	}

	@GetMapping("/machine/machine")
	public String muinYeyak(Model model) {
		List<MuinMachine> muinMachineList = yeyakService.muinMachineList();

		System.out.println(muinMachineList);

		model.addAttribute("muinMachineList", muinMachineList);

		return "/admin/machine/machine";
	}

	/* 전 매장 장비 스팩 */

	@GetMapping("/machine/machineState")
	public String machineState(Model model) {

		List<MuinMachienSpec> MachineSpecList = laundryService.machineSpecList();
		model.addAttribute("MachineSpecList", MachineSpecList);
		System.out.println("______MachineSpecList_______" + MachineSpecList);
		return "/admin/machine/machineState";
	}

	/* 전 매장 장비 수정을 위해 정보를 불러오는 컨트롤러 */
	@GetMapping("/machine/changeMachineState")
	public String machineStateChange(@RequestParam(name = "MachineCategory", required = false) String MachineCategory,
			@RequestParam(name = "MachineRelease", required = false) String MachineRelease,
			@RequestParam(name = "MachineLimit", required = false) String MachineLimit,
			@RequestParam(name = "MachineMotor", required = false) String MachineMotor,
			@RequestParam(name = "MachineEnergy", required = false) String MachineEnergy,
			@RequestParam(name = "MachineCourse", required = false) String MachineCourse,
			@RequestParam(name = "MachineRemoval", required = false) String MachineRemoval,
			@RequestParam(name = "MachineTimer", required = false) String MachineTimer,
			@RequestParam(name = "MachineSafety", required = false) String MachineSafety,
			@RequestParam(name = "MachineSkill", required = false) String MachineSkill,
			@RequestParam(name = "MachineControl", required = false) String MachineControl,
			@RequestParam(name = "MachineManagement", required = false) String MachineManagement,
			@RequestParam(name = "MachineDisplay", required = false) String MachineDisplay,
			@RequestParam(name = "MachinePower", required = false) String MachinePower,
			@RequestParam(name = "MachineSpace", required = false) String MachineSpace,
			@RequestParam(name = "MachineColor", required = false) String MachineColor,
			@RequestParam(name = "MachineSize", required = false) String MachineSize,
			@RequestParam(name = "MachineAs", required = false) String MachineAs,
			@RequestParam(name = "MachineDoor", required = false) String MachineDoor,
			@RequestParam(name = "RegistTime", required = false) String RegistTime,
			@RequestParam(name = "MachineSpecCode", required = false) String MachineSpecCode, Model model) {

		model.addAttribute("MachineCategory", MachineCategory);
		model.addAttribute("MachineLimit", MachineLimit);
		model.addAttribute("MachineMotor", MachineMotor);
		model.addAttribute("MachineEnergy", MachineEnergy);
		model.addAttribute("MachineCourse", MachineCourse);
		model.addAttribute("MachineRemoval", MachineRemoval);
		model.addAttribute("MachineTimer", MachineTimer);
		model.addAttribute("MachineSafety", MachineSafety);
		model.addAttribute("MachineSkill", MachineSkill);
		model.addAttribute("MachineManagement", MachineManagement);
		model.addAttribute("MachineDisplay", MachineDisplay);
		model.addAttribute("MachinePower", MachinePower);
		model.addAttribute("MachineColor", MachineColor);
		model.addAttribute("MachineSpace", MachineSpace);
		model.addAttribute("MachineSize", MachineSize);
		model.addAttribute("MachineAs", MachineAs);
		model.addAttribute("MachineDoor", MachineDoor);
		model.addAttribute("RegistTime", RegistTime);
		model.addAttribute("MachineRelease", MachineRelease);
		model.addAttribute("MachineControl", MachineControl);
		model.addAttribute("MachineSpecCode", MachineSpecCode);

		System.out.println("____장비 스팩을 수정하기 위해서 정보를 받아왔습니다____" + model);
		System.out.println("____MachineSpecCode____" + MachineSpecCode);

		return "/admin/machine/changeMachineState";
	}

	/* 전체 장비 스팩 수정 쿼리 실행 */
	@PostMapping("/machine/changeMachineState")
	@ResponseBody
	public String modifyMachienSpec(MuinMachienSpec MuinMachienSpec) {

		machineService.modifyMachienSpec(MuinMachienSpec);
		System.out.println("________전체 장비 스팩 수정를 실행합니다._________" + MuinMachienSpec);
		return "/admin/machine/machineState";
	}

	/* 전체 장비 스팩 추가 화면으로 전환 실행 */
	@GetMapping("/machine/addMachineState")
	public String addMachienSpec() {
		return "/admin/machine/addMachineState";
	}

	/* 전체 장비 스팩 추가 쿼리 실행 */
	@PostMapping("/machine/addMachineState")
	@ResponseBody
	public String addMachienSpec(MuinMachienSpec muinMachienSpec) {

		machineService.addMachienSpec(muinMachienSpec);
		System.out.println("______전체 장비 스팩 추가를 실행합니다._________" + muinMachienSpec);
		return "/admin/machine/machineState";
	}

	/* 전체 장비 스팩 삭제 화면으로 전환 실행 */
	@GetMapping("/machine/removeMachineState")
	public String removeMachienSpec(@RequestParam(name = "MachineCategory", required = false) String MachineCategory,
			@RequestParam(name = "MachineRelease", required = false) String MachineRelease,
			@RequestParam(name = "MachineLimit", required = false) String MachineLimit,
			@RequestParam(name = "MachineMotor", required = false) String MachineMotor,
			@RequestParam(name = "MachineEnergy", required = false) String MachineEnergy,
			@RequestParam(name = "MachineCourse", required = false) String MachineCourse,
			@RequestParam(name = "MachineRemoval", required = false) String MachineRemoval,
			@RequestParam(name = "MachineTimer", required = false) String MachineTimer,
			@RequestParam(name = "MachineSafety", required = false) String MachineSafety,
			@RequestParam(name = "MachineSkill", required = false) String MachineSkill,
			@RequestParam(name = "MachineControl", required = false) String MachineControl,
			@RequestParam(name = "MachineManagement", required = false) String MachineManagement,
			@RequestParam(name = "MachineDisplay", required = false) String MachineDisplay,
			@RequestParam(name = "MachinePower", required = false) String MachinePower,
			@RequestParam(name = "MachineSpace", required = false) String MachineSpace,
			@RequestParam(name = "MachineColor", required = false) String MachineColor,
			@RequestParam(name = "MachineSize", required = false) String MachineSize,
			@RequestParam(name = "MachineAs", required = false) String MachineAs,
			@RequestParam(name = "MachineDoor", required = false) String MachineDoor,
			@RequestParam(name = "RegistTime", required = false) String RegistTime,
			@RequestParam(name = "MachineSpecCode", required = false) String MachineSpecCode, Model model) {

		model.addAttribute("MachineCategory", MachineCategory);
		model.addAttribute("MachineLimit", MachineLimit);
		model.addAttribute("MachineMotor", MachineMotor);
		model.addAttribute("MachineEnergy", MachineEnergy);
		model.addAttribute("MachineCourse", MachineCourse);
		model.addAttribute("MachineRemoval", MachineRemoval);
		model.addAttribute("MachineTimer", MachineTimer);
		model.addAttribute("MachineSafety", MachineSafety);
		model.addAttribute("MachineSkill", MachineSkill);
		model.addAttribute("MachineManagement", MachineManagement);
		model.addAttribute("MachineDisplay", MachineDisplay);
		model.addAttribute("MachinePower", MachinePower);
		model.addAttribute("MachineColor", MachineColor);
		model.addAttribute("MachineSpace", MachineSpace);
		model.addAttribute("MachineSize", MachineSize);
		model.addAttribute("MachineAs", MachineAs);
		model.addAttribute("MachineDoor", MachineDoor);
		model.addAttribute("RegistTime", RegistTime);
		model.addAttribute("MachineRelease", MachineRelease);
		model.addAttribute("MachineControl", MachineControl);
		model.addAttribute("MachineSpecCode", MachineSpecCode);

		System.out.println("____장비 스팩을 삭제하기 위해서 정보를 받아왔습니다____" + model);
		System.out.println("____MachineSpecCode____" + MachineSpecCode);
		return "/admin/machine/removeMachineState";
	}

	/* 전체 장비 스팩 삭제 쿼리 실행 */
	@PostMapping("/machine/removeMachineState")
	@ResponseBody
	public String removeMachienSpec(String MachineSpecCode) {

		machineService.removeMachienSpec(MachineSpecCode);
		System.out.println("______전체 장비 스팩 삭제를 실행합니다._________" + MachineSpecCode);
		return "/admin/machine/machineState";
	}

}
