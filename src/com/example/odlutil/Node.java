package com.example.odlutil;

/**
 * Created by dxc on 16-11-21.
 */
public class Node {
    /**
     *  类型,OF 或者 SW
     * */
    private String type;
    /**
     * 节点的ID
     * */
    private String id;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
