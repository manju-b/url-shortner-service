package com.manju.urlshortnerservice;

public interface URLService {

	String getShortURL(RequestResource reqr);
	String getOriginalURl(String originalURL);
	
}
