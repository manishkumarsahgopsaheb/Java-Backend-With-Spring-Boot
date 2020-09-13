package com.example.DemoApp1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DB {

    HashMap<String, String> storage =
            new HashMap<>();

    ArrayList<User> userTable= new ArrayList<>();

    public DB(){
        storage.put("sachin","A Great Batsman");
        storage.put("ramu","A nice person");

        userTable.add(new User(1,20,"Ramu"));
        userTable.add(new User(7,30,"Raju"));
        userTable.add(new User(11,70,"Mohit"));

    }

    public String search(String word){
        if(storage.containsKey(word)){
            return storage.get(word);
        }
        return "Not found anything about it";
    }

    public List<User> getAllUsers(){
        return userTable;
    }

    public User getAUser(int id){
        for(User user: userTable){
            if(user.getId()==id){
                return user;
            }
        }
        System.out.println("No User Found");
        return null;
    }

    public boolean addAUser(User user){
        userTable.add(user);
        return true;
    }
    public boolean updateAUser(User user){
        for(User user1 : userTable){
            if(user1.getId()==user.getId()){
                user1.setAge(user.getAge());
                return true;
            }
        }
        return false;
    }

    public boolean deleteAUser(int id){
        for(User user1 : userTable){
            if(user1.getId()==id){
                userTable.remove(user1);
                return true;
            }
        }
        return false;
    }
}
