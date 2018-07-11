package cn.tiny77.util;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class QBeanUtils {

    public static <T,R> List<T> getConvertedBean(Collection<R> rs, Class<T> t, VoConverter<T,R>...converters){
        List<T> list = new ArrayList<>(rs.size());
        for (R rBean : rs) {
            try {
                T tBean = t.newInstance();
                BeanUtils.copyProperties(rBean, tBean);
                for (VoConverter<T, R> converter : converters) {
                    converter.convert(tBean, rBean);
                }
                list.add(tBean);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return list;
    }

}
