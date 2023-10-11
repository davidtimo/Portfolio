import java.util.*;
//2540122773 - David Timothy
public class Main {

    static Vector<Ticket> tickets = new Vector<>();

    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();


    public static void addData(){
        String newName;
        String newGender;
        int newTicket;

        do{

            System.out.print("Input Name: ");
            newName = sc.nextLine();

        }while(newName.length() < 3 || newName.length() > 50);

        do{

            System.out.print("Input Gender: ");
            newGender = sc.nextLine();

        }while(!newGender.equals("Female") && !newGender.equals("Male"));

        do{

            System.out.print("Input Ticket Quantity: ");
            newTicket = sc.nextInt();

        }while(newTicket < 1);

        StringBuilder bu = new StringBuilder(5);
        for (int i = 0; i < 5; i++) {
            int randInt = 65 + (int)(rand.nextFloat() * (90 - 65 + 1));
            bu.append((char)randInt);
        }

        Ticket ticket = new Ticket();
        ticket.setId(bu.toString());
        ticket.setPrice(500000*newTicket);
        ticket.setTixPay("Waiting");
        ticket.setGender(newGender);
        ticket.setName(newName);
        ticket.setTix(newTicket);
        System.out.println("Ticket added " + ticket.getId());
        System.out.println();
        tickets.add(ticket);

    }

    public static void updateData(){
        String tbs;
        if(tickets.isEmpty()) {
            System.out.println("There is no data to update\n");
        }
        else {
            do {
                System.out.print("Input the ID to update its status: ");
                tbs = sc.nextLine();
            } while (tbs.isEmpty());

            for (int i = 0; i < tickets.size(); i++) {
                if (tickets.get(i).getId().equals(tbs)) {
                    tickets.get(i).setTixPay("Success");
                    System.out.println("Ticket's status successfully changed!\n");
                    return;
                }
            }
            System.out.println("Data not found!\n");
        }
    }

    public static void cancel(){
        if(tickets.isEmpty()) {
            System.out.println("There is no data to delete\n");
        }
        else {
            String tbs;
            do {
                System.out.print("Input the ID: ");
                tbs = sc.nextLine();
            } while (tbs.isEmpty());

            for (int i = 0; i < tickets.size(); i++) {
                if (tickets.get(i).getId().equals(tbs)) {
                    System.out.println(tickets.get(i).getId());
                    tickets.remove(i);
                    System.out.println("The ticket ID " + tbs + " has been Deleted\n");
                    return;
                }
            }
            System.out.println("Data not found!\n");
        }
    }

    public static void print(){
        if(tickets.isEmpty()) {
            System.out.println("There is no printable data\n");
        }
        else {
            List<Ticket> ticketList = new ArrayList<>(tickets.stream().toList());
            ticketList.sort(Comparator.comparing(Ticket::getId));
            System.out.printf("%-7s %-15s %-10s %-10s %-10s %-10s\n", "ID", "Name", "Gender", "Quantity", "Total", "Payment");
            //id name gender qty price status

            for (int i = 0; i < tickets.size(); i++) {
                System.out.printf("%-7s %-15s %-10s %-10s %-10s %-10s\n", ticketList.get(i).getId(),
                        ticketList.get(i).getName(), ticketList.get(i).getGender(), ticketList.get(i).getTix(),
                        ticketList.get(i).getPrice(), ticketList.get(i).getTixPay());
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int scan;

        do{
            System.out.println("1. Add data\n2. Update data\n3. Cancel transaction\n4. Print all tickets\n5. Exit");

            do{

                try{
                    System.out.print("Choice: ");
                    scan = sc.nextInt();
                    sc.nextLine();
                } catch(Exception e){

                    scan = 0;
                    System.out.println("Please input the right choice");

                }

            } while(scan < 1 || scan > 5);

            switch(scan){

                case 1:
                    addData();
                    break;

                case 2:
                    updateData();
                    break;

                case 3:
                    cancel();
                    break;

                case 4:
                    print();
                    break;

                case 5:
                    System.out.println("Thank you for using my app");
                    break;

            }
        }while(scan != 5);

    }
}
