BrowserFrame frame = uiComponents.create(BrowserFrame.NAME);
try {
    frame.setSource(UrlResource.class).setUrl(new URL("http://www.foobar2000.org/"));
} catch (MalformedURLException e) {
    throw new RuntimeException(e);
}