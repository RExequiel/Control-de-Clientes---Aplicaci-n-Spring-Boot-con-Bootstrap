package com.Spring.SpringBoot.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptarPassword {
    public static void main(String[] args) {
        var password = "password";
        var password_user = "password-user";

        System.out.println("password-admin: "+ password);
        System.out.println("password-admin encriptada: "+ encriptarPassword(password));

        System.out.println("password-user: "+ password_user);
        System.out.println("password-user encriptada: "+ encriptarPassword(password_user));
    }

    public static String encriptarPassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
