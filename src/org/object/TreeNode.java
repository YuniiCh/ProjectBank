/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.object;

/**
 *
 * @author CYN
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class TreeNode{//树节点
	private String sname;//节点名
	ArrayList<String> label=new ArrayList<String>();//和子节点间的边标签
	ArrayList<TreeNode> node=new ArrayList<TreeNode>();//对应子节点
	public TreeNode(String str) {
		sname=str;
	}

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public ArrayList<String> getLabel() {
        return label;
    }

    public void setLabel(ArrayList<String> label) {
        this.label = label;
    }

    public ArrayList<TreeNode> getNode() {
        return node;
    }

    public void setNode(ArrayList<TreeNode> node) {
        this.node = node;
    }
}

