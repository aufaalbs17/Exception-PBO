import java.util.InputMismatchException; 
import java.util.Scanner; 
public class App { 
    public static void main(String[] args) throws Exception { 
 
        int noFaktur = 1; 
        String kodeBarang = ""; 
        String lanjut = ""; 
 
        Scanner input = new Scanner (System.in); 
 
        while (true) { 
 
            Barang barang = null; 
            boolean pembayaran = false; 
 
            while (barang == null){ 
 
                System.out.println("\nKode Barang"); 
                System.out.println("1. Sepatu (b01)"); 
                System.out.println("2. Celana (b02)"); 
                System.out.println("3. Baju (b03)"); 
                System.out.println("0 = Batal"); 
 
                System.out.print("\nMasukkan Kode Barang: "); 
                kodeBarang = input.nextLine(); 
 
                //TRY 
                try{ 
                    switch (kodeBarang){ 
                        case "b01": 
                            barang = new Sepatu(); 
                            break; 
 
                        case "b02": 
                            barang = new Celana(); 
                            break; 
 
                        case "b03": 
                            barang = new Baju(); 
                            break; 
                        case "0": 
                            input.close(); 
                            System.out.println("\nTerimakasih Telah Berbelanja"); 
                            return; 
 
                    default: 
                    //Memberikan Exception ketika tidak ada kode yang sesuai 
                    throw new IllegalArgumentException("\nKode barang tidak valid. Silahkan coba lagi."); 
                    } 
                } 
                 
                //melakukan catch untuk menjalankan exception 
                catch (IllegalArgumentException e) { 
                    System.out.println(e.getMessage()); 
                } 
 
            } 
 
            //TRY 
            try { 
                System.out.println("\nNama Barang: " + barang.nama_barang); 
                System.out.print("\nMasukkan Jumlah Barang: "); 
                int jumlahBarang = input.nextInt(); 
                input.nextLine(); 
 
                if (jumlahBarang < 1){ 
                    System.out.println("Minimum Input 1"); 
                } 
 
                if (jumlahBarang > 0){ 
             
                    barang.jumlah_beli = jumlahBarang;         
                    barang.total = (float) (barang.harga_barang * jumlahBarang); 
                    barang.no_faktur = noFaktur; 
                     
                    System.out.println("\nTotal Harga: " + barang.total); 
 
                    while (pembayaran == false) { 
         
                        System.out.print("\nSilahkan Input Uang Untuk Pembayaran: "); 
                        float bayar = input.nextInt(); 
                        input.nextLine(); 
 
                        if(bayar < barang.total){ 
                            System.out.println("\nUang Anda Kurang!"); 
                            break; 
                        } 
 
                        else { 
                            System.out.println("\nPembayaran Berhasil!"); 
                            barang.faktur(); 
                            noFaktur++; 
                            pembayaran = true; 
                        } 
                    } 
                } 
            } 
 
            //melakukan catch ketika input bukan angka 
            catch (InputMismatchException e) { 
                System.out.println("\nInput Error"); 
                input.nextLine(); 
            } 
 
            while (true){ 
                try { 
                    System.out.print("\nIngin Belanja Lagi? (1 = ya)/(0 = tidak): "); 
                    lanjut =  input.nextLine(); 
 
                    if(lanjut.equals("1")){ 
                        break; 
                    } 
                         
                    else if (lanjut.equals("0")) { 
                    break; 
                    } 
 
                    else { 
                        //Memberikan exception ketika pilihan bukan 0 atau 1 
                        throw new IllegalArgumentException("Pilihan Hanya 0 atau 1"); 
                    } 
                } 
 
                //Melakukan catch untuk menjalankan exception 
                catch (IllegalArgumentException a) { 
                    System.out.println(a.getMessage()); 
                } 
            } 
 
            if (lanjut.equals("0")){ 
                break; 
            } 
        } 
 
        input.close(); 
        System.out.println("\nTerimakasih Telah Berkunjung"); 
    } 
} 
