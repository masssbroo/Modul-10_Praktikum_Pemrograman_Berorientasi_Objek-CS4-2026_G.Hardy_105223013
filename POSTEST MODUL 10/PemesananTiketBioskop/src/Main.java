import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Map<String, Film> jadwal = new HashMap<>();
        jadwal.put("F01", new Film("Avengers: Endgame", 50000));
        jadwal.put("F02", new Film("Spider-Man: No Way Home", 45000));
        jadwal.put("F03", new Film("Doctor Strange", 40000));

        Set<String> kursiTerpesan = new HashSet<>();
        
        List<Pemesanan> riwayat = new ArrayList<>();

        String[][] simulasiAntrean = {
            {"Andi", "F01", "A1"},
            {"Budi", "F02", "B4"},
            {"Citra", "F01", "C2"},
            {"Deni", "F01", "A1"}
        };

        System.out.println("=== PROSES PEMESANAN TIKET ===");
        for (String[] req : simulasiAntrean) {
            String nama = req[0];
            String kodeFilm = req[1];
            String kursi = req[2];

            if (!jadwal.containsKey(kodeFilm)) {
                System.out.println("[X] GAGAL: " + nama + " - Kode film " + kodeFilm + " tidak valid.");
                continue;
            }

            if (!kursiTerpesan.add(kursi)) {
                System.out.println("[X] GAGAL: " + nama + " - Kursi " + kursi + " sudah dipesan orang lain.");
                continue;
            }

            Film filmDipilih = jadwal.get(kodeFilm);
            riwayat.add(new Pemesanan(nama, filmDipilih.judul, kursi, filmDipilih.harga));
            System.out.println("[V] SUKSES: " + nama + " memesan kursi " + kursi + " untuk film " + filmDipilih.judul);
        }

        System.out.println("\n=== RIWAYAT TRANSAKSI (BERURUTAN) ===");
        for (int i = 0; i < riwayat.size(); i++) {
            System.out.println((i + 1) + ". " + riwayat.get(i));
        }
    }
}