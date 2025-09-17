import DAO.CarDAO;
import DAO.CustomerDAO;
import DAO.RentalContractDAO;

import model.Car;
import model.Customer;
import model.RentalContract;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // DAO-objekter
        CustomerDAO customerDAO = new CustomerDAO();
        CarDAO carDAO = new CarDAO();
        RentalContractDAO contractDAO = new RentalContractDAO();

        boolean running = true;

        while (running) {
            System.out.println("\n=== Kailua CarRental ===");
            System.out.println("1. Kunder");
            System.out.println("2. Biler");
            System.out.println("3. Lejekontrakter");
            System.out.println("0. Afslut");
            System.out.print("Vælg: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // fanger newline

            switch (choice) {
                case 1:
                    customerMenu(scanner, customerDAO);
                    break;
                case 2:
                    carMenu(scanner, carDAO);
                    break;
                case 3:
                    contractMenu(scanner, contractDAO);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Ugyldigt valg!");
                    break;
            }
        }

        scanner.close();
        System.out.println("Program afsluttet.");
    }

    // =======================
    // Kunde-menu
    // =======================
    private static void customerMenu(Scanner scanner, CustomerDAO dao) {
        System.out.println("\n--- Kunder ---");
        System.out.println("1. Opret kunde");
        System.out.println("2. Vis alle kunder");
        System.out.println("0. Tilbage");
        System.out.print("Vælg: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Navn: ");
                String name = scanner.nextLine();
                System.out.print("Adresse: ");
                String address = scanner.nextLine();
                System.out.print("Postnummer: ");
                String zip = scanner.nextLine();
                System.out.print("By: ");
                String city = scanner.nextLine();
                System.out.print("Mobil: ");
                String mobile = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.print("Kørekort nr.: ");
                String license = scanner.nextLine();

                Customer c = new Customer();
                c.setName(name);
                c.setAddress(address);
                c.setZip(zip);
                c.setCity(city);
                c.setMobilePhone(mobile);
                c.setEmail(email);
                c.setDriverLicenseNumber(license);

                dao.addCustomer(c); // kræver implementering i DAO
                System.out.println("Kunde oprettet!");
                break;

            case 2:
                dao.getAllCustomers(); // kræver implementering
                System.out.println("Alle kunder hentet (se output i DAO).");
                break;

            case 0:
                // tilbage
                break;

            default:
                System.out.println("Ugyldigt valg!");
                break;
        }
    }

    // =======================
    // Bil-menu
    // =======================
    private static void carMenu(Scanner scanner, CarDAO dao) {
        System.out.println("\n--- Biler ---");
        System.out.println("1. Vis alle biler");
        System.out.println("0. Tilbage");
        System.out.print("Vælg: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                dao.getAllCars(); // kræver implementering
                System.out.println("Alle biler hentet (se output i DAO).");
                break;

            case 0:
                // tilbage
                break;

            default:
                System.out.println("Ugyldigt valg!");
                break;
        }
    }

    // =======================
    // Kontrakt-menu
    // =======================
    private static void contractMenu(Scanner scanner, RentalContractDAO dao) {
        System.out.println("\n--- Lejekontrakter ---");
        System.out.println("1. Vis alle kontrakter");
        System.out.println("0. Tilbage");
        System.out.print("Vælg: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                dao.getAllRentalContracts(); // kræver implementering
                System.out.println("Alle kontrakter hentet (se output i DAO).");
                break;

            case 0:
                // tilbage
                break;

            default:
                System.out.println("Ugyldigt valg!");
                break;
        }
    }
}
