package sk.umb.progea.autorama.sprava.service.impl;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import sk.umb.progea.autorama.advertisement.domain.Advertisement;
import sk.umb.progea.autorama.base.service.impl.BaseServiceImplIT;
import sk.umb.progea.autorama.sprava.service.AdService;
import sk.umb.progea.autorama.sprava.so.AdvertisementSo;

import javax.naming.NamingException;
import java.util.List;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by msvon on 23-Apr-16.
 */
public class AdServiceImplIT extends BaseServiceImplIT {

    @BeforeClass
    public static void setUpClass() throws Exception {
        startContainer();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        stopContainer();
    }

    @Test
    public void testGetAllFromDb() throws NamingException {
        // TODO Na zaklade tohto spravit vlastne testy
        AdService adService = lookupBy(AdService.class);
        List<AdvertisementSo> adList = adService.getAll();
        assertNotNull(adList);
    }

}
