package test;

import java.io.File;
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("请输入指定目录");
        String str = input.next();

        File file = new File(str);

        File[] files = file.listFiles();

        if(files != null && files.length > 0){
            for(File f : files){
                if(f.isFile()){
                    System.out.println("文件：" + f.getName());
                }else{
                    System.out.println("目录：" + f.getName());
                }
            }
        }
    }
}
