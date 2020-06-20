package trienode;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

	//자식 노드 맵
	private Map<Character,TrieNode> childNodes = new HashMap<>();
	private boolean isLastChar;//마지막 글자 여부
	
	
	public Map<Character, TrieNode> getChildNodes() {
		return childNodes;
	}
	public void setChildNodes(Map<Character, TrieNode> childNodes) {
		this.childNodes = childNodes;
	}
	public boolean isLastChar() {
		return isLastChar;
	}
	public void setIsLastChar(boolean isLastChar) {
		this.isLastChar = isLastChar;
	}
	
	
	
}
