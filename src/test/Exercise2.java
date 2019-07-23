package test;

import java.io.File;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("请输入指定目录：");
        String str = input.next();

        Exercise2 a = new Exercise2();
        a.showFile(new File(str),0);
    }

    public void showFile(File file,int level){
        File[] files = file.listFiles();

        String prev = "";
        for(int i = 0; i < level ; i++){
            prev+= "  ";
        }
        if(files != null && files.length > 0){
            for(File f : files){
                if(f.isFile()){
                    System.out.println(prev + "第" + (level+1) + "级文件" + f.getName());
                }else{
                    System.out.println(prev + "第" + (level+1) + "级目录" + f.getName());
                    showFile(f,level+1);
                }
            }
        }
    }
}
