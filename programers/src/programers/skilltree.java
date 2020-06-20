package programers;

public class skilltree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		String skill = "CBD";
		
		//String[] arr = skill.split("");
		int answer=0;
		for(int i=0;i<skill_trees.length;i++){
			int flag = 0;
			for(int j=0;j<skill_trees[i].length();j++){
				if(skill.indexOf(skill_trees[i].charAt(j))==flag){
					flag++;
				}
				else if(skill.indexOf(skill_trees[i].charAt(j))>flag){
					break;
				}if(j==skill_trees[i].length()-1){
					answer++;
				}
			}
			
		}
		
		System.out.println(answer);
		
		
	}

}
