package com.huizhi.oa.controller.system;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huizhi.oa.entity.UserRoleDep;
import com.huizhi.oa.service.UserinfoService;
import com.huizhi.oa.util.ExcelExportUtilWithPOI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/system")
public class ExcelController {
	@Autowired
	private UserinfoService userinfoService;

	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	String sc = "导出时间:";
	String print = sc+df.format(System.currentTimeMillis());
    @RequestMapping(value = "exportExcel", method = RequestMethod.GET)
	public void exportDoctorsSummary(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String fileName = new String("职工档案表.xls".getBytes(), "iso-8859-1");
		List<UserRoleDep> list = userinfoService.getAllUserinfo();
		List<String> title = new ArrayList<String>();
		title.add("职工编号");
		title.add("姓名");
		title.add("年龄");
		title.add("性别");
		title.add("地址");
		title.add("邮箱");
		title.add("电话");
		title.add("QQ");
		title.add("岗位");
		title.add("部门");
		
		List<String> field = new ArrayList<String>();
		field.add("userid");
		field.add("turename");
		field.add("age");
		field.add("sex");
		field.add("address");
		field.add("email");
		field.add("phone");
		field.add("qq");
		field.add("roleNamemc");
		field.add("depNamemc");
		
		
		InputStream is = ExcelExportUtilWithPOI.createWorkBook("职工档案表","职工档案表", title,field,list,print);
		// 设置response参数，可以打开下载页面
		response.reset();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		ServletOutputStream out = response.getOutputStream();
		try (
			BufferedInputStream bis = new BufferedInputStream(is);
			BufferedOutputStream bos = new BufferedOutputStream(out);
		) {
			byte[] buff = new byte[2048];
			int bytesRead;
			// Simple read/write loop.
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (final IOException e) {
			throw e;
		} 
	}
}
