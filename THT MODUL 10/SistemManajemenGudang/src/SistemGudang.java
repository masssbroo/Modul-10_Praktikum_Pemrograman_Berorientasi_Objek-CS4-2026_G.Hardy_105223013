import java.util.*;

public class SistemGudang {
    // Deklarasi Collections sebagai atribut kelas (non-static)
    Map<String, Barang> databaseBarang = new HashMap<>();
    Set<String> kategoriUnik = new HashSet<>();
    List<String> riwayat = new ArrayList<>();

    // Method tambah Barang Baru
    public void tambahBarangBaru(String id, String nama, String kategori, int stok) {
        if (!databaseBarang.containsKey(id)) {
            Barang barangBaru = new Barang(id, nama, kategori, stok);
            databaseBarang.put(id, barangBaru); // Masuk ke Map
            kategoriUnik.add(kategori);         // Masuk ke Set
            riwayat.add("Barang Baru Masuk: " + nama + " (" + id + ") ditambah " + stok + " unit");
        } else {
            System.out.println("Gagal: Barang dengan ID " + id + " sudah terdaftar!");
        }
    }

    // Method tambah stok
    public void tambahStok(String id, int jumlah) {
        if (databaseBarang.containsKey(id)) {
            Barang b = databaseBarang.get(id);
            b.stok += jumlah;
            riwayat.add("Update Stok: " + id + " ditambah " + jumlah + " unit. Total: " + b.stok);
        } else {
            System.out.println("Gagal Tambah Stok: ID Barang " + id + " tidak ditemukan.");
        }
    }

    // Method kurangi stok
    public void kurangiStok(String id, int jumlah) {
        if (databaseBarang.containsKey(id)) {
            Barang b = databaseBarang.get(id);
            if (b.stok >= jumlah) { // Cek jika stok mencukupi
                b.stok -= jumlah;
                riwayat.add("Barang Keluar: " + id + " dikurangi " + jumlah + " unit. Sisa: " + b.stok);
            } else {
                // Tolak jika stok kurang
                System.out.println("[X] DITOLAK: Stok " + b.namaBarang + " (" + id + ") tidak mencukupi! Sisa stok: " + b.stok);
                riwayat.add("Gagal Barang Keluar: " + id + " - Stok tidak cukup untuk dikurangi " + jumlah);
            }
        } else {
            System.out.println("Gagal Kurangi Stok: ID Barang " + id + " tidak ditemukan.");
        }
    }

    // Method cetak laporan akhir
    public void cetakLaporan() {
        System.out.println("\n===== LAPORAN SISTEM GUDANG =====");
        
        System.out.println("\n[1] DAFTAR KATEGORI UNIK (Dari Set):");
        for (String k : kategoriUnik) {
            System.out.println("- " + k);
        }

        System.out.println("\n[2] SISA STOK SEMUA BARANG (Dari Map):");
        for (Barang b : databaseBarang.values()) {
            System.out.println("- " + b.toString());
        }

        System.out.println("\n[3] RIWAYAT TRANSAKSI (Dari List):");
        for (int i = 0; i < riwayat.size(); i++) {
            System.out.println((i + 1) + ". " + riwayat.get(i));
        }
        System.out.println("=================================");
    }
}