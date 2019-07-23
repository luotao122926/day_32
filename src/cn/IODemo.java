package cn;

import org.junit.Test;

import java.io.*;

public class IODemo {
    @Test
    public void test1(){
        InputStream is = null;
        OutputStream os = null;

        try {
            is = new FileInputStream("file.txt");
            os = new FileOutputStream("file1.txt");

            byte[] bytes = new byte[1024];
            while(is.read(bytes) != -1){
                os.write(bytes);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(is != null) is.close();
                if(os != null) os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2(){
        InputStream is = null;

        try {
            is = new FileInputStream("file.txt");

            byte[] bytes = new byte[1024];
            while(is.read(bytes) != -1){
                System.out.println(new String(bytes));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
    @Test
    public void test3(){
        OutputStream os = null;

        try {
            os = new FileOutputStream("file1.txt",true);

            String info = "许炳海是人才1111";

            os.write(info.getBytes());
            System.out.println(111);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(os != null) os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
