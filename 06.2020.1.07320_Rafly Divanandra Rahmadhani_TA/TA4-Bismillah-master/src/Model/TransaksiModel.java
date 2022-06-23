package Model;
import Database.KoneksiDB;
import Entity.JajanEntity;
import Entity.TransaksiEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TransaksiModel{
    String sql;
    int result =0;
    public Connection conn = KoneksiDB.getconection();
    public ArrayList<TransaksiEntity> getTransaksi(){
        ArrayList<TransaksiEntity> transaksiEntities = new ArrayList<>();
        try {
            String sql = "select *" +
                    "from transaksi ";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                TransaksiEntity transaksiEntity = new TransaksiEntity();
                transaksiEntity.setId_transaksi(rs.getInt("id_transaksi"));
                transaksiEntity.setTgl_transaksi(rs.getDate("tgl_transaksi"));
                transaksiEntities.add(transaksiEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transaksiEntities;
    }
    public void insertTransaksi(TransaksiEntity transaksiEntity){
        try {
            sql = String.format("INSERT INTO transaksi (ID_TRANSAKSI, TGL_TRANSAKSI) VALUES " +
                            "('%s', NOW());",
                    transaksiEntity.getId_transaksi(),
                    transaksiEntity.getTgl_transaksi()
                    //transaksiEntity.getJumlah_pembayaran()
            );
            PreparedStatement statement = conn.prepareStatement(sql);
            result = statement.executeUpdate();
            if(result > 0){
                System.out.println("Berhasil Menambah Data Transaksi");
            }else{
                System.out.println("Gagal Menambah Data Transaksi");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
