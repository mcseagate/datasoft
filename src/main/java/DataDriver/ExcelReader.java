package DataDriver;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;



public class ExcelReader {
    XSSFWorkbook excelWBook;
    XSSFSheet excelSheet;
    XSSFCell excelCell;
    String path = "Path Name Should Be Affixed Here";
    String sheetName = "Sheet1";
    FileInputStream excelFile;



    public  ExcelReader(){

        try{
            excelFile = new FileInputStream(path);
            excelWBook = new XSSFWorkbook(excelFile);
            excelSheet = excelWBook.getSheet(sheetName);
            excelCell = excelSheet.getRow(0).getCell(0);
            String cellData = excelCell.getStringCellValue();
            System.out.println("Cell Data" + cellData);
        }

        catch (Exception e){
            e.printStackTrace();
        }

    }
}
