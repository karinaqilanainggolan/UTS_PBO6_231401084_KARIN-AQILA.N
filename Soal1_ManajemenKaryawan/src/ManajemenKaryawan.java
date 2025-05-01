import java.util.*;

// Kelas buat  data karyawan
class Karyawan {
    String id;
    String nama;
    String posisi;
    double gaji;

    public Karyawan(String id, String nama, String posisi, double gaji) {
        this.id = id;
        this.nama = nama;
        this.posisi = posisi;
        this.gaji = gaji;
    }

    public void printInfo() {
        System.out.println("ID: " + id + ", Nama: " + nama + ", Posisi: " + posisi + ", Gaji: Rp" + gaji);
    }
}

// Kelas  perusahaan
class Perusahaan {
    private List<Karyawan> listKaryawan = new ArrayList<>();

    private boolean idUnik(String id) {
        for (Karyawan k : listKaryawan) {
            if (k.id.equals(id)) return false;
        }
        return true;
    }

    private Karyawan cariKaryawan(String id) {
        for (Karyawan k : listKaryawan) {
            if (k.id.equals(id)) return k;
        }
        return null;
    }

    public void tambahKaryawan(Karyawan k) {
        if (!idUnik(k.id)) {
            System.out.println("ID udah dipake, coba ID lain ya.");
            return;
        }
        if (k.gaji < 0) {
            System.out.println("Gaji nggak boleh minus.");
            return;
        }
        listKaryawan.add(k);
        System.out.println("Karyawan sukses ditambahin.");
    }

    public void hapusKaryawan(String id) {
        Karyawan target = cariKaryawan(id);
        if (target != null) {
            listKaryawan.remove(target);
            System.out.println("Karyawan berhasil dihapus.");
        } else {
            System.out.println("Karyawan dengan ID itu nggak ketemu.");
        }
    }

    public void ubahPosisi(String id, String posisiBaru) {
        Karyawan k = cariKaryawan(id);
        if (k != null) {
            k.posisi = posisiBaru;
            System.out.println("Posisi udah diupdate.");
        } else {
            System.out.println("Nggak nemu karyawannya.");
        }
    }

    public void ubahGaji(String id, double gajiBaru) {
        if (gajiBaru < 0) {
            System.out.println("Gaji baru nggak boleh minus.");
            return;
        }
        Karyawan k = cariKaryawan(id);
        if (k != null) {
            k.gaji = gajiBaru;
            System.out.println("Gaji udah diupdate.");
        } else {
            System.out.println("Karyawan nggak ketemu.");
        }
    }

    public void tampilkanSemua() {
        if (listKaryawan.isEmpty()) {
            System.out.println("Belum ada data karyawan.");
            return;
        }
        for (Karyawan k : listKaryawan) {
            k.printInfo();
        }
    }
}

// bagian main
public class ManajemenKaryawan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Perusahaan pt = new Perusahaan();
        int pilihan;

        do {
            System.out.println("\n=== SISTEM MANAJEMEN KARYAWAN ===");
            System.out.println("1. Tambah Karyawan");
            System.out.println("2. Hapus Karyawan");
            System.out.println("3. Ubah Posisi");
            System.out.println("4. Ubah Gaji");
            System.out.println("5. Tampilkan Semua Karyawan");
            System.out.println("6. Keluar");
            System.out.print("Masukkan pilihan: ");
            pilihan = sc.nextInt();
            sc.nextLine(); // Buat ngilangin enter

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan ID: ");
                    String id = sc.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String nama = sc.nextLine();
                    System.out.print("Masukkan Posisi: ");
                    String posisi = sc.nextLine();
                    System.out.print("Masukkan Gaji: ");
                    double gaji = sc.nextDouble();
                    pt.tambahKaryawan(new Karyawan(id, nama, posisi, gaji));
                    break;

                case 2:
                    System.out.print("Masukkan ID karyawan yang mau dihapus: ");
                    pt.hapusKaryawan(sc.nextLine());
                    break;

                case 3:
                    System.out.print("Masukkan ID karyawan: ");
                    String idPosisi = sc.nextLine();
                    System.out.print("Masukkan posisi baru: ");
                    String posBaru = sc.nextLine();
                    pt.ubahPosisi(idPosisi, posBaru);
                    break;

                case 4:
                    System.out.print("Masukkan ID karyawan: ");
                    String idGaji = sc.nextLine();
                    System.out.print("Masukkan gaji baru: ");
                    double gajiBaru = sc.nextDouble();
                    pt.ubahGaji(idGaji, gajiBaru);
                    break;

                case 5:
                    pt.tampilkanSemua();
                    break;

                case 6:
                    System.out.println("Makasih udah make program ini!");
                    break;

                default:
                    System.out.println("Pilihan nggak valid, coba lagi.");
            }

        } while (pilihan != 6);
    }
}
