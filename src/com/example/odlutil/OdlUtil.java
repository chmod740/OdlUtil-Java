package com.example.odlutil;

import com.google.gson.Gson;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hupeng on 16-11-15.
 */
public class OdlUtil {
    private String url = "";
    private String username;
    private String password;
    private String containerName;

    /**
     * 构造函数
     * @param host OpenDayLight的北向接口的主机名称
     * @param port OpenDayLight的北向接口的端口
     * @param username OpenDayLight的管理员的用户名
     * @param password OpenDayLight的管理员的密码
     * @param containerName OpenDayLight的容器名称
     * */
    public OdlUtil(String host,int port,String username,String password, String containerName){
        this.url = "http://" + host + ":" + port;
        this.username = username;
        this.password = password;
        this.containerName = containerName;
        HttpRequest.setBasicAuth(getBasicAuthStr(username,password));
    }

    /**
     * 构造函数
     * @param host OpenDayLight的北向接口的主机名称
     * @param port OpenDayLight的北向接口的端口
     * @param username OpenDayLight的管理员的用户名
     * @param password OpenDayLight的管理员的密码
     * */
    public OdlUtil(String host,int port,String username,String password){
        this.url = "http://" + host + ":" + port;
        this.username = username;
        this.password = password;
        this.containerName = "default";
        HttpRequest.setBasicAuth(getBasicAuthStr(username,password));
    }

    /**
     * 获取拓扑信息
     * */
    public String getTopology(){

        String str = HttpRequest.sendGet(url + "/controller/nb/v2/topology/" + containerName,"");
        System.out.print(str);
        return str;
    }



    /**
     * 获取主机信息
     * */
    public String getHosts(){

        ///controller/nb/v2/topology/' + str(container_name)
        String str = HttpRequest.sendGet(url + "/controller/nb/v2/topology/" + containerName,"");

        System.out.println(str);

        return str;
    }

    /**
     * 下发流表
     * */
    public String installFlow(Flow flow){
        String json  = new Gson().toJson(flow);
        Map<String,String >headers = new HashMap<>();
        headers.put("Accept","application/json'");
        headers.put("Content-type","application/json");
        try {
            String str = HttpRequest.sendPut(url + "/controller/nb/v2/flowprogrammer/" + containerName + "/node/OF/" + flow.getNode().getId() + "/staticFlow/" + flow.getName(),headers,json);
            System.out.println(str);
            return str;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    private String getBasicAuthStr(String name,String password){
        return "Basic " + Base64.getEncoder().encodeToString((name + ":" + password).getBytes());
    }

}
