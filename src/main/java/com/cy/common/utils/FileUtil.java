package com.cy.common.utils;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 文件维护类
 * Created by kam on 2015/10/31.
 */
public class FileUtil {
    /**
     * 文件上传
     *
     * @param request
     * @return
     */
    public static List<String> upload(HttpServletRequest request, String targetPath) throws IOException {
        List<String> fileNames = new ArrayList<String>();
        //创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //判断 request 是否有文件上传,即多部分请求
        if (multipartResolver.isMultipart(request)) {
            //转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                //记录上传过程起始时的时间，用来计算上传时间
                //int pre = (int) System.currentTimeMillis();
                //取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if (file != null) {
                    //取得当前上传文件的文件名称
                    String myFileName = file.getOriginalFilename();
                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    if (myFileName.trim() != "") {
                        System.out.println(myFileName);

                        //重命名上传后的文件名
                        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
                        String originalFilename = file.getOriginalFilename();
                        int begin = originalFilename.lastIndexOf(".");
                        int end = originalFilename.length();
                        String suffix = originalFilename.substring(begin, end);
                        String fileName = df.format(new Date()).concat(suffix);
                        System.out.println(fileName);
                        //定义上传路径
                        String path = targetPath + fileName;
                        System.out.println(path);
                        File localFile = new File(path);
                        file.transferTo(localFile);
                        fileNames.add(fileName);
                    }
                }
                //记录上传该文件后的时间
                //  int finaltime = (int) System.currentTimeMillis();
                //System.out.println(finaltime - pre);
            }
        }
        return fileNames;
    }

    /**
     * 删除文件
     *
     * @param targetPath
     */
    public static void delete(String targetPath) {
        File file = new File(targetPath);
        if (file != null) {
            file.delete();
        }
    }
}
