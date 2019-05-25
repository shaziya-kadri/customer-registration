package CustomerPackage;



import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.io.FastByteArrayOutputStream;
import org.apache.pdfbox.io.ccitt.FillOrderChangeInputStream;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;

import com.sun.rowset.internal.Row;

import java.util.Iterator;


public class XlsReader {
    private static final int index = 0;
	//	public static String filename = new File("Data//MIGNG_TestData.xls").toString();
//	public static String filename = System.getProperty("user.dir")+"/Data/TestData.xlsx";
    public static String path;
    public FileInputStream fis = null;
    public FileOutputStream fileOut = null;
    private XSSFWorkbook workbook = null;
    private XSSFSheet sheet = null;
   public  XSSFRow row = null;
    public XSSFCell cell = null;
    private static int testCount=0;
   // XlsReader xlsRead = new XlsReader("C:\\Users\\Saleena\\Testng-automation\\CustomerRegistration\\TestData\\TestData_CustomerRegistration.xlsx");
    public XlsReader(java.lang.String path) {

       this.path = path;
    	
        try {
           fis = new FileInputStream(path);
           // fis = new FileInputStream("C:\\Users\\shaziya.Cinque\\Documents\\workspace-sts-3.9.8.RELEASE\\CustomerRegistration\\TestData");
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int getRowCount(String sheetName) {
        int index = workbook.getSheetIndex(sheetName);
        if (index == -1) {
            return 0;
        } else {
            sheet = workbook.getSheetAt(index);
            int number = sheet.getLastRowNum() + 1;
            return number;
          
        }

    }


    
    
    
    public String getCellData(String sheetName, String colName, int rowNum) {
        try {
            if (rowNum <= 0) {
                return "";
            }

            int index = workbook.getSheetIndex(sheetName);
            int col_Num = -1;
            if (index == -1) {
                return "";
            }

            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(0);
            for (int i = 0; i < row.getLastCellNum(); i++) {
                if (row.getCell(i).getStringCellValue().trim().equals(colName.trim())) {
                    col_Num = i;
                }
            }
            if (col_Num == -1) {
                return "";
            }

            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(rowNum - 1);
            if (row == null) {
                return "";
            }
            cell = row.getCell(col_Num);

            if (cell == null) {
                return "";
            }
            //System.out.println(cell.getCellType());
            if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                return cell.getStringCellValue();
            } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {

                String cellText = String.valueOf(cell.getNumericCellValue());
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    // format in form of M/D/YY
                    double d = cell.getNumericCellValue();

                    Calendar cal = Calendar.getInstance();
                    cal.setTime(HSSFDateUtil.getJavaDate(d));
                    cellText =
                            (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
                    cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" +
                            cal.get(Calendar.MONTH) + 1 + "/" +
                            cellText;
                    //System.out.println(cellText);
                }

                return cellText;
            } else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
                return "";
            } else {
                return String.valueOf(cell.getBooleanCellValue());
            }

        } catch (Exception e) {

            e.printStackTrace();
            return "row " + rowNum + " or column " + colName + " does not exist in xls";
        }
    }

