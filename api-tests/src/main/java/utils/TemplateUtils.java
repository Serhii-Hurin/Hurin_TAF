package utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.apache.commons.text.StringSubstitutor;

public class TemplateUtils {

    public String getResolvedTemplate(String path, Map<String, Object> values) throws IOException {
        String template = readDataFromFile(path);
        StringSubstitutor stringSubstitutor = new StringSubstitutor(values, "{{", "}}");
        return stringSubstitutor.replace(template).replaceAll("\\s", "");
    }

    public static String readDataFromFile(String path) throws IOException {
        ClassLoader classLoader = TemplateUtils.class.getClassLoader();
        File file = new File(classLoader.getResource(path).getFile());
        String data = FileUtils.readFileToString(file, Charset.defaultCharset());
        return data;
    }

}
