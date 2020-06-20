package trienode;


public class Trie{
		
		private TrieNode rootNode;//루트 노드
		public Trie() {
			rootNode = new TrieNode();
		}
		
		public void insert(String word){
			TrieNode thisNode = this.rootNode;
			
			for(int i=0;i<word.length();i++){
				thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
				
			}
			thisNode.setIsLastChar(true);
		}
		boolean contains(String word){
			TrieNode thisNode = this.rootNode;
			for(int i=0;i<word.length();i++){
				char character = word.charAt(i);
				TrieNode node = thisNode.getChildNodes().get(character);
				if(node == null)
					return false;
				thisNode = node;
			}
			return thisNode.isLastChar();
		}
		public void delete(String word){
			delete(this.rootNode,word,0);
		}
		private void delete(TrieNode thisNode,String word,int index){
			char character = word.charAt(index);
			
			//아예없는 단어일 경우 에러 발생시킴
			if(!thisNode.getChildNodes().containsKey(character))
				throw new Error("There is no["+word+"] in this Trie");
			
			TrieNode childNode = thisNode.getChildNodes().get(character);
			index++;
			
			if(index == word.length()){
				
				//리스트에 존재하는 단어지만 insert한 단어가 아닌 노드가 만들어지면서 생긴 단어일경우
				if(!childNode.isLastChar())
					throw new Error("There is no["+word+"] in this Trie.");
				
				childNode.setIsLastChar(false);
				
				//단어를 포함하는 더 긴단어가 없을 경우,끝노드까지 갔지만 단어길이를 충족 x경우
				if(childNode.getChildNodes().isEmpty())
					thisNode.getChildNodes().remove(character);
				
			}
			else{
				delete(childNode,word,index);
							
				//자식노드도 없고 현재 노드로 끝나는 다른 단어가 없는 경우 노드 삭제
				//'PIE'를 삭제 대상으로 했을 때, '-E'를 삭제후 'PI'라는 단어의 'I'가  isLastChar==true이므로 또다른 단어가 있음을 알려줍니다.
				if(!childNode.isLastChar() && childNode.getChildNodes().isEmpty())
					thisNode.getChildNodes().remove(character);

			}
		}

	}

