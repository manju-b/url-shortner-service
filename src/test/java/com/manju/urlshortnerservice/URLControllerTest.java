package com.manju.urlshortnerservice;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Assert;

@RunWith(SpringRunner.class)
public class URLControllerTest {
	
	@InjectMocks
	URLController urlController;
	
	@Mock
	URLService urlService;
	
	@Test
	public void testReturnShortURLWith_ValidURL() {
		RequestResource reqR = new RequestResource();
		reqR.setOriginalURL("https://www.facebook.com/");
		when(urlService.getShortURL(reqR)).thenReturn("http://localhost:8080/gh34Ch6");
		Assert.assertEquals("http://localhost:8080/gh34Ch6", urlController.returnShortURL(reqR));
	}
	
	@Test
	public void testReturnShortURLWith_InValidURL() {
		RequestResource reqR = new RequestResource();
		reqR.setOriginalURL("www.facebook.com/");
		when(urlService.getShortURL(reqR)).thenReturn("Please provide valid URL");
		Assert.assertEquals("Please provide valid URL", urlController.returnShortURL(reqR));
	}
	
	@Test
	public void testRedirectingWith_ValidURL() {
		URL url = new URL();
		url.setShortenURL("sEA4tP1");
		url.setOriginalURL("https://www.facebook.com/");
		when(urlService.getOriginalURl(url.getShortenURL())).thenReturn(url.getOriginalURL());
		ResponseEntity re = urlController.redirecting("sEA4tP1");
		Assert.assertThat(re.getStatusCode(), is(HttpStatus.FOUND));
	}
	
	@Test
	public void testRedirectingWith_InValidURL() {
		URL url = new URL();
		url.setShortenURL("56fgH5u");
		url.setOriginalURL("https://www.facebook.com/");
		when(urlService.getOriginalURl(url.getShortenURL())).thenReturn(null);
		ResponseEntity re = urlController.redirecting(url.getShortenURL());
		Assert.assertThat(re.getStatusCode(), is(HttpStatus.BAD_REQUEST));
	}
	
	
	
	
}
