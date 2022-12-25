import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.wdk.fulfillcore.service.api.dto.FulfillSubOrderAttribute;
import com.wdk.fulfillcore.service.message.FulfillStatusChangeEvent;
import com.wdk.fulfillcore.service.message.FulfillStatusChangeEvents;

/**
 * @author dou.guo
 * @version WdkTest, v 0.1 2022-10-28 9:24 下午 dou.guo Exp $
 */
public class WdkTest {

    public static void main(String[] args) {
        FulfillStatusChangeEvents obj = new FulfillStatusChangeEvents();

        FulfillStatusChangeEvent event = new FulfillStatusChangeEvent();
        event.setBuyerId(2210550222419l);
        event.setShopCode("9998");//dwksc
        event.setSourceFrom("TC");

        event.setBizOrderId("5000774996282110575");//wdk主单
        event.setSubBizOrderId("5000774996282120575");//wdk子单

        event.setSourceOrderId("2981446094856221924");//tp主单
        event.setSubSourceOrderId("2981446094857221924");//tp子单

        FulfillSubOrderAttribute fulfillSubOrderAttribute = new FulfillSubOrderAttribute();
        fulfillSubOrderAttribute.setFeebackReason("原因1");
        fulfillSubOrderAttribute.setFeebackSubReason("原因1——1");
        event.setFulfillSubOrderAttribute(fulfillSubOrderAttribute);

        obj.setEvents(Lists.newArrayList(event));

        String s = JSONObject.toJSONString(obj);

        System.out.println(s);
    }
}
