package com.alem.palindrome.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alem.palindrome.controller.EnglishTextController;

import net.sf.extjwnl.JWNLException;
import net.sf.extjwnl.data.IndexWord;
import net.sf.extjwnl.data.POS;
import net.sf.extjwnl.dictionary.Dictionary;

@Service
public class EnglishTextService {
	
	private final static Logger logger = LoggerFactory.getLogger(EnglishTextService.class);

	public boolean isValidEnglishWord(String word) {
		try {
			Dictionary d = Dictionary.getDefaultResourceInstance();
			IndexWord index = d.lookupIndexWord(POS.NOUN, word);
			if (index == null) {
				// check if the word is ADJECTIVE
				index = d.lookupIndexWord(POS.ADJECTIVE, word);

				if (index == null) {
					// check if the word is ADVERB
					index = d.lookupIndexWord(POS.ADVERB, word);

					if (index == null) {
						// check if the word is VERB
						index = d.lookupIndexWord(POS.VERB, word);
					}
				}
			}
			logger.debug("Word: " + word + " IndexWord: " + index);
			return (index != null);
		} catch (JWNLException e) {
			logger.error("ERROR IN LOOKING UP WORDS. " + e.getMessage());
		}

		return false;
	}
}
