package Controller;

import Entity.MengelolaEntity;
import Model.JajanModel;
import Model.MengelolaModel;

import java.util.ArrayList;
import java.util.Date;

public class MengelolaController {
    public static MengelolaModel mengelolaModel = new MengelolaModel();
    public boolean insertMengelola(ArrayList<MengelolaEntity> mengelolaEntity){
        MengelolaModel mengelolaModel = new MengelolaModel();
        return mengelolaModel.insertMengelola(mengelolaEntity);
    }
    public ArrayList<MengelolaEntity> getMengelola(){
        return new MengelolaModel().getMengelola();
    }

    public ArrayList<MengelolaEntity> getDetail(){
        return mengelolaModel.getDetail();
    }

    public void updateStok(int qty_jajan, int id_jajan){
        mengelolaModel.updateStok(qty_jajan, id_jajan);
    }
/*
    public ArrayList<MengelolaEntity> totalPembayaran(){
        return mengelolaModel.totalPembayaran();
    }
 */
    public void total(int id_transaksi){
        mengelolaModel.total(id_transaksi);
    }

    public void totalPembayaran(int id_transaksi){
        mengelolaModel.totalPembayaran(id_transaksi);
    }
    public void updateJumTrans(float total_pembayaran, int qty_jajan, int id_transaksi){
        //mengelolaModel.updateJumTrans();
        mengelolaModel.updateJumTrans(total_pembayaran, qty_jajan, id_transaksi);
    }

    public void updateTotPem(int id_transaksi){
        MengelolaModel mengelolaModel = new MengelolaModel();
        mengelolaModel.updateTotPem(id_transaksi);
    }
}
