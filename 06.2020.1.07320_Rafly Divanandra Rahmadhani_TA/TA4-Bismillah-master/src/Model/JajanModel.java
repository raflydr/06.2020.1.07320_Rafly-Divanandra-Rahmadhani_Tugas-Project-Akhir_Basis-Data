package Model;
import Database.KoneksiDB;
import Entity.JajanEntity;
import Entity.TransaksiEntity;

import java.sql.*;
import java.util.ArrayList;

public class JajanModel{
    String sql;
    public Connection conn = KoneksiDB.getconection();


    public void insertJajan(JajanEntity jajanEntity) {


        try {

            sql = String.format("INSERT INTO jajan (ID_JAJAN ,ID_JENIS_JAJAN, NAMA_JAJAN,HARGA_JAJAN,STOK_JAJAN) VALUES " +
                            "('%s', '%s', '%s', '%s', '%s');",
                    jajanEntity.getId_jajan(),
                    jajanEntity.getId_jenis_jajan(),
                    jajanEntity.getNama_jajan(),
                    jajanEntity.getHarga_jajan(),
                    jajanEntity.getStok_jajan()
            );
            PreparedStatement statement = conn.prepareStatement(sql);
            if (statement.executeUpdate() > 0) {
                System.out.println("Berhasil Menambah Data Makanan");
            } else {
                System.out.println("Gagal Menambah Data Makanan");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateJajan(int id_jajan, int id_jenis_jajan, String nama_jajan, float harga_jajan, int stok_jajan) {
        int result = 0;
        try {
            sql = String.format("UPDATE jajan set ID_JENIS_JAJAN = " + "'%s', " +
                            "NAMA_JAJAN = " + "'%s'," +
                            "HARGA_JAJAN = " + "'%s'," +
                            "STOK_JAJAN = " + "'%s' WHERE ID_JAJAN = '%s';",
                    id_jenis_jajan, nama_jajan, harga_jajan, stok_jajan, id_jajan
            );
            PreparedStatement statement = conn.prepareStatement(sql);
            result = statement.executeUpdate();
            if (result > 0) {
                System.out.println("Berhasil Mengubah Data");
            } else {
                System.out.println("Gagal Mengubah Data");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteJajan(int id) {
        int result = 0;

        try {
            Connection conn = KoneksiDB.getconection();
            String sql = String.format("DELETE FROM jajan WHERE ID_JAJAN = '%s';",
                    id
            );
            PreparedStatement statement = conn.prepareStatement(sql);
            result = statement.executeUpdate();
            if (result > 0) {
                System.out.println("Berhasil Menghapus Data");
            } else {
                System.out.println("Gagal Menghapus Data");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<JajanEntity> getJajan(){
        ArrayList<JajanEntity> jajanEntities = new ArrayList<>();
        try {
            String sql = "select *" +
                    "from jajan ";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                JajanEntity jajanEntity = new JajanEntity();
                jajanEntity.setId_jajan(rs.getInt("id_jajan"));
                jajanEntity.setId_jenis_jajan(rs.getInt("id_jenis_jajan"));
                jajanEntity.setNama_jajan(rs.getString("nama_jajan"));
                jajanEntity.setHarga_jajan(rs.getFloat("harga_jajan"));
                jajanEntity.setStok_jajan(rs.getInt("stok_jajan"));
                jajanEntities.add(jajanEntity);
                //transaksiEntities.add(transaksiEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jajanEntities;
    }
}
