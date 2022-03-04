//step1
package view;

import java.util.Scanner;

import model.DuplicateTelException;
import model.Member;
import model.SchoolService;
import model.Student;
import model.Teacher;

public class ConsoleUI3 {
	//private SchoolService service=new SchoolService();
	private Scanner scanner = new Scanner(System.in);
	private SchoolService service=new SchoolService();

	public void execute() {
		exit: while (true) {
			System.out.println("*******학사관리프로그램을 시작합니다********");
			System.out.println("1.추가 2.삭제 3.검색 4.전체회원보기 5.종료");
			String menu = scanner.nextLine();
			switch (menu) {
			case "1":
				addView();
				break;
			case "2":	
				deleteView();
				break;
			case "3":
				findView();
				break;
			case "4":
				System.out.println("**전체 구성원보기**");
				service.printAll();
				break;
			case "5":
				System.out.println("******학사관리프로그램을 종료합니다*******");
				break exit;// switch문이 아니라 exit label이 지정된 while문을 벗어난다
			default:
				System.out.println("잘못된 입력값입니다!!");
			}// switch
		} // while
		scanner.close();
	}
	
	private void addView() {
		System.out.println("입력할 구성원 종류를 선택하세요 1.학생 2.선생님 3.직원");
		String type=scanner.nextLine();
		System.out.println("1. 전화번호를 입력하세요");
		String tel=scanner.nextLine();
		System.out.println("2. 이름을 입력하세요");
		String name=scanner.nextLine();
		System.out.println("3. 주소를 입력하세요");
		String address=scanner.nextLine();
		
		//type별로 별도의 메세지를 출력해야한다 
		Member member=null;
		switch(type) {
		case "1": 
			System.out.println("4. 학번을 입력하세요");
			String stdId=scanner.nextLine();
			member=new Student(tel,name,address,stdId);
			break;
		case "2":
			System.out.println("4. 과목을 입력하세요");
			String subject=scanner.nextLine();
			member=new Teacher(tel,name,address,subject);
			break;
		case "3":
			System.out.println("4. 부서를 입력하세요");
			String department=scanner.nextLine();
			member=new Teacher(tel,name,address,department);
			break;
		}//switch
		//사용자에게 입력받은 구성원 정보를 저장하기 위해 SchoolService의 addMember()를 호출한다
		try {
			service.addMember(member);
			System.out.println("리스트에 추가: "+member);//정상적으로 등록될 경우 등록된 구성원의 정보를 보여준다
		} catch (DuplicateTelException e) {//tel이 중복될 경우 
			System.out.println(e.getMessage());//tel이 중복되어 등록불가 메세지를 보여준다
		}
		
		
	}//method

	private void deleteView() {
		
	}

	private void findView() {
		
	}

	
}
