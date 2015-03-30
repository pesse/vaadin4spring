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

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.vaadin.spring.navigator.annotation.VaadinView;
import org.vaadin.spring.samples.mvp.ui.component.listener.NavigationPanelListener;
import org.vaadin.spring.samples.mvp.ui.component.nav.NavContainerFactory;
import org.vaadin.spring.samples.mvp.ui.component.nav.NavElement;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Tree;

/**
 * Primary navigation view that employs a {@link Tree} to render a hierarchical display of
 * targeted links.  Each link targets a single {@link View}.  Targeting is handled by the
 * {@link NavigationPanelListener} (which is an {@link com.vaadin.event.ItemClickEvent.ItemClickListener}).
 * @author Chris Phillipson (fastnsilver@gmail.com)
 *
 */
@VaadinUIScope
@VaadinView(name = NavigationPanelView.NAME)
public class NavigationPanelView extends Panel implements View {

    private static final long serialVersionUID = 1L;

    public static final String NAME = "navPanel";

    @Inject
    private NavigationPanelListener listener;

    private final Tree tree;

    public NavigationPanelView() {
        tree = new Tree();
    }

    @PostConstruct
    private void init() {
        tree.addItemClickListener(listener);
        tree.setSizeUndefined();
        tree.setImmediate(true);
        setContent(tree);
        setSizeFull();
    }

    /**
     * @param navElements
     */
    public void setData(List<NavElement> navElements) {
        NavContainerFactory nc = new NavContainerFactory(navElements);
        tree.setContainerDataSource(nc.constructNavigationHierarchy());

        // Expand whole tree
        for (final Object id : tree.rootItemIds()) {
            tree.expandItemsRecursively(id);
        }
    }

    @Override
    public void enter(ViewChangeEvent event) {

    }

}
