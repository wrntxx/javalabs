package com.education.ztu;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> userList = new ArrayList<>();
    private final Gson gson = new Gson();
    private final String usersKey = "users";
    private final String userKey = "user";

    public User getLogginedUser(HttpServletRequest request) throws UnsupportedEncodingException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(userKey)) {
                    String encodedUserList = URLDecoder.decode(cookie.getValue(), "UTF-8");
                    Type userListType = new TypeToken<User>() {
                    }.getType();
                    return gson.fromJson(encodedUserList, userListType);
                }
            }
        }
        return null;
    }

    public void loginUser(User user, HttpServletResponse response) throws UnsupportedEncodingException {
        String userJson = gson.toJson(user);
        String encodedUser = URLEncoder.encode(userJson, "UTF-8");
        Cookie userCookie = new Cookie(userKey, encodedUser);
        response.addCookie(userCookie);
    }

    public void logoutUser(HttpServletResponse response) {
        Cookie userNameCookieRemove = new Cookie(userKey, "");
        userNameCookieRemove.setMaxAge(0);
        response.addCookie(userNameCookieRemove);
    }

    public void addUser(User user, HttpServletRequest request, HttpServletResponse response)
            throws UnsupportedEncodingException {
        loadUserListFromCookie(request);
        userList.add(user);
        saveUserListToCookie(response);
    }

    public User getUserByName(String username, HttpServletRequest request) throws UnsupportedEncodingException {
        loadUserListFromCookie(request);

        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }

        return null;
    }

    public List<User> getUserList(HttpServletRequest request) throws UnsupportedEncodingException {
        loadUserListFromCookie(request);
        return userList;
    }

    private void saveUserListToCookie(HttpServletResponse response) throws UnsupportedEncodingException {
        String userListJson = gson.toJson(userList);
        String encodedUserList = URLEncoder.encode(userListJson, "UTF-8");
        Cookie userListCookie = new Cookie(usersKey, encodedUserList);
        response.addCookie(userListCookie);
    }

    private void loadUserListFromCookie(HttpServletRequest request) throws UnsupportedEncodingException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(usersKey)) {
                    String encodedUserList = URLDecoder.decode(cookie.getValue(), "UTF-8");
                    Type userListType = new TypeToken<List<User>>() {
                    }.getType();
                    userList = gson.fromJson(encodedUserList, userListType);
                    break;
                }
            }
        }
    }
}
