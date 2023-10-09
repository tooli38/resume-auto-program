package Model;

public class Education {
    private String graduationYear;
    private String schoolName;
    private String major;
    private String graduationStatus;

    private Education(String graduationYear, String schoolName, String major, String graduationStatus) {
        this.graduationYear = graduationYear;
        this.schoolName = schoolName;
        this.major = major;
        this.graduationStatus = graduationStatus;
    }

    public static Education of(String graduationYear, String schoolName, String major, String graduationStatus) {
        return new Education(
                graduationYear,
                schoolName,
                major,
                graduationStatus
        );
    }

    public static Education from(String educationInfo) {
        String[] educationInfoSplit = educationInfo.split(" ");

        if(educationInfoSplit.length != 4) {
            throw new IllegalArgumentException("잘못된 학력 정보가 입력되었습니다.");
        }

        return Education.of(
                educationInfoSplit[0],
                educationInfoSplit[1],
                educationInfoSplit[2],
                educationInfoSplit[3]
        );
    }

    public String getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(String graduationYear) {
        this.graduationYear = graduationYear;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGraduationStatus() {
        return graduationStatus;
    }

    public void setGraduationStatus(String graduationStatus) {
        this.graduationStatus = graduationStatus;
    }
}
