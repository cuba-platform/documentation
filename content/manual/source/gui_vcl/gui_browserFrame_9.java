BrowserFrame frame = componentsFactory.createComponent(BrowserFrame.class);
try {
    frame.setSource(UrlResource.class).setUrl(new URL("http://www.foobar2000.org/"));
} catch (MalformedURLException e) {
    throw new RuntimeException(e);
}