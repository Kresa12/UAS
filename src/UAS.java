import java.util.ArrayList;

public class ParkingLot {

    private static final int JUMLAH_LANTAI = 3;
    private static final int JUMLAH_MAX_KENDARAAN_PER_LANTAI = 100;

    private ArrayList<Kendaraan> kendaraanLantai1 = new ArrayList<>();
    private ArrayList<Kendaraan> kendaraanLantai2 = new ArrayList<>();
    private ArrayList<Kendaraan> kendaraanLantai3 = new ArrayList<>();

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();

        while (true) {
            int kapasitasMesin = inputKapasitasMesin();

            if (kapasitasMesin == -1) {
                break;
            }

            Kendaraan kendaraan = new Kendaraan(kapasitasMesin);

            int lantai = taruhKendaraan(kendaraan);

            if (lantai == -1) {
                System.out.println("Tempat parkir penuh!");
            } else {
                switch (lantai) {
                    case 1:
                        parkingLot.kendaraanLantai1.add(kendaraan);
                        break;
                    case 2:
                        parkingLot.kendaraanLantai2.add(kendaraan);
                        break;
                    case 3:
                        parkingLot.kendaraanLantai3.add(kendaraan);
                        break;
                }
            }
        }

        System.out.println("Data kendaraan yang masuk:");
        System.out.println("Lantai 1:");
        for (Kendaraan kendaraan : parkingLot.kendaraanLantai1) {
            System.out.println(kendaraan);
        }
        System.out.println("Lantai 2:");
        for (Kendaraan kendaraan : parkingLot.kendaraanLantai2) {
            System.out.println(kendaraan);
        }
        System.out.println("Lantai 3:");
        for (Kendaraan kendaraan : parkingLot.kendaraanLantai3) {
            System.out.println(kendaraan);
        }
    }

    private static int inputKapasitasMesin() {
        System.out.print("Masukan kapasitas mesin (cc): ");
        int kapasitasMesin = Integer.parseInt(System.console().readLine());

        return kapasitasMesin;
    }

    private int taruhKendaraan(Kendaraan kendaraan) {
        int lantai = -1;

        if (kendaraan.getKapasitasMesin() >= 2500) {
            lantai = 1;
        } else if (kendaraan.getKapasitasMesin() >= 1500) {
            lantai = 2;
        } else if (kendaraan.getKapasitasMesin() >= 1000) {
            lantai = 3;
        }

        if (lantai != -1) {
            if (kendaraan.getKapasitasMesin() > getBebanMaksimumLantai(lantai)) {
                return -1;
            } else {
                return lantai;
            }
        }

        return -1;
    }

    private int getBebanMaksimumLantai(int lantai) {
        switch (lantai) {
            case 1:
                return 2000;
            case 2:
                return 1800;
            case 3:
                return 1500;
            default:
                return -1;
        }
    }
}

class Kendaraan {

    private int kapasitasMesin;

    public Kendaraan(int kapasitasMesin) {
        this.kapasitasMesin = kapasitasMesin;
    }

    public int getKapasitasMesin() {
        return kapasitasMesin;
    }

    @Override
    public String toString() {
        return "Kendaraan (cc: " + kapasitasMesin + ")";
    }
}