package sk.umb.progea.autorama.sprava.so;

import java.io.Serializable;

/**
 * Created by msvon on 23-Apr-16.
 */
public class CountySo extends BaseSo implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
