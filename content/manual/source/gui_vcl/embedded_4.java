try {
    embedded.setSource(new URL("http://www.cuba-platform.com"));
} catch (MalformedURLException e) {
    throw new RuntimeException(e);
}