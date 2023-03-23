package study;

import java.util.*;

class Japanese_quiz{
   String[][] words;  //단어목록
   String[][] quizs;  //객관식 문제 배열
   Scanner scn;       //입력
   
   Japanese_quiz(){
	  scn = new Scanner(System.in); //스캐너 활성화
	  
      words = new String[][]{
            {"勘弁","용서"},     //words[0][0],words[0][1]
            {"抽選","추첨"},     //words[1][0],words[1][1]
            {"当面","당면"},     //words[2][0],words[2][1]
            {"食べる","먹다"},
            {"日本語","일본어"},
            {"携帯","휴대"},
            {"座る","앉다"},
            {"建物","건물"},
            {"輸入","수입"},
            {"果物","과일"},
            {"自動車","자동차"},
            {"電車","전차"},
            {"自動販売機","자판기"}
      };
      //레벨5 까지 설정
      //총 10문제 출력
      //문제 4개 삽입
      quizs = new String[][]{
    	  //첫번째 요소는 한자문제 //두번째 요소는 객관식 답 //나머지는 문제
    	  //1인덱스[한자문제], 2인덱스[답], 3~[문제들]
    		  {"選択","せんたく","せんやく","せんだく","せんたく","せんかつ"},
    		  {"包む","つつむ","たむ","すずむ","つずむ","つつむ"},
    		  {"助ける","たすける","たすける","かすける","だすける","たつける"},
    		  {"郵便局","ゆうびんきょく","ゆびんきょく","ゆうびんきょく","ゆうひんんきょく","ゆべんきょく"},
    		  {"速い","おそい","おそい","おぞい","おあさい","おすい"},
    		  {"交流","こうりゅう","こうりゅう","こりゅう","こうりゅい","こうるい"},
    		  {"活動","かつどう","がつど","かつど","かつどう","がつどう"},
    		  {"活躍","かっぱつ","かつはつ","かつぱつ","かっばつ","かっぱつ"},
    		  {"印象","いんしょう","にんしょう","いんしょう","いんしょ","にんしょ"},
    		  {"挨拶","あいさつ","あいさつ","さいざつ","あいざつ","あいこむ"}
    		  };
   }//생성자
   
   // 매우 중요 기능!
   void choice() { //객관식 문제 출력 메소드
	   //단어들을 배열로 정리시킨다. 
	   // [한자][답][문제][문제][문제][문제] | 0 1 2 3 4 5
	   //랜덤함수로 문제번호를 무작위로 출력단계
	   String arr[] = new String[4]; //1. 선택지 4개를 배열에 순서대로 저장.
	   int count = 0;
	   int O = 0, X = 0;  // O = 정답 , X = 오답
	   
	   while(count < quizs.length){  //10문제를 출력
		   System.out.println(count + 1 +"." + quizs[count][0] + "의 읽는법은?");
		   //선택지 출력
		   for(int i = 0; i < 4; i++) { // 0 1 2 3
			   System.out.print(i+1 + ")" + quizs[count][i+2] + " ");
			   arr[i] = quizs[count][i+2];  //2. 선택지를 순서대로 배열에 복사 저장.  //OK
		   }//for
		   //입력단계
		   int Num = scn.nextInt();         //답(숫자) 입력
		   System.out.println(">>");
		   //답 일치 확인 단계
		   boolean yes = true;   //정답이 맞으면 false로 변환
		   for(int a = 0; a < 4; a++) {
			   if(arr[Num - 1].equals(quizs[count][1])) { //이용자가 입력한 숫자(arr[])로 문제(quizs[count][a+2])와 일치하는지 확인 단계
				   System.out.println("정답입니다!" + "\t" + "정답: " + quizs[count][1]);
				   O++;           //정답수 기록  
				   yes = false;   //정답일시 false로 바꿔야 다음의 if문에 오답안내 출력을 막는다 
				   break;
			   }
		   }//for		   
		   if(yes) {
			   System.out.println("틀렸습니다.." + "\t" + "정답: " + quizs[count][1]);
			   X++;               //오답수 기록
		   }//if
		     count++;
	      }//while
	   //결과 출력단계
	   score_result(O,X);
       }//메소드
   
   void score_result(int o,int x) {  //결과 출력 메소드
	   System.out.println("결과" + "\n" + "정답 : " + o + "개" + "\n" + "오답 : " + x + "개");
   }
   
}//class


public class Japanese {
	
	static void menu() { //메뉴 출력 메소드
	      System.out.println("┌─────────────────────────────┐");
	      System.out.println("│ 1. 일본 단어 뜻 문제           │");
	      System.out.println("│ 2. 일본 단어 문제(객관식)       │");
	      System.out.println("│ 3. 단어 출력                  │");
	      System.out.println("│ 4. 종료                      │");
	      System.out.println("└─────────────────────────────┘");
	   }
	
	public static void main(String[] args) {
		
		Japanese_quiz jp = new Japanese_quiz();
	      Scanner scn = new Scanner(System.in);   
	      
	      while(true) {
	         menu();   //메뉴 출력
	         System.out.println(">>");
	         int num = scn.nextInt();
	         
	         //메뉴 이외 번호 입력시 오류 출력 단계
	         if(num >= 5) {
	        	 System.out.println("ERROE(56310-56902): 메뉴 번호를 입력하시오>>");
	        	 continue;
	         }
	         
	         //1 일본 단어 뜻 문제
	         if(num == 1) {
	            for(int i = 0; i < jp.words.length; i++) {
	               System.out.println(jp.words[i][0] + " 한자 뜻 입력>>");
	               String answer = scn.next();
	               
	               //정답 확인
	               if(answer.equals(jp.words[i][1])) {
	                  System.out.println("정답. 답:" + jp.words[i][1]);
	               }
	               else {
	                  System.out.println("오답. 답:" + jp.words[i][1]);
	               }
	            }//for
	         }//if
	         
	         //2 객관식 문제
	         else if(num == 2) {
	            jp.choice();
	         }
	         
	         //3 일본어 단어 전체 출력
	         else if(num == 3) {
	            for(int j = 0; j < jp.words.length; j++) {      //행(일본어)
	               for(int i = 0; i < 1; i++) {  //열(뜻,히라가나)
	                  System.out.print(jp.words[j][0]+ " : " + jp.words[j][1]);
	                  //System.out.print(jp.quizs[j][0]+ " : " + jp.quizs[j][1]); <= 확인용
	               }//for
	               System.out.println();
	            }
	         }//else if
	         
	         //4 프로그램 종료
	         else if(num == 4) {
	            System.out.println("off");
	            break;
	         }
	         
	      }//while

	   }

}
