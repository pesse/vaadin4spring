/*
 * Copyright 2014 The original authors
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
package org.vaadin.spring.servlet;

import com.vaadin.server.ServiceException;
import com.vaadin.server.SessionInitEvent;
import com.vaadin.server.SessionInitListener;
import com.vaadin.server.VaadinServlet;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Subclass of the standard {@link com.vaadin.server.VaadinServlet Vaadin servlet} that adds a {@link SpringAwareUIProvider} to
 * every new Vaadin session.
 * <p/>
 * If you need a custom Vaadin servlet, you can either extend this servlet directly, or extend another subclass of {@link VaadinServlet}
 * and just add the UI provider.
 *
 * @author Petter Holmström (petter@vaadin.com)
 * @author Josh Long (josh@joshlong.com)
 * @see org.vaadin.spring.servlet.SpringAwareVaadinServlet.ServiceCallback
 */
public class SpringAwareVaadinServlet extends VaadinServlet {

    private final List<ServiceCallback> serviceCallbackList = new LinkedList<>();

    @Override
    protected void servletInitialized() throws ServletException {
        final WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        serviceCallbackList.addAll(webApplicationContext.getBeansOfType(ServiceCallback.class).values());
        getService().addSessionInitListener(new SessionInitListener() {
            @Override
            public void sessionInit(SessionInitEvent sessionInitEvent) throws ServiceException {
                SpringAwareUIProvider uiProvider = new SpringAwareUIProvider(webApplicationContext);
                sessionInitEvent.getSession().addUIProvider(uiProvider);
            }
        });
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!serviceCallbackList.isEmpty()) {
            final Iterator<ServiceCallback> iterator = serviceCallbackList.iterator();
            iterator.next().onService(request, response, new ServiceCallbackChain() {
                @Override
                public void onService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                    if (iterator.hasNext()) {
                        iterator.next().onService(request, response, this);
                    } else {
                        SpringAwareVaadinServlet.super.service(request, response);
                    }
                }
            });
        } else {
            super.service(request, response);
        }
    }


    /**
     * Callback interface to be implemented by Spring beans that wish to do something before or after
     * a request has been served by the {@link org.vaadin.spring.servlet.SpringAwareVaadinServlet}, and that for some reason
     * cannot use {@link javax.servlet.Filter}s or {@link javax.servlet.ServletRequestListener}s.
     * <p/>
     * The {@code SpringAwareVaadinServlet} will automatically detect all Spring-managed beans that implement this interface
     * and invoke them in the order they are returned by the Spring application context.
     */
    public interface ServiceCallback {

        /**
         * Called before {@link org.vaadin.spring.servlet.SpringAwareVaadinServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
         *
         * @param request       the request, never {@code null}.
         * @param response      the response, never {@code null}.
         * @param callbackChain
         */
        void onService(HttpServletRequest request, HttpServletResponse response, ServiceCallbackChain callbackChain) throws ServletException, IOException;
    }

    /**
     *
     */
    public interface ServiceCallbackChain {

        /**
         * @param request
         * @param response
         * @throws ServletException
         * @throws IOException
         */
        void onService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    }
}
