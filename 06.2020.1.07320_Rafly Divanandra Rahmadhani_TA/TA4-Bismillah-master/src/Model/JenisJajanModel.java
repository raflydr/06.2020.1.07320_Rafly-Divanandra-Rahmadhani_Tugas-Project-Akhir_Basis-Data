package Model;
import Entity.JenisJajanEntity;
import Database.KoneksiDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JenisJajanModel{
    String sql;
    public Connection conn = KoneksiDB.getconection();

    public void insertJenisJajan(JenisJajanEntity jenisJajanEntity){
        try {
            sql = String.format("INSERT INTO jenis_jajan (ID_JENIS_JAJAN, NAMA_JENIS_JAJAN) VALUES " +
                            "('%s', '%s');",
                    jenisJajanEntity.getId_jenis_jajan(),
                    jenisJajanEntity.getNama_jenis_jajan()
            );
            PreparedStatement statement = conn.prepareStatement(sql);
            if(statement.executeUpdate() > 0){
                System.out.println("Berhasil Menambah Data Jenis Makanan");
            }else{
                System.out.println("Gagal Menambah Data Jenis Makanan");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteJenisJajan(int id_jenis_jajan){
        int result = 0;

        try {
            Connection conn = KoneksiDB.getconection();
            String sql = String.format("DELETE FROM jenis_jajan WHERE ID_JENIS_JAJAN = '%s';",
                    id_jenis_jajan
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
}
