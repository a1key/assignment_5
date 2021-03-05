package com.company.controllers;

import com.company.entities.Medicine;
import com.company.repositories.IMedicineRepository;

import java.util.List;

public class MedicineController {
    private final IMedicineRepository repository;

    public MedicineController(IMedicineRepository repository){
        this.repository = repository;
    }

    public String createMedicine(String name, int price, String expire_date, String manufacturer){
        Medicine medicine = new Medicine(name, price, expire_date, manufacturer);

        boolean created = repository.createMedicine(medicine);

        return (created ? "Medicine was created!" : "Medicine creation was failed!");
    }

    public String getMedicineByName(String name) {
        Medicine medicine = repository.getMedicineByName(name);

        return (medicine == null ? "Medicine was not found!" : medicine.toString());
    }

    public String getMedicineById(int id){
        Medicine medicine = repository.getMedicineById(id);

        return (medicine == null ? "Medicine was not found!" : medicine.toString());
    }

    public String getAllMedicine(){
        List<Medicine> medicines = repository.getAllMedicine();

        return medicines.toString();
    }

    public String deleteMedicine(int id){
        Medicine medicine = repository.getMedicineById(id);

        return repository.deleteMedicine(id);
    }
}
