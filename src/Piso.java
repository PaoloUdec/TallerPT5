import java.util.List;

public class Piso extends Inmueble {

    private List<Local> locales;

    public Piso(String direccion, int precio) {
        super(direccion, precio);
    }

    public List<Local> getLocales() {
        return  this.locales;
    }

    public void addLocal(Local local) {
        locales.add(local);
    }

    public void removeLocal(Local local) {
        locales.remove(local);
    }
}
