package com.stc.stcfiletask.util;


import java.util.Base64;

public class DataParser {
    public static byte[] convertBase64ToBytes(String fileBase46){
        return Base64.getDecoder().decode(fileBase46);
    }
    public static String convertBase64ToBytes(byte[] fileBase46){
        return Base64.getEncoder().encodeToString(fileBase46);
    }
}
