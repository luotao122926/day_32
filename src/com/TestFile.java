package com;

import org.junit.Test;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestFile {
    @Test
    public void FileTest(){
        File file = new File("file.txt");

        try {
            if(file.exists()){
                System.out.println("文件已存在");
            }else{
                file.createNewFile();
                System.out.println("文件已创建");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //该文件存放的绝对路径
        System.out.println(file.getAbsoluteFile());
        //该文件存放的相对路径
        System.out.println(file.getPath());
        //该文件的文件名
        System.out.println(file.getName());
        //文件是否可写
        System.out.println(file.canWrite());
        //该文件是否可读
        System.out.println(file.canRead());
        //该文件是否为隐藏文件
        System.out.println(file.isHidden());
        //该文件的长度
        System.out.println(file.length());
        //判断是否为文件or是否为文件
        System.out.println(file.isFile());
        //判断是否为文件or是否为目录
        System.out.println(file.isDirectory());
        //该文件的最后修改时间


        long lastModified = file.lastModified();

        Date date = new Date(lastModified);

        DateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println("最后修改时间："+sd.format(date));



    }
    @Test
    public void test1() {
        File file = new File("F:/feiq/Recv Files");

        File[] files = file.listFiles(new MyFile());

        if (files != null && files.length > 0) {
            for (File f : files) {
                if (f.isFile()) {
                    System.out.println("文件" + f.getName());
                } else {
                    System.out.println("目录" + f.getName());
//                    File[] files1 = f.listFiles();
//                    if (files1 != null && files1.length > 0) {
//                        for (File f1 : files1) {
//                            if (f1.isFile()) {
//                                System.out.println("子目录文件" + f1.getName());
//                            } else {
//                                System.out.println("子目录目录" + f1.getName());
//                            }
//                        }
//                    }
                }
            }
        }
    }


    @Test
    public void TestFile1(){
        showFile(new File("F:/feiq/Recv Files"),0);
    }

    public void showFile(File file,int level){
        String prev = "";
        for(int i = 0 ; i < level ; i++){
            prev+= "  ";
        }
        File[] files = file.listFiles();
        if(files != null && files.length > 0){
            for(File f : files){
                if(f.isFile()){
                    System.out.println(prev + "第" + (level+1) + "级文件：" + f.getName());
                }else{
                    System.out.println(prev + "第" + (level+1) + "级目录：" + f.getName());
                    showFile(f,level+1);
                }
            }
        }
    }
}

class MyFile implements FileFilter{
    @Override
    public boolean accept(File file) {
                if(file.isFile()) {
                    if (file.getName().endsWith(".md")) {
                        return true;
                    }
                }
        return false;
    }
}
