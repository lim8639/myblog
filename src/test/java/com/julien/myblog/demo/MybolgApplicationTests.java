package com.julien.myblog.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;


@SpringBootTest
class MybolgApplicationTests {

    @Test
    void contextLoads() {
        int a=0,b=0,c=0;

        Scanner scanner=new Scanner(System.in);//接受三次输入
        System.out.print("输入a：");
        a=scanner.nextInt();
        System.out .print("输入b：");
        b=scanner.nextInt();
        System.out .print("输入c:");
        c=scanner.nextInt();
        // 判断三角形
        if(a>0||b>0||c>0||a+b>c&&a+c>b&&b+c>a){

//          判断等边
            if(b == c && a == c) {
                System.out.print("等边三角形");
            }
            if(a==b||b==c||a==c) {
                System.out.print("等腰三角形");
                if(a*a+b*b==c*c||c*c+b*b==a*a||a*a+c*c==b*b) {
                    System.out.print("等腰直角三角形");
                }
            }
            else if(a*a+b*b==c*c||c*c+b*b==a*a||a*a+c*c==b*b) {
                System.out.print("直角三角形");
            }
            else {
                System.out.print("一般三角形");
            }
        }else{
            System.out.println("不是三角形，输入错误");
        }


    }


    @Test
    public String test() throws FileNotFoundException {
        File file  = new File("C:\\Users\\julien\\Downloads\\Video\\测试文件.txt");
        InputStream inputStream = new FileInputStream(file);

        System.out.println("hello");
        return "helloworld";
    }

}
