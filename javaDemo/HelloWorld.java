import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import java.io.BufferedReader;    
import java.io.IOException;    
import java.io.InputStream;    
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;   

public class HelloWorld
{ 
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Process exitValue: " + "aaaaaa");
		// String cmd = "/Users/chenmeng08/t3jar/mp4DecryptMac/t3javaVM/temurin-11.jdk/Contents/Home/bin/java -jar /Users/chenmeng08/t3jar/mp4DecryptMac/bars-sdk-0.3.2.jar -f /Users/chenmeng08/t3jar/157627879086026949_1676885572493.mp4 -i /3a20f734a8824d1b916808ac8be5c618/157627704088229700/157627879086026949/157627879086026949_1676885572493.mp4 -t 2426e6d67d238e10438904e624317202 -o out.mp4";
        // Process pid = Runtime.getRuntime().exec(cmd);
        // // 获取外部程序标准输出流
        // new Thread(new OutputHandlerRunnable(pid.getInputStream())).start();
        // // 获取外部程序标准错误流
        // new Thread(new OutputHandlerRunnable(pid.getErrorStream())).start();
        // int exitValue = pid.waitFor();
        // System.out.println("Process exitValue: " + exitValue);
    }


    public static String decryptCTRMode(final String encryptedStr, String key, String ivKey) {
        if (!StringUtils.isNotBlank(encryptedStr)) {
            return null;
        }
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
        Cipher encipher = Cipher.getInstance("AES/CTR/pkcs5padding");
        IvParameterSpec iv = new IvParameterSpec(ivKey.getBytes(StandardCharsets.UTF_8));
        encipher.init(Cipher.DECRYPT_MODE, keySpec, iv);
        // 鍏堢敤BASE64瑙ｅ瘑
        byte[] encryptedBytes = Base64.decodeBase64(encryptedStr);
        // 鐒跺悗鍐岮ES瑙ｅ瘑
        byte[] originalBytes = encipher.doFinal(encryptedBytes);
        // 杩斿洖瀛楃涓�
        return new String(originalBytes, StandardCharsets.UTF_8);
    }

    private void decodeBase64(String encryptedStr) {
        // TODO
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