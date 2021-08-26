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
			// �Ŵ���¹� ��ȣ����
			
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
				System.out.println("���ڹ����ʰ� �ٽ��Է¿����");
				break;
			}// end of switch
		}
		System.out.println("���α׷� ����");
	}

	private static void studentInsert() {
		String s_num = null;
		String s_name = null;
		int s_java = 0;
		int s_android =0;
		int s_kottlen=0;
		while (true) {
			System.out.print("�й�(01) �Է��ϼ���>>");
			s_num = scan.nextLine();
			s_num = scan.nextLine();
			if (s_num.length() != 2) {
				System.out.println("�л���ȣ�� 2�ڸ��� �����ּ���");
				continue;
			} 
			s_num=format1.format(today)+s_num;
			boolean duplicate =DBControler.duplicateCheck(s_num);
			if(duplicate) {
				System.out.println("�����ϴ� �л���ȣ �Դϴ�.");
				continue;
			}
			break;
		}
		while (true) {
			System.out.print("�̸��� �Է��ϼ���>>");
			s_name = scan.nextLine();
			if (s_name.length() == 0&&s_name.length()>7) {
				System.out.println("����� �̸��� �Է����ּ���");
				continue;
			} 
			break;
		}
		while (true) {
			System.out.print("�ڹ������� �Է��ϼ���>>");
			s_java = scan.nextInt();
			if (s_java < 0&&s_java>100) {
				System.out.println("����� ������ �Է����ּ���");
				continue;
			} 
			break;
		}
		while (true) {
			System.out.print("�ȵ���̵������� �Է��ϼ���>>");
			s_android = scan.nextInt();
			if (s_android < 0&&s_android>100) {
				System.out.println("����� ������ �Է����ּ���");
				continue;
			} 
			break;
		}
		while (true) {
			System.out.print("��Ʋ�������� �Է��ϼ���>>");
			s_kottlen = scan.nextInt();
			if (s_kottlen < 0&&s_kottlen>100) {
				System.out.println("����� ������ �Է����ּ���");
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
			// �Ŵ���¹� ��ȣ����
			
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
				System.out.println("���ڹ����ʰ� �ٽ��Է¿����");
				break;
			}// end of switch
		}

	}

	private static void studentDelete() {
		System.out.println("������ �л��� �л���ȣ�� �Է��Ͻÿ�");
		String s_num = scan.nextLine();
		s_num = scan.nextLine();
		int count =DBControler.studentDeleteTBL(s_num);
		if(count !=0) {
			System.out.println(s_num+"��������");
		}else {
			System.out.println(s_num+"��������");
		}
	}


	private static void studentUpdate() {
		System.out.println("������ �л��� �л���ȣ�� �Է��Ͻÿ�");
		String s_num = scan.nextLine();
		s_num = scan.nextLine();
		System.out.println("������ �л��� �ڹټ����� �Է��Ͻÿ�");
		int s_java = scan.nextInt();
		System.out.println("������ �л��� �ڹټ����� �Է��Ͻÿ�");
		int s_android = scan.nextInt();
		System.out.println("������ �л��� �ڹټ����� �Է��Ͻÿ�");
		int s_kottlen = scan.nextInt();
		boolean count =DBControler.studentUpdateTBL(s_num,s_java,s_android,s_kottlen);
		if(count ==true) {
			System.out.println(s_num+"��������");
		}else {
			System.out.println(s_num+"��������");
		}
	}

	private static int displayMenu() {
		int selcetNumber = 0;
		boolean flag = false;
		while (!flag) {

			System.out.println("************************************************************");
			System.out.println("\n1.������ �Է�  2.������ ��ȸ  3.������ ����  4.������ ���� 5.���� \n");
			System.out.println("************************************************************");
			System.out.print("��ȣ����>>");
			try {
				// ��ȣ����
				selcetNumber = scan.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("�����Է¿��");
				continue;
			} catch (Exception e) {
				System.out.println("�����Է¿�� ���Է¿��");
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
			System.out.println("\n1.�⺻ ���  2.������������  3.������������  4.���� \n");
			System.out.println("************************************************************");
			System.out.print("��ȣ����>>");
			try {
				// ��ȣ����
				selcetNumber = scan.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("�����Է¿��");
				continue;
			} catch (Exception e) {
				System.out.println("�����Է¿�� ���Է¿��");
				continue;
			}
			break;
		}
		return selcetNumber;

	}
}
