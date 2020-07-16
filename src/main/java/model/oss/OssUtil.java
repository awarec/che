package model.oss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectRequest;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class OssUtil {
    private static String endpoint = "https://oss-cn-hangzhou.aliyuncs.com";
    private static String accessKeyId = "LTAI4G2Ye1hcf5QvpbHtbRPh";
    private static String accessKeySecret = "FYepRpSA95gqqrPfZDNgKr9Y1FGz4F";
    private static String bucketName = "sunkeys";
    private static String folder = "image/";
    private static String key = "https://sunkeys.oss-cn-hangzhou.aliyuncs.com";


    /**
     * 文件上传
     * @param fileName
     * @param inputStream
     * @return
     */
    public static String uploadImageToOSS(String fileName, InputStream inputStream) {

        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

        try {
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmm-");
            String data = simpleDateFormat.format(date);
            String[] names = fileName.split("[.]");
            //图片名称：时间-uuid
            String name = data + uuid + "." + names[names.length - 1];
            //putObject 上传对象
            ossClient.putObject(new PutObjectRequest(bucketName, folder + name, inputStream));
//            Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
//            System.out.println(ossClient.generatePresignedUrl("bucketName","fileName",expiration).toString());
            return key+folder+name;
        } catch ( Exception e){
            e.printStackTrace();
            System.err.println(e.getMessage());

        }
        return null;
    }
}
