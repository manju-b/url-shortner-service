package com.manju.urlshortnerservice;

import java.net.MalformedURLException;
import java.nio.charset.MalformedInputException;
import java.util.Date;

import org.apache.commons.validator.routines.UrlValidator;
//import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class URLServiceImpl implements URLService {

	@Autowired
	URLRepository urlRepository;
	UrlValidator urlvalidator = new UrlValidator();
	
	 public String getShortURL(RequestResource reqr) {
			 if(urlvalidator.isValid(reqr.getOriginalURL())) {
				 if(urlRepository.findOne(reqr.getOriginalURL()) != null){
					 URL url = urlRepository.findOne(reqr.getOriginalURL());
					 return url.getShortenURL();
				 } else {
					 URL url = new URL();
					 url.setOriginalURL(reqr.getOriginalURL());
					 url.setShortenURL(RandomString.getRandomString());
					 url.setTimeStamp(new Date());
					 urlRepository.save(url);
					 return "http://localhost:8080/"+url.getShortenURL();
				 }
			 } else {
				 return "Please provide valid URL";
			 }
		 
		 
		 
		 
		 
	 }

	@Override
	public String getOriginalURl(String shortURL) {
		URL url = urlRepository.findOne(shortURL);
		if(url == null) {
			return null;
		}
		return url.getOriginalURL();
	}
}
