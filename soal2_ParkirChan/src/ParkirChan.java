import java.util.*;

class Kendaraan {
    String jenis;
    int durasi; // dalam jam


    public Kendaraan(String jenis) {
        this.jenis = jenis.toLowerCase();
    }


    public void setDurasi(int jam) {
        this.durasi = jam;
    }


    public void setDurasi(int masuk, int keluar) {
        this.durasi = keluar - masuk;
    }


    public double hitungBiaya() {
        int hargaPerJam = 0;
        switch (jenis) {
            case "motor": hargaPerJam = 2000; break;
            case "mobil": hargaPerJam = 5000; break;
            case "truk":  hargaPerJam = 9000; break;
            default: System.out.println("Jenis kendaraan nggak dikenali."); return 0;
        }

        double total = hargaPerJam * durasi;

        // Diskon kalau durasi > 5 jam
        if (durasi > 5) {
            total = total * 0.9; // diskon 10%
        }

        return total;
    }

    public void printRingkasan() {
        System.out.println("\n----- PARKING SUMMARY -----");
        System.out.println("Vehicle Type : " + capitalize(jenis));
        System.out.println("Parking Time : " + durasi + " hour(s)");
        System.out.println("Total Fee    : Rp" + hitungBiaya());
    }

    private String capitalize(String s) {
        return s.substring(0,1).toUpperCase() + s.substring(1);
    }
}

public class ParkirChan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Kendaraan> daftarKendaraan = new ArrayList<>();
        double totalBiaya = 0;

        System.out.println("=== Welcome to ParkingChan ===");

        while (true) {
            System.out.print("\nEnter vehicle type (Motor/Mobil/Truk) : ");
            String jenis = sc.nextLine();

            Kendaraan k = new Kendaraan(jenis);

            System.out.print("Enter Duration (Manual/Time): ");
            String metode = sc.nextLine().toLowerCase();

            if (metode.equals("manual")) {
                System.out.print("Enter Duration (in hour): ");
                int jam = sc.nextInt(); sc.nextLine();
                k.setDurasi(jam);
            } else if (metode.equals("time")) {
                System.out.print("Entry time : ");
                int masuk = sc.nextInt();
                System.out.print("Exit time  : ");
                int keluar = sc.nextInt(); sc.nextLine();
                k.setDurasi(masuk, keluar);
            } else {
                System.out.println("Metode input nggak valid!");
                continue;
            }

            k.printRingkasan();
            daftarKendaraan.add(k);
            totalBiaya += k.hitungBiaya();

            System.out.print("\nAdd another vehicle? (y/n): ");
            String lanjut = sc.nextLine();
            if (!lanjut.equalsIgnoreCase("y")) break;
        }


        System.out.println("\n======= FINAL REPORT =======");
        System.out.println("Total Vehicle Final   : " + daftarKendaraan.size());
        System.out.println("Total Parking Fees    : Rp" + totalBiaya);
        System.out.println("Thank You......");
    }
}
