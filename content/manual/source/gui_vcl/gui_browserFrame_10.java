UrlResource resource = browserFrame.createResource(UrlResource.class)
        .setUrl(new URL(fromString));
browserFrame.setSource(resource);