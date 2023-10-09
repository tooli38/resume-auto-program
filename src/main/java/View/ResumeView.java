package View;

import Model.Career;
import Model.Education;
import Model.PersonInfo;
import java.util.List;
import java.util.Scanner;

public class ResumeView {
    private final Scanner sc;

    public ResumeView() {
        sc = new Scanner(System.in);
    }

    public PersonInfo inputPersonInfo() {
        System.out.print("사진 파일명을 입력하세요:");
        String photo = sc.nextLine();
        System.out.print("이름을 입력하세요:");
        String name = sc.nextLine();
        System.out.print("이메일을 입력하세요:");
        String email = sc.nextLine();
        System.out.print("주소를 입력하세요:");
        String address = sc.nextLine();
        System.out.print("전화번호를 입력하세요:");
        String phoneNumber = sc.nextLine();
        System.out.print("생년월일을 입력하세요 (예: 1990-01-01):");
        String birthDate = sc.nextLine();

        PersonInfo personInfo = PersonInfo.of(photo, name, email, address, phoneNumber, birthDate);

        return personInfo;
    }

    public List<Education> inputEducationList() {
        List<Education> educations = List.of();

        return educations;
    }

    public List<Career> inputCareerList() {
        List<Career> careers = List.of();

        return careers;
    }

    public String inputSelfIntroduction() {
        String selfIntroduction = sc.nextLine();

        return selfIntroduction;
    }
}
