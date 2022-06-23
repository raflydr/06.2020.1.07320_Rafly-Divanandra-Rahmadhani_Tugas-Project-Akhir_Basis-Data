package Controller;

import Entity.JenisJajanEntity;
import Model.JenisJajanModel;

public class JenisJajanController {
    public void insertJenisJajan(String nama_jenis_jajan){
        JenisJajanModel jenisJajanModel = new JenisJajanModel();
        JenisJajanEntity jenisJajanEntity = new JenisJajanEntity(0, nama_jenis_jajan);
        jenisJajanModel.insertJenisJajan(jenisJajanEntity);
    }
    public void deleteJenisJajan(int currentId) {
        JenisJajanModel jenisJajanModel = new JenisJajanModel();
        jenisJajanModel.deleteJenisJajan(currentId);
    }
}
