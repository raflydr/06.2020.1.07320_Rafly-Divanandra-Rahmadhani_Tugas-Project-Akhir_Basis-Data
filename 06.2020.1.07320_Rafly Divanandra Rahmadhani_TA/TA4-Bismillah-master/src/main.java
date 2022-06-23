import Controller.JajanController;
import Controller.JenisJajanController;
import Controller.MengelolaController;
import Controller.TransaksiController;
import Entity.*;
import Model.AdminModel;
import Model.MengelolaModel;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static Scanner input = new Scanner(System.in);
    public static JajanEntity jajanEntity = new JajanEntity();
    public static JajanController jajanController = new JajanController();
    public static MengelolaEntity mengelolaEntity = new MengelolaEntity();
    public static MengelolaController mengelolaController = new MengelolaController();
    public static AdminEntity adminEntity = new AdminEntity();
    public static AdminModel adminModel = new AdminModel();
    public static TransaksiController transaksiController = new TransaksiController();
    private static boolean cekAdmin;
    public static float total;

    public static void main(String[] args) {
        int pil;
        dataAdmin();

        System.out.print("Username : ");
        adminEntity.setNama(input.next());
        //String nama = input.next();
        System.out.print("Password : ");
        //String pass = input.next();
        adminEntity.setPass(input.next());
        cekAdmin = adminModel.cekAdmin(adminEntity.getNama(), adminEntity.getPass());
        //System.out.println("Selamat Datang " + adminEn.getAdmin()[cekAdmin].getNama());
        while(cekAdmin) {

            do {
                System.out.println("""
                        Menu :
                        1. Data jajan
                        2. Data Jenis Jajan
                        3. Data Transaksi
                        Masukakan Pilihan  :        
                        """);
                pil = input.nextInt();
                switch (pil) {
                    case 1 -> {
                        do {
                            System.out.print("""
                                    Data Jajan:
                                    1. Insert Jajan
                                    2. Update Jajan
                                    3. Delete Jajan
                                    4. Exit
                                    Masukkan Pilihan :
                                    """);
                            pil = input.nextInt();
                            switch (pil) {
                                case 1 -> insertJajan();
                                case 2 -> updateJajan();
                                case 3 -> deleteJajan();
                                case 4 -> System.out.println("Logout...");
                                default -> System.out.println("Inputan Salah");
                            }
                        } while (pil != 4);
                    }
                    case 2 -> {
                        do {
                            System.out.print("""
                                    Data Jenis Jajan :
                                    1. Insert Jenis Jajan
                                    2. Delete Jenis Jajan
                                    3. Exit
                                    Masukkan Pilihan :
                                    """);
                            pil = input.nextInt();
                            switch (pil) {
                                case 1 -> insertJenisJajan();
                                case 2 -> deleteJenisJajan();
                                case 3 -> System.out.println("Logout...");
                                default -> System.out.println("Inputan Salah");
                            }
                        } while (pil != 3);
                    }
                    case 3 -> {
                        do {
                            System.out.print("""
                                    Data Transaksi :
                                    1. Insert Transaksi 
                                    2. Insert Detail Transaksi 
                                    3. View Transaksi 
                                    4. Exit
                                    Masukkan Pilihan :    
                                    """);
                            pil = input.nextInt();
                            switch (pil) {
                                case 1 -> insertTransaksi();
                                case 2 -> insertMengelola();
                                case 3 -> viewDetail();
                                case 4 -> System.out.println("Logout..");
                                default -> System.out.println("Inputan Salah");
                            }
                        } while (pil != 4);
                    }

                }
            } while (pil != 3);
        }
    }
    //viewDetail()

    static void dataAdmin(){
        String nama[] = {"admin"};
        String pass[] = {"admin"};
        adminModel.insert(nama, pass);
    }

    private static void insertJenisJajan() {
        JenisJajanEntity jenisJajanEntity = new JenisJajanEntity();
        System.out.print("Masukan Nama Jenis Jajan : ");
        jenisJajanEntity.setNama_jenis_jajan(input.next());

        JenisJajanController jenisJajanController = new JenisJajanController();
        jenisJajanController.insertJenisJajan(jenisJajanEntity.getNama_jenis_jajan());
    }

    public static void insertJajan() {
        viewJajan();
        System.out.print("Masukan ID Jenis Jajan : ");
        jajanEntity.setId_jenis_jajan(input.nextInt());
        System.out.print("Masukan Nama Jajan: ");
        jajanEntity.setNama_jajan(input.next());
        System.out.print("Masukan Harga Jajan: ");
        jajanEntity.setHarga_jajan(input.nextFloat());
        System.out.print("Masukan Stok Jajan: ");
        jajanEntity.setStok_jajan(input.nextInt());

        jajanController.insertJajan(jajanEntity.getId_jenis_jajan(),jajanEntity.getNama_jajan(), jajanEntity.getHarga_jajan(),
                jajanEntity.getStok_jajan());
    }
