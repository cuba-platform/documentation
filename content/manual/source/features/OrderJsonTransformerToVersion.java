package com.company.test.transformer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Strings;
import com.haulmont.restapi.transform.AbstractEntityJsonTransformer;
import com.haulmont.restapi.transform.JsonTransformationDirection;

public class OrderJsonTransformerToVersion extends AbstractEntityJsonTransformer {

    public RepairJsonTransformerToVersion() {
        super("sales$NewOrder", "sales$OldOrder", "1.0", JsonTransformationDirection.TO_VERSION);
    }

    @Override
    protected void doCustomTransformations(ObjectNode rootObjectNode, ObjectMapper objectMapper) {
        JsonNode orderDateNode = rootObjectNode.get("orderDate");
        if (orderDateNode != null) {
            String orderDateNodeValue = orderDateNode.asText();
            if (!Strings.isNullOrEmpty(orderDateNodeValue))
                rootObjectNode.put("orderDate", orderDateNodeValue + " 00:00:00.000");
        }
    }
}