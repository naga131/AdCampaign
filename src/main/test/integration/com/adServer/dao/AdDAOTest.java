package integration.com.adServer.dao;

import com.adServer.dao.AdDAO;
import com.adServer.model.Ad;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class AdDAOTest {
    AdDAO adDao;
    @Before
    public void setup(){
        adDao  = new AdDAO();
    }

    @Test
    public  void testCreateAd(){
        Ad ad = new Ad();
        ad.setPartnerId(34l);
        ad.setAddContent("Testing");
        ad.setDuration(60);
        Ad response = adDao.create(ad);
        assert response.equals(ad);
    }

    @Test
    public void testAdList(){
        List<Ad> adList = adDao.list();
        assert adList.get(0).getPartnerId() == 101;
    }


    @Test
    public void testAdGet(){
        Ad ad = adDao.get(201l);
        assert ad.getAddContent().equals("Russ");
    }

    @Test
    public void testGetNull(){
        Ad ad = adDao.get(987l);
        assert ad == null;
    }


}
