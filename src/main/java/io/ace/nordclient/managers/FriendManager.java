package io.ace.nordclient.managers;

import io.ace.nordclient.utilz.FriendUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ace________/Ace_#1233
 */

public class  FriendManager {

    public static List<FriendUtil> friends;
    private static String friened;
    public FriendManager(){
        friends = new ArrayList<>();
    }

    public static List<FriendUtil> getFriends() {
        return friends;
    }

    public static void addFriend(String name) {
        friends.add(new FriendUtil(name));
    }

    public static void removeFriend(String name){
        friends.remove(getFriendByName(name));
    }

    public static boolean isFriend(String name) {
        boolean fr = false;
        for(FriendUtil f : getFriends()){
            if (f.getName().equalsIgnoreCase(name)) {
                fr = true;
                break;
            }
        }
        return fr;
    }


    public static boolean isClientFriend(String name) {
        FriendUtil friend = null;
        Boolean friendValue = null;
        for (FriendUtil f : getFriends()){
            if (f.getName().equalsIgnoreCase(name)) friendValue = true;
            if (!f.getName().equalsIgnoreCase(name)) friendValue = false;
        }
        return friendValue;
    }




    public static FriendUtil getFriendByName(String name){
        FriendUtil friend = null;
        for(FriendUtil f : getFriends()){
            if(f.getName().equalsIgnoreCase(name)) friend = f;
        }
        return friend;
    }



    }

