/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Cart {

    private List<Item> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public int getQuantityByid(int id) {
//        if (getItemById(id) == null) {
//            return -1;
//        }
        return getItemById(id).getQuantity();
    }

    private Item getItemById(int id) {
        
        for (Item i : items) {
//            System.out.println(i.getProduct().getId() +"---" +id );
            if (i.getProduct().getId() == id) {
                return i;
            }
        }
        return null;
    }
    
    private int getLocationById(int id){
        for (int i = 0; i<items.size(); i++) {
            if (items.get(i).getProduct().getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void addItem(Item t) {
        if (getItemById(t.getProduct().getId()) != null) {
            Item m = getItemById(t.getProduct().getId());
            m.setQuantity(m.getQuantity() + t.getQuantity());
        } else {
            items.add(t);
        }
    }

    public void removeItem(int id) {
//        for (int i = 0; i < items.size(); i++) {
//            if (items.get(i).getProduct().getId() == id) {
//                items.remove(i);
//                return;
//            }
//        }
            if(getItemById(id)!=null){
                items.remove(getLocationById(id));
            }

    }

    public double getTotalMoney() {
        double t = 0;
        for (Item i : items) {
            t += (i.getQuantity() * i.getPrice());
        }
        return t;
    }

    private Product getProductById(int id, List<Product> list) {
        for (Product i : list) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }
//
//    public void updateItemQuantityByID(int id, int quantity) {
//
//        for (int i = 0; i < items.size(); i++) {
//            if (items.get(i).getProduct().getId() == id) {
//                Item item = items.get(i);
//                System.out.println(item.getQuantity());
//                item.setQuantity(quantity);
//                items.set(i, item);
//                System.out.println(item.getQuantity());
//            }
//        }
//    }

    public Cart(String txt, List<Product> list) {
        items = new ArrayList<>();
        try {
            if (txt != null & txt.length() != 0) {
                String[] s = txt.split("-");
                for (String i : s) {
                    String[] n = i.split(":");
                    int id = Integer.parseInt(n[0]);
                    int quantity = Integer.parseInt(n[1]);
                    Product p = getProductById(id, list);
                    Item t = new Item(p, quantity, p.getPrice());
                    addItem(t);
                }
            }
        } catch (Exception e) {

        }

    }

}
