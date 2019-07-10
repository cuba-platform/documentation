package com.company.demo.core;

import com.company.demo.entity.Foo;
import com.haulmont.chile.core.model.MetaPropertyPath;
import com.haulmont.cuba.core.app.DefaultJpqlSortExpressionProvider;

public class CustomSortExpressionProvider extends DefaultJpqlSortExpressionProvider {

    @Override
    public String getDatatypeSortExpression(MetaPropertyPath metaPropertyPath, boolean sortDirectionAsc) {
        if (metaPropertyPath.getMetaClass().getJavaClass().equals(Foo.class)
                && "number".equals(metaPropertyPath.toPathString())) {
            return String.format("CAST({E}.%s BIGINT)", metaPropertyPath.toString());
        }
        return String.format("{E}.%s", metaPropertyPath.toString());
    }
}