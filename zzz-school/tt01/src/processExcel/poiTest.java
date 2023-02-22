package processExcel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class poiTest {

	public static void main(String[] args) throws IOException {
		Workbook sourcewWorkbook = readExcel("excel/source.xls");
		Workbook updateWorkbook = readExcel("excel/update.xlsx");
		Sheet sheet = sourcewWorkbook.getSheetAt(1);
		Sheet updateSheet = updateWorkbook.getSheetAt(0);
		//

		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			if (null == row)
				continue;
			for (int j = 0; j < updateSheet.getPhysicalNumberOfRows(); j++) {
				Row row2 = updateSheet.getRow(j);
				if (null == row2)
					continue;
				if (row.getCell(0).getStringCellValue().equals(row2.getCell(0).getStringCellValue())) {
					Cell cell = row2.getCell(7);
					if (cell == null) {
						row2.createCell(7, CellType.NUMERIC).setCellValue((double) getCellValue(row.getCell(1)));
					} else {
						row2.getCell(7).setCellValue((double) getCellValue(row.getCell(1)));
					}
				}

			}
		}
		FileOutputStream fileOutputStream = new FileOutputStream("excel/generate.xlsx");
		updateWorkbook.write(fileOutputStream);
		fileOutputStream.flush();
		System.out.println("-----------OK------------------");
	}

	public static Workbook readExcel(String file) throws IOException {
		InputStream in = new FileInputStream(file);
		Workbook workbook = null;
		String[] strings = file.split("\\.");

		if (strings[1].equals("xls")) {
			workbook = new HSSFWorkbook(in);
		} else if (strings[1].equals("xlsx")) {
			workbook = new XSSFWorkbook(in);
		} else {
			workbook = null;
		}
		in.close();
		return workbook;
	}

	public static Object getCellValue(Cell cell) {
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_NUMERIC: {
			return cell.getNumericCellValue();
		}
		case Cell.CELL_TYPE_STRING: {
			return cell.getStringCellValue();
		}
		default: {
			return null;
		}
		}
	}

	/**
	 * 今天项目里遇到以"." 、"\"、“|”分割字符串，直接用"." 、"\"、“|”无法分割， 因为"."
	 * 、"\"、“|”是特殊字符，需要转义，"\\." 、"\\\"、“\\|”。
	 */
	@Test
	public void t2() {
		String file = "excel/source.xls";
		String[] strings = file.split("\\.");
		System.out.println(strings.length);
		for (String s : strings)
			System.out.println(s);
	}

	/**
	 * 测试读取带修改的表 xlsx
	 * 
	 * @throws IOException
	 */
	@Test
	public void t3() throws IOException {
		Workbook workbook = readExcel("excel/update.xlsx");
		Sheet sheet = workbook.getSheetAt(0);
		int rowNum = sheet.getPhysicalNumberOfRows();
		System.out.println(rowNum);
		for (int i = 0; i < rowNum; i++) {
			System.out.print(i + " ");
			Row row = sheet.getRow(i);
			if (row != null) {
				Cell cell = row.getCell(7);
				if (cell != null)
					System.out.println(i + " " + cell.getCellType() + " " + getCellValue(cell));
				else {
					row.createCell(7, CellType.STRING).setCellValue("111");
					System.out.println("null");
				}
			}
		}
		FileOutputStream fileOutputStream = new FileOutputStream("excel/generate.xlsx");
		workbook.write(fileOutputStream);
		fileOutputStream.flush();
	}

}
