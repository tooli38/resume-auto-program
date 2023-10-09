package View;

import Model.Career;
import Model.Education;
import Model.PersonInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ResumeView {
    private final String INPUT_FINISH = "q";
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
        List<Education> educations = new ArrayList<>();
        System.out.println("학력 정보를 입력하세요 (종료는 "+INPUT_FINISH+"):");

        while(true) {
            System.out.println("졸업년 학교명 전공 졸업여부");
            String educationInfo = sc.nextLine();

            if(educationInfo.equals(INPUT_FINISH)) {
                break;
            } else {
                try {
                    educations.add(Education.from(educationInfo));
                } catch (IllegalArgumentException e) {
                    System.out.println(e + "다시 입력해주세요.");
                }
            }
        }

        return educations;
    }

    public List<Career> inputCareerList() {
        List<Career> careers = new ArrayList<>();
        while(true) {
            System.out.println("경력 정보를 입력하세요 (종료는 "+INPUT_FINISH+"):");
            System.out.println("근무기간 근무처 담당업무 근속연수");
            String careersInfo = sc.nextLine();

            if(careersInfo.equals(INPUT_FINISH)) {
                break;
            } else {
                try {
                    careers.add(Career.from(careersInfo));
                } catch (IllegalArgumentException e) {
                    System.out.println(e + "다시 입력해주세요.");
                }
            }
        }

        return careers;
    }

    public String inputSelfIntroduction() {
        String selfIntroduction = sc.nextLine();

        return selfIntroduction;
    }
}
