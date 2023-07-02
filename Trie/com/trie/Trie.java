package com.trie;

public class Trie {

	private Node root;

	public Trie() {
		this.root = new Node();
	}

	public void insert(String word) {
		Node node = this.root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (!node.containsKey(ch)) {
				node.put(ch);
			}
			node = node.get(ch);
			node.increaseCountPrefix();
		}
		node.setFlag(true);
		node.increaseCountEndWith();
	}

	public boolean search(String word) {
		Node node = this.root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (!node.containsKey(ch))
				return false;
			node = node.get(ch);
		}
		return node.isEnd();
	}
	
	public int countWordsEqualTo(String word) {
		Node node = this.root;
		for(int i =0;i<word.length();i++) {
			char ch = word.charAt(i);
			if(!node.containsKey(ch)) return 0;
			node = node.get(ch);
		}
		return node.getCountEndWith();
	}
	
	public int countWordsStartsWith(String word) {
		Node node = this.root;
		for(int i=0;i<word.length();i++) {
			char ch = word.charAt(i);
			if(!node.containsKey(ch)) return 0;
			node = node.get(ch);
		}
		return node.getCountPrefix();
	}

	public boolean startsWith(String prefix) {
		Node node = this.root;
		for (int i = 0; i < prefix.length(); i++) {
			char ch = prefix.charAt(i);
			if (!node.containsKey(ch))
				return false;
			node = node.get(ch);
		}
		return true;
	}
	
	public void erase(String word) {
		if(this.search(word)) {
			Node node = this.root;
			for(int i=0;i<word.length();i++) {
				char ch = word.charAt(i);
				node = node.get(ch);
				node.decreaseCountPrefix();
			}
			node.decreaseCountEndWith();
		}
	}	

}
