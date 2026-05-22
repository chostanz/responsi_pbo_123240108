package controller;
import model.Karyawan;
import responsi_pbo_123240108.Responsi_pbo_123240108;
import database.Koneksi;
import view.FrameKaryawan;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class KaryawanController {
    FrameKaryawan view;
    int selectedId;
    
    public KaryawanController(FrameKaryawan view){
        this.view = view;
    }
    
    public void clearForm(){
        view.getjTextFieldNama().setText("");
        view.getjComboBoxPosisi().setItem("Default");
        view.getjTextKontribusi().setText("");
        view.getjTextFieldKedisiplinan().setText("");
        view.getjTextFieldKerjasama().setText("");
    }
    
    public void loadData(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nama");
        model.addColumn("Posisi");
        model.addColumn("Kontribusi");
        model.addColumn("Kedisiplinan");
        model.addColumn("Kerjasama");
        model.addColumn("Nilai Akhir");
        model.addColumn("Status");
        String sql = """
                        SELECT * FROM karyawan;
                     """;
        try {
            //maaf mas/mba koenksinya gatau karna ga keprint ternyata query databasenyaa jadi seingetku aja T-T
            ResultSet rs = PreparedStatement(sql); 
            while(rs.next()){
                model.addRow(newObject[]{
                rs.getInt("id"),
                rs.getString("nama"),
                rs.getString("posisi"),
                rs.getDouble("kontribusi"),
                rs.getDouble("kedisiplinan"),
                rs.getDouble("kerjasama"),
                rs.getDouble("nilai_akhir"),
                rs.getString("status")
            });
            }
            view.getTabelKaryawan().setModel(model);
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    
    public void tambah(){
        try{
            String nama = view.getjTextFieldNama().getText();
            String posisi = view.getjComboBoxPosisi().getText();
            Double kontribusi = Double.parseDouble(view.jTextFieldKontribusi().getText());
            Double kedisiplinan = Double.parseDouble(view.jTextFieldKedisiplinan().getText());
            Double kerjasama = Double.parseDouble(view.jTextFieldKerjasama().getText());
            Karyawan karyawan = new Karyawan(nama, posisi, kontribusi, kedisiplinan, kerjasama);
            String sql = "INSERT INTO karyawan "+
                     "(nama, posisi, kontribusi, kedisiplinan, kerjasama, nilai_akhir, status)"+
                    "VALUES (?,?,?,?,?,?,?)"; 
            nama = setNama(nama);
            posisi = setPosisi(posisi);
            kontribusi = setKontribusi(kontribusi);
            kedisiplinan = setKedisiplinan(kedisiplinan);
            kerjasama = setKerjasama(kontribusi);
            nilai_kontribusi = setKontribusi(kontribusi);

            conn = PreparedStatement(sql);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void update(){
        try{
            String nama = view.getjTextFieldNama().getText();
            String posisi = view.getjComboBoxPosisi().getText();
            Double kontribusi = Double.parseDouble(view.jTextFieldKontribusi().getText());
            Double kedisiplinan = Double.parseDouble(view.jTextFieldKedisiplinan().getText());
            Double kerjasama = Double.parseDouble(view.jTextFieldKerjasama().getText());
            double nilai_akhir = (kontribusi * 0.3) + (kedisiplinan * 0.3) + (kerjasama * 0.4);
            Karyawan karyawan = new Karyawan(nama, posisi, kontribusi, kedisiplinan, kerjasama);
            String sql = "UPDATE karyawan SET nama =  " nama +
                        "posisi = " posisi+
                        "kontribusi = " kontribusi +
                        "kedisiplinan = " kedisiplinan +
                        "kerjasama = " kerjasama +
                        "nilai akhir = " nilai_akhir+
                        "WHERE id = "selectedId;
                    ; //ga inget query databasenya syntaxnya gimana T-T
            conn = PreparedStatement(sql);
            JOptionPane.showMessageDialog(null, sql);
            loadData();
            clearForm();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void delete(){
       try{
           String sql = "DELETE FROM karyawan where id = " selectedID;
           JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
           loadData();
           clearForm();
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
    }
    
    public void klikTable(){
       try{
           int baris = view.getTabelKaryawan().selectedRow();
           selectedId = Integer.parseInt(view.getTabelKaryawan().getModel().getValueAt(baris, 0).toString());
           view.getjTextFieldNama().setText(view.getTabelKaryawan().getValueAt(baris, 1), toString());
           view.getjComboBoxPosisi().setText(view.getTabelKaryawan().getValueAt(baris, 2), toString());
           view.getjTextFieldKontribusi().setText(view.getTabelKaryawan().getValueAt(baris, 3), toString());
           view.getjTextFieldKedisiplinan().setText(view.getTabelKaryawan().getValueAt(baris, 4), toString());
           view.getjTextFieldKerjasama().setText(view.getTabelKaryawan().getValueAt(baris, 5), toString());
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
    }
    
}
