package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GuestService;
import com.javaex.vo.GuestVo;

@Controller
public class GuestbookController {

	@Autowired
	private GuestService guestService;

	@RequestMapping(value = "/addList", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("GuestbookControlller.list()");

		List<GuestVo> gList = guestService.exeList();

		model.addAttribute("gList", gList);

		return "addList";
	}

	// 추가
	@RequestMapping(value = "/insert", method = { RequestMethod.GET, RequestMethod.POST })
	public String insert(@ModelAttribute GuestVo guestVo) {
		System.out.println("GuestbookController.insert()");

		guestService.exeInsert(guestVo);

		return "redirect:/addList";
	}

	// 삭제폼
	@RequestMapping(value = "/deleteform", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteForm(@ModelAttribute(value = "no") int no, Model model) {
		System.out.println("GuestbookController.deleteForm()");

		model.addAttribute("no", no);

		return "deleteForm";
	}

	// 삭제
	@RequestMapping(value = "delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(GuestVo guestVo) {

		guestService.exeDelete(guestVo);

		return "redirect:/addList";
	}

}
