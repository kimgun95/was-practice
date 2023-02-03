package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueryStrings {

    List<QueryString> queryStringList = new ArrayList<>();

    // operand1=11 & operator=* & operand2=55
    public QueryStrings(String queryStringLine) {
        String[] queryStringTokens = queryStringLine.split("&");
        Arrays.stream(queryStringTokens)
                .forEach(queryString -> {
                    String[] values = queryString.split("=");
                    if (values.length != 2) {
                        throw new IllegalArgumentException("잘못된 QueryString 포맷을 가진 문자열 입니다.");
                    }
                    queryStringList.add(new QueryString(values[0], values[1]));
                });
    }

    public String getValue(String key) {
        return queryStringList.stream()
                .filter(queryString -> queryString.exist(key))
                .map(QueryString::getValue)
                .findFirst()
                .orElse(null);
    }
}
