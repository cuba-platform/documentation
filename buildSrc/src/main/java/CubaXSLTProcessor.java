import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * Helper for xslt processing, just to avoid using ant task.
 * Significant note should be taken: it fails if remote XSL stylesheet is somehow
 * included in processed files by {@code <xsl:include/>} or {@code <xsl:import/>}.
 * @author kozlov
 * @version $Id: CubaXSLTProcessor.java 12665 2013-08-29 15:32:57Z kozlov $
 */
public class CubaXSLTProcessor {

    private Transformer transformer;

    private static Source getSource(File src) {
        return new StreamSource(src);
    }

    private static Result getResult(File out) {
        try {
            FileOutputStream os = new FileOutputStream(out);
            return new StreamResult(os);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Creates XSLT processor with associated transformer instance, configured by specified xsl-stylesheet.
     * @param stylesheet stylesheet location, if not exists a {@code RuntimeException} is thrown
     */
    public CubaXSLTProcessor(File stylesheet) {
        TransformerFactory factory = TransformerFactory.newInstance();
        factory.setURIResolver(new PathResolver());
        if (stylesheet.exists()) {
            try {
                transformer = factory.newTransformer(getSource(stylesheet));
            } catch (TransformerConfigurationException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new RuntimeException("Stylesheet not found: " + stylesheet.getAbsolutePath());
        }
    }

    /**
     * Put parameters from map to XSLT transformer instance.
     * @param parameters string parameters for XSLT
     * @return self, for method chaining
     */
    public CubaXSLTProcessor setParameters(Map<String, String> parameters) {
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            transformer.setParameter(entry.getKey(), entry.getValue());
        }
        return this;
    }

    /**
     * Performs transformation defined by the stylesheet.
     * @param input input file location
     * @param output output file location
     * @throws TransformerException when transformation cannot be performed, depends on XSLT processor used
     */
    public void transform(File input, File output) throws TransformerException {
        transformer.transform(getSource(input), getResult(output));
    }

    // Path resolver that resolves local-only resources and fails on remote ones.
    private static class PathResolver implements URIResolver {

        @Override
        public Source resolve(String href, String base) throws TransformerException {
            try {
                File resolved = new File(getBase(base).getParentFile(), href);
                return getSource(resolved.getCanonicalFile());
            } catch (URISyntaxException | IOException e) {
                return null;
            }
        }

        public File getBase(String base) throws URISyntaxException {
            URI uri = new URI(base);
            return new File(uri.getPath());
        }
    }
}
