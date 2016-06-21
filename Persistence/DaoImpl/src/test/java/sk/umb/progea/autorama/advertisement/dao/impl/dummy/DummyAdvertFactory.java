package sk.umb.progea.autorama.advertisement.dao.impl.dummy;

import sk.umb.progea.autorama.advertisement.domain.Advertisement;

import java.util.Date;

/**
 * Created by msvon on 20-Mar-16.
 */
public class DummyAdvertFactory {

    public static Advertisement generateAdvert() {
        Advertisement a = new Advertisement();
        a.setBrand("Mercedes-Benz");
        a.setColor("White");
        a.setDateStart(new Date(System.currentTimeMillis()));

        return a;
    }


}
