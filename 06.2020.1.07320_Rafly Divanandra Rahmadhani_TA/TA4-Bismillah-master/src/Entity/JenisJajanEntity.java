package Entity;

public class JenisJajanEntity {
    private int id_jenis_jajan;
    private String nama_jenis_jajan;


    public  JenisJajanEntity() {
    }

    public JenisJajanEntity(int id_jenis_jajan, String nama_jenis_jajan){
        this.id_jenis_jajan=id_jenis_jajan;
        this.nama_jenis_jajan=nama_jenis_jajan;
    }


    public int getId_jenis_jajan() {
        return id_jenis_jajan;
    }
    public void setId_jenis_jajan(int id_jenis_jajan) {
        this.id_jenis_jajan = id_jenis_jajan;
    }


    public String getNama_jenis_jajan() {
        return nama_jenis_jajan;
    }
    public void setNama_jenis_jajan(String nama_jenis_jajan) {
        this.nama_jenis_jajan = nama_jenis_jajan;
    }
}
