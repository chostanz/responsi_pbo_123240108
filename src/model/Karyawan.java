package model;
public class Karyawan {
    private int id;
    private String nama;
    private String posisi;
    private double kontribusi;
    private double kedisiplinan;
    private double kerjasama;
    private double nilai_akhir;
    private String status;
    
    public Karyawan(String nama, String posisi, double kontribusi, double kedisiplinan, double kerjasama){
        if(kontribusi <0|| kontribusi >5 ||
            kedisiplinan < 0||kedisiplinan > 5|| 
                kerjasama <0||kerjasama >5){
            throw new IllegalArgumentException("Nilai harus antara 0 sampai 5!");
        }
        this.nama = nama;
        this.posisi = posisi;
        this.kontribusi = kontribusi;
        this.kedisiplinan = kedisiplinan;
        this.kerjasama = kerjasama;
        this.nilai_akhir = (kontribusi * 0.3) + (kedisiplinan * 0.3) + (kerjasama * 0.4);
        if(nilai_akhir >= 3.5 && kontribusi > 3 && kedisiplinan > 3&&kerjasama >3){
            this.status = "Lolos Perpanjang";
        }else{
            this.status = "Putus Kontrak";
        }
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getNama(){
        return nama;
    }
    public void setNama(){
        this.nama = nama;
    }
    public double getKontribusi(){
        return kontribusi;
    }
    public void setKontribusi(){
        this.kontribusi = kontribusi;
    }
    public double getKedisiplinan(){
        return kedisiplinan;
    }
    public void setKedisiplinan(){
        this.kedisiplinan = kedisiplinan;
    }
    public double getKerjasama(){
        return kerjasama;
    }
    public void setKerjasama(){
        this.kerjasama = kerjasama;
    }
    public double setNilai_akhir() {
        return nilai_akhir;
    }
    public void getNilai_akhir(){
        this.nilai_akhir = nilai_akhir;
    }
    public String setStatus(){
        return status;
    }
    public void getStatus(){
        this.status = status;
    }

}
