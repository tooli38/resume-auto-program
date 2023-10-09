package Model;

public class Career {
    private String workPeriod;
    private String companyName;
    private String jobTitle;
    private String employMentYears;

    private Career(String workPeriod, String companyName, String jobTitle, String employMentYears) {
        this.workPeriod = workPeriod;
        this.companyName = companyName;
        this.jobTitle = jobTitle;
        this.employMentYears = employMentYears;
    }

    public static Career of(String workPeriod, String companyName, String jobTitle, String employMentYears) {
        return new Career(workPeriod, companyName, jobTitle, employMentYears);
    }

    public String getWorkPeriod() {
        return workPeriod;
    }

    public void setWorkPeriod(String workPeriod) {
        this.workPeriod = workPeriod;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getEmployMentYears() {
        return employMentYears;
    }

    public void setEmployMentYears(String employMentYears) {
        this.employMentYears = employMentYears;
    }
}
