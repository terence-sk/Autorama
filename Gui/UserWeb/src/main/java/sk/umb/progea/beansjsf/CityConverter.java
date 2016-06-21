package sk.umb.progea.beansjsf;

import sk.umb.progea.autorama.sprava.service.CityService;
import sk.umb.progea.autorama.sprava.so.CitySo;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Created by msvon on 11-May-16.
 */
@ManagedBean
@RequestScoped
public class CityConverter implements Converter {

    @EJB
    CityService cityService;

    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return cityService.getByName(value);
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) {
        CitySo c = cityService.getById((Long)value);
        return c.getName();
    }

}