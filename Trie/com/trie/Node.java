package com.trie;

public class Node {

	private Node[] nodeLinks;
	private boolean flag;
	private int countEndWith = 0;
	private int countPrefix = 0;

	
	public Node() {
		super();
		this.nodeLinks = new Node[26];
	}

	public Node(Node[] nodeLinks, boolean flag) {
		super();
		this.nodeLinks = nodeLinks;
		this.flag = flag;
	}

	public Node[] getNodeLinks() {
		return nodeLinks;
	}

	public void setNodeLinks(Node[] nodeLinks) {
		this.nodeLinks = nodeLinks;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public boolean containsKey(char ch) {
		return get(ch)!=null;
	}
	
	public Node get(char ch) {
		return this.nodeLinks[ch-'a'];
	}
	
	public void put(char ch) {
		this.nodeLinks[ch-'a'] = new Node();
	}
	
	public boolean isEnd() {
		return this.isFlag();
	}
	
	public int getCountEndWith() {
		return countEndWith;
	}

	public void setCountEndWith(int countEndWith) {
		this.countEndWith = countEndWith;
	}

	public int getCountPrefix() {
		return countPrefix;
	}

	public void setCountPrefix(int countPrefix) {
		this.countPrefix = countPrefix;
	}

	public void increaseCountEndWith() {
		this.countEndWith++;
	}
	
	public void increaseCountPrefix() {
		this.countPrefix++;
	}
	
	public void decreaseCountEndWith() {
		this.countEndWith--;
	}
	
	public void decreaseCountPrefix() {
		this.countPrefix--;
	}
}
