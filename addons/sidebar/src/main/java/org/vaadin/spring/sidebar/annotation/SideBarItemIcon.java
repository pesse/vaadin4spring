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
package org.vaadin.spring.sidebar.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.vaadin.spring.sidebar.SideBarItemIconProvider;

/**
 * Meta annotation designed to be placed on icon annotations that are used to specify an icon of a {@link org.vaadin.spring.sidebar.annotation.SideBarItem}.
 *
 * @author Petter Holmström (petter@vaadin.com)
 * @see org.vaadin.spring.sidebar.annotation.FontAwesomeIcon
 * @see org.vaadin.spring.sidebar.annotation.ThemeIcon
 * @see org.vaadin.spring.sidebar.annotation.LocalizedThemeIcon
 */
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SideBarItemIcon {

    /**
     * The class of the {@link org.vaadin.spring.sidebar.SideBarItemIconProvider} that knows how to provide
     * the actual icon {@link com.vaadin.server.Resource}s. An instance of this class will be looked up from the
     * Spring application context, so make sure your icon provider is Spring managed.
     */
    @SuppressWarnings("rawtypes")
    Class<? extends SideBarItemIconProvider> value();

}
