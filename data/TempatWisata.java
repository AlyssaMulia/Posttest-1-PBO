package data;

public class TempatWisata {
    private String nama;
    private String lokasi;
    private String kategori;

    public TempatWisata(String nama, String lokasi, String kategori) {
        this.nama = nama;
        this.lokasi = lokasi;
        this.kategori = kategori;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public void tampilkanInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Lokasi: " + lokasi);
        System.out.println("Kategori: Wisata " + kategori);
        System.out.println("-------------------------");
    }
}