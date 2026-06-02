public class Main {
    public static void main(String[] args) {
        //instance/objek dari SistemGudang
        SistemGudang gudang = new SistemGudang();

        System.out.println("=== MEMULAI SIMULASI GUDANG ===\n");

        // 1. Daftarkan minimal 3 barang baru
        gudang.tambahBarangBaru("B01", "Laptop Asus", "Elektronik", 10);
        gudang.tambahBarangBaru("B02", "Meja Belajar", "Furnitur", 15);
        gudang.tambahBarangBaru("B03", "Mouse Logitech", "Elektronik", 20);
        
        System.out.println("-> 3 Barang berhasil ditambahkan.");

        // 2. Lakukan 1x tambah stok yang berhasil
        System.out.println("\nMelakukan penambahan stok...");
        gudang.tambahStok("B01", 5);

        // 3. Lakukan 1x kurangi stok yang berhasil
        System.out.println("\nMelakukan pengurangan stok (berhasil)...");
        gudang.kurangiStok("B02", 5);

        // 4. Lakukan 1x kurangi stok yang GAGAL
        System.out.println("\nMelakukan pengurangan stok (harus gagal)...");
        gudang.kurangiStok("B03", 50);

        // 5. Panggil metode cetak laporan akhir
        gudang.cetakLaporan();
    }
}