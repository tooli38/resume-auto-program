package Controller;

import Model.Career;
import Model.Education;
import Model.PersonInfo;
import View.ResumeView;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;

public class ResumeController {

    private final double PIXEL_SIZE = 2.83465;
    private final ResumeView view;
    private final XSSFWorkbook workbook;

    public ResumeController() {
        this.view = new ResumeView();
        this.workbook = new XSSFWorkbook();
    }

    public void createResume() {
        PersonInfo personInfo = view.inputPersonInfo();
        List<Education> educations = view.inputEducationList();
        List<Career> careers = view.inputCareerList();
        String selfIntroduction = view.inputSelfIntroduction();

        createResumeSheet(personInfo, educations, careers);
        createSelfIntroductionSheet(selfIntroduction);

        saveWorkbookToFile();

        System.out.println("이력서 생성이 완료되었습니다.");
    }

    private void saveWorkbookToFile() {
        try(FileOutputStream fileOut = new FileOutputStream("이력서.xlsx")) {
            workbook.write(fileOut);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private XSSFCellStyle getWrapCellStyle() {
        XSSFCellStyle style = workbook.createCellStyle();
        style.setWrapText(true);
        return style;
    }

    private void createSelfIntroductionSheet(String selfIntroduction) {
        Sheet sheet = workbook.createSheet("자기소개서");

        Row dataRow = sheet.createRow(0);
        Cell selfIntroductionCell = dataRow.createCell(0);
        selfIntroductionCell.setCellStyle(getWrapCellStyle());
        selfIntroductionCell.setCellValue(
                new XSSFRichTextString(selfIntroduction.replace("\n", String.valueOf((char) 10)))
        );
    }

    private void createResumeImageCell(Sheet sheet, Row dataRow, String photoFileName) {
        try (InputStream photoStream = new FileInputStream(photoFileName)) {
            BufferedImage originalImage = ImageIO.read(photoStream);

            int newWidth = (int) (35 * PIXEL_SIZE);
            int newHeight = (int) (45 * PIXEL_SIZE);
            Image resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
            BufferedImage resizedBufferedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_4BYTE_ABGR);
            Graphics2D g2d = resizedBufferedImage.createGraphics();
            g2d.drawImage(resizedImage, 0, 0, null);
            g2d.dispose();

            // 조정된 이미지를 바이트 배열로 변환합니다.
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(resizedBufferedImage, "png", baos);
            byte[] imageBytes = baos.toByteArray();
            int imageIndex = workbook.addPicture(imageBytes, Workbook.PICTURE_TYPE_PNG);

            // Drawing 객체를 생성하고 이미지를 삽입합니다.
            XSSFDrawing drawing = (XSSFDrawing) sheet.createDrawingPatriarch();
            XSSFClientAnchor anchor = new XSSFClientAnchor(0, 0, 0, 0, 0, 1, 1, 2);
            drawing.createPicture(anchor, imageIndex);

            //이미지가 삽입된 행 열 위치 조정
            dataRow.setHeightInPoints(newHeight * 72 / 96);

            int columnWidth = (int) Math.floor(((float) newWidth / (float) 8) * 256);
            sheet.setColumnWidth(0, columnWidth);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createResumeSheet(PersonInfo personInfo, List<Education> educations, List<Career> careers) {
        Sheet sheet = workbook.createSheet("이력서");
        //개인 정보
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("사진");
        headerRow.createCell(1).setCellValue("이름");
        headerRow.createCell(2).setCellValue("이메일");
        headerRow.createCell(3).setCellValue("주소");
        headerRow.createCell(4).setCellValue("전화번호");
        headerRow.createCell(5).setCellValue("생년월일");

        Row dataRow = sheet.createRow(1);
        String photoFileName = personInfo.getPhoto();
        createResumeImageCell(sheet, dataRow, photoFileName);

        dataRow.createCell(1).setCellValue(personInfo.getName());
        dataRow.createCell(2).setCellValue(personInfo.getEmail());
        dataRow.createCell(3).setCellValue(personInfo.getAddress());
        dataRow.createCell(4).setCellValue(personInfo.getPhoneNumber());
        dataRow.createCell(5).setCellValue(personInfo.getBirthDate());

        //학력 정보
        int educationStartRow = 3;
        Row educationHeaderRow = sheet.createRow(educationStartRow - 1);
        educationHeaderRow.createCell(0).setCellValue("졸업년도");
        educationHeaderRow.createCell(1).setCellValue("학교명");
        educationHeaderRow.createCell(2).setCellValue("전공");
        educationHeaderRow.createCell(3).setCellValue("졸업여부");

        int educationRowNum = educationStartRow;
        for (Education education : educations) {
            Row educationDataRow = sheet.createRow(educationRowNum++);
            educationDataRow.createCell(0).setCellValue(education.getGraduationYear());
            educationDataRow.createCell(1).setCellValue(education.getSchoolName());
            educationDataRow.createCell(2).setCellValue(education.getMajor());
            educationDataRow.createCell(3).setCellValue(education.getGraduationStatus());
        }

        //경력 정보
        int careerStartRow = educationRowNum + 1;
        Row careerHeaderRow = sheet.createRow(careerStartRow - 1);
        careerHeaderRow.createCell(0).setCellValue("근무기간");
        careerHeaderRow.createCell(1).setCellValue("근무처");
        careerHeaderRow.createCell(2).setCellValue("담당업무");
        careerHeaderRow.createCell(3).setCellValue("근속연수");

        int careerRowNum = careerStartRow;
        for (Career career : careers) {
            Row careerDataRow = sheet.createRow(careerRowNum++);
            careerDataRow.createCell(0).setCellValue(career.getWorkPeriod());
            careerDataRow.createCell(1).setCellValue(career.getCompanyName());
            careerDataRow.createCell(2).setCellValue(career.getJobTitle());
            careerDataRow.createCell(3).setCellValue(career.getEmployMentYears());
        }
    }

    public static void main(String[] args) {
        ResumeController controller = new ResumeController();
        controller.createResume();
    }
}
