import java.io.BufferedReader;    
import java.io.IOException;    
import java.io.InputStream;    
import java.io.InputStreamReader;   

public class HelloWorld
{ 
    public static void main(String[] args) throws IOException, InterruptedException {
		String cmd = "/Users/chenmeng08/t3jar/mp4DecryptMac/t3javaVM/temurin-11.jdk/Contents/Home/bin/java -jar /Users/chenmeng08/t3jar/mp4DecryptMac/bars-sdk-0.3.2.jar -f /Users/chenmeng08/t3jar/157627879086026949_1676885572493.mp4 -i /3a20f734a8824d1b916808ac8be5c618/157627704088229700/157627879086026949/157627879086026949_1676885572493.mp4 -t 2426e6d67d238e10438904e624317202 -o out.mp4";
        Process pid = Runtime.getRuntime().exec(cmd);
        // 获取外部程序标准输出流
        new Thread(new OutputHandlerRunnable(pid.getInputStream())).start();
        // 获取外部程序标准错误流
        new Thread(new OutputHandlerRunnable(pid.getErrorStream())).start();
        int exitValue = pid.waitFor();
        System.out.println("Process exitValue: " + exitValue);
    }

    private static class OutputHandlerRunnable implements Runnable {
        private InputStream in;

        public OutputHandlerRunnable(InputStream in) {
            this.in = in;
        }

        @Override
        public void run() {
            try (BufferedReader bufr = new BufferedReader(new InputStreamReader(this.in))) {
                String line = null;
                while ((line = bufr.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

		

}