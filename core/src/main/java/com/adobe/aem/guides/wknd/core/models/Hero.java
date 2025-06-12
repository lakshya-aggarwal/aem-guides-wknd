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
package com.adobe.aem.guides.wknd.core.models;

/**
 * Represents the Hero AEM Component for the WKND Site project.
 **/
public interface Hero {
    
    /**
     * @return the hero type - true if product hero, false if default hero
     */
    Boolean getImageToRight();
    
    /**
     * @return the background color for the hero
     */
    String getBgolor();
    
    /**
     * @return the path to the hero icon from DAM
     */
    String getIcon();
    
    /**
     * @return the eyebrow text for the hero
     */
    String getEyebrow();
    
    /**
     * @return the title/headline for the hero
     */
    String getTitle();
    
    /**
     * @return the description text for the hero
     */
    String getDescription();
    
    /**
     * @return whether to show the hero image
     */
    Boolean getShowImage();
    
    /**
     * @return the file reference for the hero image
     */
    String getFileReference();
    
    /**
     * @return the file name for the hero image
     */
    String getFileName();
    
    /**
     * @return the CTA link URL
     */
    String getLink();
    
    /**
     * @return the CTA text
     */
    String getCtaText();
    
    /**
     * @return true if the component has no content to display
     */
    boolean isEmpty();
} 