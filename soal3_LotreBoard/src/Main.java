import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LotreBoard lotre = new LotreBoard();

        System.out.println("Welcome to E-Lottery Gosok");

        boolean mainLanjut = true;

        while (mainLanjut) {
            lotre.displayBoard();
            System.out.print("Masukkan tebakan anda (baris dan kolom): ");
            int baris = input.nextInt();
            int kolom = input.nextInt();

            mainLanjut = lotre.guess(baris, kolom);

            if (lotre.isGameOver()) {
                lotre.displayBoard();
                System.out.println("Selamat anda menang!");
                break;
            }
        }

        System.out.println("Game selesai.");
        input.close();
    }
}
