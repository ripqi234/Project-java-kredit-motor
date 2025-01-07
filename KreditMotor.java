/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package tugasakhir;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author RIFQI
 */

class DataPembeli {
    String namaPembeli,jenisMotor, NIK, alamat;
    int umur, hargaMotor, uangMuka, lamaCicilan, cicilanPerBulan;

    DataPembeli(String namaPembeli, String NIK, int umur, String alamat, String jenisMotor, int hargaMotor, int uangMuka, int lamaCicilan) {
        this.namaPembeli = namaPembeli;
        this.NIK = NIK;
        this.umur = umur;
        this.alamat = alamat;
        this.jenisMotor = jenisMotor;
        this.hargaMotor = hargaMotor;
        this.uangMuka = uangMuka;
        this.lamaCicilan = lamaCicilan;
        this.cicilanPerBulan = (hargaMotor - uangMuka) / lamaCicilan;
    }
}
public class KreditMotor {
    static ArrayList<DataPembeli> pembeliList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("\nPROGRAM KREDIT MOTOR FIFGROUP");
        System.out.println("Nama : MOH RIFQI MIFFTAKHULKHOIR");
        System.out.println("NIM  : 24.240.0040\n");

        while (true) {
            showMenu();
        }
    }
    static void showMenu() throws IOException {
        System.out.println("\nMENU UTAMA");
        System.out.println("1. Isi Formulir Kredit");
        System.out.println("2. Lihat Laporan");
        System.out.println("3. Koreksi/Edit Data");
        System.out.println("4. Hapus Data");
        System.out.println("5. Selesai");
        System.out.print("Pilih Menu [1-5]: ");
        int pilihan = input.nextInt();

        switch (pilihan) {
            case 1 -> isiData();
            case 2 -> lihatLaporan();
            case 3 -> editData();
            case 4 -> hapusData();
            case 5 -> {
                System.out.println("Program selesai. Terima kasih!");
                System.exit(0);
            }
            default -> System.out.println("Pilihan tidak valid!");
        }
    }
    static void isiData() {
        do {
            System.out.print("Nama Pembeli: ");
            input.nextLine();
            String namaPembeli = input.nextLine();

            System.out.print("NIK: ");
            String NIK = input.nextLine();

            System.out.print("Umur: ");
            int umur = input.nextInt();

            System.out.print("Alamat: ");
            input.nextLine();
            String alamat = input.nextLine();

            System.out.println("Pilih Jenis Motor:");
            System.out.println("1. Genio (Rp 17.000.000)");
            System.out.println("2. Scoopy (Rp 20.000.000)");
            System.out.println("3. PCX (Rp 30.000.000)");
            System.out.println("4. ADV (Rp 35.000.000)");
            System.out.println("5. CRF (Rp 40.000.000)");
            System.out.println("6. CBR (Rp 50.000.000)");
            System.out.print("Pilih Motor (1-6): ");
            int pilihanMotor = input.nextInt();

            String jenisMotor = "";
            int hargaMotor = 0;

            switch (pilihanMotor) {
                case 1 -> {
                    jenisMotor = "Genio";
                    hargaMotor = 17000000;
                }
                case 2 -> {
                    jenisMotor = "Scoopy";
                    hargaMotor = 20000000;
                }
                case 3 -> {
                    jenisMotor = "PCX";
                    hargaMotor = 30000000;
                }
                case 4 -> {
                    jenisMotor = "ADV";
                    hargaMotor = 35000000;
                }
                case 5 -> {
                    jenisMotor = "CRF";
                    hargaMotor = 40000000;
                }
                case 6 -> {
                    jenisMotor = "CBR";
                    hargaMotor = 50000000;
                }
                default -> {
                    System.out.println("Pilihan tidak valid!");
                    continue;
                }
            }
            System.out.print("Masukkan Uang Muka (Minimal Rp 2.000.000): ");
            int uangMuka = input.nextInt();
            if (uangMuka < 2000000) {
                System.out.println("Uang muka minimal Rp 2.000.000!");
                continue;
            }
            System.out.println("Pilih Lama Cicilan:");
            System.out.println("1. 6 bulan");
            System.out.println("2. 12 bulan");
            System.out.println("3. 24 bulan");
            System.out.println("4. 36 bulan");
            System.out.print("Pilih Cicilan (1-4): ");
            int pilihanCicilan = input.nextInt();

            int lamaCicilan;
            switch (pilihanCicilan) {
                case 1 -> lamaCicilan = 6;
                case 2 -> lamaCicilan = 12;
                case 3 -> lamaCicilan = 24;
                case 4 -> lamaCicilan = 36;
                default -> {
                    System.out.println("Pilihan tidak valid!");
                    continue;
                }
            }
            pembeliList.add(new DataPembeli(namaPembeli, NIK, umur, alamat, jenisMotor, hargaMotor, uangMuka, lamaCicilan));
            System.out.print("Isi data lagi? [Y/T]: ");
        } while (input.next().equalsIgnoreCase("Y"));
    }
    static void lihatLaporan() {
    if (pembeliList.isEmpty()) {
        System.out.println("Belum ada data yang dimasukkan.");
        return;
    }
    int dataPerHalaman = 3; 
    int totalHalaman = (int) Math.ceil((double) pembeliList.size() / dataPerHalaman);
    int grandTotal = 0; 

    for (int halaman = 0; halaman < totalHalaman; halaman++) {
        int startIdx = halaman * dataPerHalaman;
        int endIdx = Math.min(startIdx + dataPerHalaman, pembeliList.size());
        int subtotal = 0; 

        System.out.println("\nLAPORAN KREDIT MOTOR FIFGROUP");
        System.out.printf("\nLaporan Bulan Januari 2025 (Halaman %d/%d)\n", halaman + 1, totalHalaman);
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| No | Nama Pembeli  | NIK          | Umur | Alamat       | Jenis Motor | Harga Motor  | Uang Muka   | Cicilan/Bulan  | Lama |");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");

        for (int i = startIdx; i < endIdx; i++) {
            DataPembeli pembeli = pembeliList.get(i);
            System.out.printf("| %-2d | %-13s | %-12s | %-4d | %-12s | %-11s | Rp %-9d | Rp %-8d | Rp %-11d | %-4d |\n",
                    i + 1, pembeli.namaPembeli, pembeli.NIK, pembeli.umur, pembeli.alamat,
                    pembeli.jenisMotor, pembeli.hargaMotor, pembeli.uangMuka, pembeli.cicilanPerBulan, pembeli.lamaCicilan);

            subtotal += pembeli.cicilanPerBulan;
        }
        grandTotal += subtotal;

        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| Subtotal Cicilan Per Halaman: Rp %d\n", subtotal);
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");

        if (halaman < totalHalaman - 1) {
            System.out.print("Tekan Enter untuk halaman selanjutnya...");
            input.nextLine();
            if (input.hasNextLine()) {
                input.nextLine();
            }
        }
    }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
    System.out.printf("|Grand Total Cicilan Semua Halaman: Rp %d\n", grandTotal);
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
    }
    static void editData() {
    if (pembeliList.isEmpty()) {
        System.out.println("Belum ada data yang dimasukkan.");
        return;
    }
    lihatLaporan();
    System.out.print("Pilih nomor data yang ingin diubah: ");
    int index = input.nextInt() - 1;

    if (index >= 0 && index < pembeliList.size()) {
        DataPembeli pembeli = pembeliList.get(index);

        System.out.print("Nama Pembeli Baru: ");
        input.nextLine(); 
        pembeli.namaPembeli = input.nextLine();

        System.out.print("NIK Baru: ");
        pembeli.NIK = input.nextLine();

        System.out.print("Umur Baru: ");
        pembeli.umur = input.nextInt();

        System.out.print("Alamat Baru: ");
        input.nextLine(); 
        pembeli.alamat = input.nextLine();

        System.out.println("Pilih Jenis Motor Baru:");
        System.out.println("1. Genio (Rp 17.000.000)");
        System.out.println("2. Scoopy (Rp 20.000.000)");
        System.out.println("3. PCX (Rp 30.000.000)");
        System.out.println("4. ADV (Rp 35.000.000)");
        System.out.println("5. CRF (Rp 40.000.000)");
        System.out.println("6. CBR (Rp 50.000.000)");
        System.out.print("Pilih Motor (1-6): ");
        int pilihanMotor = input.nextInt();

        switch (pilihanMotor) {
            case 1 -> {
                pembeli.jenisMotor = "Genio";
                pembeli.hargaMotor = 17000000;
            }
            case 2 -> {
                pembeli.jenisMotor = "Scoopy";
                pembeli.hargaMotor = 20000000;
            }
            case 3 -> {
                pembeli.jenisMotor = "PCX";
                pembeli.hargaMotor = 30000000;
            }
            case 4 -> {
                pembeli.jenisMotor = "ADV";
                pembeli.hargaMotor = 35000000;
            }
            case 5 -> {
                pembeli.jenisMotor = "CRF";
                pembeli.hargaMotor = 40000000;
            }
            case 6 -> {
                pembeli.jenisMotor = "CBR";
                pembeli.hargaMotor = 50000000;
            }
            default -> {
                System.out.println("Pilihan tidak valid!");
                return;
            }
        }
        System.out.print("Masukkan Uang Muka Baru (Minimal Rp 2.000.000): ");
        pembeli.uangMuka = input.nextInt();
        if (pembeli.uangMuka < 2000000) {
            System.out.println("Uang muka minimal Rp 2.000.000! Data tidak diperbarui.");
            return;
        }
        System.out.println("Pilih Lama Cicilan Baru:");
        System.out.println("1. 6 bulan");
        System.out.println("2. 12 bulan");
        System.out.println("3. 24 bulan");
        System.out.println("4. 36 bulan");
        System.out.print("Pilih Cicilan (1-4): ");
        int pilihanCicilan = input.nextInt();

        switch (pilihanCicilan) {
            case 1 -> pembeli.lamaCicilan = 6;
            case 2 -> pembeli.lamaCicilan = 12;
            case 3 -> pembeli.lamaCicilan = 24;
            case 4 -> pembeli.lamaCicilan = 36;
            default -> {
                System.out.println("Pilihan tidak valid! Data tidak diperbarui.");
                return;
            }
        }
        pembeli.cicilanPerBulan = (pembeli.hargaMotor - pembeli.uangMuka) / pembeli.lamaCicilan;
        
        System.out.println("Data berhasil diperbarui!");
    } else {
        System.out.println("Data tidak ditemukan!");
    }}
    static void hapusData() {
        if (pembeliList.isEmpty()) {
            System.out.println("Belum ada data yang dimasukkan.");
            return;
        }
        lihatLaporan();
        System.out.print("Pilih nomor data yang ingin dihapus: ");
        int index = input.nextInt() - 1;

        if (index >= 0 && index < pembeliList.size()) {
            pembeliList.remove(index);
            System.out.println("Data berhasil dihapus!");
        } else {
            System.out.println("Data tidak ditemukan!");
        }}}