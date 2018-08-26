package com.alem.palindrome.controller;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alem.palindrome.bean.EnglishText;
import com.alem.palindrome.service.EnglishTextService;

/**
 * @author Alemberhan Getahun
 *
 */

@Controller
public class EnglishTextController {

	@Autowired
	EnglishTextService service;

	Set<EnglishText> texts = new HashSet<EnglishText>();
	private final static Logger logger = LoggerFactory.getLogger(EnglishTextController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {
		return "index";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String checkPalindrome(ModelMap model, @RequestParam("word") String word) {
		boolean isValidWord = service.isValidEnglishWord(word);
		logger.debug(word);
		if (!isValidWord) {
			model.put("errorMessage", "Invalid English word");
			model.put("texts", texts);
			return "index";
		}

		// Create a EnglishText object
		EnglishText text = new EnglishText(word);
		texts.add(text);

		model.put("text", text);
		model.put("texts", texts);
		return "index";
	}

}
