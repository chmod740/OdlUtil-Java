package com.example.odlutil;

import java.util.Base64;

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
    }

    /**
     * 获取拓扑信息
     * */
    public String getTopology(){
        HttpRequest.setBasicAuth(getBasicAuthStr(username,password));
        String str = HttpRequest.sendGet(url + "/controller/nb/v2/topology/" + containerName,"");
        //System.out.print(str);
        return str;
    }



    /**
     * 获取主机信息
     * */
    public String getHosts(){
        HttpRequest.setBasicAuth(getBasicAuthStr(this.username,this.password));
        ///controller/nb/v2/topology/' + str(container_name)
        String str = HttpRequest.sendGet(url + "/controller/nb/v2/topology/" + containerName,"");

        System.out.println(str);

        return str;
    }


    private String getBasicAuthStr(String name,String password){
        return "Basic " + Base64.getEncoder().encodeToString((name + ":" + password).getBytes());
    }

}
