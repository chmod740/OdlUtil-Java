package com.example.odlutil;

import java.util.Base64;

/**
 * Created by dxc on 16-11-15.
 */
public class OdlUtil {
    private String url = "";

    public OdlUtil(String host,int port){
        this.url = "http://" + host + ":" + port;
    }

    public String getTopology(){
        return getTopology("default");
    }

    public String getTopology(String containerName, String username, String password) {
        HttpRequest.setBasicAuth(getBasicAuthStr(username,password));
        String str = HttpRequest.sendGet(url + "/controller/nb/v2/topology/" + containerName,"");
        System.out.print(str);
        return null;
    }

    public String getTopology(String containerName){
        getTopology(containerName, "admin","admin");
        return null;
    }

    private String getBasicAuthStr(String name,String password){
        return "Basic " + Base64.getEncoder().encodeToString((name + ":" + password).getBytes());
    }

}
