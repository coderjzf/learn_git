package com.jzf.collection;

import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		TreeSet<User> treeSet = new TreeSet<>();
		treeSet.add(new User("lbj",32));//�����Ԫ�ر���ʵ��Comparable�ӿ�
		treeSet.add(new User("dw",35));
		treeSet.add(new User("rose",28));
		
		for(User user : treeSet){
			System.out.println(user);
		}
	}

}
