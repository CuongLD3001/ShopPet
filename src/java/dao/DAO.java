/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Service.EncodeString;
import context.DBContext;
import entity.Account;
import entity.Cart;
import entity.Category;
import entity.Item;
import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "select * from product";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "select * from Category";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public Product getFavourite() {
        String query = "select top 1 * from product order by id desc";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public List<Product> getProductByCID(String cid) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product where cateID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public List<Product> getProductBySellID(int id) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product where sell_ID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    
    
     public Product getProductByID(String id) {

        String query = "select * from product where id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));

            }
        } catch (Exception e) {

        }
        return null;
    }

    public void changePassword(String user, String pass){
        String query = "update Account set pass = ? where [user] = ?";
        try {
           conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, pass);
            ps.setString(2, user);
            rs = ps.executeQuery();
            
        } catch (Exception e) {
        }
    }
    
    public List<Product> searchByName(String txtSearch) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product where [title] like ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public Account login(String user, String pass) {
        String query = "select * from account where [user] = ? and pass = ? and active = 1";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, EncodeString.EncodingSHA256(pass));
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getBoolean(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getInt(11),
                        rs.getInt(12)
                );
            }
        } catch (Exception e) {

        }
        return null;
    }
    
    public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<>();
        String query = "select * from account";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getBoolean(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getInt(11),
                        rs.getInt(12)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public Account checkAccountExist(String user) {
        String query = "select * from account where [user] = ? and pass = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getBoolean(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getInt(11),
                        rs.getInt(12));
                
            }
        } catch (Exception e) {

        }
        return null;
    }

    public void signup(String user, String pass, String email, String phone, Boolean gender, String dateOfBirth, String securityQuestion, String answer) {
        try {
            String query = "insert into account values(?,?,?,?,?,?,?,?,0,0,0)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, EncodeString.EncodingSHA256(pass));
            ps.setString(3, email);
            ps.setString(4, phone);
            ps.setBoolean(5, gender);
            ps.setString(6, dateOfBirth);
            ps.setString(7,securityQuestion);
            ps.setString(8, answer);
            ps.executeUpdate();
        } catch (Exception e) {

        }

    }
    
    public Account getAccountByUser(String user) {

        String query = "select * from account where [user] = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getBoolean(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getInt(11),
                        rs.getInt(12));
                

            }
        } catch (Exception e) {

        }
        return null;
    }

    public void deleteProduct(String pid) {
        String query = "delete from product where id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }
    
    public void deleteAccount(String aid) {
        String query = "delete from account where uID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, aid);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public void insertProduct(String name, String image, String price, String title,
            String description,String quantity, String category, int sid) {
        String query = "INSERT [dbo].[product] ([name], [image], [price], [title], [description], [quantity], [cateID], [sell_ID]) VALUES (?,?,?,?,?,?,?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, quantity);
            ps.setString(7, category);
            ps.setInt(8, sid);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public void editProduct(String name, String image, String price, String title,
            String description, String quantity, String category, String pid) {
        String query = "update product set name = ?, image = ?, price = ?, title = ?, description = ?, quantity = ?, cateID = ? where id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, quantity);
            ps.setString(7, category);
            ps.setString(8, pid);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }
    
    public void editAccount(String user, String email, String pass,String phone, String dob, int isSell, int isAdmin, int active) {
        String query = "update Account set email = ?, pass = ?, phone = ?, dateOfBirth = ?, isSell =?, isAdmin=?, active=? where [user] = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, pass);
            ps.setString(3, phone);
            ps.setString(4, dob);          
            ps.setInt(5, isSell);
            ps.setInt(6, isAdmin);
            ps.setInt(7, active);
            ps.setString(8, user);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }
    
    public boolean updateAccount(int uID, String email, String phone, Boolean gender, String dateOfBirth) {
        String query = "update Account set email = ?, phone = ?, gender = ?, dateOfBirth = ? where uID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, phone);
            ps.setBoolean(3,gender);
            ps.setString(4, dateOfBirth);
            ps.setInt(5, uID);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }
    
    public Account getAccountByID(int id) {
        String query = "select * from Account where id=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                Account a = new Account();
                a.setUser(rs.getString("user"));
                a.setPass(rs.getString("pass"));
                a.setEmail(rs.getString("email"));
                a.setPhone(rs.getString("phone"));
                a.setGender(rs.getBoolean("gender"));
                a.setDateOfBirth(rs.getString("dateOfBirth"));
                a.setSecurityQuestion(rs.getString("securityQuestion"));
                a.setAnswer(rs.getString("answer"));
                a.setIsSell(rs.getInt("isSell"));
                a.setIsAdmin(rs.getInt("isAdmin"));
                a.setActive(rs.getInt("active"));
                return a;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void updateStatus(int active, Account a){
        String query = "update Account set active=? where [user]=?";
        
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, active);
            ps.setString(2, a.getUser());
            ps.executeUpdate();            
        } catch (Exception e) {
        }
    }
    
    public void addOrder(Account a, Cart cart){
        LocalDate curDate = LocalDate.now();
        String date =  curDate.toString();
        String query ="insert into [order] values(?,?,?)";
        try{
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, date);
            ps.setInt(2, a.getId());
            ps.setDouble(3, cart.getTotalMoney());
            ps.executeUpdate();
            //lay id của order vua add
            String query1="select top 1 id from [order] order by id desc";
            PreparedStatement ps1 = conn.prepareStatement(query1);
            rs = ps1.executeQuery();
            //add bang Orderdetail
            if(rs.next()){
                int oid = rs.getInt("id");
                for(Item i: cart.getItems()){
                    String query2 = "insert into [orderdetail] values(?,?,?,?)";
                    PreparedStatement ps2 = conn.prepareStatement(query2);
                    ps2.setInt(1, oid);
                    ps2.setInt(2, i.getProduct().getId());
                    ps2.setInt(3, i.getQuantity());
                    ps2.setDouble(4, i.getPrice());
                    ps2.executeUpdate();
                    
                }
            }
            String query3 = "update product set quantity = quantity-? where id =?";
            PreparedStatement ps3 = conn.prepareStatement(query3);
            for(Item i:cart.getItems()){
                ps3.setInt(1, i.getQuantity());
                ps3.setInt(2, i.getProduct().getId());
                ps3.executeUpdate();
            }
            
        }catch(Exception e){
            
        }
    }
    
    public List<Product> getListByPage(List<Product> list, int start, int end){
        ArrayList<Product> arr = new ArrayList<>();
        for(int i = start; i< end; i++){
            arr.add(list.get(i));
        }
        return arr;
    }
    
    public void resetPass(String pass, String user){
        String query = "update Account set pass=? where [user]=?";
        
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, EncodeString.EncodingSHA256(pass));
            ps.setString(2, user);
            ps.executeUpdate();            
        } catch (Exception e) {
        }
    }
    
    

//    public static void main(String[] args) {
//        DAO dao = new DAO();
//        List<Product> list = dao.getAllProduct();
//        for(Product o: list){
//            System.out.println(o);
//        }
//    }
}
