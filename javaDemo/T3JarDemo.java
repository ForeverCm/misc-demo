package javaDemo;

import java.io.BufferedReader;    
import java.io.IOException;    
import java.io.InputStream;    
import java.io.InputStreamReader;   

public class T3JarDemo {
    public static void main(String[] args)    
    {    
        Process p;    
       //test.bat中的命令是ipconfig/all    
        String cmd="ls";    
           
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