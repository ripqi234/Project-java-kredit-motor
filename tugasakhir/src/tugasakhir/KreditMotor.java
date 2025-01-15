package tugasakhir;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class DataPembeli {
    String namaPembeli, jenisMotor, NIK, alamat;
    int umur, hargaMotor, uangMuka, lamaCicilan;
    int bungaPerTahun, cicilanPerBulan, totalBunga;

    DataPembeli(String namaPembeli, String NIK, int umur, String alamat, String jenisMotor, 
                int hargaMotor, int uangMuka, int lamaCicilan, int bungaPerTahun) {
        this.namaPembeli = namaPembeli;
        this.NIK = NIK;
        this.umur = umur;
        this.alamat = alamat;
        this.jenisMotor = jenisMotor;
        this.hargaMotor = hargaMotor;
        this.uangMuka = uangMuka;
        this.lamaCicilan = lamaCicilan;
        this.bungaPerTahun = bungaPerTahun;
        int pokokKredit = hargaMotor - uangMuka;
        this.totalBunga = (int) (pokokKredit * bungaPerTahun / 100.0 * (lamaCicilan / 12.0));
        this.cicilanPerBulan = (pokokKredit + totalBunga) / lamaCicilan;
}}

public class KreditMotor {
    static ArrayList<DataPembeli> pembeliList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("=================================================");
        System.out.println("PROGRAM KREDIT MOTOR FIFGROUP");
        System.out.println("Nama : MOH RIFQI MIFFTAKHULKHOIR");
        System.out.println("NIM  : 24.240.0040");
        System.out.println("=================================================");

