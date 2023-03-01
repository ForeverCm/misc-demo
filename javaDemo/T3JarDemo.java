package javaDemo;

import java.io.BufferedReader;    
import java.io.IOException;    
import java.io.InputStream;    
import java.io.InputStreamReader;   

public class T3JarDemo {
    public static void main(String[] args)    
    {    
        Process p;    
        String cmd="/Users/chenmeng08/t3jar/t3javaVM/temurin-11.jdk/Contents/Home/bin/java -jar bars-sdk-0.3.2.jar -f /Users/chenmeng08/t3jar/157627981430836325_1677020832798.mp4 -i /3a20f734a8824d1b916808ac8be5c618/157627704190576357/157627981430836325/157627981430836325_1677020832798.mp4 -t f68feaf5e590e90680b79570cb17e13a -o decrypt.mp4";    
       try    
        {    
           //执行命令    
            p = Runtime.getRuntime().exec(cmd);    
           //取得命令结果的输出流    
            InputStream fis=p.getInputStream();    
           //用一个读输出流类去读    
            InputStreamReader isr=new InputStreamReader(fis);    
           //用缓冲器读行    
            BufferedReader br=new BufferedReader(isr);    
            String line=null;    
           //直到读完为止    
           while((line=br.readLine())!=null)    
            {    
                System.out.println(line);    
            }    
        }    
       catch (IOException e)    
        {    
            e.printStackTrace();    
        }    
    }    
}