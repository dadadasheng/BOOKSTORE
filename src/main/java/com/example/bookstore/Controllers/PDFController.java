package com.example.bookstore.Controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
@Controller
public class PDFController {
    @RequestMapping("/preview1")
    public void er(HttpServletResponse response){
        File file = new File("C:\\Users\\DELL\\Desktop\\BookStoreOnline\\pdf\\高等数学 第7版 上册 同济大学.pdf");
        if (file.exists()){
            byte[] data = null;
            try {
                FileInputStream input = new FileInputStream(file);
                data = new byte[input.available()];
                input.read(data);
                response.getOutputStream().write(data);
                input.close();
            } catch (Exception e) {
                System.out.println(e);
            }

        }else{
            return;
        }

    }
    @ResponseBody
    @RequestMapping("/preview2")
    public void findPdf( HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        FileInputStream in = null;
        try {
            in = new FileInputStream(new File("G:\\桌面\\Thymeleaf3.0中文翻译文档@www.java1234.com.pdf"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        OutputStream out = response.getOutputStream();
        byte[] b = new byte[512];
        while ((in.read(b))!=-1) {
            out.write(b);
        }
        out.flush();
        in.close();
        out.close();
    }

    @ResponseBody
    @RequestMapping("/preview3")
    public void devDoc(HttpServletRequest request, HttpServletResponse response, String storeName) throws Exception {
        request.setCharacterEncoding("UTF-8");
        String ctxPath = request.getSession().getServletContext().getRealPath("");
        String downLoadPath = "G:\\桌面\\Thymeleaf3.0中文翻译文档@www.java1234.com.pdf";
        response.setContentType("application/pdf");
        FileInputStream in = new FileInputStream(new File(downLoadPath));
        OutputStream out = response.getOutputStream();
        byte[] b = new byte[1024];
        while ((in.read(b))!=-1) {
            out.write(b);
        }
        out.flush();
        in.close();
        out.close();
    }
    @ResponseBody
    @RequestMapping("/preview")
    public void download( HttpServletResponse response
    ) throws IOException {
        String filePath = "G:\\桌面\\Thymeleaf3.0中文翻译文档@www.java1234.com.pdf";
        System.out.println("filePath:" + filePath);
        File f = new File(filePath);
        if (!f.exists()) {
            response.sendError(404, "File not found!");
            return;
        }
        BufferedInputStream br = new BufferedInputStream(new FileInputStream(f));
        byte[] bs = new byte[1024];
        int len = 0;
        response.reset(); // 非常重要
        if (true) { // 在线打开方式
            URL u = new URL("file:///" + filePath);
            String contentType = u.openConnection().getContentType();
            response.setContentType(contentType);
            response.setHeader("Content-Disposition", "inline;filename="
                    + "2019年上半年英语四级笔试准考证(戴林峰).pdf");
            // 文件名应该编码成utf-8，注意：使用时，我们可忽略这句
        } else {
            // 纯下载方式
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment;filename="
                    + "2019年上半年英语四级笔试准考证(戴林峰).pdf");
        }
        OutputStream out = response.getOutputStream();
        while ((len = br.read(bs)) > 0) {
            out.write(bs, 0, len);
        }
        out.flush();
        out.close();
        br.close();
    }



}
