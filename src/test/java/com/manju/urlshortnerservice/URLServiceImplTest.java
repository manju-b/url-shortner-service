package com.manju.urlshortnerservice;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

import org.apache.commons.validator.routines.UrlValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class URLServiceImplTest {

	@InjectMocks
	URLServiceImpl service;
	
	URL url;
	
	@Mock
	URLRepository urlRepository;
	@Mock
	UrlValidator urlvalidator;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetShortURLWith_InValidInput() {
		RequestResource reqR = new RequestResource();
		reqR.setOriginalURL("www.facebook.com/");
		Assert.assertEquals("Please provide valid URL", service.getShortURL(reqR));
	}
	
	@Test
	public void testGetShortURLWith_ValidInput() {
		RequestResource reqR = new RequestResource();
		reqR.setOriginalURL("https://www.facebook.com/");
		when(urlvalidator.isValid("https://www.facebook.com/")).thenReturn(true);
		when(urlRepository.findOne(reqR.getOriginalURL())).thenReturn(null);
		String result = service.getShortURL(reqR);
		Assert.assertNotNull(result);
		Assert.assertTrue(result.contains("http://localhost:8080/"));
	}
	
	@Test
	public void testGetOriginalURLWith_ValidInput() {
		url = new URL();
		url.setShortenURL("rt34Rd1");
		url.setOriginalURL("https://www.facebook.com/");
		when(urlRepository.findOne("rt34Rd1")).thenReturn(url);
		Assert.assertEquals("https://www.facebook.com/", service.getOriginalURl("rt34Rd1"));
	}
	
	@Test
	public void testGetOriginalURLWith_InValidInput() {
		when(urlRepository.findOne("gh45Bs2")).thenReturn(null);
		Assert.assertEquals(null, service.getOriginalURl("gh45Bs2"));
	}
	
}
