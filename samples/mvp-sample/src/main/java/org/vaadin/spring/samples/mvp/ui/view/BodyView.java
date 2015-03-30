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
package org.vaadin.spring.samples.mvp.ui.view;

import javax.annotation.PostConstruct;

import org.vaadin.spring.navigator.annotation.VaadinView;
import org.vaadin.spring.samples.mvp.ui.component.layout.Styles;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalSplitPanel;

@VaadinUIScope
@VaadinView(name = BodyView.NAME)
public class BodyView extends HorizontalSplitPanel implements View {

    private static final long serialVersionUID = -1302741483256336480L;

    public static final String NAME = "body";


    @PostConstruct
    private void init() {
        setSplitPosition(20f, Unit.PERCENTAGE);
        setStyleName(Styles.SPLITPANEL_SMALL);
    }

    public void setNavigationPanel(Component navigationPanel) {
        setFirstComponent(navigationPanel);
    }

    public void setTabbedPanel(Component tabPanel) {
        setSecondComponent(tabPanel);
    }

    @Override
    public void enter(ViewChangeEvent event) {

    }
}
