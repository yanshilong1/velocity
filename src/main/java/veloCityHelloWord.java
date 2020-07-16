import com.sun.org.apache.xerces.internal.impl.io.UTF8Reader;
import entity.Stu;
import lombok.Builder;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import sun.text.normalizer.UTF16;
import util.initTemplateByName;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yanshilong5@jd.com
 * @date 2020/7/16 14:46
 * @since JDK 1.8
 * desc：变量赋值输出测试用例
 */
public class veloCityHelloWord {
    public static void main(String[] args) {
        //基本初始化赋值运算
        Template t = initTemplateByName.initTemplate("hellovelocity.vm");
//        test1(t);

        //日期使用
        Template t2 = initTemplateByName.initTemplate("velocitydate.vm");
//        test2(t2);

        //对类进行操作
        Template t3 = initTemplateByName.initTemplate("stu.vm");
        test3(t3);

        //宏计算
        Template t4 = initTemplateByName.initTemplate("macrotest.vm");
//        test4(t4);
    }

    public static void test1(Template t) {
        if (Objects.isNull(t)) {
            throw new RuntimeException("template is null");
        }
        //变量设置
        VelocityContext context = new VelocityContext();
        context.put("name", "我是velocity");
        List<String> list = new ArrayList<>();
        list.add("ab");
        list.add("ac");
        list.add("bc");
        context.put("list", list);
        //变量赋值输出给模板
        StringWriter stringWriter = new StringWriter();
        t.merge(context, stringWriter);
        System.out.println(stringWriter);
    }

    public static void test2(Template t) {
        if (Objects.isNull(t)) {
            throw new RuntimeException("template is null");
        }
        //变量设置
        VelocityContext context = new VelocityContext();
        context.put("topic", "person");
        context.put("date", new SimpleDateFormat("yyyy-mm-dd HH:mm:ss").format(new Date()));
        StringWriter stringWriter = new StringWriter();
        t.merge(context, stringWriter);
        System.out.println(stringWriter);

    }


    public static void test3(Template t) {
        if (Objects.isNull(t)) {
            throw new RuntimeException("template is null");
        }
        //初始化模板引擎
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        //初始化
        velocityEngine.init();
        VelocityContext context = new VelocityContext();
        context.put("topic", "第：");

        Stu stu1 = new Stu("张三", 22);
        Stu stu2 = new Stu("张四", 23);
        Stu stu3 = new Stu("张五", 24);
        List<Stu> stuList = new ArrayList<>(Arrays.asList(stu1, stu2, stu3));
        context.put("stuList", stuList);
        StringWriter sw = new StringWriter();

//        List a = Arrays.asList(context.getKeys());
//        System.out.println("key:" + a);
//        System.out.println("topic:" + context.get("topic"));
//        System.out.println("arr:" + context.get("stuList"));

//        List<String> arrayList = new ArrayList<>();
//        arrayList.add("新加str");
//        arrayList.add("新加str1");
//        context.put("strList", arrayList);
//        t.merge(context, sw);
//        System.out.println(sw);


        velocityEngine.mergeTemplate("stu.vm","utf-8",context,sw);
        List list= Stream.of(context.get("strList")).collect(Collectors.toList());
        System.out.println(list);
        list.add("strAdd");
        list.add("strAdd1");
        context.put("strList",list);

    }


    public static void test4(Template t) {
        if (Objects.isNull(t)) {
            throw new RuntimeException("template is null");
        }
        VelocityContext context = new VelocityContext();
        StringWriter sw = new StringWriter();
        t.merge(context, sw);
        System.out.println(sw);
    }
}
