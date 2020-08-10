package entity;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.StringWriter;

/**
 * @author yanshilong5@jd.com
 * @date 2020/7/16 16:19
 * @since JDK 1.8
 * desc：学生实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stu {

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 方法或者字段描述
     */
    private long longval;
}
