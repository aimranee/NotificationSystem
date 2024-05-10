package com.adria.notification.utils;

import com.adria.notification.dto.request.VariablesRequestDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import java.util.HashMap;
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

        Map<String, Pattern> templateMap = parseTemplateVariables(templateVariables);

        for (VariablesRequestDto requestVariable : requestVariables) {
            String templateName = requestVariable.getName();
            if (!templateMap.containsKey(templateName)) {
                System.err.println("Variable not found in template: " + templateName);
                return false;
            }

            Pattern  regex = templateMap.get(templateName);

            if (!validateRegex(requestVariable.getValue(), regex)) {
                System.err.println("Value does not match regex ");
                return false; // Request value does not match the regex from template
            }
        }

        return true;
    }

    private static Map<String, Pattern> parseTemplateVariables(String templateVariables) {
        Map<String, Pattern> templateMap = new HashMap<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(templateVariables);
            if (jsonNode.isArray()) {
                for (JsonNode objNode : jsonNode) {
                    if (objNode.has("name") && objNode.has("validation")) {
                        String name = objNode.get("name").asText();
                        Pattern validation = Pattern.compile(objNode.get("validation").asText());
                        templateMap.put(name, validation);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return templateMap;
    }

    private static boolean validateRegex(String value, Pattern  regex) {
        if (StringUtils.isEmpty(value) || regex == null) {
            return false;
        }
        Matcher matcher = regex.matcher(value);
        return matcher.matches();
    }

    public static boolean isLink(String value) {
        if (StringUtils.isEmpty(value)) {
            return false;
        }

        Pattern pattern = Pattern.compile("https?://(www\\.)?[-a-zA-Z0-9@:%._+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_+.~#?&//=]*)");
        return validateRegex(value, pattern);
    }
}
