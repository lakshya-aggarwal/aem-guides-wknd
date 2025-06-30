package com.adobe.aem.guides.wknd.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Button {

    @ValueMapValue
    private String label;

    @ValueMapValue
    private String link;

    @ValueMapValue
    private boolean openInNewTab;

    @ValueMapValue
    private String style;

    @ValueMapValue
    private String icon;

    @ValueMapValue
    private String customClass;

    public String getLabel() {
        return label;
    }

    public String getLink() {
        return link;
    }

    public boolean isOpenInNewTab() {
        return openInNewTab;
    }

    public String getStyle() {
        return style;
    }

    public String getIcon() {
        return icon;
    }

    public String getCustomClass() {
        return customClass;
    }
} 