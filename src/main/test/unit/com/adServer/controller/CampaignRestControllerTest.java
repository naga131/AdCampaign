package unit.com.adServer.controller;

import com.adServer.controller.CampaignRestController;
import com.adServer.dao.AdDAO;
import com.adServer.model.Ad;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = com.adServer.controller.CampaignRestController.class)

public class CampaignRestControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @InjectMocks
    private CampaignRestController myLauncher = new CampaignRestController();

    @Mock
    private AdDAO adDAO;

    @InjectMocks
    private CampaignRestController campaignRestController;

    Ad ad;

   @Before
   public void init(){
       MockitoAnnotations.initMocks(this);
       mockMvc = MockMvcBuilders
               .standaloneSetup(campaignRestController)
               .build();
       AdDAO adDAO1 = new AdDAO();
       ad =new Ad();
       ad.setAddContent("Test");
       ad.setPartnerId(105l);
       ad.setDuration(60);
       adDAO1.list().add(ad);
   }

   @Test
    public void getAd() throws Exception {
       ResponseEntity responseEntity =  campaignRestController.getAd(101l);
      assert responseEntity.getStatusCode() == HttpStatus.NOT_FOUND;
      assert responseEntity.getBody().toString().equals("No Ad found for ID 101");
    }

}
