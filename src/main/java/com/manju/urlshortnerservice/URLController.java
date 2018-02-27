package com.manju.urlshortnerservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class URLController {

	@Autowired
	URLService urlService;
	
	@RequestMapping(value = "/")
	public String welcomeMessege() {
		return "Greetings from manju";
	}
	
	@RequestMapping(value = "/shortenURL", method = RequestMethod.POST)
	public String returnShortURL(@RequestBody RequestResource reqr) {
		return  urlService.getShortURL(reqr);
	}
	
	@RequestMapping(value = "/{shortURLid}", method = RequestMethod.GET)
	public ResponseEntity redirecting(@PathVariable("shortURLid") String shortURL) {
		String originalURL = urlService.getOriginalURl(shortURL);
		if(originalURL == null) {
			return ResponseEntity.badRequest().body("please provide valid URL");
		}
		return ResponseEntity.status(302).header("location", originalURL).build();
	}
}
