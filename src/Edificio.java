import java.util.List;

public class Edificio extends Inmueble {

    private List<Piso> pisos;

    public Edificio(String direccion, int precio) {
        super(direccion, precio);
    }

    public List<Piso> getLocales() {
        return  this.pisos;
    }

    public void addLocal(Piso local) {
        this.pisos.add(local);
    }

    public void removeLocal(Piso local) {
        this.pisos.remove(local);
    }
}
