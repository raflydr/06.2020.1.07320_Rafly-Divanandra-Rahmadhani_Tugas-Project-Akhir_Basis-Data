package Entity;
import java.util.Date;
import Entity.TransaksiEntity;

public class MengelolaEntity extends TransaksiEntity{
    TransaksiEntity transaksiEntity = new TransaksiEntity();
    private int id_jajan, id_transaksi, qty_jajan;
    private float total_pembayaran;
    private Date tgl_transaksi;
    private int id_transaksi1;

    //private TransaksiEntity id_transaksi1;
    //private TransaksiEntity tgl_transaksi;
    //public static JajanEntity jajanEntity = new JajanEntity();
    //public static TransaksiEntity transaksiEntity = new TransaksiEntity();


    public  MengelolaEntity() {
    }

    public MengelolaEntity(int id_jajan, int id_transaksi, int qty_jajan, float total_pembayaran){
        this.id_jajan = id_jajan;
        this.id_transaksi = id_transaksi;
        this.qty_jajan = qty_jajan;
        //this.harga_qty_jajan = harga_qty_jajan;
        this.total_pembayaran = total_pembayaran;

        //this.id_transaksi1 = id_transaksi1;
        //this.tgl_transaksi = tgl_transaksi;
        //this.tgl_transaksi = tgl_transaksi;
    }
    //public TransaksiEntity transaksiEntity (int id_transaksi, Date tgl_transaksi){
        //this.id_transaksi1 = id_transaksi;
        //this.tgl_transaksi = tgl_transaksi;
      //  return transaksiEntity(id_transaksi, tgl_transaksi);
    //}

    public int getId_jajan() {
        return id_jajan;
    }
    public void setId_jajan(int id_jajan) {
        this.id_jajan = id_jajan;
    }

    public int getId_transaksi() {
        return id_transaksi;
    }
    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public int getQty_jajan() {
        return qty_jajan;
    }
    public void setQty_jajan(int qty_jajan) {
        this.qty_jajan = qty_jajan;
    }



/*
    public TransaksiEntity getId_transaksi1(){
        return id_transaksi1;
    }
    public void setId_transaksi1(TransaksiEntity id_transaksi1){
        this.id_transaksi1 = id_transaksi1;
        }
        */
    public int getId_transaksi1(){
        return id_transaksi1;
    }
    public void setId_transaksi1(){
        this.id_transaksi1 = id_transaksi1;
    }
    public Date getTgl_transaksi(){
        return tgl_transaksi;
    }
    public void setTgl_transaksi(Date tgl_transaksi){
        this.tgl_transaksi = tgl_transaksi;
    }

    public float getTotal_pembayaran() {
        return total_pembayaran;
    }
    public void setTotal_pembayaran(float total_pembayaran) {
        this.total_pembayaran = total_pembayaran;
    }
}
