package com.manju.urlshortnerservice;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface URLRepository extends JpaRepository<URL, String> {
		
	URL findOneByOriginalURL(String originalURL);
	
}
