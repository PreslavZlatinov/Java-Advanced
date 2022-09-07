package Lab;

import java.util.*;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> guests = new TreeSet<>();

        String guest = scanner.nextLine();

        while (!guest.equals("PARTY")){

            guests.add(guest);

            guest = scanner.nextLine();
        }

        String guestsOnParty = scanner.nextLine();

        while(!guestsOnParty.equals("END")){
            guests.remove(guestsOnParty);

            guestsOnParty = scanner.nextLine();
        }

        System.out.println(guests.size());

        for (String s : guests) {
            System.out.println(s);
        }

    }
}
