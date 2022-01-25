package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.InvalidJsonException;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.json.JacksonJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import io.qameta.allure.Allure;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonUtils {

    public synchronized static String getFieldFromJson(String body, String jsonPath) {
        Configuration jacksonConfig = Configuration.builder()
                .mappingProvider(new JacksonMappingProvider())
                .jsonProvider(new JacksonJsonProvider())
                .build();

        String val;
        JsonNode node;
        try {
            node = JsonPath.using(jacksonConfig).parse(body).read(jsonPath, JsonNode.class);
        } catch (InvalidJsonException e) {
            Allure.addAttachment("INVALID JSON", "application/json", body, ".txt");
            throw new InvalidJsonException("Невалидный json.");
        }

        if (node == null || node.isNull()) {
            val = "null";
        } else {
            val = node.toString();
        }

        String matchValue = getMatchValueByGroupNumber(val, "^\"(.*)\"$", 1);
        val = matchValue == null ? val : matchValue;
        return val;
    }

    private synchronized static String getMatchValueByGroupNumber(String sentence, String regex, int groupNumber) {
        if (sentence != null && regex != null) {
            sentence = sentence.trim();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(sentence);
            if (matcher.find()) {
                return matcher.group(groupNumber);
            }
        }
        return null;
    }

    public synchronized static String extractBrackets(Object in) {
        if (in == null) {
            return "null";
        }
        String op = in.toString();
        String replace;
        String replace2;
        if (op.startsWith("[") && op.endsWith("]") && !op.contains(",")) {
            replace = StringUtils.replace(StringUtils.replace(op, "[", ""), "]", "");
            if (StringUtils.startsWith(replace, "\"") && StringUtils.endsWith(replace, "\"")) {
                replace2 = StringUtils.replace(replace, "\"", "");
                try {
                    if (replace2.matches("^[0-9]+$")) {
                        new BigDecimal(replace2);
                    }
                    return replace2;
                } catch (NumberFormatException n) {
                    return replace;
                }
            } else {
                return replace;
            }
        }
        if (op.startsWith("[[") && op.endsWith("]]") || op.startsWith("[") && op.endsWith("]")) {
            op = op.replaceFirst("\\[", "");
            int lastIndex = op.lastIndexOf("]");
            return op.substring(0, lastIndex);
        }
        return op;
    }
}
