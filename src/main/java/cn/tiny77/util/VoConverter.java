package cn.tiny77.util;

public interface VoConverter<T,R>{
    void convert(T t, R r);
}