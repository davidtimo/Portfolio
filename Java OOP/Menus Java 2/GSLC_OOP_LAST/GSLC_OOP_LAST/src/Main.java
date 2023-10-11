import java.util.Scanner;
import java.util.Vector;

public class Main{

    static Vector<Pembeli> vPembeli = new Vector<>();
    static Vector<Seller> vSeller = new Vector<>();

    static Scanner sc = new Scanner(System.in);



    public static class registerCustomer{

        static String username, nama, gender, password;

        public static void registMenuCustomer(){

            do{
                System.out.print("Masukkan username pembeli: ");
                sc.nextLine();
                username = sc.nextLine();
            } while (username.length() == 0);

            do{
                System.out.print("Masukkan nama pembeli: ");
                nama = sc.nextLine();
            } while (nama.length() == 0);

            do{
                System.out.print("Masukkan gender pembeli: ");
                gender = sc.nextLine();
            } while (!gender.equals("Wanita") && !gender.equals("Pria"));

            do{
                System.out.print("Masukkan password pembeli: ");
                password = sc.nextLine();
            } while (password.length() == 0);

            Pembeli input = new Pembeli (username, nama, gender, password);
            vPembeli.add(input);

        }

    }

    public static class registSeller{

        static String tempUsername;
        static String tempTokoName;
        static String tempPassword;
        static String tempType;
        static String tempDesc;

        public static void registMenuSeller(){

            do{

                System.out.println("Input Username: ");
                sc.nextLine();
                tempUsername = sc.nextLine();

            }while(tempUsername.length() == 0);

            do{

                System.out.println("Input Nama Toko: ");
                tempTokoName = sc.nextLine();

            }while(tempTokoName.length() == 0);

            do{

                System.out.println("Input Password: ");
                tempPassword = sc.nextLine();

            }while(tempPassword.length() == 0);

            String typeValid1 = "Elektronik";
            String typeValid2 = "Fashion";
            String typeValid3 = "Makanan & Minuman";

            do{

                System.out.println("Input Jenis Toko: ");
                tempType = sc.nextLine();

            }while(!tempType.equals(typeValid1) && !tempType.equals(typeValid2) && !tempType.equals(typeValid3));

            do{

                System.out.println("Input Deskripsi: ");
                tempDesc = sc.nextLine();

            }while(tempDesc.length() == 0);

            Seller input = new Seller(tempUsername, tempTokoName, tempPassword, tempType, tempDesc);
            vSeller.add(input);



        }

    }

    public static void Register() {

        int choice;
        do {
            System.out.println("Mau jadi seller atau customer\n1. Seller\n2. Customer\nPilih [1/2]: ");
            sc.nextLine();
            choice = sc.nextInt();
        }
        while(choice>2||choice<1);

        if(choice == 1) {
            registSeller.registMenuSeller();
        }
        else if(choice == 2){
            registerCustomer.registMenuCustomer();
        }
    }

    public static void mainMenuPembeli(){

        for(int i = 0; i < vSeller.size(); i++){

            System.out.printf("%-3d -- %-15s -- %-15s -- %-20s\n", i + 1, vSeller.get(i).getTokoName(), vSeller.get(i).getTokoType(), vSeller.get(i).getDesc());

        }

        String query;
        do{
            query = sc.nextLine();
        }while(!query.equals("logout"));

        mainMenu();

    }

    public static void mainMenuSeller(){

        System.out.println("Fitur masih dikembangkan\n");

        String query;
        do{
            query = sc.nextLine();
        }while(!query.equals("logout"));

        mainMenu();

    }

    public static void Login(){

        String username, password;

        do{

            System.out.printf("Input Username: ");
            username = sc.nextLine();

        }while(username.length() == 0);

        do{

            System.out.printf("Input password: ");
            password = sc.nextLine();

        }while(password.length() == 0);

//        do searching here

        for(int i = 0; i < vPembeli.size(); i++){

            if(vPembeli.get(i).getUsername().equals(username) && vPembeli.get(i).getPassword().equals(password)){
                mainMenuPembeli();
            }
            else if(vSeller.get(i).getUsername().equals(username) && vSeller.get(i).getPassword().equals(password)){
                mainMenuSeller();
            }

        }

    }

    public static void mainMenu(){

        int choice;

        do{
            do{
                System.out.println("1. Login");
                System.out.println("2. Register");
                System.out.println("3. Exit");
                choice = sc.nextInt();

            }while(choice < 1 || choice > 3);

            if(choice == 1){
                Login();
            }
            else if(choice == 2){
                Register();
            }
        }while(choice != 3);

        return;

    }

    public static void main(String[] args){
        mainMenu();
    }
}