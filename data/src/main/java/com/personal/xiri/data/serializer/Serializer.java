package com.personal.xiri.data.serializer;

import com.google.gson.Gson;
import com.personal.xiri.domin.Response;

import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Gaojianyang on 18/9/12.
 * github https://github.com/gaojianyang
 */
public class Serializer {
    private final Gson gson = new Gson();

    @Inject
    Serializer() {
    }

    /**
     * Serialize an object to Json.
     *
     * @param object to serialize.
     */
    public String serialize(Object object, Class clazz) {
        return gson.toJson(object, clazz);
    }
    /**
     * Serialize an object to Json.
     *
     * @param object to serialize.
     */
    public String serialize(Object object) {
        return gson.toJson(object);
    }

    /**
     * Deserialize a json representation of an object.
     *
     * @param string A json string to deserialize.
     */
    public <T> T deserialize(String string, Class<T> clazz) {
        return gson.fromJson(string, clazz);
    }

    public <T> Response<T> deserializefromJsonObject(String reader, Class<T> clazz) {
        Type type = new ParameterizedTypeImpl(Response.class, new Class[]{clazz});
        return new Gson().fromJson(reader, type);
    }

    public <T> Response<List<T>> deserializefromJsonArray(String reader, Class<T> clazz) {
        // 生成List<T> 中的 List<T>
        Type listType = new ParameterizedTypeImpl(List.class, new Class[]{clazz});
        // 根据List<T>生成完整的Result<List<T>>
        Type type = new ParameterizedTypeImpl(Response.class, new Type[]{listType});
        return new Gson().fromJson(reader, type);
    }

}