    // returns the data from a cell
    public String getCellData(String sheetName, int colNum, int rowNum) {
        try {
            if (rowNum <= 0) {
                return "";
            }

            int index = workbook.getSheetIndex(sheetName);

            if (index == -1) {
                return "";
            }

            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(rowNum - 1);
            if (row == null) {
                return "";
            }
            cell = row.getCell(colNum);
            if (cell == null) {
                return "";
            }

            if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                return cell.getStringCellValue();
            } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
                String cellText = String.valueOf(cell.getNumericCellValue());
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    // format in form of M/D/YY
                    double d = cell.getNumericCellValue();
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(HSSFDateUtil.getJavaDate(d));
                    cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
                    cellText = cal.get(Calendar.MONTH) + 1 + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cellText;
                }
                return cellText;
            } else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
                return "";
            } else {
                return String.valueOf(cell.getBooleanCellValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "row " + rowNum + " or column " + colNum + " does not exist  in xls";
        }
    }

    // returns true if data is set successfully else false
    public Boolean setCellData(String sheetName, String colName, int rowNum, String data) {
        try {
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);

            if (rowNum <= 0) {
               return false;
            	
            }

            int index = workbook.getSheetIndex(sheetName);
            int colNum = -1;
            if (index == -1) {
                return false;
            }


            sheet = workbook.getSheetAt(index);
            int rowCount = getRowCount(sheetName);


            row = sheet.getRow(0);
           /* for (int i = 0; i < row.getLastCellNum(); i++) {
                //System.out.println(row.getCell(i).getStringCellValue().trim());
                if (row.getCell(i).getStringCellValue().trim().equals(colName)) {
                    colNum = i;
                }
            }*/
            if (colNum == -1) {
                return false;
            }

            sheet.autoSizeColumn(colNum);
            row = sheet.getRow(rowCount);
            if (row == null) {
                row = sheet.createRow(rowCount - 1);
            }

            cell = row.getCell(colNum);
            if (cell == null) {
                cell = row.createCell(colNum);
            }
            
            cell.setCellValue(data);
            System.out.println("column="+ colNum+"Row"+rowCount);
           // System.out.println(rowCount);
            
 
            fileOut = new FileOutputStream(path);

            workbook.write(fileOut);

            fileOut.close();

        } catch (Exception e) {
            e.printStackTrace();
           return false;
        }
       return true;
		
    }

  

    // returns true if data is set successfully else false
    public void setCellData(String data) {  
    	String sheetName=null;
    	String colName =null;
    	int rowNum =0;
       String url =null;
    	
    	try {
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);

            if (rowNum <= 0) 
            {
              // return false;
            }

            int index = workbook.getSheetIndex(sheetName);
            int colNum = -1;
            if (index == -1) {
              //  return false;
            }


            sheet = workbook.getSheetAt(index);
            //System.out.println("A");
            row = sheet.getRow(0);
            int rowCount = getRowCount(sheetName);
            for (int i = 0; i < row.getLastCellNum(); i++) {
                System.out.println(row.getCell(i).getStringCellValue().trim());
                if (row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(colName)) {
                    colNum = i;
                }
            }

            if (colNum == -1) {
          
            }
            sheet.autoSizeColumn(colNum); 
            row = sheet.getRow(rowNum - 1);
            if (row == null) {
                row = sheet.createRow(rowNum - 1);
            }

            cell = row.getCell(colNum);
            if (cell == null) {
                cell = row.createCell(colNum);
            }

            cell.setCellValue(data);
            XSSFCreationHelper createHelper = workbook.getCreationHelper();

         
           
            CellStyle hlink_style = workbook.createCellStyle();
            XSSFFont hlink_font = workbook.createFont();
            hlink_font.setUnderline(XSSFFont.U_SINGLE);
            hlink_font.setColor(IndexedColors.BLUE.getIndex());
            hlink_style.setFont(hlink_font);
          

            XSSFHyperlink link = createHelper.createHyperlink(XSSFHyperlink.LINK_FILE);
            link.setAddress(url);
            cell.setHyperlink(link);
            cell.setCellStyle(hlink_style);

            fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
           

            fileOut.close();

        } catch (Exception e) {
            e.printStackTrace();
          
        }
     
		
        
        
	
    }


    // returns true if sheet is created successfully else false
    public boolean addSheet(String sheetname) {

        FileOutputStream fileOut;
        try {
            workbook.createSheet(sheetname);
            fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // returns true if sheet is removed successfully else false if sheet does not exist
    public boolean removeSheet(String sheetName) {
        int index = workbook.getSheetIndex(sheetName);
        if (index == -1) {
            return false;
        }

        FileOutputStream fileOut;
        try {
            workbook.removeSheetAt(index);
            fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // returns true if column is created successfully
    public boolean addColumn(String sheetName, String colName) {
        //System.out.println("**************addColumn*********************");

        try {
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
            int index = workbook.getSheetIndex(sheetName);
            if (index == -1) {
                return false;
            }

            XSSFCellStyle style = workbook.createCellStyle();
            style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
            style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

            sheet = workbook.getSheetAt(index);

            row = sheet.getRow(0);
            if (row == null) {
                row = sheet.createRow(0);
            }

            //cell = row.getCell();
            //if (cell == null)
            //System.out.println(row.getLastCellNum());
            if (row.getLastCellNum() == -1) {
                cell = row.createCell(0);
            } else {
                cell = row.createCell(row.getLastCellNum());
            }

            cell.setCellValue(colName);
            cell.setCellStyle(style);

            fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.close();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;


    }

    // removes a column and all the contents
    @SuppressWarnings("unused")
    public boolean removeColumn(String sheetName, int colNum) {
        try {
            if (!isSheetExist(sheetName)) {
                return false;
            }
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
            XSSFCellStyle style = workbook.createCellStyle();
            style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
            XSSFCreationHelper createHelper = workbook.getCreationHelper();
            style.setFillPattern(HSSFCellStyle.NO_FILL);


            for (int i = 0; i < getRowCount(sheetName); i++) {
                row = sheet.getRow(i);
                if (row != null) {
                    cell = row.getCell(colNum);
                    if (cell != null) {
                        cell.setCellStyle(style);
                        row.removeCell(cell);
                    }
                }
            }
            fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

    // find whether sheets exists
    public boolean isSheetExist(String sheetName) {
        int index = workbook.getSheetIndex(sheetName);
        if (index == -1) {
            index = workbook.getSheetIndex(sheetName.toUpperCase());
            if (index == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    // returns number of columns in a sheet
    public int getColumnCount(String sheetName) {
        // check if sheet exists
        if (!isSheetExist(sheetName)) {
            return -1;
        }

        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(0);

        if (row == null) {
            return -1;
        }

        return row.getLastCellNum();
    }

    // returns number of columns in a sheet
    public int getColumnCount(String sheetName, int rowNumber) {
        // check if sheet exists
        if (!isSheetExist(sheetName)) {
            return -1;
        }

        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rowNumber);

        if (row == null) {
            return -1;
        }

        return row.getLastCellNum();
    }

    //String sheetName, String testCaseName,String keyword ,String URL,String message
   /* public boolean addHyperLink(String sheetName, String screenShotColName, String testCaseName, int index, String url, String message) {
        //System.out.println("ADDING addHyperLink******************");

        url = url.replace('\\', '/');
        if (!isSheetExist(sheetName)) {
            return false;
        }

        sheet = workbook.getSheet(sheetName);

        for (int i = 2; i <= getRowCount(sheetName); i++) {
            if (getCellData(sheetName, 0, i).equalsIgnoreCase(testCaseName)) {
                //System.out.println("**caught "+(i+index));
                setCellData(sheetName, screenShotColName, i + index, message, url);
                break;
            }
        }


        return true;
    }*/

    public int getCellRowNum(String sheetName, String colName, String cellValue) {

        for (int i = 2; i <= getRowCount(sheetName); i++) {
            if (getCellData(sheetName, colName, i).equalsIgnoreCase(cellValue)) {
                return i;
            }
        }
        return -1;

    }

    public Object[][] getTestDataWithNoEmptyRows(String sheetName) {

        int columnCount = getColumnCount(sheetName);
        int rowCount = getRowCount(sheetName);

        ArrayList<Map<String, String>> data = new ArrayList<Map<String, String>>();
        for (int rNum = 1; rNum < rowCount; rNum++) {
        	boolean skipRow = false;
            Map<String, String> testScenario = new HashMap();
            for (int cNum = 0; cNum < columnCount; cNum++) {
                String columnName = getCellData(sheetName, cNum, 1);
                String value = getCellData(sheetName, cNum, rNum+1);
                if (cNum == 0 && value != null && value.equalsIgnoreCase("skip_this_row")) {
                	skipRow = true;
                }
                testScenario.put(columnName, value == null ? "" : value);
            }
            if (checkMapIsNotEmpty(testScenario) && !skipRow) {
                data.add(testScenario);
            }
        }
        Object[][] dataObjectList = new Object[data.size()][1];
        int i = 0;
        for (Map<String, String> dataMap : data) {
            dataObjectList[i][0] = dataMap;
            i++;
        }
        return dataObjectList;
    }



    private boolean checkMapIsNotEmpty(Map<String, String> scenarioMap) {
        Iterator<String> iterator = scenarioMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            String value = scenarioMap.get(key);
            if (value != null && !value.trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }
  
    

    
  /*  public void writeCell(String[] dataToWrite) throws IOException{
        
        String fileName = null;
		File file =    new File(path+"\\"+fileName);
        
        FileInputStream inputStream = new FileInputStream(file);
        Workbook customerdata = null;
        
        String fileExtensionName = fileName.substring(fileName.indexOf("."));
      
        if(fileExtensionName.equals(".xlsx")){
                	customerdata = new XSSFWorkbook(inputStream);
        }
       
        else if(fileExtensionName.equals(".xls")){
         
        	customerdata = new HSSFWorkbook(inputStream);
 
        }    
 
    Sheet sheet = customerdata.getSheet(sheetName);
    int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
    Row row1 = (Row) sheet.getRow(0);
 
   Row newRow1 = (Row) sheet.createRow(rowCount+1); 
 

 
    for(int j = 0; j < row.getLastCellNum(); j++){
 
        Cell cell = ((org.apache.poi.ss.usermodel.Row) newRow1).createCell(j);
 
        cell.setCellValue(dataToWrite[j]);
 
    }
     inputStream.close();
 
 
    FileOutputStream outputStream = new FileOutputStream(file);
 
    customerdata.write(outputStream);

    outputStream.close();   
 
    }
 
   // public static void main(String...strings) throws IOException{
 
 
 
     
 
	
 
}*/
}





    
    
    








    
    
    



