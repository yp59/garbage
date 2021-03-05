package hangman;
import java.util.*;
public class Hangmain {
	static String InputWord() {
		int count=0;
		int countword=0;
		String word;
	
		Scanner input= new Scanner(System.in);
		
		System.out.println("행맨 게임을 시작합니다 단어를 입력해 주세요.");
		
			do {
				
			count=0;//countword와 비교해서 같으면 반복문 벗어나기
			word=input.nextLine();
			
			countword=word.length();	//word의 길이를 저장하고 워드의 스펠링을 검사하는 길이의 기준이 된다.
			
				if(countword==0) //빈칸일 때 명령문
				{	
					System.out.println("공백입니다. 단어를 입력해주세요.");		
					count=-1;
					continue;	
				}
			
				for(int i=0;i<word.length();i++) {//string과 charAt를 사용해서 단어의 스펠링 적합성검사 반복문
						
		
						if (word.charAt(i)<0x61||word.charAt(i)>0x7A) //소문자 아스키코드 범위를 벗어나면 다시 입력
					{
								System.out.println("단어가 잘못됐습니다. 영어 소문자로 입력해 주세요.");
									break;
						
					} 
					count++;//스펠링 검사하고 맞으면 ++ 단어를 다 검사하면 countword와 같게 되어 while반복문을 벗어난다.
				}
			
			
			}while(count!=countword);
			

		return word;
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int wrongcount=0; 
		int life=7;//행맨 목숨
		 int spellcount=0;//스펠링 
		 int w_o_r_dCount=0;//w_o_r_d배열에 스펠링이 채워질때마다 카운드 됨.
		 Scanner input2 =new Scanner(System.in);
		 String IN= InputWord();//정답 단어를 저장
		 String[] WrongSpell =new String[life];//틀린 스펠링을 배열로 저장
		for(int i=0;i<WrongSpell.length;i++) WrongSpell[i]="";//배열을 ""로 초기화시킴 (초기화 안하면 기본값은 null)
		 String[] w_o_r_d=new String[IN.length()];//맞은 스펠링 배열로 저장
		 String sp;//스펠링 변수값 

		 
		 for(int i=0;i<10;i++) {
		 System.out.println();//정답 가리기
		 }
		do{
		//--------------------------------------------------------------------------------------------------
			//맞춘 스펠링과 틀린 스펠링 출력
		
			
			 for(int i=0;i<IN.length();i++) {
			
				 if(w_o_r_d[i]!=null) {
					 
					 System.out.print(w_o_r_d[i]+" ");//정답인 스펠링을 출력
					 }
				 else
				 System.out.print("_ ");
				 
			 }
			System.out.print("스펠링을 입력해 주세요.");
			
			System.out.println(Arrays.toString(WrongSpell));//틀린 스펠링 출력
			
			
			//---------------------------------------------------------------------------------------
			 sp = input2.nextLine();	
		
			if(sp.equals("")) continue;  //스펠링 입력란이 공백이면 다시 입력하게 컨티뉴
			
			if (sp.charAt(0)<0x61||sp.charAt(0)>0x7A) {System.out.println("소문자로 입력해 주세요"); continue;}
				 
			if(sp.equals(IN)) break;//단어를 한번에 맞추면 do-while 벗어남
				
			if(sp.length()>1||sp.length()==0) {
					
					System.out.println("한글자씩 입력해주세요");	
					continue;
				}
			//--------------------------------------------------------------------------스펠링 입력부분
				
							for(int i=0;i<IN.length();i++) {
								
								
								if(IN.charAt(i)==sp.charAt(0)) {
									
										w_o_r_d[i]=sp;
										w_o_r_dCount++;
								}
								
								else if(IN.charAt(i)!=sp.charAt(0)) {
											spellcount+=1;//IN의 스펠링과 순차적으로 비교해서 맞지 않을때 마다 적립
									
									if(spellcount==IN.length()) {
										WrongSpell[wrongcount]=sp;//모든 스펠링과 비교해서 맞지 않으면 worngspell에 저장
										
											life-=1;
											wrongcount++;
											System.out.println("틀렸습니다.\n 남은목숨: "+life);
									}
								}

							}	
				//---------------------------------------------------------------------------스펠링 검사 부분
										
							spellcount=0;
							
							if(w_o_r_dCount==IN.length()) break;//w_o_r_d 배열안에 스펠링이 다 채워지면 반복문을 벗어남
				
		}while(life!=0);
		
		if(life==0) {
			
			System.out.println("처형당했습니다.");
			
		}
		
		else
			System.out.println("정답입니다. 단어는 : "+IN);
		
}

	
}
