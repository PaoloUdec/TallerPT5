import java.util.List;

public class Propietario extends Persona {

    private List<Inmueble> inmuebles;

    public Propietario(String nombre, boolean esValido, String dni, int edad) {
        super(nombre, esValido, dni, edad);
    }

    public List<Inmueble> getInmuebles() {
        return inmuebles;
    }

    public void addInmueble(Inmueble inmueble) {
        inmuebles.add(inmueble);
    }

    public void removeInmueble(Inmueble inmueble) {
        inmuebles.remove(inmueble);
    }
}
