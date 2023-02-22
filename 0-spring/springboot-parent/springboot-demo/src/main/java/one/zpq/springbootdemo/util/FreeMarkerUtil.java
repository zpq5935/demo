package one.zpq.springbootdemo.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author zhangchaopei
 * @version 1.0
 * @date 2020-12-16 10:27
 */
public class FreeMarkerUtil {
    /**
     * @param outputStream
     * @param templatePath
     * @param templateName
     * @param dataMap
     * @throws IOException
     * @throws TemplateException
     */
    public static void process(OutputStream outputStream, String templatePath, String templateName, Map dataMap) throws IOException,
            TemplateException {
        Configuration configuration = new Configuration();
        configuration.setDirectoryForTemplateLoading(new File(templatePath));
        Template template = configuration.getTemplate(templateName);
        Writer out = new OutputStreamWriter(outputStream);
        template.process(dataMap, out);
    }
}
