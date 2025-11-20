/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;


import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author Admin
 */
public class Buku {
    private int idBuku;
    private String judul;
    private String penerbit;
    private String tahun;
    private Kategori kategori;
    private int idKategori; // tambahan jika ingin menyimpan idKategori secara terpisah

    public Buku() {
    }

    public Buku(String judul, String penerbit, String tahun, Kategori kategori) {
        this.judul = judul;
        this.penerbit = penerbit;
        this.tahun = tahun;
        this.kategori = kategori;
        this.idKategori = kategori.getIdKategori();
    }

    public int getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(int idBuku) {
        this.idBuku = idBuku;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public int getIdKategori() {
        return idKategori;
    }

    public void setIdKategori(int idKategori) {
        this.idKategori = idKategori;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public Buku getById(int id) {
        Buku buku = new Buku();
        String sql = "SELECT b.*, k.nama AS nama_kategori FROM buku b " +
                     "LEFT JOIN kategori k ON b.idkategori = k.idkategori " +
                     "WHERE b.idbuku = " + id;

        ResultSet rs = dbHelper.selectQuery(sql);
        try {
            if (rs.next()) {
                Kategori k = new Kategori();
                k.setIdKategori(rs.getInt("idkategori"));
                k.setNama(rs.getString("nama_kategori"));

                buku.setIdBuku(rs.getInt("idbuku"));
                buku.setJudul(rs.getString("judul"));
                buku.setPenerbit(rs.getString("penerbit"));
                buku.setTahun(rs.getString("tahun"));
                buku.setKategori(k);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buku;
    }

    public ArrayList<Buku> getAll() {
        ArrayList<Buku> list = new ArrayList<>();
        String sql = "SELECT b.*, k.nama AS nama_kategori FROM buku b " +
                     "LEFT JOIN kategori k ON b.idkategori = k.idkategori";

        ResultSet rs = dbHelper.selectQuery(sql);
        try {
            while (rs.next()) {
                Kategori k = new Kategori();
                k.setIdKategori(rs.getInt("idkategori"));
                k.setNama(rs.getString("nama_kategori"));

                Buku buku = new Buku();
                buku.setIdBuku(rs.getInt("idbuku"));
                buku.setJudul(rs.getString("judul"));
                buku.setPenerbit(rs.getString("penerbit"));
                buku.setTahun(rs.getString("tahun"));
                buku.setKategori(k);

                list.add(buku);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Buku> search(String keyword) {
        ArrayList<Buku> list = new ArrayList<>();
        String sql = "SELECT b.*, k.nama AS nama_kategori FROM buku b " +
                     "LEFT JOIN kategori k ON b.idkategori = k.idkategori " +
                     "WHERE b.judul ILIKE '%" + keyword + "%' " +
                     "OR k.nama ILIKE '%" + keyword + "%'";

        ResultSet rs = dbHelper.selectQuery(sql);
        try {
            while (rs.next()) {
                Kategori k = new Kategori();
                k.setIdKategori(rs.getInt("idkategori"));
                k.setNama(rs.getString("nama_kategori"));

                Buku buku = new Buku();
                buku.setIdBuku(rs.getInt("idbuku"));
                buku.setJudul(rs.getString("judul"));
                buku.setPenerbit(rs.getString("penerbit"));
                buku.setTahun(rs.getString("tahun"));
                buku.setKategori(k);

                list.add(buku);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void save() {
        if (getById(this.idBuku).getIdBuku() == 0) {
            String SQL = "INSERT INTO buku (judul, penerbit, tahun, idkategori) VALUES (\'" +
                         this.judul + "\', \'" + this.penerbit + "\', \'" + this.tahun + "\', " +
                         this.kategori.getIdKategori() + ") RETURNING idbuku";
            this.idBuku = dbHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE buku SET judul = \'" + this.judul + "\', penerbit = \'" +
                         this.penerbit + "\', tahun = \'" + this.tahun + "\', idkategori = " +
                         this.kategori.getIdKategori() + " WHERE idbuku = " + this.idBuku;
            dbHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        String SQL = "DELETE FROM buku WHERE idbuku = " + this.idBuku;
        dbHelper.executeQuery(SQL);
    }
}

