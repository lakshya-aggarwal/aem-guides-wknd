/*
 *  Copyright 2015 Adobe Systems Incorporated
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

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.via.ResourceSuperType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.wcm.core.components.models.Accordion;
import com.adobe.cq.wcm.core.components.models.ListItem;

@Model(adaptables = SlingHttpServletRequest.class,
       adapters = Accordion.class,
       resourceType = "wknd/components/accordion")
public class AccordionModel implements Accordion {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AccordionModel.class);

    @Self @Via(type = ResourceSuperType.class)
    private Accordion accordion;

    private List<AccordionItem> accordionItems = null;
    
    public List<AccordionItem> getAccords(){
        accordionItems = new ArrayList<>();
        for(ListItem i : accordion.getItems()){
            AccordionItem newItem = new AccordionItem();
            newItem.setTitle(i.getTitle());
            LOGGER.debug("AccordionModel :: {}", i.getTitle());
            newItem.setDescription("Hello");
            accordionItems.add(newItem);
        }
        return accordionItems;
    }
}