        while (true) {
            showMenu();
        }
    }

    static void showMenu() throws IOException {
    System.out.println("=====MENU UTAMA=====");
    System.out.println("1. Isi Formulir Kredit");
    System.out.println("2. Lihat Laporan");
    System.out.println("3. Koreksi/Edit Data");
    System.out.println("4. Hapus Data");
    System.out.println("5. Cetak Kwitansi");
    System.out.println("6. Selesai");
    System.out.print("Pilih Menu [1-6]> ");
    int pilihan = input.nextInt();
    System.out.println("====================");

    switch (pilihan) {
        case 1 -> isiData();
        case 2 -> lihatLaporan();
        case 3 -> editData();
        case 4 -> hapusData();
        case 5 -> cetakKwitansi();
        case 6 -> {
            System.out.println("Program selesai. Terima kasih!");
            System.exit(0);
        }
        default -> System.out.println("Pilihan tidak valid!");
    }
}

    static void isiData() {
        do {
            System.out.println("");
            System.out.println("===========ISI FORMULIR PEMBELIAN==========="); 
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
            System.out.println("1. Genio    (Rp 18.000.000)");
            System.out.println("2. Scoopy   (Rp 20.480.000)");
            System.out.println("3. PCX      (Rp 30.940.000)");
            System.out.println("4. ADV      (Rp 35.000.000)");
            System.out.println("5. CRF      (Rp 48.000.000)");
            System.out.println("6. CBR      (Rp 63.000.000)");
            System.out.print("Pilih Motor (1-6): ");
            int pilihanMotor = input.nextInt();

            String jenisMotor = "";
            int hargaMotor = 0;

            switch (pilihanMotor) {
                case 1 -> {
                    jenisMotor = "Genio";
                    hargaMotor = 18000000;
                }
                case 2 -> {
                    jenisMotor = "Scoopy";
                    hargaMotor = 20480000;
                }
                case 3 -> {
                    jenisMotor = "PCX";
                    hargaMotor = 30940000;
                }
                case 4 -> {
                    jenisMotor = "ADV";
                    hargaMotor = 35000000;
                }
                case 5 -> {
                    jenisMotor = "CRF";
                    hargaMotor = 48000000;
                }
                case 6 -> {
                    jenisMotor = "CBR";
                    hargaMotor = 63000000;
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
            System.out.println("1. 6 bulan  (Bunga 10% per tahun)");
            System.out.println("2. 12 bulan (Bunga 12% per tahun)");
            System.out.println("3. 24 bulan (Bunga 14% per tahun)");
            System.out.print("Pilih Cicilan (1-3): ");
            int pilihanCicilan = input.nextInt();

            int lamaCicilan;
            int bungaPerTahun;
            switch (pilihanCicilan) {
                case 1 -> {
                    lamaCicilan = 6;
                    bungaPerTahun = 10;
                }
                case 2 -> {
                    lamaCicilan = 12;
                    bungaPerTahun = 12;
                }
                case 3 -> {
                    lamaCicilan = 24;
                    bungaPerTahun = 14;
                }
                default -> {
                    System.out.println("Pilihan tidak valid!");
                    continue;
                }
            }

            DataPembeli newPembeli = new DataPembeli(namaPembeli, NIK, umur, alamat, jenisMotor, 
                                    hargaMotor, uangMuka, lamaCicilan, bungaPerTahun);
            pembeliList.add(newPembeli);
                        
            System.out.print("Isi data lagi? [Y/T]: ");
        } while (input.next().equalsIgnoreCase("Y"));
        System.out.println("");
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
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("| No | Nama Pembeli  | NIK          | Motor    | Harga Motor  | Uang Muka   | Bunga/Th | Cicilan/Bulan  | Lama | Total Bunga   |");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------");

            for (int i = startIdx; i < endIdx; i++) {
                DataPembeli pembeli = pembeliList.get(i);
                System.out.printf("| %-2d | %-13s | %-12s | %-8s | Rp %-9d | Rp %-8d | %d%%      | Rp %-11d | %-4d | Rp %-10d |\n",
                        i + 1, pembeli.namaPembeli, pembeli.NIK, pembeli.jenisMotor,
                        pembeli.hargaMotor, pembeli.uangMuka, pembeli.bungaPerTahun,
                        pembeli.cicilanPerBulan, pembeli.lamaCicilan, pembeli.totalBunga);

                subtotal += pembeli.cicilanPerBulan;
            }
            grandTotal += subtotal;

            System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| Subtotal Cicilan Per Halaman: Rp %d\n", subtotal);
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------");

            if (halaman < totalHalaman - 1) {
                System.out.print("Tekan Enter untuk halaman selanjutnya...");
                input.nextLine();
                if (input.hasNextLine()) {
                    input.nextLine();
                }
            }
        }
        System.out.printf("|Grand Total Cicilan Semua Halaman: Rp %d\n", grandTotal);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");    
        System.out.print("Tekan Enter untuk kembali ke menu utama...");
        input.nextLine();
        if (input.hasNextLine()) {
                    input.nextLine();
                }
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
            System.out.print("Nama Pembeli Baru: ");
            input.nextLine(); 
            String namaPembeli = input.nextLine();

            System.out.print("NIK Baru: ");
            String NIK = input.nextLine();

            System.out.print("Umur Baru: ");
            int umur = input.nextInt();

            System.out.print("Alamat Baru: ");
            input.nextLine(); 
            String alamat = input.nextLine();

            System.out.print("Pilih Motor (1-6): ");
            int pilihanMotor = input.nextInt();

            String jenisMotor = "";
            int hargaMotor = 0;

            switch (pilihanMotor) {
               case 1 -> {
                    jenisMotor = "Genio";
                    hargaMotor = 18000000;
                }
                case 2 -> {
                    jenisMotor = "Scoopy";
                    hargaMotor = 20480000;
                }
                case 3 -> {
                    jenisMotor = "PCX";
                    hargaMotor = 30940000;
                }
                case 4 -> {
                    jenisMotor = "ADV";
                    hargaMotor = 35000000;
                }
                case 5 -> {
                    jenisMotor = "CRF";
                    hargaMotor = 48000000;
                }
                case 6 -> {
                    jenisMotor = "CBR";
                    hargaMotor = 63000000;
                }
                default -> {
                    System.out.println("Pilihan tidak valid!");
                    return;
                }
            }

            System.out.print("Masukkan Uang Muka Baru (Minimal Rp 2.000.000): ");
            int uangMuka = input.nextInt();
            if (uangMuka < 2000000) {
                System.out.println("Uang muka minimal Rp 2.000.000! Data tidak diperbarui.");
                return;
            }

            System.out.print("Pilih Cicilan (1-3): ");
            int pilihanCicilan = input.nextInt();
            int lamaCicilan;
            int bungaPerTahun;
            switch (pilihanCicilan) {
                case 1 -> {
                    lamaCicilan = 6;
                    bungaPerTahun = 10;
                }
                case 2 -> {
                    lamaCicilan = 12;
                    bungaPerTahun = 12;
                }
                case 3 -> {
                    lamaCicilan = 24;
                    bungaPerTahun = 14;
                }
                default -> {
                    System.out.println("Pilihan tidak valid! Data tidak diperbarui.");
                    return;
                }
            }

            DataPembeli updatedPembeli = new DataPembeli(namaPembeli, NIK, umur, alamat, jenisMotor, 
                                                        hargaMotor, uangMuka, lamaCicilan, bungaPerTahun);
            pembeliList.set(index, updatedPembeli);
            
            System.out.println("Data berhasil diperbarui!");
        } else {
            System.out.println("Data tidak ditemukan!");
        }
    }

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
        }
    }

    static void cetakKwitansi() {
    if (pembeliList.isEmpty()) {
        System.out.println("Belum ada data yang dimasukkan.");
        return;
    }
    
    // Show brief list of customers first
    System.out.println("\nDaftar Pembeli:");
    System.out.println("------------------------------------------");
    for (int i = 0; i < pembeliList.size(); i++) {
        DataPembeli pembeli = pembeliList.get(i);
        System.out.printf("%d. %s - %s (%s)\n", 
            i + 1, 
            pembeli.namaPembeli, 
            pembeli.jenisMotor,
            pembeli.NIK);
    }
    System.out.println("------------------------------------------");
    
    System.out.print("Pilih nomor pembeli untuk cetak kwitansi: ");
    int index = input.nextInt() - 1;

    if (index >= 0 && index < pembeliList.size()) {
        DataPembeli pembeli = pembeliList.get(index);
        
        System.out.println("\n===========================================");
        System.out.println("            KWITANSI PEMBAYARAN            ");
        System.out.println("           KREDIT MOTOR FIFGROUP           ");
        System.out.println("===========================================");
        System.out.println("DATA PEMBELI:");
        System.out.println("Nama     : " + pembeli.namaPembeli);
        System.out.println("NIK      : " + pembeli.NIK);
        System.out.println("Umur     : " + pembeli.umur + " tahun");
        System.out.println("Alamat   : " + pembeli.alamat);
        System.out.println("-------------------------------------------");
        System.out.println("DETAIL PEMBELIAN:");
        System.out.println("Motor    : " + pembeli.jenisMotor);
        System.out.printf("Harga    : Rp %,d\n", pembeli.hargaMotor);
        System.out.printf("DP       : Rp %,d\n", pembeli.uangMuka);
        System.out.println("-------------------------------------------");
        System.out.println("DETAIL KREDIT:");
        System.out.printf("Pokok Kredit    : Rp %,d\n", (pembeli.hargaMotor - pembeli.uangMuka));
        System.out.println("Tenor           : " + pembeli.lamaCicilan + " bulan");
        System.out.printf("Bunga per tahun : %d%%\n", pembeli.bungaPerTahun);
        System.out.printf("Cicilan/bulan   : Rp %,d\n", Math.round(pembeli.cicilanPerBulan));
        System.out.printf("Total Bunga     : Rp %,d\n", Math.round(pembeli.totalBunga));
        System.out.printf("Total Bayar     : Rp %,d\n", 
                        Math.round(pembeli.cicilanPerBulan * pembeli.lamaCicilan + pembeli.uangMuka));
        System.out.println("===========================================");

        System.out.println("\nTekan Enter untuk melanjutkan...");
        try {
            System.in.read();
            if (input.hasNextLine()) {
                input.nextLine();
            }
        } catch (IOException e) {
            System.out.println("Error membaca input.");
        }
    } else {
        System.out.println("Nomor pembeli tidak valid!");
    }
}}