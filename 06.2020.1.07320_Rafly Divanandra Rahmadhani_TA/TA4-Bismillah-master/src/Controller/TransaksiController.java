package Controller;

import Entity.JajanEntity;
import Entity.TransaksiEntity;
import Model.JajanModel;
import Model.TransaksiModel;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.Date;

public class TransaksiController {
    public void insertTransaksi(Date tgl_transaksi) {
        TransaksiModel transaksiModel = new TransaksiModel();
        TransaksiEntity transaksiEntity = new TransaksiEntity(0, tgl_transaksi);
        transaksiModel.insertTransaksi(transaksiEntity);
    }
    public ArrayList<TransaksiEntity> getTransaksi(){
        return new TransaksiModel().getTransaksi();
    }
}
