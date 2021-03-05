package com.company;


import com.company.data.DB;
import com.company.data.IDB;
import com.company.repositories.IMedicineRepository;
import com.company.repositories.MedicineRepository;

public class Main {

    public static void main(String[] args) {
        IDB db = new DB();
        IMedicineRepository repo = new MedicineRepository(db);
        MyApplication app = new MyApplication(repo);
        app.start();
    }
}
