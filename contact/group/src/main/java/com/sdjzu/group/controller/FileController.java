package com.sdjzu.group.controller;


import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.sdjzu.group.domain.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/files")
public class FileController {
    @Value("${server.port}")
    private String port;
    private static final String ip = "http://localhost";
    @PostMapping("/upload")
    public Result<?> uploadFiles(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();//获取源文件
        //因为相同的文件名可能是不同文件，为防止覆盖，我门需要加一个文件前缀来保证每次上床的文件不被覆盖
        String flag = IdUtil.fastSimpleUUID();
        String rootFilePath = System.getProperty("user.dir")+"/group/src/main/resources/files/"+flag+"_"+originalFilename;//获取上传路径
        FileUtil.writeBytes(file.getBytes(),rootFilePath);//把文件写入对应上床路径
        return Result.success(ip+":"+port+"/files/"+flag);//返回url
    }
    @GetMapping("/{flag}")
    public  void getFiles(@PathVariable String flag, HttpServletResponse response){
        OutputStream outputStream;//定义一个输出流对象
        String rootFilePath = System.getProperty("user.dir")+"/group/src/main/resources/files/";//文件上传路径
        List<String> fileNames = FileUtil.listFileNames(rootFilePath);//获取所有上传文件名称
        String fileName=fileNames.stream().filter(name -> name.contains(flag)).findAny().orElse("");//找到和参数一致的文件
        try{
            if(StrUtil.isNotEmpty(fileName)){
                response.addHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(fileName,"UTF-8"));
                response.setContentType("application/octet-stream");
                byte[] bytes = FileUtil.readBytes(rootFilePath + fileName);//通过路径读取文件字节流
                outputStream = response.getOutputStream();//输出流返回文件
                outputStream.write(bytes);
                outputStream.flush();
                outputStream.close();
            }
        }
        catch (Exception e){
            System.out.println("文件下载失败");
        }
    }
}
