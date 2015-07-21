@Inject
protected Resources resources;
...
InputStream stream = null;
try {
    stream = resources.getResourceAsStream(resourceLocation);
    ...
} finally {
    IOUtils.closeQuietly(stream);
}