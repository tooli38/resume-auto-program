package Model;

public class Education {
    private long graduationYear;
    private String schoolName;
    private String major;
    private String graduationStatus;

    private Education(long graduationYear, String schoolName, String major, String graduationStatus) {
        this.graduationYear = graduationYear;
        this.schoolName = schoolName;
        this.major = major;
        this.graduationStatus = graduationStatus;
    }

    public static Education of(long graduationYear, String schoolName, String major, String graduationStatus) {
        return new Education(
                graduationYear,
                schoolName,
                major,
                graduationStatus
        );
    }

    public long getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(long graduationYear) {
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
