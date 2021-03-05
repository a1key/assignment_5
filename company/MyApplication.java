package com.company;

import com.company.controllers.MedicineController;
import com.company.repositories.IMedicineRepository;

import java.util.Scanner;

public class MyApplication {
    private final MedicineController controller;
    private final Scanner sc;

    public MyApplication(IMedicineRepository medicineRepository){
        controller = new MedicineController(medicineRepository);
        sc = new Scanner(System.in);
    }

    public void start(){
        while (true){
            System.out.println("\n Welcome to my Application");
            System.out.println("Choose one of the options:");
            System.out.println("1.Get medicine by NAME");
            System.out.println("2. Get medicine by ID");
            System.out.println("3. Add medicine to DataBase");
            System.out.println("4. Remove medicine by ID");
            System.out.println("5. Get all medicine");
            System.out.println("0. Exit\n\n");
            try {
                int option = sc.nextInt();
                if(option == 1){
                    getMedicineByNameMenu();
                }
                else if(option == 2){
                    getMedicineByIdMenu();
                }
                else if(option == 3){
                    addMedicineMenu();
                }
                else if(option == 4){
                    removeMedicineMenu();
                }
                else if(option == 5){

                }
                else {
                    break;
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            System.out.println("_______________________");
        }
    }

    public void getMedicineByNameMenu(){
        System.out.println("\n Please enter name:");
        String name = sc.next();
        System.out.println(controller.getMedicineByName(name));
    }

    public void getMedicineByIdMenu(){
        System.out.println("\n Please enter id:");
        int id = sc.nextInt();
        System.out.println(controller.getMedicineById(id));
    }

    public void addMedicineMenu(){
        System.out.println("\n Please enter elements in proper order\n( name price date_expired manufacturer (with only spaces) )");
        System.out.println(controller.createMedicine(sc.next(), sc.nextInt(), sc.next(), sc.next()));
    }

    public void removeMedicineMenu(){
        System.out.println("\n Please enter id of medicine that you want to remove:");
        int id = sc.nextInt();
        System.out.println(controller.deleteMedicine(id));
    }

    public void getAllMedicine(){
        System.out.println(controller.getAllMedicine());
    }
}
