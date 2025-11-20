/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Anggota {
    private int idAnggota;
    private String nama;
    private String alamat;
    private String telepon;

    public Anggota (int idAnggota, String nama, String alamat, String telepon) {
        this.idAnggota = idAnggota;
        this.nama = nama;
        this.alamat = alamat;
        this.telepon = telepon;
    }

    public int getIdAnggota() {
        return idAnggota;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }
    
    public String getTelepon() {
        return telepon;
    }

    public void setIdAnggota(int idAnggota) {
        this.idAnggota = idAnggota;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public Anggota(){

    }

    public Anggota(String nama, String alamat, String telepon){
        this.nama = nama;
        this.alamat = alamat;
        this.telepon = telepon;
    }

    public Anggota getById (int id) throws SQLException{
        Anggota anggota = new Anggota();
        ResultSet rs = dbHelper.selectQuery("select * from anggota " + " where idanggota = '" + id + "'");

        try{
            while(rs.next()){
                anggota = new Anggota();
                anggota.setIdAnggota(rs.getInt("idanggota"));
                anggota.setNama(rs.getString("nama"));
                anggota.setAlamat(rs.getString("alamat"));
                anggota.setTelepon(rs.getString("telepon"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return anggota;
    }

    public ArrayList<Anggota> getAll() {
        ArrayList<Anggota> ListAnggota = new ArrayList();
        
        ResultSet rs = dbHelper.selectQuery("SELECT * FROM anggota");
        
        try {
            while(rs.next()) {
                
                Anggota anggota = new Anggota();
                anggota.setIdAnggota(rs.getInt("idanggota"));
                anggota.setNama(rs.getString("nama"));
                anggota.setAlamat(rs.getString("alamat"));
                anggota.setTelepon(rs.getString("telepon"));
                
                ListAnggota.add(anggota);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ListAnggota;
    }

    public ArrayList<Anggota> search(String keyword) {
        ArrayList<Anggota> ListAnggota = new ArrayList();

        String sql = "SELECT * FROM anggota WHERE "
                + " nama ILIKE '%" + keyword + "%' "
                + " OR alamat ILIKE '%" + keyword + "%' "
                + " OR telepon ILIKE '%" + keyword + "%'";

        ResultSet rs = dbHelper.selectQuery(sql);

        try {
            while(rs.next()) {

                Anggota anggota = new Anggota();
                anggota.setIdAnggota(rs.getInt("idanggota"));
                anggota.setNama(rs.getString("nama"));
                anggota.setAlamat(rs.getString("alamat"));
                anggota.setTelepon(rs.getString("telepon"));

                ListAnggota.add(anggota);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListAnggota;
    }

    public void save() throws SQLException {
    if(getById(this.idAnggota).getIdAnggota() == 0) {
        
        String SQL = "INSERT INTO anggota (nama, alamat, telepon) VALUES("
                + " '" + this.nama + "',"
                + " '" + this.alamat + "',"
                + " '" + this.telepon + "')";
                
        this.idAnggota = dbHelper.insertQueryGetId(SQL);
        
    } else {
        
        String SQL = "UPDATE anggota SET "
                + " nama = '" + this.nama + "',"
                + " alamat = '" + this.alamat + "',"
                + " telepon = '" + this.telepon + "'"
                + " WHERE idanggota = '" + this.idAnggota + "'";
                
        dbHelper.executeQuery(SQL);
    }
}

    
    public void delete() {
    
        String SQL = "DELETE FROM anggota WHERE idanggota = '" + this.idAnggota + "'";
        dbHelper.executeQuery(SQL);
        
    }
}
