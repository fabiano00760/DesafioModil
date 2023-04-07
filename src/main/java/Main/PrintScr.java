package Main;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static Main.AppDriver.getDriver;

public class PrintScr {

  static WebDriver driver;
  public static List<Image> screenshots = new ArrayList<>();
  String folderPath = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
  LocalDate now = LocalDate.now();
  String folderName = now.format(DateTimeFormatter.ISO_LOCAL_DATE);
  String folderPathWithDate = folderPath + File.separator + folderName;
  String fileName = String.format("%s_%d.pdf", now.format(DateTimeFormatter.ISO_LOCAL_DATE), System.currentTimeMillis());
  String filePath = folderPathWithDate + File.separator + fileName;


  public PrintScr() {
    this.driver = getDriver();
  }

  public void tirarFoto(WebDriver navegador, String passo) {


    File folder = new File(folderPathWithDate);
    if (!folder.exists()) {
      folder.mkdirs();
    }

    try {
      int numScreenshots = 1;

      for (int i = 1; i <= numScreenshots; i++) {
        File screenshotFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        Image screenshot = Image.getInstance(screenshotFile.getPath());
        screenshot.scaleToFit(PageSize.A4.rotate().getWidth() / 2, PageSize.A4.rotate().getHeight() / 2);
        screenshots.add(screenshot);
      }

    } catch (IOException | DocumentException e) {

    }

  }

  public void salvarArquivosNoPdf(String passo) throws FileNotFoundException, DocumentException {

    Document document = new Document();
    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));

    document.open();
    document.newPage();
    document.add(new com.itextpdf.text.Paragraph(passo));

    for (Image screenshot : screenshots) {
      document.add(screenshot);
    }

    screenshots.clear();
    document.newPage();
    document.close();
    writer.close();


  }

}
