package jsoncompare;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 * @author yanshilong5@jd.com
 * @date 2020/8/10 18:28
 * @since JDK 1.8
 * desc：json字符串对比工具类
 */
public class JsonUtil {

    /**
     * Description: 方法描述
     * Param: [json1 json字符1, json2 json字符2]
     * Author: yanshilong5@jd.com
     * Creation: 2020/8/10 18:30
     * Return: map<值不同的key,key对应的值>
     */
    static Map<String,Object> doCompare(String json1,String json2){
        //返回值map
        Map<String,Object> resultMap=new HashMap<>(3,1);
//        resultMap.put("str2",json2);
//        resultMap.put("str1",json1);
        if(StringUtils.isEmpty(json1)||StringUtils.isEmpty(json2)){
            resultMap.put("exprRet","字符串不可以为空");
        }
        StringBuilder res=new StringBuilder();
        try {
            JSONObject jsonObject1= JSONObject.parseObject(json1);

            JSONObject jsonObject2=JSONObject.parseObject(json2);
            jsonCompare(res,jsonObject1,jsonObject2,"");
            resultMap.put("exprRet",res);

        }catch (Exception e){
            e.printStackTrace();
            resultMap.put("exprRet",e.getMessage());
            return resultMap;
        }

        return resultMap;
    }


    static void jsonCompare(StringBuilder stringBuilder,JSONObject jsonObject1,JSONObject jsonObject2,String key){
        Iterator<String> i=jsonObject1.keySet().iterator();
        while (i.hasNext()){
            key=i.next();
            compareJson(stringBuilder,jsonObject1.get(key),jsonObject2.get(key),key);
        }
    }

    static void compareJson(StringBuilder stringBuilder,Object json1,Object json2,String key){
        if(json1 instanceof  JSONObject){
            jsonCompare(stringBuilder,(JSONObject) json1,(JSONObject) json2,key);
        }else if(json1 instanceof JSONArray){
            compareJson(stringBuilder,(JSONArray)json1,(JSONArray)json2,key);
        }
        try {
            if(Objects.isNull(json1)&&Objects.isNull(json2)){
                stringBuilder.append("json1,json2 均为空");
                return;
            }
            if(Objects.nonNull(json1)){
                if(Objects.isNull(json2)){
                    stringBuilder.append("不一致key:" + key + ",json1:" + json1.toString() + ",json2:" + null  +"\n");
                    return;
                }
                if(json1.getClass()!=json2.getClass()){
                    stringBuilder.append("不一致key:"+key+",json1Class:"+json1.getClass()+",json2Class:"+json2.getClass()+"\n");
                    return;
                }
                compareJson(stringBuilder,json1.toString(),json2.toString(),key);
            }else {
                stringBuilder.append("不一致key:" + key + ",json1:" + null + ",json2:" + json2.toString()  +"\n");
                return;
            }


        }catch (Exception e){
            e.printStackTrace();
            stringBuilder.append("转换发生异常：");
            stringBuilder.append(e.getMessage());
        }
    }

    static void compareJson(StringBuilder stringBuilder,JSONArray json1,JSONArray json2,String key){
        if(Objects.nonNull(json1)&&Objects.nonNull(json2)){
            Iterator i1=json1.iterator();
            Iterator i2=json2.iterator();
            while (i1.hasNext()){
                compareJson(stringBuilder,json1,json2,key);
            }
        }else {
            if (json1 == null && json2 == null) {
                stringBuilder.append("不一致：key:" + key + "  在json1和json2中均不存在\n");
            } else if (json1 == null) {
                stringBuilder.append("不一致：key:" + key + "  在json1中不存在\n");
            } else if (json2 == null) {
                stringBuilder.append("不一致：key:" + key + "  在json2中不存在\n");
            } else {
                stringBuilder.append("不一致：key:" + key + "  未知原因\n");
            }

        }
    }


    static void  compareJson(StringBuilder stringBuilder,String str1,String str2,String key){
        if(!str1.equals(str2)){
            stringBuilder.append("不一致key："+key+",json1:"+str1+",json2:"+str2+"\n");
        }else {

        }
    }
}
