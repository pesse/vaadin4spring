/*
 * Copyright 2015 The original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.vaadin.spring.samples.sidebar;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import org.vaadin.spring.sidebar.annotation.SideBarItem;
import org.vaadin.spring.sidebar.annotation.ThemeIcon;

/**
 * Example view that shows up under the Reporting section in the side bar.
 *
 * @author Petter Holmström (petter@vaadin.com)
 */
@SpringView(name = ReportingView3.VIEW_NAME)
@SideBarItem(sectionId = Sections.REPORTING,
        caption = "View 3")
@ThemeIcon("../runo/icons/64/help.png")
@UIScope
public class ReportingView3 extends VerticalLayout implements View {

    private static final long serialVersionUID = 3349407981454517828L;
    
    public static final String VIEW_NAME = "reporting3";

    public ReportingView3() {
        addComponent(new Label("Reporting View 3"));
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
