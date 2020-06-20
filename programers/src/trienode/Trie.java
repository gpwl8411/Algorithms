package trienode;


public class Trie{
		
		private TrieNode rootNode;//��Ʈ ���
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
			
			//�ƿ����� �ܾ��� ��� ���� �߻���Ŵ
			if(!thisNode.getChildNodes().containsKey(character))
				throw new Error("There is no["+word+"] in this Trie");
			
			TrieNode childNode = thisNode.getChildNodes().get(character);
			index++;
			
			if(index == word.length()){
				
				//����Ʈ�� �����ϴ� �ܾ����� insert�� �ܾ �ƴ� ��尡 ��������鼭 ���� �ܾ��ϰ��
				if(!childNode.isLastChar())
					throw new Error("There is no["+word+"] in this Trie.");
				
				childNode.setIsLastChar(false);
				
				//�ܾ �����ϴ� �� ��ܾ ���� ���,�������� ������ �ܾ���̸� ���� x���
				if(childNode.getChildNodes().isEmpty())
					thisNode.getChildNodes().remove(character);
				
			}
			else{
				delete(childNode,word,index);
							
				//�ڽĳ�嵵 ���� ���� ���� ������ �ٸ� �ܾ ���� ��� ��� ����
				//'PIE'�� ���� ������� ���� ��, '-E'�� ������ 'PI'��� �ܾ��� 'I'��  isLastChar==true�̹Ƿ� �Ǵٸ� �ܾ ������ �˷��ݴϴ�.
				if(!childNode.isLastChar() && childNode.getChildNodes().isEmpty())
					thisNode.getChildNodes().remove(character);

			}
		}

	}

