import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    static boolean instantiated = false;
    static Controller instance = null;

    private Scanner sc = new Scanner(System.in);
    public List<Persona> personas = new ArrayList<Persona>();
    public List<Inmueble> inmuebles = new ArrayList<Inmueble>();

    private Controller() {
        instantiated = true;
    }

    public static Controller getInstance() {
        if (instantiated) {
            return instance;
        }
        Controller.instantiated = true;
        Controller.instance = new Controller();
        return Controller.instance;
    }

    private Persona newPersona(String nombre, boolean esValido, String dni, int edad) {
        Persona newPersona = new Persona(nombre, esValido, dni, edad);
        personas.add(newPersona);
        return newPersona;
    }

    private Inmueble newInmueble(String direccion, int precio) {
        Inmueble newInmueble = new Inmueble(direccion, precio);
        this.inmuebles.add(newInmueble);
        return newInmueble;
    }

    private Inmueble updateInmueble(Inmueble old, Inmueble newInmueble) {
        if (inmuebles.contains(old)) {
            inmuebles.remove(old);
            inmuebles.add(newInmueble);
            return newInmueble;
        } else {
            System.out.println("El inmueble que desea modificar no existe");
            return old;
        }
    }

    private Persona selectPersona() {
        int option;
        if (!personas.isEmpty()) {
            for (int i = 0; i < personas.size(); i++) {
                System.out.println(i + ". " + personas.get(i).getNombre() + " " + personas.get(i).getDni());
            }

            option = sc.nextInt();
            sc.nextLine();
            try {
                return personas.get(option);
            } catch (Exception e) {
                return null;
            }
        } else {
            return null;
        }
    }

    private Inmueble selectInmueble() {
        int option;
        if (!inmuebles.isEmpty()) {
            for (int i = 0; i < inmuebles.size(); i++) {
                System.out.print(i + ". " + inmuebles.get(i).getDireccion());
                if (inmuebles.get(i).isActive) {
                    System.out.println(" ACTIVO");
                } else {
                    System.out.println(" INACTIVO");
                }
            }

            option = sc.nextInt();
            sc.nextLine();
            try {
                return inmuebles.get(option);
            } catch (Exception e) {
                return null;
            }
        } else {
            return null;
        }
    }

    public void makeMenu() {
        String asterisksBorder = "********************************";

        System.out.println(asterisksBorder);
        System.out.println("1. Registrar nuevo usuario");
        System.out.println("2. Registrar nuevo inmueble");
        System.out.println("3. Actualizar un inmueble");
        System.out.println("4. Dar de baja a un usuario");
        System.out.println("5. Dar de baja o activar un inmueble");
        System.out.println("6. Salir");
        System.out.println(asterisksBorder);
    }

    public Persona registerNewUser() {
        String nombre = "";
        boolean esValido = false;
        String dni = "";
        int edad = 0;

        System.out.print("\nNombre: ");
        nombre = sc.nextLine();

        System.out.print("\nEs un usuario valido para modificar inmuebles? Y/N ");
        String option = sc.nextLine().toUpperCase();
        if (option.equals("Y")) {
            esValido = true;
        } else {
            esValido = false;
        }

        System.out.print("\nIngrese documento: ");
        dni = sc.nextLine();

        System.out.print("\nIngrese edad: ");
        edad = sc.nextInt();
        sc.nextLine();
        Persona newPersona = newPersona(nombre, esValido, dni, edad);
        return newPersona;
    }

    public Inmueble registerNewInmueble() {
        String direccion;
        int precio;

        System.out.println("Ingrese la drieccion:");
        direccion = sc.nextLine();

        System.out.println("Ingrese el precio del inmueble");
        precio = sc.nextInt();
        sc.nextLine();

        return newInmueble(direccion, precio);
    }

    public Inmueble updateInmueble() {
        Inmueble old = selectInmueble();
        Inmueble newInmueble = registerNewInmueble();
        return updateInmueble(old, newInmueble);
    }

    public void removeUser() {
        Persona persona = selectPersona();
        personas.remove(persona);
    }

    public void changeStateOfInmueble() {
        Inmueble inmueble = selectInmueble();
        int index = inmuebles.indexOf(inmueble);

        if (index != -1) {
            inmuebles.get(index).isActive = !inmuebles.get(index).isActive;
        }
    }
}
