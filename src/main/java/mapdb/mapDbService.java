package mapdb;

/**
 * @author yanshilong5@jd.com
 * @date 2020/10/26 20:35
 * @since JDK 1.8
 * desc：mapdb 接口
 */
public interface mapDbService {


    /**
     * Description: 方法描述
     *
     * @param : yanshilong5@jd.com
     * @param key 文件key
     * @param  value 值
     * @Creation: 2020/10/26 20:35
     * @Return:
     */

    boolean setValue(String key, Object value);


    /**
     * Description: 方法描述
     * @param key 存储key
     * @Creation: 2020/10/26 20:45
     * @Return:
     */
    Object getValue(String key);

}
