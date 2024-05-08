package com.adria.notification.utils;
import com.adria.notification.dto.request.VariablesRequestDto;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ValidationUtils {

    public static boolean validateVariables(String templateVariables, List<VariablesRequestDto> requestVariables) {
        if (templateVariables == null || requestVariables == null) {
            System.err.println("Template variables or request variables are null");
            return false;
        }

        Map<String, String> templateMap = parseTemplateVariables(templateVariables);

//        for (Map.Entry<String, String> entry : templateMap.entrySet()) {
//            String key = entry.getKey();
//            String value = entry.getValue();
//            System.out.println("Key: " + key + ", Value: " + value);
//        }

        for (VariablesRequestDto requestVariable : requestVariables) {
            String templateName = requestVariable.getName();
//            String requestValue = requestVariable.getValue();

//            VariablesRequestDto matchingRequestVariable = findMatchingVariable(requestVariables, templateName);


//            if (matchingRequestVariable == null) {
//                return false; // Request does not contain the variable from template
//            }
//
//            String requestValue = matchingRequestVariable.getValue();
            System.err.println("Request variable: " + requestVariable.getName() + " " + requestVariable.getValue());
            System.err.println("res : " + templateMap.get("FIRST_NAME"));
            System.err.println("res : " + templateMap.get("LAST_NAME"));
            if (!templateMap.containsKey(templateName)) {
                // Variable not found in template
                System.err.println("Variable not found in template " + templateMap.get(templateName));
                return false;
            }

            String regex = templateMap.get(requestVariable.getName());

            if (!validateRegex(requestVariable.getValue(), regex)) {
                System.err.println("Value does not match regex ");
                return false; // Request value does not match the regex from template
            }
        }

        return true;
    }

    private static Map<String, String> parseTemplateVariables(String templateVariables) {
        Map<String, String> templateMap = new HashMap<>();
        String[] pairs = templateVariables.split(";");
        for (String pair : pairs) {
            String[] keyValue = pair.trim().split(":");
            if (keyValue.length == 2) {
                templateMap.put(keyValue[0].trim(), keyValue[1].trim());
            }
        }
        return templateMap;
    }

    private static boolean validateRegex(String value, String regex) {
        if (StringUtils.isEmpty(value) || StringUtils.isEmpty(regex)) {
            return false;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

}
