// Main class
public class main {
    public static void main(String[] args) {
        // Create instances of Kucing and Burung
        Kucing kucing1 = new Kucing("Mawmaw", 2, "Persia");
        Burung burung1 = new Burung("Rio", 1, "Biru");

        // Display details of Kucing
        System.out.println("Detail Hewan");
        System.out.println();
        System.out.println("ini adalah " + kucing1.nama + " !");
        kucing1.suara();
        kucing1.makan();
        kucing1.makan("ikan");
        kucing1.infoHewan();

        // Display details of Burung
        System.out.println();
        System.out.println("ini adalah " + burung1.nama + " !");
        burung1.suara();
        burung1.makan();
        burung1.makan("biji-bijian");
        burung1.infoHewan();
    }
}

// Class Hewan
class Hewan {
    protected String nama;
    protected int umur;

    // Constructor
    public Hewan(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
    }

    // Methods
    public void suara() {
        System.out.println(nama + " mengeluarkan suara.");
    }

    public void makan() {
        System.out.println(nama + " sedang makan.");
    }
    
    public void makan(String makanan) {
        System.out.println(nama + " sedang makan " + makanan + ".");
    }

    public void infoHewan() {
        System.out.println("Nama: " + nama + ", Umur: " + umur + " tahun.");
    }
}

// Class Kucing (extends Hewan)
class Kucing extends Hewan {
    private String ras;

    // Constructor
    public Kucing(String nama, int umur, String ras) {
        super(nama, umur);
        this.ras = ras;
    }

    @Override
    public void suara() {
        System.out.println(nama + " meong.");
    }

    @Override
    public void infoHewan() {
        super.infoHewan();
        System.out.println("Ras: " + ras);
    }
}

// Class Burung (extends Hewan)
class Burung extends Hewan {
    private String warnaBulu;

    // Constructor
    public Burung(String nama, int umur, String warnaBulu) {
        super(nama, umur);
        this.warnaBulu = warnaBulu;
    }

    @Override
    public void suara() {
        System.out.println(nama + " berkicau.");
    }

    @Override
    public void infoHewan() {
        super.infoHewan();
        System.out.println("Warna bulu: " + warnaBulu);
    }
}