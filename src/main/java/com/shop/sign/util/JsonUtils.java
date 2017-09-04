package main.java.com.shop.sign.util;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;
import main.java.com.shop.sign.SPayException;
import main.java.com.shop.sign.SPayObject;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;


/**
 * JSON 工具类
 * 
 * 参考地址：http://wiki.fasterxml.com/JacksonDownload
 * 
 * @author sunaolin
 * 
 */
public abstract class JsonUtils {
	/**
	 * JSON格式化时间的默认格式
	 */
	private static final DateFormat DEFAULT_DATETIME_FORMAT = new SimpleDateFormat(SPayConfig.DATE_TIME_FORMAT);

	private static final ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * 设置对象的默认属性
	 */
	static {
		// 设置输出格式
		objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false)
	        .configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
	        .configure(Feature.WRITE_NUMBERS_AS_STRINGS, true);

        // 设置输出格式
        objectMapper.setSerializationInclusion(Include.NON_NULL);

		// 设置日期格式
		objectMapper.setDateFormat(DEFAULT_DATETIME_FORMAT);

		// 设置支持的注解类型
		AnnotationIntrospector introspector = AnnotationIntrospector.pair(
		    new JacksonAnnotationIntrospector(), 
		    new JaxbAnnotationIntrospector(TypeFactory.defaultInstance())
		);

		objectMapper.setAnnotationIntrospector(introspector);
	}

    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }

	/**
	 * 把带有注解的请求/响应对象转换成键值映射对象
	 * 
	 * @param object 请求/响应对象
	 * 
	 * @return 返回键值映射对象
	 */
    @SuppressWarnings("unchecked")
    public static <T extends SPayObject> Map<String, String> toMap(T object) {
        try {
            String content = objectMapper.writeValueAsString(object);
            return objectMapper.readValue(content, Map.class);
        }
        catch (IOException ex) {
            throw new SPayException(ex);
        }
    }

    /**
     * 把普通JAVABEAN对象，转换成JSON格式字符串
     * 
     * @param object 转换的JAVABEAN对象
     * 
     * @return 返回转换后的JSON格式字符串
     */
    public static String toString(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        }
        catch (JsonProcessingException ex) {
            throw new SPayException(ex);
        }
    }

    /**
     * 把JSON格式字符串转换成{@code SPayObject}对象
     * 
     * @param json JSON格式字符串
     * 
     * @param clazz 实现{@code SPayObject}的类
     * 
     * @return 返回{@code SPayObject}对象
     */
    public static <T extends SPayObject> T toObject(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        }
        catch (IOException ex) {
            throw new SPayException(ex);
        }
    }
}