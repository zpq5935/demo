package controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import domain.User_file;


@Controller
@RequestMapping(value="/file")
public class FileUploadController {
	@RequestMapping("/uploadForm")
	public String uploadForm(){
		return  "/WEB-INF/jsp/uploadForm.jsp";
	}
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String upload(HttpServletRequest request,
			@RequestParam("description") String description,
			@RequestParam("file") MultipartFile file) throws Exception{
		System.out.println(description);
		if(!file.isEmpty()){
			String path = request.getServletContext().getRealPath("/images/");
			System.out.println(path);
			String filename = file.getOriginalFilename();
			File filepath = new File(path,filename);
			if(!filepath.getParentFile().exists()){
				filepath.getParentFile().mkdirs();
			}
			file.transferTo(new File(path+File.separator+filename));
			return "/WEB-INF/jsp/upload_success.jsp";
		}
		return "/WEB-INF/jsp/upload_error.jsp";
	}
	
	@RequestMapping(value="/upload2",method=RequestMethod.POST)
	public String upload2(
			HttpServletRequest request,
			@ModelAttribute User_file user,
			Model model) throws Exception{
		System.out.println(user.getUsername());
		if(!user.getImage().isEmpty()){
			String path = request.getServletContext().getRealPath("/images/");
			String filename = user.getImage().getOriginalFilename();
			File filepath = new File(path,filename);
			if(!filepath.getParentFile().exists()){
				filepath.getParentFile().mkdirs();
			}
			user.getImage().transferTo(new File(path+File.separator+filename));;
			model.addAttribute("user", user);
			return "/WEB-INF/jsp/upload_success.jsp";
		}
		return "/WEB-INF/jsp/upload_error.jsp";
	}

	@RequestMapping(value="/download")
	public ResponseEntity<byte[]> download(
				HttpServletRequest request,
				@RequestParam("filename") String filename,
				Model model) throws Exception{
		String path = request.getServletContext().getRealPath("/images/");
		File file = new File(path+File.separator+filename);
		//
		HttpHeaders headers = new HttpHeaders();
		//
		String downloadFileName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
		//
		headers.setContentDispositionFormData("attachment",downloadFileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
				headers,HttpStatus.CREATED);
	}
}
