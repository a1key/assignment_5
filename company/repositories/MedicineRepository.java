package com.company.repositories;

import com.company.data.IDB;
import com.company.entities.Medicine;
import com.company.repositories.IMedicineRepository;

import java.util.LinkedList;
import java.util.List;
import java.sql.*;

public class MedicineRepository implements IMedicineRepository {
    private final IDB db;

    public MedicineRepository(IDB db){
        this.db = db;
    }

    @Override
    public boolean createMedicine(Medicine medicine) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO users(name, price, expire_date, manufacturer) VALUES (?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, medicine.getName());
            st.setInt(2, medicine.getPrice());
            st.setString(3, medicine.getExpire_date());
            st.setString(4, medicine.getManufacturer());

            boolean executed = st.execute();
            return executed;
        }catch (SQLException | ClassNotFoundException throwables){
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        return false;
    }


    @Override
    public Medicine getMedicineById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, price, expire_date, manufacturer FROM medicine WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if(rs.next()){
                Medicine medicine = new Medicine(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("expire_date"),
                        rs.getString("manufacturer"));
                return medicine;
            }
        }catch (SQLException | ClassNotFoundException throwables){
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Medicine getMedicineByName(String name) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, price, expire_date, manufacturer FROM medicine WHERE name=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, name);

            ResultSet rs = st.executeQuery();
            if(rs.next()){
                Medicine medicine = new Medicine(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("expire_date"),
                        rs.getString("manufacturer"));
                return medicine;
            }
        }catch (SQLException | ClassNotFoundException exception){
            exception.printStackTrace();
        } finally {
            try {
                con.close();
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public List<Medicine> getAllMedicine() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT*FROM medicine";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            List<Medicine> medicines = new LinkedList<>();
            while (rs.next()) {
                Medicine medicine = new Medicine(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("expire_date"),
                        rs.getString("manufacturer"));
                medicines.add(medicine);
            }return medicines;
        }catch (SQLException | ClassNotFoundException exception){
            exception.printStackTrace();
        } finally {
            try {
                con.close();
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public String deleteMedicine(int id) {
        Connection con = null;
        Medicine medicine = new Medicine();
        try {
            con = db.getConnection();
            String sql = "DELETE*FROM medicine WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);
            st.execute();

            return "Row has been deleted!";

        }catch (SQLException | ClassNotFoundException throwables){
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;

    }

}
