package Controller;

import Entity.JajanEntity;
import Entity.MengelolaEntity;
import Model.JajanModel;
import Model.MengelolaModel;

import java.util.ArrayList;

public class JajanController {
    JajanModel jajanModel = new JajanModel();
    public void insertJajan(int id_jenis_jajan, String nama_jajan, float harga_jajan, int stok_jajan) {
        JajanModel jajanModel = new JajanModel();
        JajanEntity jajanEntity = new JajanEntity (0, id_jenis_jajan, nama_jajan, harga_jajan, stok_jajan);
        jajanModel.insertJajan(jajanEntity);
    }
    public void updateJajan(int id_jajan,int id_jenis_jajan,String nama_jajan,float harga_jajan,int stok_jajan){
        JajanModel jajanModel = new JajanModel();
        jajanModel.updateJajan(id_jajan,id_jenis_jajan,nama_jajan,harga_jajan,stok_jajan);
    }

    public void deleteJajan(int currentId) {
        JajanModel jajanModel = new JajanModel();
        jajanModel.deleteJajan(currentId);
    }

    public ArrayList<JajanEntity> getJajan(){
        return new JajanModel().getJajan();
    }
}
