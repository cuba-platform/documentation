package com.company.demo.web.mixins;

import com.haulmont.cuba.gui.model.*;
import com.haulmont.cuba.gui.screen.*;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface DeclarativeLoaderParameters {

    Pattern CONTAINER_REF_PATTERN = Pattern.compile(":(container\\$(\\w+))");

    @Subscribe
    default void onDeclarativeLoaderParametersInit(Screen.InitEvent event) { // <1>
        Screen screen = event.getSource();
        ScreenData screenData = UiControllerUtils.getScreenData(screen); // <2>

        Set<DataLoader> loadersToLoadBeforeShow = new HashSet<>();

        for (String loaderId : screenData.getLoaderIds()) {
            DataLoader loader = screenData.getLoader(loaderId);
            String query = loader.getQuery();
            Matcher matcher = CONTAINER_REF_PATTERN.matcher(query);
            while (matcher.find()) { // <3>
                String paramName = matcher.group(1);
                String containerId = matcher.group(2);
                InstanceContainer<?> container = screenData.getContainer(containerId);
                container.addItemChangeListener(itemChangeEvent -> { // <4>
                    loader.setParameter(paramName, itemChangeEvent.getItem()); // <5>
                    loader.load();
                });
                if (container instanceof HasLoader) { // <6>
                    loadersToLoadBeforeShow.add(((HasLoader) container).getLoader());
                }
            }
        }

        DeclarativeLoaderParametersExt ext = new DeclarativeLoaderParametersExt(); // <7>
        ext.setLoadersToLoadBeforeShow(loadersToLoadBeforeShow);
        Extensions.register(screen, DeclarativeLoaderParametersExt.class, ext);
    }

    @Subscribe
    default void onDeclarativeLoaderParametersBeforeShow(Screen.BeforeShowEvent event) { // <8>
        Screen screen = event.getSource();
        DeclarativeLoaderParametersExt ext =
                Extensions.get(screen, DeclarativeLoaderParametersExt.class);
        if (ext.getLoadersToLoadBeforeShow() != null) {
            for (DataLoader loader : ext.getLoadersToLoadBeforeShow()) {
                loader.load(); // <9>
            }
        }
    }
}