/*
    public static void totalPembayaran(){
        ArrayList<MengelolaEntity> mengelolaEntities = mengelolaController.totalPembayaran();
        if(mengelolaEntities.size() == 0) {
            System.out.println("Tidak Ada Data");
            return;
        }
        for(MengelolaEntity index : mengelolaEntities) {
            //TransaksiEntity transaksiEntity = transaksiEntities.get();
            System.out.println("total pembayaran : " + index.getTotal_pembayaran());
        }
        //System.out.print("masukkan ID : ");
        //mengelolaEntity.setId_transaksi(input.nextInt());
        //mengelolaController.totalPembayaran();
        //System.out.print("total : ");
        //mengelolaEntity.getTotal_pembayaran();
        //mengelolaController.totalPembayaran(mengelolaEntity.getId_transaksi());
    }
 */

    private static void total(){
        System.out.println("masukkan id : ");
        int id_transaksi = input.nextInt();
        System.out.println("total : ");
        mengelolaController.total(id_transaksi);

    }
    private static void viewJajan(){
        ArrayList<JajanEntity> jajanEntities = jajanController.getJajan();
        if(jajanEntities.size() == 0) {
            System.out.println("There is no data");
            return;
        }
        for(JajanEntity index : jajanEntities) {
            System.out.println("id jajan : " + index.getId_jajan());
            System.out.println("id jenis jajan : " + index.getId_jenis_jajan());
            System.out.println("nama jajan : " + index.getNama_jajan());
            System.out.println("harga jajan : " + index.getHarga_jajan());
            System.out.println("stok jajan : " + index.getStok_jajan());
            System.out.println(" ");
        }
    }

    public static void updateJajan() {
        //jajanController.viewJajan();
        viewJajan();
        System.out.println("Masukan ID Jajan : ");
        int id_jajan = input.nextInt();
        System.out.println("Masukan ID Jenis Jajan : ");
        int id_jenis_jajan = input.nextInt();
        System.out.println("Masukan Nama Jajan : ");
        String nama_jajan = input.next();
        System.out.println("Masukan Harga Jajan : ");
        float harga_jajan = input.nextFloat();
        System.out.println("Masukan Stok Jajan : ");
        int stok_jajan = input.nextInt();

        JajanController cont = new JajanController();
        cont.updateJajan(id_jajan,id_jenis_jajan,nama_jajan,harga_jajan,stok_jajan);
    }
    private static void deleteJajan() {
        viewJajan();
        //jajanController.viewJajan();
        int currentId = 0;
        System.out.println("Masukan Id Jajan yang ingin dihapus : ");
        currentId = input.nextInt();
        JajanController cont = new JajanController();
        cont.deleteJajan(currentId);
    }
    private static void deleteJenisJajan() {
        int currentId = 0;
        System.out.println("Masukan Id Jenis Jajan yang ingin dihapus : ");
        currentId = input.nextInt();
        JenisJajanController cont = new JenisJajanController();
        cont.deleteJenisJajan(currentId);
    }
    private static void insertTransaksi(){
        viewTransaksi();
        TransaksiEntity transaksiEntity = new TransaksiEntity();


        System.out.println("Masukan Tgl Transaksi : ");
        System.out.print("Total Pembayaran : ");
        //transaksiEntity.setTotal_pembayaran(input.nextFloat());

        TransaksiController transaksiController = new TransaksiController();
        transaksiController.insertTransaksi(transaksiEntity.getTgl_transaksi());
    }
    private static void viewTransaksi(){
        ArrayList<TransaksiEntity> transaksiEntities = transaksiController.getTransaksi();
        if(transaksiEntities.size() == 0) {
            System.out.println("Tidak Ada Data");
            return;
        }
        for(TransaksiEntity index : transaksiEntities) {
            System.out.println("id transaksi : " + index.getId_transaksi());
            System.out.println("tgl transaksi :" + index.getTgl_transaksi());

            System.out.println(" ");
        }

        //transaksiController.getTransaksi();
    }
    private static void insertMengelola() {
        viewMengelola();
        String pilih = "Y";
        ArrayList<MengelolaEntity> mengelolaEntities = new ArrayList<>();
        do {
            MengelolaEntity mengelolaEntity = new MengelolaEntity();
            System.out.print("Masukan ID Jajan : ");
            mengelolaEntity.setId_jajan(input.nextInt());
            System.out.print("Masukan ID Transaksi : ");
            mengelolaEntity.setId_transaksi(input.nextInt());
            System.out.print("Masukan Qty Jajan: ");
            mengelolaEntity.setQty_jajan(input.nextInt());
            System.out.print("Masukan Total Pembayaran : ");
            mengelolaEntity.setTotal_pembayaran(input.nextFloat());
            //mengelolaController.updateJumTrans();
            mengelolaController.updateStok(mengelolaEntity.getQty_jajan(), mengelolaEntity.getId_jajan());
            System.out.println("Apakah ingin menambah : ");
            pilih = input.next();
            /*
            if (pilih.equals("N")){
                System.out.print("Masukan Total Pembayaran : ");
                //mengelolaEntity.setTotal_pembayaran(input.nextFloat());
                //mengelolaController.total(id_transaksi);
                //mengelolaController.total(id_transaksi);
                //mengelolaEntity.getTotal_pembayaran();

                //mengelolaController.totalPem(mengelolaEntity.getId_transaksi());
            }
             */
            mengelolaEntities.add(mengelolaEntity);
        } while (pilih.equals("Y"));
        mengelolaController.insertMengelola(mengelolaEntities);
    }

    private static void viewMengelola(){
        ArrayList<MengelolaEntity> mengelolaEntities = mengelolaController.getMengelola();
        if(mengelolaEntities.size() == 0) {
            System.out.println("Tidak Ada Data");
            return;
        }
        for(MengelolaEntity index : mengelolaEntities) {

            System.out.println("id jajan : " + index.getId_jajan());
            System.out.println("id transaksi : " + index.getId_transaksi());
            System.out.println("qty jajan : " + index.getQty_jajan());
            //System.out.println("harga qty jajan : " + index.getHarga_qty_jajan());
            System.out.println("total pembayaran : " + index.getTotal_pembayaran());

            System.out.println(" ");
        }

        //transaksiController.getTransaksi();
    }
    private static void viewDetail(){
        //ArrayList<MengelolaEntity> mengelolaEntities = mengelolaController.getDetail();
        ArrayList<MengelolaEntity> mengelolaEntities = mengelolaController.getDetail();
        ArrayList<TransaksiEntity> transaksiEntities = transaksiController.getTransaksi();
        if(mengelolaEntities.size() == 0) {
            System.out.println("Tidak Ada Data");
            return;
        }
        for(MengelolaEntity index : mengelolaEntities) {

            System.out.println("id transaksi : " + index.getId_transaksi());
            System.out.println("tgl transaksi : " + index.getTgl_transaksi());
            System.out.println("id jajan : " + index.getId_jajan());
            System.out.println("id transaksi : " + index.getId_transaksi());
            System.out.println("qty jajan : " + index.getQty_jajan());

            System.out.println("total pembayaran : " + index.getTotal_pembayaran());


            System.out.println(" ");
        }

        //transaksiController.getTransaksi();
    }

}
