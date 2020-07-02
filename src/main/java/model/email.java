package aliy.poji;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

public class email {

    public static  void email(){

        //自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        //产品名称:云通信短信API产品,开发者无需替换
        final String product = "Dysmsapi";
        //产品域名,开发者无需替换
        final String domain = "dysmsapi,aliyuecs.com";

        final String accessKeyId = "LTAI4G2Ye1hcf5QvpbHtbRPh";
        final String accessKeySecret = "FYepRpSA95gqqrPfZDNgKr9Y1FGz4F";


//        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
//        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
//        IAcsClient acsClient = new DefaultAcsClient(profile);
        //使用CommonRequest调用方式可实现任意Open API接口的调用
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4G2Ye1hcf5QvpbHtbRPh", "FYepRpSA95gqqrPfZDNgKr9Y1FGz4F");
        IAcsClient client = new DefaultAcsClient(profile);


        CommonRequest request = new CommonRequest();
        //使用post提交
//        request.setSysProtocol(ProtocolType.HTTPS);
        request.setSysMethod(MethodType.POST); //请求
        request.setSysDomain("dysmsapi.aliyuncs.com");//设置发送短信服务器，默认为dysmsapi.aliyuncs.com
        request.setSysVersion("2017-05-25");//设置版本，默认为2017-05-25
        request.setSysAction("SendSms"); //  设置调用的API方法名
//        request.putQueryParameter("RegionId","cn-hangzou");

        request.putQueryParameter("PhoneNumbers","13758932806"); //手机号
        request.putQueryParameter("SignName","明月");//标签名称
        request.putQueryParameter("TemplateCode","SMS_193244014");//模板code
        request.putQueryParameter("TemplateParam","{code:123456}");//短信发送内容
        CommonResponse response = null;
        try {
            response = client.getCommonResponse(request);
        } catch (ClientException e) {
            e.printStackTrace();
        }
//        //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式；发送国际/港澳台消息时，接收号码格式为国际区号+号码，如“85200000000”
//        request.setPhoneNumbers("1500000000");
//        //必填:短信签名-可在短信控制台中找到
//        request.setSignName("东阳云尚");
//        //      接收短信的电话号码
//        request.putQueryParameter("15558050065", "电话号码");
//        //必填:短信模板-可在短信控制台中找到，发送国际/港澳台消息时，请使用国际/港澳台短信模版
//        request.setTemplateCode("SMS_193244014");
//        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
//        //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
//        request.setTemplateParam("{\"qwe\":\"Tom\", \"${code}\":\"123\"}");
//        //可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
//        //request.setSmsUpExtendCode("90997");
//        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
//        request.setOutId("yourOutId");
//请求失败这里会抛ClientException异常
//        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
//        if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
////请求成功
//        }
        try {
            System.out.println(response.getData());

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    static final String product = "Dysmsapi";
    static final String endpoint  = "dysmsapi.aliyuncs.com";
    static final String accessKeyId = "LTAI4G2Ye1hcf5QvpbHtbRPh";
    static final String accessKeySecret = "FYepRpSA95gqqrPfZDNgKr9Y1FGz4F";

    public static void send() throws  Exception {
        //自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, endpoint );
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组长请求对象  -阿里云的文档部分内容
        SendSmsRequest request=new SendSmsRequest();
        request.setPhoneNumbers("15558050065");
        request.setSignName("明月");
        request.setTemplateCode("SMS_193244014");
        request.setTemplateParam("{\"code\":\"1111\"}");
        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutId");
        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        request.setSmsUpExtendCode("90997");
        SendSmsResponse response=acsClient.getAcsResponse(request);
        System.out.println(response);
    }
}
