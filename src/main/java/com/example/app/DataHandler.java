//package com.example.app;
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class DataHandler {
//    private static final String DATA_FILE = "data.txt";
//
//    public void saveData(List<Transaction> transactions){
//        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(DATA_FILE))){
//            outputStream.writeObject(transactions);
//        } catch(IOException e){
//            e.printStackTrace();
//        }
//    }
//
//    public List<Transaction> loadData(){
//        List<Transaction> transactions = new ArrayList<>();
//        File file = new File(DATA_FILE);
//
//        if(file.exists()) {
//            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
//                transactions = (List<Transaction>) inputStream.readObject();
//            } catch (IOException | ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//        }
//        return transactions;
//    }
//    public void clearData(){
//        File file = new File(DATA_FILE);
//        if(file.exists()){
//            file.delete();
//        }
//    }
//}
