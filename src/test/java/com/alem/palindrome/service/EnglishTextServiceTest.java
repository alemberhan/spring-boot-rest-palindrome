package com.alem.palindrome.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.alem.palindrome.service.impl.EnglishTextServiceImpl;

/**
 * @author Alemberhan Getahun
 *
 */

@RunWith(SpringRunner.class)
public class EnglishTextServiceTest {
	@TestConfiguration
    static class EnglishTextServiceTestContextConfiguration {
  
        @Bean
        public EnglishTextService englishTextService() {
            return new EnglishTextServiceImpl();
        }
    }
 
    @Autowired
    private EnglishTextService englishTextService;
    
    @Test
    public void testIsValidEnglishWord() {
    	
    	assertTrue(englishTextService.isValidEnglishWord("Hello"));
    	assertFalse(englishTextService.isValidEnglishWord("alemberhan"));
    	assertFalse(englishTextService.isValidEnglishWord(""));
    }
}
