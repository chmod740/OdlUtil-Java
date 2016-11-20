package com.example.odlutil;

import java.util.Base64;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //System.out.print(Base64.getEncoder().encodeToString(("admin" + ":" + "123456").getBytes()));
        OdlUtil odlUtil = new OdlUtil("127.0.0.1",8080,"admin","admin","default");
        odlUtil.getHosts();
    }
}
