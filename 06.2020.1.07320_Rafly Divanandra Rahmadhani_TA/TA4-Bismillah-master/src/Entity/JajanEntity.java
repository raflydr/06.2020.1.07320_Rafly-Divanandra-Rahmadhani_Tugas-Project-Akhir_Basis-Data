package Entity;

public class JajanEntity {
    private int id_jajan, id_jenis_jajan, stok_jajan;
    private String nama_jajan;
    private float harga_jajan;
//private int stok_jajan;

    public  JajanEntity() {
    }

    public JajanEntity(int id_jajan, int id_jenis_jajan,String nama_jajan, float harga_jajan,int stok_jajan) {
        this.id_jajan = id_jajan;
        this.id_jenis_jajan = id_jenis_jajan;
        this.nama_jajan = nama_jajan;
        this.harga_jajan = harga_jajan;
        this.stok_jajan = stok_jajan;
    }

    public int getId_jajan() {
        return id_jajan;
    }
    public void setId_jajan(int id_jajan) {
        this.id_jajan = id_jajan;
    }

    public int getId_jenis_jajan() {
        return id_jenis_jajan;
    }
    public void setId_jenis_jajan(int id_jenis_jajan) {
        this.id_jenis_jajan = id_jenis_jajan;
    }


    public String getNama_jajan() {
        return nama_jajan;
    }
    public void setNama_jajan(String nama_jajan) {
        this.nama_jajan = nama_jajan;
    }

    public float getHarga_jajan() {
        return harga_jajan;
    }
    public void setHarga_jajan(float harga_jajan) {
        this.harga_jajan = harga_jajan;
    }

    public int getStok_jajan() {
        return stok_jajan;
    }
    public void setStok_jajan(int stok_jajan) {
        this.stok_jajan = stok_jajan;
    }
}
