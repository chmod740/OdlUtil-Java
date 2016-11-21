package com.example.odlutil;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //System.out.print(Base64.getEncoder().encodeToString(("admin" + ":" + "123456").getBytes()));
        OdlUtil odlUtil = new OdlUtil("127.0.0.1",8080,"admin","admin","default");
        //odlUtil.getTopology();
        Flow flow = new Flow();
        flow.setName("123456111");
        Node node = new Node();
        node.setId("00:00:00:00:00:00:00:02");
        node.setType("OF");
        flow.setNode(node);
        List<String>actions = new ArrayList<>();
        actions.add("SET_NW_TOS=63");
        flow.setActions(actions);
        flow.setNwSrc("10.0.0.1");
        flow.setNwDst("10.0.0.3");
        odlUtil.installFlow(flow,"111");
    }
}
