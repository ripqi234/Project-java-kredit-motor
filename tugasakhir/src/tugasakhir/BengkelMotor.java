/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugasakhir;
import java.util.*;
/**
 *
 * @author ASUS TUF GAMING
 */
class DataBengkel {
        String namaPelanggan;
        String nomorTelepon;
        String tanggalPelayanan;
        String jenisMotor; 
        String jenisLayanan;
        int biaya;
        String tambahanLayanan;
        int biayaTambahan;

        public DataBengkel(String namaPelanggan, String nomorTelepon, String tanggalPelayanan, 
                       String jenisMotor, String jenisLayanan, int biaya, String tambahanLayanan, int biayaTambahan) {
            this.namaPelanggan = namaPelanggan;
            this.nomorTelepon = nomorTelepon;
            this.tanggalPelayanan = tanggalPelayanan;
            this.jenisMotor = jenisMotor;
            this.jenisLayanan = jenisLayanan;
            this.tambahanLayanan = tambahanLayanan;
            this.biayaTambahan = biayaTambahan;
            this.biaya = biaya;
    }
}

public class BengkelMotor {
    static ArrayList<DataBengkel> dataList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRunning = true;
        while (isRunning) {
            showMenu();
        }
    }

    static void showMenu() {
        System.out.println("=======================================");
        System.out.println("|          BENGKEL YOGA MOTOR         |");
        System.out.println("|             *** BATANG ***          |");
        System.out.println("=======================================");
        System.out.println("|              MENU UTAMA             |");
        System.out.println("|-------------------------------------|");
        System.out.println("| 1. Isi Data Pelanggan               |");
        System.out.println("| 2. Lihat Laporan Perbaikan          |");
        System.out.println("| 3. Edit Data Pelanggan              |");
        System.out.println("| 4. Hapus Data                       |");
        System.out.println("| 5. Keluar                           |");
        System.out.println("=======================================");
        System.out.print("Pilih Menu : ");
        int pilihan = Integer.parseInt(scanner.nextLine());
        switch (pilihan) {
            case 1:
                isiData();
                break;
            case 2:
                lihatLaporan();
                break;
            case 3:
                editData();
                break;
            case 4:
                hapusData();
                break;
            case 5:
                System.out.println("Terima kasih telah menggunakan program.");
                System.exit(0);
                break;
            default:
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
        }
    }

    static void isiData() {
    boolean isAdding = true;
    while (isAdding) {
        System.out.println("\n--- Isi Data Pelanggan ---");
        System.out.print("Masukkan Nama Pelanggan                : ");
        String nama = scanner.nextLine();
        
        System.out.print("Masukkan Nomor Telepon                 : ");
        String nomorTelepon = scanner.nextLine();
        
        System.out.print("Masukkan Tanggal Pelayanan (DD-MM-YYYY): ");
        String tanggalPelayanan = scanner.nextLine();
        
        System.out.print("Masukkan Jenis Motor                   : ");
        String jenisMotor = scanner.nextLine();
        
        System.out.println("|     Pilihan Jenis Layanan     |");
        System.out.println("| [1] Service Motor (Rp 100.000)|");
        System.out.println("| [2] Ganti Oli     (Rp 60.000 )|");
        System.out.println("| [3] Tambal Ban    (Rp 25.000 )|");
        System.out.println("| {4} Tune-Up       (Rp 200.000)|");
        System.out.print("Pilih : ");
        int jenis = Integer.parseInt(scanner.nextLine());

        String jenisLayanan = "";
        int biaya = 0;

        switch (jenis) {
            case 1:
                jenisLayanan = "Service Motor";
                biaya = 100000;
                break;
            case 2:
                jenisLayanan = "Ganti Oli";
                biaya = 60000;
                break;
            case 3:
                jenisLayanan = "Tambal Ban";
                biaya = 25000;
                break;
            case 4:
                jenisLayanan = "Tune-Up";
                biaya = 200000;
                break;
            default:
                System.out.println("Pilihan tidak valid. Input data dibatalkan.");
                return;
        }
        System.out.println("|        Pilihan Jenis Layanan Tambahan       |");
        System.out.println("|[1] Ganti Van Belt               (Rp 190.000)|");
        System.out.println("|[2] Ganti Ban Depan dan Belakang (Rp 483.000)|");
        System.out.println("|[3] Ganti Aki Motor              (Rp 185.000)|");
        System.out.println("|[4] Ganti Kampas Rem             (Rp 100.000)|");
        System.out.println("|[5] Tidak Ada ");
        System.out.print("Pilih : ");
        int jenisTambahan = Integer.parseInt(scanner.nextLine());
        
        String tambahanLayanan="";
        int biayaTambahan=0;
        switch (jenisTambahan) {
            case 1:
                tambahanLayanan = "Ganti Van Belt";
                biayaTambahan = 190000;
                break;
            case 2:
                tambahanLayanan = "Ganti Ban Depan dan Belakang";
                biayaTambahan = 483000;
                break;
            case 3:
                tambahanLayanan = "Ganti Aki";
                biayaTambahan = 185000;
                break;
            case 4:
                tambahanLayanan = "Ganti Kampas Rem";
                biayaTambahan = 100000;
                break;
            case 5:
                tambahanLayanan = "Tidak Ada";
                biayaTambahan = 0;
                break;
            default:
                System.out.println("Pilihan tidak valid. Input data dibatalkan.");
                return;
        }

        DataBengkel dataBaru = new DataBengkel(nama, nomorTelepon, tanggalPelayanan, 
                jenisMotor, jenisLayanan, biaya, tambahanLayanan, biayaTambahan);
        dataList.add(dataBaru);
        System.out.println("Data berhasil ditambahkan.");

        System.out.print("Apakah ingin isi data lagi? [Y/T]: ");
        String pilihan = scanner.nextLine().toUpperCase();

        if (pilihan.equals("T")) {
            isAdding = false;
        }
    }
}


    static void lihatLaporan() {
    System.out.println("\n=================================================================== LAPORAN DATA PELANGGAN ==================================================================================");
    System.out.println("                                                                  *** BENGKEL YOGA MOTOR ***                                    ");
    System.out.println("=============================================================================================================================================================================");
    if (dataList.isEmpty()) {
        System.out.println("Belum ada data yang dimasukkan.");
    } else {
        int totalgrand = 0;
        int page = 0;
        boolean isViewing = true;

        while (isViewing) {
            int subtotal = 0;
            int total = 0;
            System.out.printf("\nHalaman %d:\n", page + 1);
            System.out.println("=============================================================================================================================================================================");
            System.out.println("| No |       Nama        |    No Telepon    |   Tanggal   |   Jenis Motor   | Jenis Layanan |     Biaya     |       Layanan Tambahan       | Biaya Tambahan |     Total     |");
            System.out.println("|----|-------------------|------------------|-------------|-----------------|---------------|---------------|------------------------------|----------------|---------------|");

            for (int i = page * 3; i < Math.min((page + 1) * 3, dataList.size()); i++) {
                DataBengkel data = dataList.get(i);
                total = data.biaya + data.biayaTambahan;
                System.out.printf("| %-2d | %-17.17s | %-16s | %-11s | %-15s | %-13s |Rp.%-12d| %-28s |Rp.%-13d|Rp.%-12d|\n", 
                    i + 1, data.namaPelanggan, data.nomorTelepon, data.tanggalPelayanan, data.jenisMotor,
                    data.jenisLayanan, data.biaya, data.tambahanLayanan, data.biayaTambahan, total);

                subtotal += total;
            }

            totalgrand += subtotal;

            System.out.println("|========================|==================================================================================================================================|===============|");
            System.out.printf("|Subtotal halaman ini    |                                                                                                                                  |Rp.%-12d|\n", subtotal);
            System.out.println("|========================|==================================================================================================================================|===============|");
            System.out.printf("|Grand Total             |                                                                                                                                  |Rp.%-12d|\n", totalgrand);
            System.out.println("=============================================================================================================================================================================");
            
            if ((page + 1) * 3 >= dataList.size()) {
                System.out.println("\n                                                                     *** Laporan Telah Habis  ***                                                                            ");
                System.out.print("Tekan [Enter] untuk keluar: ");
                scanner.nextLine();
                isViewing = false;
            } else {
                System.out.print("Tekan [N] untuk halaman selanjutnya. Tekan [Q] untuk keluar dari halaman: ");
                String pilihan = scanner.nextLine().toUpperCase();

                if (pilihan.equals("N")) {
                    page++;
                } else if (pilihan.equals("Q")) { 
                    isViewing = false;
                } else {
                    System.out.println("Pilihan tidak valid.");
                }
            }
        }
    }
}



    static void editData() {
        System.out.println("\n--- Edit Data Pelanggan ---");
        lihatLaporan();
        if (!dataList.isEmpty()) {
            System.out.print("Masukkan nomor data yang ingin diubah  : ");
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index >= 0 && index < dataList.size()) {
            System.out.print("Masukkan Nama Pelanggan                : ");
            String nama = scanner.nextLine();
        
            System.out.print("Masukkan Nomor Telepon                 : ");
            String nomorTelepon = scanner.nextLine();
        
            System.out.print("Masukkan Tanggal Pelayanan (DD-MM-YYYY): ");
            String tanggalPelayanan = scanner.nextLine();
        
            System.out.print("Masukkan Jenis Motor                   : ");
            String jenisMotor = scanner.nextLine();
        
            System.out.println("|     Pilihan Jenis Layanan     |");
        System.out.println("| [1] Service Motor (Rp 100.000)|");
        System.out.println("| [2] Ganti Oli     (Rp 60.000 )|");
        System.out.println("| [3] Tambal Ban    (Rp 25.000 )|");
        System.out.println("| {4} Tune-Up       (Rp 200.000)|");
        System.out.print("Pilih : ");
        int jenis = Integer.parseInt(scanner.nextLine());

        String jenisLayanan = "";
        int biaya = 0;

        switch (jenis) {
            case 1:
                jenisLayanan = "Service Motor";
                biaya = 100000;
                break;
            case 2:
                jenisLayanan = "Ganti Oli";
                biaya = 60000;
                break;
            case 3:
                jenisLayanan = "Tambal Ban";
                biaya = 25000;
                break;
            case 4:
                jenisLayanan = "Tune-Up";
                biaya = 200000;
                break;
            default:
                System.out.println("Pilihan tidak valid. Input data dibatalkan.");
                return;
        }
        System.out.println("|        Pilihan Jenis Layanan Tambahan       |");
        System.out.println("|[1] Ganti Van Belt               (Rp 190.000)|");
        System.out.println("|[2] Ganti Ban Depan dan Belakang (Rp 483.000)|");
        System.out.println("|[3] Ganti Aki Motor              (Rp 185.000)|");
        System.out.println("|[4] Ganti Kampas Rem             (Rp 100.000)|");
        System.out.println("|[5] Tidak Ada ");
        System.out.print("Pilih : ");
        int jenisTambahan = Integer.parseInt(scanner.nextLine());
        
        String tambahanLayanan="";
        int biayaTambahan=0;
        switch (jenisTambahan) {
            case 1:
                tambahanLayanan = "Ganti Van Belt";
                biayaTambahan = 190000;
                break;
            case 2:
                tambahanLayanan = "Ganti Ban Depan dan Belakang";
                biayaTambahan = 483000;
                break;
            case 3:
                tambahanLayanan = "Ganti Aki";
                biayaTambahan = 185000;
                break;
            case 4:
                tambahanLayanan = "Ganti Kampas Rem";
                biayaTambahan = 100000;
                break;
            case 5:
                tambahanLayanan = "Tidak Ada";
                biayaTambahan = 0;
                break;
            default:
                System.out.println("Pilihan tidak valid. Input data dibatalkan.");
                return;
        }
            

                dataList.set(index, new DataBengkel(nama, nomorTelepon, tanggalPelayanan,
                        jenisMotor, jenisLayanan, biaya, tambahanLayanan, biayaTambahan));
                System.out.println("Data berhasil diperbarui.");
            } else {
                System.out.println("Nomor data tidak valid.");
            }
        }
    }

    static void hapusData() {
        System.out.println("\n--- Hapus Data Pelanggan ---");
        lihatLaporan();
        if (!dataList.isEmpty()) {
            System.out.print("Masukkan nomor data yang ingin dihapus : ");
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index >= 0 && index < dataList.size()) {
                dataList.remove(index);
                System.out.println("Data berhasil dihapus.");
            } else {
                System.out.println("Nomor data tidak valid.");
            }
        }
    }
}
