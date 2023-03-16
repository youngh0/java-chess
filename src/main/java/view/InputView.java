package view;

import java.util.Scanner;

public class InputView {

    private final Scanner SCANNER = new Scanner(System.in);

    public GameCommand requestGameStartCommand() {
        return GameCommand.from(SCANNER.nextLine());
    }
}
