package View;

import Model.Career;
import Model.Education;
import Model.PersonInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ResumeView {

    private final Scanner sc;

    public ResumeView() {
        sc = new Scanner(System.in);
    }

    public PersonInfo inputPersonInfo() {
        PersonInfo personInfo = PersonInfo.of("test","test","test","test","test","test");

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
