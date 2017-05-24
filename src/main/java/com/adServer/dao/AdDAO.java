package com.adServer.dao;

import com.adServer.model.Ad;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Component
public class AdDAO {

	// Dummy database. Initialize with some dummy values.
	private static List<Ad> ads;
	{
		ads = new ArrayList();
		ads.add(new Ad(101, "John",60));
		ads.add(new Ad(201, "Russ",60));
		ads.add(new Ad(301, "Kate",60));
		ads.add(new Ad(System.currentTimeMillis(), "Viral",60));
	}

	/**
	 * Returns list of ads from dummy database.
	 * 
	 * @return list of ads
	 */
	public List list() {
		return ads;
	}

	/**
	 * Return customer object for given id from dummy database. If customer is
	 * not found for id, returns null.
	 * 
	 * @param id
	 *            customer id
	 * @return customer object for given id
	 */
	public Ad get(Long id) {

		for (Ad c : ads) {
			if (c.getPartnerId().equals(id)) {
				return c;
			}
		}
		return null;
	}

	/**
	 * Create new ad in dummy database. Updates the id and insert new
	 * ad in list.
	 * 
	 * @param ad
	 *            Ad object
	 * @return ad object with updated id
	 */
	public Ad create(Ad ad, HttpServletResponse response) throws JsonProcessingException {
			ads.add(ad);
		return ad;
	}


}