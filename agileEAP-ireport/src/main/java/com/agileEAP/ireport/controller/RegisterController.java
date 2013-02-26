package com.agileEAP.ireport.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.agileEAP.ireport.entity.User;
import com.agileEAP.ireport.service.AccountService;
/**
 * 用户注册的Controller.
 * 
 * @author calvin
 */
@Controller
@RequestMapping(value = "/register")
public class RegisterController {

	@Autowired
	private AccountService accountService;

	@RequestMapping(method = RequestMethod.GET)
	public String registerForm() {
		return "account/register";
	}
	
	@RequestMapping(value="/register_old",method = RequestMethod.GET)
	public String register_old() {
		return "account/register_old";
	}
	
	@RequestMapping(value="/login_old", method = RequestMethod.GET)
	public String login_old() {
		return "account/login_old";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String register(@Valid User user, RedirectAttributes redirectAttributes) {
		accountService.registerUser(user);
		redirectAttributes.addFlashAttribute("username", user.getLoginName());
		return "redirect:/login";
	}

	/**
	 * Ajax请求校验loginName是否唯一。
	 */
	@RequestMapping(value = "checkLoginName")
	@ResponseBody
	public String checkLoginName(@RequestParam("loginName") String loginName) {
		if (accountService.findUserByLoginName(loginName) == null) {
			return "true";
		} else {
			return "false";
		}
	}
}
