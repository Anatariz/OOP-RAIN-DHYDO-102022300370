public class KomputerVIP {
    private boolean vipCard;

    public KomputerVIP(int jumlahKomputer, String namaWarnet, float hargaPerjam, boolean vipCard){
        super(jumlahKomputer, namaWarnet, hargaPerjam);
        this.vipCard = vipCard;
    }

    @Override
    public void informasi(){
        super.informasi();
        if (vipCard) {
            System.out.println("Diskon 10% untuk bermain lebih dari 3 jam");
            System.out.println("Gratis minuman setiap 4 jam bermain");
            System.out.println("Prioritas booking komputer gaming");
        }
        else{
            System.out.println("jgn ngarep benefit, maav");
        }
    }

    public void Login(String username);
        System.out.println("login dengan username" + username);

    public void Bermain(int jam);
        System.out.println("baermain selama" + jam + "jam");

    public void Bermain(int jam, int menitTambahan);
        System.out.println("nambah billing selama" + jam + "jam" + menitTambahan + "menit");
