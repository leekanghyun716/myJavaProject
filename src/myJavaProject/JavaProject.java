package myJavaProject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class JavaProject {
	public static final Scanner scan = new Scanner(System.in);
	public static final int INSERT = 1, SEARCH = 2, DELETE = 3, UPDATE = 4, FINISH = 5;
	public static final Date today = new Date();
	public static final SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
	public static void main(String[] args) {
		boolean flag = false;
		int selcetNumber = 0;
		boolean numberInputContitue = false;
		while (!flag) {
			// 매뉴출력및 번호선택
			
			selcetNumber = displayMenu();
			
			switch (selcetNumber) {
			case INSERT:
				studentInsert();
				break;
			case SEARCH:
				studentSearch();
				break;
			case DELETE:
				studentDelete();
				break;
			case UPDATE:
				studentUpdate();
				break;
			case FINISH:
				flag = true;
				break;
			default:
				System.out.println("숫자범위초과 다시입력요망망");
				break;
			}// end of switch
		}
		System.out.println("프로그램 종료");
	}

	private static void studentInsert() {
		String s_num = null;
		String s_name = null;
		int s_java = 0;
		int s_android =0;
		int s_kottlen=0;
		while (true) {
			System.out.print("학번(01) 입력하세요>>");
			s_num = scan.nextLine();
			s_num = scan.nextLine();
			if (s_num.length() != 2) {
				System.out.println("학생번호를 2자리를 지켜주세요");
				continue;
			} 
			s_num=format1.format(today)+s_num;
			boolean duplicate =DBControler.duplicateCheck(s_num);
			if(duplicate) {
				System.out.println("존재하는 학생번호 입니다.");
				continue;
			}
			break;
		}
		while (true) {
			System.out.print("이름을 입력하세요>>");
			s_name = scan.nextLine();
			if (s_name.length() == 0&&s_name.length()>7) {
				System.out.println("제대로 이름을 입력해주세요");
				continue;
			} 
			break;
		}
		while (true) {
			System.out.print("자바점수을 입력하세요>>");
			s_java = scan.nextInt();
			if (s_java < 0&&s_java>100) {
				System.out.println("제대로 점수를 입력해주세요");
				continue;
			} 
			break;
		}
		while (true) {
			System.out.print("안드로이드점수을 입력하세요>>");
			s_android = scan.nextInt();
			if (s_android < 0&&s_android>100) {
				System.out.println("제대로 점수를 입력해주세요");
				continue;
			} 
			break;
		}
		while (true) {
			System.out.print("코틀린점수을 입력하세요>>");
			s_kottlen = scan.nextInt();
			if (s_kottlen < 0&&s_kottlen>100) {
				System.out.println("제대로 점수를 입력해주세요");
				continue;
			} 
			break;
		}
		Student student = new Student(s_num, s_name, s_java, s_android, s_kottlen);
		int count=DBControler.studentInsertTBL(student);

	}

	private static void studentSearch() {
		boolean flag = false;
		int selcetNumber = 0;
		final int BASE =1,ASC =2,DESC=3,FINISH =4;
		boolean numberInputContitue = false;
		while (!flag) {
			// 매뉴출력및 번호선택
			
			selcetNumber = displaySearchMenu();
			
			switch (selcetNumber) {
			case BASE:
				DBControler.studentBaseSearchTBL();
				break;
			case ASC:
				DBControler.studentASCSearchTBL();
				break;
			case DESC:
				DBControler.studentDESCSearchTBL();
				break;
			case FINISH:
				flag = true;
				break;
			default:
				System.out.println("숫자범위초과 다시입력요망망");
				break;
			}// end of switch
		}

	}

	private static void studentDelete() {
		System.out.println("삭제할 학생의 학생번호를 입력하시오");
		String s_num = scan.nextLine();
		s_num = scan.nextLine();
		int count =DBControler.studentDeleteTBL(s_num);
		if(count !=0) {
			System.out.println(s_num+"삭제성공");
		}else {
			System.out.println(s_num+"삭제실패");
		}
	}


	private static void studentUpdate() {
		System.out.println("수정할 학생의 학생번호를 입력하시오");
		String s_num = scan.nextLine();
		s_num = scan.nextLine();
		System.out.println("수정될 학생의 자바성적를 입력하시오");
		int s_java = scan.nextInt();
		System.out.println("수정될 학생의 자바성적를 입력하시오");
		int s_android = scan.nextInt();
		System.out.println("수정될 학생의 자바성적를 입력하시오");
		int s_kottlen = scan.nextInt();
		boolean count =DBControler.studentUpdateTBL(s_num,s_java,s_android,s_kottlen);
		if(count ==true) {
			System.out.println(s_num+"수정성공");
		}else {
			System.out.println(s_num+"수정실패");
		}
	}

	private static int displayMenu() {
		int selcetNumber = 0;
		boolean flag = false;
		while (!flag) {

			System.out.println("************************************************************");
			System.out.println("\n1.데이터 입력  2.데이터 조회  3.데이터 삭제  4.데이터 수정 5.종료 \n");
			System.out.println("************************************************************");
			System.out.print("번호선택>>");
			try {
				// 번호선택
				selcetNumber = scan.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("숫자입력요망");
				continue;
			} catch (Exception e) {
				System.out.println("숫자입력요망 재입력요망");
				continue;
			}
			break;
		}
		return selcetNumber;

	}
	private static int displaySearchMenu() {
		int selcetNumber = 0;
		boolean flag = false;
		while (!flag) {

			System.out.println("************************************************************");
			System.out.println("\n1.기본 출력  2.오름차순정렬  3.내림차순정렬  4.종료 \n");
			System.out.println("************************************************************");
			System.out.print("번호선택>>");
			try {
				// 번호선택
				selcetNumber = scan.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("숫자입력요망");
				continue;
			} catch (Exception e) {
				System.out.println("숫자입력요망 재입력요망");
				continue;
			}
			break;
		}
		return selcetNumber;

	}
}
