package one.zpq.springbootdemo.controller;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import one.zpq.springbootdemo.domain.Customer;
import one.zpq.springbootdemo.service.PdfExportService;
import one.zpq.springbootdemo.view.PdfView;

@RequestMapping("mvc")
@Controller
public class MvcController {

    @Autowired
    private MessageSource messageSource;

    /**
     * 测试前端传递数组参数
     * 
     * @return
     */
    @GetMapping("array")
    public Map<String, Object> testSendArray(int[] intArr) {
        System.out.println("testSendArray");
        System.out.println(Arrays.toString(intArr));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("intArr", intArr);
        return map;
    }

    /**
     * 测试传递Json数据
     * 
     * @return
     */
    @PostMapping("json")
    public Map<String, Object> testSendJson(@RequestBody Customer customer) {
        System.out.println("testSendJson");
        System.out.println(customer);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("customer", customer);
        return map;
    }

    // @NumberFormat(pattern = "#,###.##")
    /**
     * 格式时间、金额格式
     * 
     * @return
     */
    @PostMapping("format")
    @ResponseBody
    public Map<String, Object> testFormat(Date date, Double money) {
        System.out.println("testFormat");
        System.out.println(date);
        System.out.println(money);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("date", date);
        map.put("money", money);
        return map;
    }

    @PostMapping("testConverter")
    public Map<String, Object> testConverter(Customer customer) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("customer", customer);
        return map;
    }

    @GetMapping("testPdfView")
    public ModelAndView testPdfView() {
        List<Customer> customerList = new ArrayList<Customer>();
        for (int i = 0; i < 10; i++) {
            Customer customer = new Customer();
            customer.setAccount("account-" + i);
            customer.setEmail("email-" + i);
            customerList.add(customer);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("customerList", customerList);
        View view = new PdfView(getService());
        modelAndView.setView(view);
        return modelAndView;
    }

    /**
     * Lambda获取PdfExportService
     * 
     * @return
     */
    private PdfExportService getService() {

        return (Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request,
                HttpServletResponse response) -> {
            try {
                document.setPageSize(PageSize.A4);
                document.addTitle("客户信息");
                document.add(new Chunk("\n"));
                PdfPTable table = new PdfPTable(2);
                PdfPCell cell = null;
                Font f8 = new Font();
                f8.setColor(Color.BLUE);
                f8.setStyle(Font.BOLD);
                // cell = new PdfPCell(new Paragraph("id", f8));
                // cell.setHorizontalAlignment(1);
                // table.addCell(cell);
                List<Customer> customerList = (List<Customer>) model.get("customerList");
                for (Customer customer : customerList) {
                    document.add(new Chunk("\n"));
                    cell = new PdfPCell(new Paragraph(customer.getAccount() + ""));
                    table.addCell(cell);
                    cell = new PdfPCell(new Paragraph(customer.getEmail() + ""));
                    table.addCell(cell);
                }
                document.add(table);
            } catch (DocumentException e) {
                e.printStackTrace();
            }

        };
    }

    /**
     * 跳转页面
     * 
     * @return
     */
    @GetMapping("testFileUpload")
    public String toFileUpload() {
        return "testFileUpload";
    }

    /**
     * 测试文件上传，使用MultipartHttpServletRequest
     * 
     * @return
     */
    @GetMapping("testFileUpload/request")
    @ResponseBody
    public Map testFileUpload1(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        MultipartHttpServletRequest multipartHttpServletRequest = null;
        if (!(request instanceof MultipartHttpServletRequest)) {
            map.put("code", "999999");
            map.put("msg", "上传参数有误");
            return map;
        }
        multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartHttpServletRequest.getFile("file");
        String originalFilename = multipartFile.getOriginalFilename();
        File file = new File(originalFilename);
        try {
            multipartFile.transferTo(file);
        } catch (Exception e) {
            map.put("code", "999999");
            map.put("msg", "上传失败");
            e.printStackTrace();
            return map;
        }
        map.put("code", "000000");
        map.put("msg", "上传成功");
        return map;
    }

    /**
     * 
     * @return
     */
    @PostMapping("testFileUpload/multipartFile")
    @ResponseBody
    public Map testFileUpload2(@RequestParam(name = "file") MultipartFile multipartFile) {
        Map<String, Object> map = new HashMap<>();
        String originalFilename = multipartFile.getOriginalFilename();
        File file = new File(originalFilename);
        try {
            multipartFile.transferTo(file);
        } catch (Exception e) {
            map.put("code", "999999");
            map.put("msg", "上传失败");
            e.printStackTrace();
            return map;
        }
        map.put("code", "000000");
        map.put("msg", "上传成功");
        return map;
    }

    /**
     * 
     * @return
     */
    @PostMapping("testFileUpload/part")
    @ResponseBody
    public Map testFileUpload3(Part file) {
        Map<String, Object> map = new HashMap<>();
        try {
            file.write(file.getSubmittedFileName());
        } catch (IOException e) {
            map.put("code", "999999");
            map.put("msg", "上传失败");
            e.printStackTrace();
            return map;
        }
        map.put("code", "000000");
        map.put("msg", "上传成功");
        return map;
    }

    @GetMapping(value = "test/interceptor/1")
    @ResponseBody
    public String testInterceptor() {
        System.out.println("this is method testInterceptor");
        return "000000";
    }

    @GetMapping(value = "test/i18n")
    @ResponseBody
    public String testI18n() {
        Locale locale = LocaleContextHolder.getLocale();
        String message = messageSource.getMessage("msg", null, locale);
        System.out.println("this is method testInterceptor");
        return message;
    }

}
