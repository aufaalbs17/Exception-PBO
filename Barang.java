public class Barang { //Super Class 
 
    public String kode_barang; 
    public String nama_barang; 
    public float harga_barang; 
 
    public int no_faktur; 
    public int jumlah_beli; 
    public float total; 
 
    public Barang (String kode_barang, String nama_barang, float harga_barang){ 
        this.kode_barang = kode_barang; 
        this.nama_barang = nama_barang; 
        this.harga_barang = harga_barang; 
    } 
 
    public void faktur () { 
        System.out.println("No. Faktur   : " + no_faktur); 
        System.out.println("Kode Barang  : " + kode_barang); 
        System.out.println("Nama Barang  : " + nama_barang); 
        System.out.println("Harga Barang : " + harga_barang); 
        System.out.println("Jumlah Beli  : " + jumlah_beli); 
        System.out.println("Total        : " + total); 
} 
} 
class Sepatu extends Barang { //Child Class Dari Kelas Barang 
public Sepatu (){ 
super("b01", "Sepatu Hijau", 300000); 
} 
} 
class Celana extends Barang { //Child Class Dari Kelas Barang 
public Celana (){ 
super("b02", "Celana Panjang", 200000); 
} 
} 
class Baju extends Barang { //Child Class Dari Kelas Barang 
public Baju (){ 
super("b03", "Baju Kemeja", 100000); 
} 
}