package com.adServer.controller;

import com.adServer.dao.AdDAO;
import com.adServer.model.Ad;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class CampaignRestController {

	
	@Autowired
	private AdDAO adDAO;

	
	@GetMapping("/ads")
	public List getAds() {
		return adDAO.list();
	}

	@GetMapping("/ad/{id}")
	public ResponseEntity getAd(@PathVariable("id") Long id) {

		Ad ad = adDAO.get(id);
		if (ad == null) {
			return new ResponseEntity("No Ad found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(ad, HttpStatus.OK);
	}

	@PostMapping(value = "/ad")
	public ResponseEntity createAd(@RequestBody Ad ad, HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for (Cookie cookie : cookies) {
              if(cookie.getName().equals(ad.getPartnerId().toString()))
              return new ResponseEntity("Partner Campaign is already active", HttpStatus.OK);;
			}
		}
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(ad);
		Cookie newCookie = new Cookie(ad.getPartnerId().toString(), json);
		newCookie.setMaxAge(ad.getDuration());
		adDAO.create(ad,response);
		response.addCookie(newCookie);

		return new ResponseEntity(ad, HttpStatus.OK);
	}


}