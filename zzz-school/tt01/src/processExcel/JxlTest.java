package processExcel;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;


/**
 * 这个 jxl 不支持 2007xlsx 格式的 excel 文档
 * @author zcp
 *
 */
public class JxlTest {
	public static void main(String[] args) throws BiffException, IOException {
		jxl.Workbook workbook = null;
		InputStream inputStream = new FileInputStream("excel/source.xls");
		workbook = Workbook.getWorkbook(inputStream);
		Sheet sheet1 = workbook.getSheet(0);
		int rows = sheet1.getRows();
		int columns = sheet1.getColumns();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				Cell cell = sheet1.getCell(j, i);
				System.out.printf("%20s|%d", cell.getContents(), cell.getContents().length());
			}
			System.out.println();
		}

	}

	public Workbook readExcel(InputStream in) throws BiffException, IOException {
		Workbook workbook = null;
		if (in != null) {
			workbook = Workbook.getWorkbook(in);
		}
		return workbook;
	}

	@Test
	public void t1() throws BiffException, FileNotFoundException, IOException, RowsExceededException, WriteException {
		long start = System.currentTimeMillis();
		Workbook sourceWorkbook = readExcel(new BufferedInputStream(new FileInputStream("excel/source.xls")));
		Workbook waitWorkbook = readExcel(new BufferedInputStream(new FileInputStream("excel/update.xlsx")));
		jxl.write.WritableWorkbook writeWorkbook = Workbook.createWorkbook(new File("excel/generate.xlsx"),
				waitWorkbook);
		Sheet sheet_s = sourceWorkbook.getSheet(1);
		Sheet sheet_w = sourceWorkbook.getSheet(0);
		jxl.write.WritableSheet writableSheet = writeWorkbook.getSheet(0);
		int rows_s = sheet_s.getRows();
		int columns_s = sheet_s.getColumns();
		int rows_w = sheet_w.getRows();
		int columns_w = sheet_w.getColumns();
		//
		for (int i = 0; i < rows_s; i++) {
			for (int j = 0; j < rows_w; j++) {
				if (sheet_s.getCell(0, i).getContents().equals(sheet_w.getCell(0, j).getContents())) {
					// ((Label) (writableSheet.getWritableCell(7,
					// j))).setString(sheet_s.getCell(1, i).getContents());
					Label label = new Label(7, i, sheet_s.getCell(1, i).getContents());
					writableSheet.addCell(label);
				}
			}
		}

		//
		writeWorkbook.write();
		long end = System.currentTimeMillis();
		System.out.println("OVER : " + (end - start));
		sourceWorkbook.close();
		waitWorkbook.close();
		writeWorkbook.close();

	}
}
