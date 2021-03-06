package com.alem.palindrome.controller;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

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

	Set<EnglishText> allTexts = new TreeSet<EnglishText>();
	private final static Logger logger = LoggerFactory.getLogger(EnglishTextController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {
		return "index";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String checkPalindrome(ModelMap model, @RequestParam("word") String word) {

		String[] inputs = word.split(",");
		Set<String> errorMessage = new HashSet<String>();
		Set<EnglishText> texts = new HashSet<EnglishText>();

		for (String input : inputs) {
			boolean isValidWord = service.isValidEnglishWord(input);
			logger.debug("Input: " + input);
			if (!isValidWord) {
				errorMessage.add("Invalid English word. " + input);
			} else {
				// Create a EnglishText object
				EnglishText text = new EnglishText(input.trim());
				texts.add(text);
				allTexts.add(text);
			}
		}

		model.put("texts", texts);
		model.put("allTexts", allTexts);
		model.put("errorMessages", errorMessage);
		return "index";
	}

}
