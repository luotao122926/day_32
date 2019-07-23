package test;

import org.junit.Test;

import java.io.*;

public class Exercise3 {

    @Test
    public void testFile() {
        copyFile("D:\\笔记\\day31", "c:/新建文件夹1");
    }

    public void copyFile(String srcFilePath, String targetFilePath) {
        File file = new File(srcFilePath);
        File file1 = new File(targetFilePath);

        File[] files = file.listFiles();

        if (files != null && files.length > 0) {
            for (File f : files) {
                if (file1.exists()) {
                    if (f.isFile()) {
//                    System.out.println(file1);
//                    System.out.println(f.getName());

                        try (
                                InputStream is = new FileInputStream(f);
                                OutputStream os = new FileOutputStream(file1 + "/" + f.getName());
                        ) {
                            byte[] bytes = new byte[1024];
                            while (is.read(bytes) != -1) {
                                os.write(bytes);
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("1" + f);
                        System.out.println("2" + file1);
                        System.out.println("3" + file1 + "/" + f.getName());
                        System.out.println("4" + file + "/" + f.getName());
                        copyFile((file + "/" + f.getName()), (file1 + "/" + f.getName()));
                    }
                } else {
                    file1.mkdir();
                }

            }
        }
    }
}

