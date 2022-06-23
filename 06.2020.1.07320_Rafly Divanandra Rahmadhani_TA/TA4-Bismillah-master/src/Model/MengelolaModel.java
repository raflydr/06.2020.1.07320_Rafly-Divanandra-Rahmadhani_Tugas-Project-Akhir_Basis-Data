package Model;

import Database.KoneksiDB;
import Entity.JajanEntity;
import Entity.MengelolaEntity;
import Entity.TransaksiEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

public class MengelolaModel {
    String sql;
    public Connection conn = KoneksiDB.getconection();
    public MengelolaEntity mengelola = new MengelolaEntity();

    public ArrayList<MengelolaEntity> getMengelola() {
        ArrayList<MengelolaEntity> mengelolaEntities = new ArrayList<>();
        try {
            String sql = "select *" +
                    "from mengelola ";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                MengelolaEntity mengelolaEntity = new MengelolaEntity();
                mengelolaEntity.setId_jajan(rs.getInt("id_jajan"));
                mengelolaEntity.setId_transaksi(rs.getInt("id_transaksi"));
                mengelolaEntity.setQty_jajan(rs.getInt("qty_jajan"));
                //mengelolaEntity.setHarga_qty_jajan(rs.getFloat("harga_qty_jajan"));
                mengelolaEntity.setTotal_pembayaran(rs.getFloat("total_pembayaran"));
                mengelolaEntities.add(mengelolaEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mengelolaEntities;
    }
    public ArrayList<MengelolaEntity> getDetail() {
        ArrayList<MengelolaEntity> mengelolaEntities = new ArrayList<>();
        try {
            String sql = "select * from transaksi t right join mengelola m on t.id_transaksi = m.id_transaksi";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                MengelolaEntity mengelolaEntity = new MengelolaEntity();
                mengelolaEntity.setId_jajan(rs.getInt("id_jajan"));
                mengelolaEntity.setId_transaksi(rs.getInt("id_transaksi"));
                mengelolaEntity.setQty_jajan(rs.getInt("qty_jajan"));
                //mengelolaEntity.setHarga_qty_jajan(rs.getFloat("harga_qty_jajan"));
                mengelolaEntity.setTotal_pembayaran(rs.getFloat("total_pembayaran"));
                //mengelolaEntity.setId_transaksi1(rs.getInt("id_transaksi"));
                mengelolaEntity.setTgl_transaksi(rs.getDate("tgl_transaksi"));
                mengelolaEntities.add(mengelolaEntity);
                //mengelolaEntities.add(transaksiEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mengelolaEntities;
    }

    public void updateStok(int qty_jajan, int id_jajan){
        //int result = 0;
        try {
            sql = "UPDATE jajan SET stok_jajan=stok_jajan-? WHERE id_jajan = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, qty_jajan);
            statement.setInt(2, id_jajan);
            statement.executeUpdate();

        }catch (SQLException e){
            System.out.println("Gagal Update");
            e.printStackTrace();
        }

    }

    /*
    public ArrayList<MengelolaEntity> totalPembayaran(){
        ArrayList<MengelolaEntity> mengelolaEntities = new ArrayList<>();
        //int result = 0;
        try {
            String sql = "select SUM(harga_qty_jajan) as total from mengelola where id_transaksi = 2";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                MengelolaEntity mengelolaEntity = new MengelolaEntity();
                mengelolaEntity.setTotal_pembayaran(rs.getFloat("total"));
            }
        }catch (SQLException e){
            System.out.println("Gagal Update");
            e.printStackTrace();
        }
        return mengelolaEntities;

    }
     */

    public void total(int id_transaksi){
        try {

            String sql = "select SUM(harga_qty_jajan) as total from mengelola where id_transaksi = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_transaksi);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                mengelola.setTotal_pembayaran(rs.getFloat("total"));
                System.out.println(rs.getFloat("total"));
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void totalPem(int id_transaksi){
        //int result = 0;
        try {
            sql = "SELECT SUM(harga_qty_jajan) AS total_pembayaran FROM mengelola WHERE id_transaksi = ?";
            //sql = "UPDATE jajan SET stok_jajan=stok_jajan-? WHERE id_jajan = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id_transaksi);
            //statement.setInt(2, id_jajan);
            statement.executeUpdate();

        }catch (SQLException e){
            System.out.println("Gagal Update");
            e.printStackTrace();
        }

    }

    public void totalPembayaran(int id_transaksi){
        try {

            sql = String.format("select SUM(harga_qty_jajan) as total from mengelola where id_transaksi = '%s';",
                    id_transaksi

            );
            PreparedStatement statement = conn.prepareStatement(sql);
            if (statement.executeUpdate() > 0) {
                System.out.println("Berhasil Menambah Total");
            } else {
                System.out.println("Gagal Menambah Total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean insertMengelola(ArrayList<MengelolaEntity> mengelolaEntity) {
        ArrayList<MengelolaEntity> mengelolaEntities = new ArrayList<>();
        try {
            for (MengelolaEntity i : mengelolaEntity
            ) {sql = String.format("INSERT INTO mengelola (ID_JAJAN ,ID_TRANSAKSI, QTY_JAJAN, " +
                            " TOTAL_PEMBAYARAN) VALUES " +
                            "('%s', '%s', '%s', '%s');",
                    i.getId_jajan(),
                    i.getId_transaksi(),
                    i.getQty_jajan(),
                    i.getTotal_pembayaran());
                PreparedStatement statement = conn.prepareStatement(sql);
                if (statement.executeUpdate() > 0) {
                    System.out.println("Berhasil Menambah Data");
                } else {
                    System.out.println("Gagal Menambah Data");
                    break;
                }

            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    public void updateJumTrans(float total_pembayaran, int qty_jajan, int id_transaksi){
        //int result = 0;
        try {
            sql = "update mengelola inner join jajan on mengelola.id_jajan = jajan.id_jajan set ? = harga_jajan * ? where id_transaksi= ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setFloat(1, total_pembayaran);
            statement.setInt(2, qty_jajan);
            statement.setInt(3, id_transaksi);

            //statement.setInt(2, id_jajan);
            statement.executeUpdate();

        }catch (SQLException e){
            System.out.println("Gagal Update");
            e.printStackTrace();
        }

    }

    public void updateTotPem(int id_transaksi) {
        int result = 0;
        try {
            sql = String.format("update mengelola inner join jajan on mengelola.id_jajan = jajan.id_jajan set total_pembayaran = harga_jajan * qty_jajan " +
                            "where id_transaksi= '%s';",
                    id_transaksi
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
}
