import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("=== JAWABAN SOAL 1 ===");
        Map<String, Buku> katalogBuku = new HashMap<>();
        
        katalogBuku.put("ISBN-101", new Buku("ISBN-101", "Pemrograman Java"));
        katalogBuku.put("ISBN-102", new Buku("ISBN-102", "Struktur Data"));
        katalogBuku.put("ISBN-103", new Buku("ISBN-103", "Kecerdasan Buatan"));
        
        System.out.println("Katalog Buku: " + katalogBuku.values());

        System.out.println("\n=== JAWABAN SOAL 2 ===");
        Set<Anggota> daftarAnggota = new HashSet<>();
        
        daftarAnggota.add(new Anggota("A001", "Budi", "Mahasiswa"));
        daftarAnggota.add(new Anggota("A002", "Siti", "Mahasiswa"));
        daftarAnggota.add(new Anggota("D001", "Pak Andi", "Dosen"));
        
        System.out.println("Daftar Anggota saat ini:");
        for (Anggota a : daftarAnggota) {
            System.out.println("- " + a);
        }

        System.out.println("\n=== JAWABAN SOAL 3 ===");
        Deque<String> antrean = new LinkedList<>();
        
        antrean.addLast("A001#ISBN-101");
        antrean.addLast("A002#ISBN-102");
        antrean.addFirst("D001#ISBN-103");
        antrean.addFirst("D002#ISBN-101");
        
        antrean.addLast("X999#ISBN-102");
        antrean.addLast("A001#ISBN-999");

        System.out.println("Antrean Siap Diproses (Dari depan ke belakang):");
        for (String item : antrean) {
            System.out.println("-> " + item);
        }

        System.out.println("\n=== JAWABAN SOAL 4 (PROSES PEMINJAMAN) ===");
        Set<String> bukuSedangDipinjam = new HashSet<>();

        while (!antrean.isEmpty()) {
            String dataPinjam = antrean.pollFirst();
            
            String[] parts = dataPinjam.split("#");
            String idAnggota = parts[0];
            String isbn = parts[1];
            
            System.out.println("Memproses: " + dataPinjam);

            Anggota dummyAnggota = new Anggota(idAnggota, "", "");
            if (!daftarAnggota.contains(dummyAnggota)) {
                System.out.println("  [X] DITOLAK: Anggota dengan ID " + idAnggota + " tidak terdaftar.");
                continue;
            }

            if (!katalogBuku.containsKey(isbn)) {
                System.out.println("  [X] DITOLAK: Buku dengan ISBN " + isbn + " tidak ada di katalog.");
                continue;
            }

            if (bukuSedangDipinjam.contains(isbn)) {
                System.out.println("  [X] DITOLAK: Buku (ISBN: " + isbn + ") sedang dipinjam oleh orang lain.");
                continue;
            }

            bukuSedangDipinjam.add(isbn);
            Buku bukuYangDipinjam = katalogBuku.get(isbn);
            System.out.println("  [V] BERHASIL: " + idAnggota + " meminjam buku '" + bukuYangDipinjam.judul + "'");
        }

        System.out.println("\nKoleksi Akhir Buku Sedang Dipinjam (ISBN):");
        System.out.println(bukuSedangDipinjam);

        System.out.println("\n=== JAWABAN SOAL 5 (LAPORAN BUKU DIPINJAM A-Z) ===");
        List<String> laporanJudul = new ArrayList<>();
        
        for (String isbnDipinjam : bukuSedangDipinjam) {
            laporanJudul.add(katalogBuku.get(isbnDipinjam).judul);
        }
        
        Collections.sort(laporanJudul);
        
        for (int i = 0; i < laporanJudul.size(); i++) {
            System.out.println((i + 1) + ". " + laporanJudul.get(i));
        }
    }
}