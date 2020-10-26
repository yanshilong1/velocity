package mapdb.Impl;

import mapdb.mapDbService;
import org.mapdb.DB;
import org.mapdb.DBMaker;

import java.util.concurrent.ConcurrentMap;

/**
 * @author yanshilong5@jd.com
 * @date 2020/10/26 20:39
 * @since JDK 1.8
 * desc：
 */
public class mapDbServiceImpl implements mapDbService {

    /**
     * mapDB
     */
    private static DB mapDb;


    /**
     * 构造函数初试化
     */
    public mapDbServiceImpl(){
       mapDb=DBMaker.fileDB("file.db").make();

    }

    @Override
    public boolean setValue(String key, Object value) {
        try {
            ConcurrentMap map = mapDb.hashMap("map").createOrOpen();
            map.put(key, value);
            mapDb.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public Object getValue(String key) {
        ConcurrentMap map = mapDb.hashMap("map").createOrOpen();
        Object val=map.get(key);
        return val;
    }
}
