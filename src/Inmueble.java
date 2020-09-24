public class Inmueble {
    private String direccion;
    private int precio;
    public boolean isActive;

    public Inmueble(String direccion, int precio) {
        this.direccion = direccion;
        this.precio = precio;
        this.isActive = true;
    }

    public void update(String direccion, int precio, boolean isActive) {
        this.direccion = direccion;
        this.precio = precio;
        this.isActive = isActive;
    }
    public int getPrecio() {
        return precio;
    }
    public String getDireccion() {
        return direccion;
    }
}
