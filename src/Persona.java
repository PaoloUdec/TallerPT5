public class Persona {
    private String nombre;
    private boolean esValido;
    private String dni;
    private int edad;

    public Persona(String nombre, boolean esValido, String dni, int edad) {
        this.nombre = nombre;
        this.esValido = esValido;
        this.dni = dni;
        this.edad = edad;
    }

    public void setEsValido(boolean esValido) {
        this.esValido = esValido;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isEsValido() {
        return esValido;
    }

    public String getDni() {
        return dni;
    }

    public int getEdad() {
        return edad;
    }
}
