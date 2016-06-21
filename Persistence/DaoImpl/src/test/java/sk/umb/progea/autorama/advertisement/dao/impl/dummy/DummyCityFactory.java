package sk.umb.progea.autorama.advertisement.dao.impl.dummy;

import sk.umb.progea.autorama.advertisement.domain.City;

/**
 * Created by msvon on 25-Mar-16.
 */
public class DummyCityFactory {

    public static City generateCity(boolean createCounty){
        City c = new City();
        c.setName("Banska Bystrica");
        // NEPOUZIVAT TYMTO SPOSOBOM V CountyDaoImplTest
        // POTOM SA DO DB ULOZI UZIVATEL 2x A TEST NEPREJDE
        if(createCounty)
            c.setCounty(DummyCountyFactory.generateCounty());
        return c;
    }

}
