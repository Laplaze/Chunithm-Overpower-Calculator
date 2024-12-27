import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PostTextRequest {

    public static void main(String[] args) {
        String urlString = "http://43.139.107.206:8083/api/chunithm/filtered_info"; // 你的URL地址
        String filePath = "response.txt"; // 文件路径
        String postData = "{\n" +
                "  \"qq\": \"920759985\",\n" +
                "  \"level\": \"10-15\",\n" +
                "  \"diff\": \"MU\"\n" +
                "}"; // 要发送的JSON格式文本数据

        try {
            // 创建URL对象并打开连接
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8"); // 设置内容类型为JSON，并指定字符编码
            conn.setDoOutput(true); // 允许输出

            // 发送POST请求
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = postData.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // 获取响应码以检查请求是否成功
            int responseCode = conn.getResponseCode();
            System.out.println("Response Code : " + responseCode);

            // 尝试读取错误流中的信息
            BufferedReader errorReader = null;
            if (responseCode >= 400) {
                errorReader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                String errorLine;
                StringBuilder errorContent = new StringBuilder();

                while ((errorLine = errorReader.readLine()) != null) {
                    errorContent.append(errorLine);
                }

                errorReader.close();
                System.out.println("Error Response: " + errorContent.toString());
            } else {
                // 正常读取响应
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }

                in.close();
                conn.disconnect();

                // 将字符串保存到文件
                Files.write(Paths.get(filePath), content.toString().getBytes("UTF-8"));
                System.out.println("Content saved to file: " + filePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}