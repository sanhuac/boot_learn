package com.huc.boot.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/20 19:33
 * @Description: xml工具类
 */
public class xmlUtil {

 public static String xml = "<?xml  version="+" '1.0' "+" encoding="+" 'GBK' "+" standalone="+" 'no' " +"?><B2CRes><interfaceName>ICBC_WAPB_B2C</interfaceName><interfaceVersion>1.0.0.6</interfaceVersion><orderInfo><orderDate>20130410133846</orderDate><orderid>201304101338460</orderid><amount>500</amount><installmentTimes>1</installmentTimes><merAcct>0200024109031548569</merAcct><merID>0200EC23335149</merID><curType>001</curType><verifyJoinFlag>0</verifyJoinFlag><JoinFlag>0</JoinFlag><UserNum></UserNum></orderInfo><bank><TranSerialNo>1234567890</TranSerialNo><notifyDate>20130410134154</notifyDate><tranStat>1</tranStat><comment>交易成功，已清算！</comment></bank></B2CRes>";


    /**
     * @description 将xml字符串转换成map
     * @param xml
     * @return Map
     */
    public static Map readStringXmlOut(String xml) {
        Map map = new HashMap();
        Document doc = null;
        try {
            doc = DocumentHelper.parseText(xml); // 将字符串转为XML
            Element rootElt = doc.getRootElement(); // 获取根节点
            System.out.println("根节点：" + rootElt.getName()); // 拿到根节点的名称
            Iterator iter = rootElt.elementIterator("orderInfo");
            // 遍历head节点
            while (iter.hasNext()) {
                Element recordEle = (Element) iter.next();
                String orderDate = recordEle.elementTextTrim("orderDate");
                System.out.println("orderDate:" + orderDate);
                map.put("orderDate", orderDate);
                String orderid = recordEle.elementTextTrim("orderid");
                System.out.println("orderid:" + orderid);
                map.put("orderid", orderid);
                String amount = recordEle.elementTextTrim("amount");
                System.out.println("amount:" + amount);
                map.put("amount", amount);
                String installmentTimes = recordEle.elementTextTrim("installmentTimes");
                System.out.println("installmentTimes:" + installmentTimes);
                map.put("installmentTimes", installmentTimes);
                String merAcct = recordEle.elementTextTrim("merAcct");
                System.out.println("merAcct:" + merAcct);
                map.put("merAcct", merAcct);
                String merID = recordEle.elementTextTrim("merID");
                System.out.println("merID:" + merID);
                map.put("merID", merID);
                String curType = recordEle.elementTextTrim("curType");
                System.out.println("curType:" + curType);
                map.put("curType", curType);
                String verifyJoinFlag = recordEle.elementTextTrim("verifyJoinFlag");
                System.out.println("verifyJoinFlag:" + verifyJoinFlag);
                map.put("verifyJoinFlag", verifyJoinFlag);
                String JoinFlag = recordEle.elementTextTrim("JoinFlag");
                System.out.println("JoinFlag:" + JoinFlag);
                map.put("JoinFlag", JoinFlag);
                String UserNum = recordEle.elementTextTrim("UserNum");
                System.out.println("UserNum:" + UserNum);
                map.put("UserNum", UserNum);

            }
            Iterator iterss = rootElt.elementIterator("bank"); ///获取根节点下的子节点body
            // 遍历body节点
            while (iterss.hasNext()) {
                Element recordEless = (Element) iterss.next();
                String TranSerialNo = recordEless.elementTextTrim("TranSerialNo"); // 拿到body节点下的子节点result值
                System.out.println("TranSerialNo:" + TranSerialNo);
                map.put("TranSerialNo", TranSerialNo);
                String notifyDate = recordEless.elementTextTrim("notifyDate"); // 拿到body节点下的子节点result值
                System.out.println("notifyDate:" + notifyDate);
                map.put("notifyDate", notifyDate);
                String tranStat = recordEless.elementTextTrim("tranStat"); // 拿到body节点下的子节点result值
                System.out.println("tranStat:" + tranStat);
                map.put("tranStat", tranStat);
                String comment = recordEless.elementTextTrim("comment"); // 拿到body节点下的子节点result值
                System.out.println("comment:" + comment);
                map.put("comment", comment);

            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void main(String[] args) {
        Map map = readStringXmlOut(xml);
        System.out.println(map);
    }
}
