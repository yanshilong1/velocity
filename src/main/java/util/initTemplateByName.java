package util;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.PropertyConfigurator;
import org.apache.velocity.Template;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * @author yanshilong5@jd.com
 * @date 2020/7/16 15:02
 * @since JDK 1.8
 * desc：根据模板名称获取模板的工具类
 */

public class initTemplateByName {
    public   static Template initTemplate(String templateName){
        if(StringUtils.isEmpty(templateName)){
            throw new RuntimeException("initTemplateByName.initTemplate param templateName is null");
        }
        //初始化
        VelocityEngine velocityEngine=init();
        //通过文件名称获取模板
        try {
            Template t = velocityEngine.getTemplate(templateName);
            if (Objects.isNull(t)) {
                if (StringUtils.isEmpty(templateName)) {
                    throw new RuntimeException("initTemplateByName.initTemplate can not find a template templateName is：" + templateName);
                }
            }
            return t;
        }catch (Exception e){
            if(e instanceof ResourceNotFoundException){
                System.out.println("please check templateName");
            }else {
                e.printStackTrace();
            }
            return null;
        }
    }


    /**
     * Description: VelocityEngine这个模板引擎
     * Param: void
     * Author: yanshilong5@jd.com
     * Creation: 2020/7/16 15:04
     * Return:velocityEngine
     */
    public  static VelocityEngine init(){
        //初始化模板引擎
        VelocityEngine velocityEngine=new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER,"classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        //初始化
        velocityEngine.init();
        return velocityEngine;
    }
}
