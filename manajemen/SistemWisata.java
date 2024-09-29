package manajemen;

import data.TempatWisata;
import java.util.ArrayList;
import java.util.Scanner;

public class SistemWisata {
    private static ArrayList<TempatWisata> daftarWisata = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void tampilkanMenu() {
        int pilihan;
        do {
            System.out.println("\nSelamat Datang Di Sistem Manajemen");
            System.out.println("===   Wisata Kota Samarinda   ===");
            System.out.println("1. Tambah Wisata");
            System.out.println("2. Tampilkan Wisata");
            System.out.println("3. Ubah Wisata");
            System.out.println("4. Hapus Wisata");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1/2/3/4/5): ");
            pilihan = scanner.nextInt();
            scanner.nextLine();  // Membersihkan newline dari input sebelumnya

            switch (pilihan) {
                case 1:
                    tambahWisata();
                    break;
                case 2:
                    tampilkanWisata();
                    break;
                case 3:
                    ubahWisata();
                    break;
                case 4:
                    hapusWisata();
                    break;
                case 5:
                    System.out.println("Keluar dari sistem...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 5);
    }

    private static void tambahWisata() {
        System.out.println("\n=== Tambah Wisata Baru ===");
        System.out.print("Masukkan Nama Wisata: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Lokasi Wisata: ");
        String lokasi = scanner.nextLine();
        System.out.print("Masukkan Kategori Wisata: ");
        String kategori = scanner.nextLine();

        TempatWisata wisata = new TempatWisata(nama, lokasi, kategori);
        daftarWisata.add(wisata);
        System.out.println("Wisata berhasil ditambahkan.");
    }

    private static void tampilkanWisata() {
        System.out.println("\n=== Daftar Tempat Wisata ===");
        if (daftarWisata.isEmpty()) {
            System.out.println("Belum ada wisata yang terdaftar.");
        } else {
            for (TempatWisata wisata : daftarWisata) {
                wisata.tampilkanInfo();
            }
        }
    }

    // Metode untuk mencari tempat wisata berdasarkan nama
    private static TempatWisata getTempatWisataByName(String nama) {
        for (TempatWisata wisata : daftarWisata) {
            if (wisata.getNama().equalsIgnoreCase(nama)) {
                return wisata;
            }
        }
        return null;  // Jika tidak ditemukan
    }

    private static void ubahWisata() {
        System.out.println("\n=== Ubah Wisata ===");
        System.out.print("Masukkan nama wisata yang ingin diubah: ");
        String nama = scanner.nextLine();
        TempatWisata wisata = getTempatWisataByName(nama);

        if (wisata != null) {
            System.out.print("Masukkan nama baru: ");
            String namaBaru = scanner.nextLine();
            System.out.print("Masukkan lokasi baru: ");
            String lokasiBaru = scanner.nextLine();
            System.out.print("Masukkan kategori baru: ");
            String kategoriBaru = scanner.nextLine();

            wisata.setNama(namaBaru);
            wisata.setLokasi(lokasiBaru);
            wisata.setKategori(kategoriBaru);

            System.out.println("Wisata berhasil diubah.");
        } else {
            System.out.println("Wisata dengan nama tersebut tidak ditemukan.");
        }
    }

    private static void hapusWisata() {
        System.out.println("\n=== Hapus Wisata ===");
        System.out.print("Masukkan nama wisata yang ingin dihapus: ");
        String nama = scanner.nextLine();
        TempatWisata wisata = getTempatWisataByName(nama);

        if (wisata != null) {
            daftarWisata.remove(wisata);
            System.out.println("Wisata berhasil dihapus.");
        } else {
            System.out.println("Wisata dengan nama tersebut tidak ditemukan.");
        }
    }
}