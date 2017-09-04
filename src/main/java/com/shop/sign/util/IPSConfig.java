package main.java.com.shop.sign.util;

import com.esotericsoftware.reflectasm.FieldAccess;

import java.lang.reflect.Array;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class IPSConfig {

	/**
	 * 商户号
	 */
	public static final String MERCHANT_ID = "808801";
	/**
	 * IPS证书
	 */
	public static final String CERT = "GPhKt7sh4dxQQZZkINGFtefRKNPyAj8S00cgAwtRyy0ufD7alNC28xCBKpa6IU7u54zzWSAv4PqUDKMgpOnM7fucO1wuwMi4RgPAnietmqYIhHXZ3TqTGKNzkxA55qYH";
	/**
	 * IPS 3des密钥
	 */
	public static final String SIGN_KEY = "ICHuQplJ0YR9l7XeVNKi6FMn";
	/**
	 * IPS 3des向量
	 */
	public static final String SIGN_SALT = "2EDxsEfp";
	/**
	 * IPS WebService的请求主机地址
	 */
	public static final String WEB_SERVICE_HOST = "http://p2p.ips.net.cn:8013" /* "https://p2p.ips.com.cn" */;
	public static final String CREDIT_WS = WEB_SERVICE_HOST + "/CreditWS/Service.asmx?wsdl";
	public static final String CREDIT_WS_QUERY = WEB_SERVICE_HOST + "/CreditWSQuery/Service.asmx?wsdl";
	/**
	 * IPS操作成功
	 */
	public static final String IPS_ERR_CODE = "MG00000F";
	/**
	 * IPS充值操作成功
	 */
	public static final String IPS_BANK_ERR_CODE = "0000";

	/**
	 * 充值渠道 ＝ 9
	 */
	public static final int IPS_PAY_CHANNEL = 9;



	/**
	 * 开户请求POST URL
	 */
	public static final String POST_URL = "http://p2p.ips.net.cn:8091/CreditWeb/";

	/**
	 * 开户请求WS_URL URL
	 */
	public static final String WS_URL = "http://p2p.ips.net.cn:6778/CreditWS/Service.asmx";

	/**
	 * OPEN_ACCOUNT_URL:开户请求完整地址POST URL
	 */
	public static final String OPEN_ACCOUNT_URL = POST_URL + "CreateNewIpsAcct.aspx";

	/**
	 * 开户结果成功返回的商户返回地址URL
	 */
	public static final String OPEN_ACCOUNT_BACK_URL = "http://192.168.0.210/jjh/user/openAccountResult";
	/**
	 * 开户结果返回的商户异步返回地址返回地址URL
	 */
	public static final String OPEN_ACCOUNT_BACK_S2S_URL = "http://192.168.0.210/jjh/user/openAccountAnsyResult";

	/**
	 * OPEN_ACCOUNT_URL:充值请求完整地址POST URL
	 */
	public static final String RECHARGE_WEB_URL = POST_URL + "doDpTrade.aspx";

	/**
	 * 开户结果成功返回的商户返回地址URL
	 */
	public static final String RECHARG_BACK_URL = "http://192.168.0.210/jjh/pay/result";
	/**
	 * 开户结果返回的商户异步返回地址返回地址URL
	 */
	public static final String RECHARG_BACK_S2S_URL = "http://192.168.0.210/jjh/pay/notice";

	/**
	 * 将键值对转换为符合环迅需要的XML格式的字符串
	 *
	 * @param kvPairs
	 * @return
	 * @version 1.0
	 * @author Ready
	 */
	/*public static final String get3DesXmlPara(String... kvPairs) {
		Assert.isTrue(kvPairs.length > 0 && (kvPairs.length & 1) == 0, "The number of kvPairs must be even");
		StringBuilder sb = new StringBuilder((kvPairs.length << 4) + 32);
		sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		sb.append("<pReq>");
		String name = null;
		boolean cdata = false;
		for (int i = 0; i < kvPairs.length; i++) {
			name = kvPairs[i++];
			cdata = name.charAt(0) == '@';
			if (cdata) {
				name = name.substring(1);
			}
			sb.append('<').append(name).append('>');
			if (cdata) {
				sb.append("<![CDATA[");
			}
			sb.append(kvPairs[i]);
			if (cdata) {
				sb.append("]]>");
			}
			sb.append("</").append(name).append('>');
		}
		sb.append("</pReq>");
		return encode3DesXmlPara(sb.toString());
	}
*/
	/**
	 * 加密发起请求中的3DesXmlPara
	 *
	 * @param data
	 * @return
	 * @version 1.0
	 * @author Ready
	 */
	/*public static final String encode3DesXmlPara(String data) {
		return IpsCrypto.triDesEncrypt(data, SIGN_KEY, SIGN_SALT);
	}*/

	/**
	 * 解码响应的3DesXmlPara
	 *
	 * @param data
	 * @return
	 * @version 1.0
	 * @author Ready
	 */
	/*public static final String decode3DesXmlPara(String data) {
		return IpsCrypto.triDesDecrypt(data, SIGN_KEY, SIGN_SALT);
	}*/

	static ConcurrentMap<Class<?>, FieldAccess> accessors = new ConcurrentHashMap<Class<?>, FieldAccess>();

	/**
	 * 如果在指定Map集合中存在与实体类中对应的属性，则将该属性赋值为map中的对应值
	 *
	 * @param map
	 * @param bean
	 * @param fromRequest 指示当前map是否来自于请求(即HttpServletRequest)
	 * @return
	 * @version 1.0
	 * @author Ready
	 */
	@SuppressWarnings("rawtypes")
	public static final <E> E mapAsBean(Map map, E bean, boolean fromRequest) {
		Class<?> clazz = bean.getClass();
		FieldAccess access = accessors.get(clazz);
		if (access == null) {
			access = FieldAccess.get(clazz);
			accessors.put(clazz, access);
		}
		String[] names = access.getFieldNames();
		for (int i = 0; i < names.length; i++) {
			access.set(bean, i, washMapValue(map.get(names[i]), fromRequest));
		}
		return bean;
	}

	/**
	 * 清洗Map集合中的值。由于某些Map集合来自于request，其值可能为String[]，因此需要对Map的value值进行清洗，以确保返回值为字符串
	 *
	 * @param value
	 * @param fromRequest
	 * @return
	 * @version 1.0
	 * @author Ready
	 */
	public static final String washMapValue(Object value, boolean fromRequest) {
		if (fromRequest && value instanceof String[]) {
			value = Array.get(value, 0);
		}
		return (String) value;
	}

	/**
	 * 如果在指定Map集合中存在与实体类中对应的属性，则将该属性赋值为map中的对应值
	 *
	 * @param map
	 * @param bean
	 * @return
	 * @version 1.0
	 * @author Ready
	 */
	@SuppressWarnings("rawtypes")
	public static final <E> E mapAsBean(Map map, E bean) {
		return mapAsBean(map, bean, false);
	}

}
