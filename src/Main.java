import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Controller mainController = Controller.getInstance();
        int option = 0;

        while (option != 6) {
            option = 0;
            while (option == 0) {
                System.out.println("Selecciona una opcion: ");
                mainController.makeMenu();
                option = sc.nextInt();
                sc.nextLine();
            }

            switch (option) {
                case 1:
                    mainController.registerNewUser();
                    break;

                case 2:
                    mainController.registerNewInmueble();
                    break;

                case 3:
                    mainController.updateInmueble();
                    break;

                case 4:
                    mainController.removeUser();
                    break;

                case 5:
                    mainController.changeStateOfInmueble();
                    break;
            }
        }
    }
}
