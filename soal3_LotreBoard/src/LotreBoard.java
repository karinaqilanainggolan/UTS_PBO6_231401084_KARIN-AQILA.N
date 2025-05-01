import java.util.Random;

public class LotreBoard {
    private final int ukuran = 3;
    private String[][] board;
    private int barisMenang;
    private int kolomMenang;
    private boolean gameOver = false;

    public LotreBoard() {
        board = new String[ukuran][ukuran];
        for (int i = 0; i < ukuran; i++) {
            for (int j = 0; j < ukuran; j++) {
                board[i][j] = "-";
            }
        }

        Random rand = new Random();
        barisMenang = rand.nextInt(ukuran);
        kolomMenang = rand.nextInt(ukuran);
    }

    public void displayBoard() {
        System.out.println("Papan Lotre:");
        for (int i = 0; i < ukuran; i++) {
            for (int j = 0; j < ukuran; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean guess(int baris, int kolom) {
        if (baris < 0 || baris >= ukuran || kolom < 0 || kolom >= ukuran) {
            System.out.println("Tebakan di luar batas! Coba lagi.");
            return true;
        }

        if (baris == barisMenang && kolom == kolomMenang) {
            board[baris][kolom] = "✓";
            gameOver = true;
            return false;
        } else {
            board[baris][kolom] = "X";
            System.out.println("Belum tepat, coba lagi!");
            return true;
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
