package com.codewithkv.Utils;

import java.io.File;

public class FileUtil {
    private static File credentialsFile;

    public static File getCredentialsFile(){
        if(credentialsFile==null){
            credentialsFile=new File("src/main/java/com/codewithkv/assets/credentials.csv");
        }
        return credentialsFile;
    }
}
