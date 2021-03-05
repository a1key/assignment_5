package com.company.repositories;

import com.company.entities.Medicine;

import java.util.List;

public interface IMedicineRepository {
    boolean createMedicine(Medicine medicine);
    Medicine getMedicineById(int id);
    Medicine getMedicineByName(String name);
    List<Medicine> getAllMedicine();
    String deleteMedicine(int id);
}
