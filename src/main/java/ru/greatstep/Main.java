package ru.greatstep;

import static ru.greatstep.util.Constants.HELLO;

import java.util.Scanner;
import ru.greatstep.service.NameService;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(HELLO);
        var input = scanner.nextLine();

        while (!input.equals("exit")) {
            System.out.println(NameService.addName(input));
            System.out.println(HELLO);
            input = scanner.nextLine();
        }
    }

}
