package requests.jacksonrequest;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

import java.io.File;
import java.util.*;

// ===== Model Class with Annotations =====
class Product {
    @JsonProperty("product_name") // custom field name
    private String name;

    private double price;

    @JsonIgnore // excluded from serialization
    private String internalCode;

    @JsonInclude(JsonInclude.Include.NON_NULL) // include only if not null
    private String category;

    public Product() {} // default constructor required

    public Product(String name, double price, String internalCode, String category) {
        this.name = name;
        this.price = price;
        this.internalCode = internalCode;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price +
                ", internalCode='" + internalCode + "', category='" + category + "'}";
    }
}

// ===== Custom Serializer =====
class ProductSerializer extends JsonSerializer<Product> {
    @Override
    public void serialize(Product product, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("custom_product", product.toString());
        gen.writeEndObject();
    }
}

// ===== Custom Deserializer =====
class ProductDeserializer extends JsonDeserializer<Product> {
    @Override
    public Product deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.getCodec().readTree(p);
        String full = node.get("custom_product").asText();
        return new Product(full, 0.0, "N/A", null);
    }
}

public class JacksonProductFullDemo {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        // ===== 1. Basic Serialization =====
        Product p1 = new Product("Laptop", 1200.50, "INT123", "Electronics");
        String json = mapper.writeValueAsString(p1);
        System.out.println("Basic Serialization: " + json);

        // ===== 2. Basic Deserialization =====
        Product p2 = mapper.readValue(json, Product.class);
        System.out.println("Basic Deserialization: " + p2);

        // ===== 3. Pretty Printing =====
        String prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(p1);
        System.out.println("Pretty JSON:\n" + prettyJson);

        // ===== 4. File Operations =====
        mapper.writeValue(new File("product.json"), p1); // write to file
        Product fileProduct = mapper.readValue(new File("product.json"), Product.class);
        System.out.println("File Read: " + fileProduct);

        // ===== 5. Collections =====
        List<Product> products = Arrays.asList(
                new Product("Phone", 800.00, "INT456", "Electronics"),
                new Product("Table", 150.00, "INT789", null)
        );
        String listJson = mapper.writeValueAsString(products);
        System.out.println("List Serialization: " + listJson);

        List<Product> deserializedList = mapper.readValue(listJson, new TypeReference<List<Product>>() {});
        System.out.println("List Deserialization: " + deserializedList);

        // ===== 6. Map Serialization =====
        Map<String, Double> priceMap = new HashMap<>();
        priceMap.put("Laptop", 1200.50);
        priceMap.put("Phone", 800.00);
        String mapJson = mapper.writeValueAsString(priceMap);
        System.out.println("Map Serialization: " + mapJson);

        Map<String, Double> deserializedMap = mapper.readValue(mapJson, new TypeReference<Map<String, Double>>() {});
        System.out.println("Map Deserialization: " + deserializedMap);

        // ===== 7. Tree Model =====
        JsonNode tree = mapper.readTree(json);
        System.out.println("Tree Model Access: " + tree.get("product_name").asText());

        // ===== 8. Custom Serializer/Deserializer =====
        SimpleModule module = new SimpleModule();
        module.addSerializer(Product.class, new ProductSerializer());
        module.addDeserializer(Product.class, new ProductDeserializer());
        ObjectMapper customMapper = new ObjectMapper();
        customMapper.registerModule(module);

        String customJson = customMapper.writeValueAsString(p1);
        System.out.println("Custom Serialization: " + customJson);
        Product customProduct = customMapper.readValue(customJson, Product.class);
        System.out.println("Custom Deserialization: " + customProduct);

        // ===== 9. Configuration Options =====
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        System.out.println("Configured Pretty Print:\n" + mapper.writeValueAsString(p1));
    }
}