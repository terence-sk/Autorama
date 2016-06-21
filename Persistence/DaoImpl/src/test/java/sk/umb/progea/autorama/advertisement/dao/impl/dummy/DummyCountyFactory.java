package sk.umb.progea.autorama.advertisement.dao.impl.dummy;

import sk.umb.progea.autorama.advertisement.domain.County;

/**
 * Created by msvon on 25-Mar-16.
 */
public class DummyCountyFactory {

    public static County generateCounty(){
        County c = new County();
        c.setName("Banskobystricky kraj");
        return c;
    }

}
