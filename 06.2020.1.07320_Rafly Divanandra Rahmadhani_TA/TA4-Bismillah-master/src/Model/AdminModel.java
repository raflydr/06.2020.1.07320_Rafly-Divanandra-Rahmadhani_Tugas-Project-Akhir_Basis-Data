package Model;

import Entity.AdminEntity;

public class AdminModel extends AdminEntity {
    private static AdminEntity[] admin = new AdminEntity[100];
    public void insert(String[] nama, String[] pass){
        admin[0] = new AdminEntity(nama[0], pass[0]);
    }

    public AdminEntity getAdmin(){
        return admin[0];
    }
    public void view(){
        System.out.println("Nama : " + admin[0].getNama() + "\nPass " + admin[0].getPass());
    }
    public boolean cekAdmin(String nama, String pass){
        if(admin[0].getNama().equals(nama) && admin[0].getPass().equals(pass)){
            System.out.println("login berhasil");
            return true;
        }else {
            System.out.println("login gagal");
            return false;
        }
    }
}
