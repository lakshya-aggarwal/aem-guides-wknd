/*
 *  Copyright 2019 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.adobe.aem.guides.wknd.core.models.impl;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.factory.ModelFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.components.ComponentContext;
import com.adobe.aem.guides.wknd.core.models.Hero;
import com.adobe.cq.wcm.core.components.models.Image;

@Model(
        adaptables = {SlingHttpServletRequest.class},
        adapters = {Hero.class},
        resourceType = {HeroImpl.RESOURCE_TYPE},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class HeroImpl implements Hero {
    protected static final String RESOURCE_TYPE = "wknd/components/hero";

    @Self
    private SlingHttpServletRequest request;

    @OSGiService
    private ModelFactory modelFactory;

    @ScriptVariable
    private Page currentPage;

    @ScriptVariable
    protected ComponentContext componentContext;

    @ValueMapValue
    private Boolean imageToRight;

    @ValueMapValue
    private String bgolor;

    @ValueMapValue
    private String icon;

    @ValueMapValue
    private String eyebrow;

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String description;

    @ValueMapValue
    private Boolean showImage;

    @ValueMapValue
    private String fileReference;

    @ValueMapValue
    private String fileName;

    @ValueMapValue
    private String link;

    @ValueMapValue
    private String ctatext;

    // Add a logger for any errors
    private static final Logger LOGGER = LoggerFactory.getLogger(HeroImpl.class);

    @PostConstruct
    private void init() {
    }

    @Override
    public Boolean getImageToRight() {
        return imageToRight != null ? imageToRight : false;
    }

    @Override
    public String getBgolor() {
        return bgolor;
    }

    @Override
    public String getIcon() {
        return icon;
    }

    @Override
    public String getEyebrow() {
        return eyebrow;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Boolean getShowImage() {
        return showImage != null ? showImage : true;
    }

    @Override
    public String getFileReference() {
        return fileReference;
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public String getLink() {
        return link;
    }

    @Override
    public String getCtaText() {
        return ctatext;
    }

    @Override
    public boolean isEmpty() {
        // Hero is considered empty if it has no title and no description
        if (StringUtils.isBlank(title) && StringUtils.isBlank(description)) {
            return true;
        }
        return false;
    }
} 