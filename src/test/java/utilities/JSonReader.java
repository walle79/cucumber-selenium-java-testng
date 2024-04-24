package utilities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JSonReader {
    private JsonNode jsonNode;
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public JSonReader(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                throw new IOException("JSON file does not exist: " + filePath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            jsonNode = objectMapper.readTree(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public JsonNode getJsonNode() {
        return jsonNode;
    }

    public String getJsonValue(String sectionName, String attributeName) {
        JsonNode sectionNode = jsonNode.get(sectionName);
        if (sectionNode == null) {
            return ""; // Section not found, return an empty string
        }
        JsonNode attributeNode = sectionNode.get(attributeName);
        if (attributeNode == null) {
            return ""; // Attribute not found, return an empty string
        }
        String jsonValue = attributeNode.asText();
        System.out.println(jsonValue);
        return jsonValue;
    }
}
