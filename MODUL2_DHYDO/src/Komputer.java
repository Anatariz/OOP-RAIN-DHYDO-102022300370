public class Komputer {
    private int jumlahKomputer;
    private String namaWarnet;
    private float hargaPerJam;

    public Komputer(int jumlahKomputer, String namaWarnet, float hargaPerJam){
        this.jumlahKomputer = jumlahKomputer;
        this.namaWarnet = namaWarnet;
        this.hargaPerJam = hargaPerJam;

    }

    public void informasi(){
        System.out.println("Jumlah Komputer:" + jumlahKomputer);
        System.out.println("Nama Warnet:" + namaWarnet);
        System.out.println("Harga Perjam:" + hargaPerJam);
    }
        
        
}
