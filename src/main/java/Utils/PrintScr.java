package Utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
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

import static Configuration.AppDriver.getDriver;

public class PrintScr {

    static WebDriver driver;
    public static List<Image> screenshots = new ArrayList<>();
    String folderPath = "C:/Users/fabiano.silva/Desktop/DesafioModil/target/out";
    LocalDate now = LocalDate.now();
    String folderName = now.format(DateTimeFormatter.ISO_LOCAL_DATE);
    String folderPathWithDate = folderPath + File.separator + folderName;
    String fileName = String.format("%s_%d.pdf", now.format(DateTimeFormatter.ISO_LOCAL_DATE), System.currentTimeMillis());
    String filePath = folderPathWithDate + File.separator + fileName;


    public PrintScr() {
        this.driver = getDriver();
    }

    public void tirarFoto() {
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
        document.add(new com.itextpdf.text.Paragraph(passo));

        int count = 0;
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100f); // definir a largura da tabela como 100% da página
        float[] columnWidths = {2f, 2f, 2f}; // definir a largura de cada coluna
        table.setWidths(columnWidths); // aplicar as larguras das colunas

        for (Image screenshot : screenshots) {
            count++;
            PdfPCell cell = new PdfPCell(screenshot, true); // criar uma célula com a imagem
            cell.setPadding(10f); // definir o espaçamento interno da célula
            table.addCell(cell); // adiciona a célula na tabela

            if (count == 3) {
                document.add(table);
                table = new PdfPTable(3);
                table.setWidthPercentage(100f);
                table.setWidths(columnWidths);
                count = 0;
            }
        }

        if (count > 0) {
            while (count < 3) {
                PdfPCell cell = new PdfPCell(new Phrase(" "));
                cell.setPadding(10f);
                table.addCell(cell);
                count++;
            }
            document.add(table);
        }

        screenshots.clear();
        document.close();
        writer.close();
    }

}
