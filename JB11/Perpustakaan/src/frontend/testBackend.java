package frontend;
import java.sql.SQLException;

import backend.*;
public class testBackend {
public static void main(String[] args) throws SQLException
{
//Kategori kat1 = new Kategori("Novel", "Koleksi buku novel");
//Kategori kat2 = new Kategori("Referensi", "Buku referensi ilmiah");
//Kategori kat3 = new Kategori("Komik", "Komik anak-anak");
//// test insert
//kat1.save();
//kat2.save();
//kat3.save();
//// test update
//kat2.setKeterangan("Koleksi buku referensi ilmiah");
//kat2.save();
//// test delete
//kat3.delete();
//// test select all
//for(Kategori k : new Kategori().getAll())
//{
//System.out.println("Nama: " + k.getNama() + ", Ket: " + k.getKeterangan());
//}
//// test search
//for(Kategori k : new Kategori().search("ilmiah"))
//{
//System.out.println("Nama: " + k.getNama() + ", Ket: " + k.getKeterangan());

//Anggota a1 = new Anggota("Budi", "Jl. Kenanga 12", "08123456789");
//        Anggota a2 = new Anggota("Siti", "Jl. Melati 5", "08561234567");
//        Anggota a3 = new Anggota("Doni", "Jl. Kamboja 3", "08991234567");
//
//        a1.save();
//        a2.save();
//        a3.save();
//
//        // ======================
//        // TEST UPDATE
//        // ======================
//        a2.setAlamat("Jl. Melati Indah No. 7");
//        a2.save();
//
//        // ======================
//        // TEST DELETE
//        // ======================
//        a3.delete();
//
//        // ======================
//        // TEST SELECT ALL
//        // ======================
//        System.out.println("=== DATA ANGGOTA (ALL) ===");
//        for (Anggota a : new Anggota().getAll()) {
//            System.out.println("ID: " + a.getIdAnggota() 
//                    + ", Nama: " + a.getNama() 
//                    + ", Alamat: " + a.getAlamat()
//                    + ", Telepon: " + a.getTelepon());
//        }
//
//        // ======================
//        // TEST SEARCH
//        // ======================
//        System.out.println("\n=== PENCARIAN 'Melati' ===");
//        for (Anggota a : new Anggota().search("Melati")) {
//            System.out.println("ID: " + a.getIdAnggota() 
//                    + ", Nama: " + a.getNama()
//                    + ", Alamat: " + a.getAlamat()
//                    + ", Telepon: " + a.getTelepon());
//        }
    
    Kategori kat = new Kategori("Komik", "Buku Komik");
    kat.save();
    Buku buku = new Buku("aku", "gramedia", "febri", kat);
    buku.save();
    
}
}