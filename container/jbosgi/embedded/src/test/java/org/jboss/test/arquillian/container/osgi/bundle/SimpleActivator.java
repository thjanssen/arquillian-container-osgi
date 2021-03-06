/*
 * JBoss, Home of Professional Open Source
 * Copyright 2009, Red Hat Middleware LLC, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.test.arquillian.container.osgi.bundle;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * A BundleActivator that registers a {@ SimpleService}
 *
 * @author thomas.diesler@jboss.com
 * @version $Revision: $
 */
public class SimpleActivator implements BundleActivator {
    public void start(BundleContext context) throws Exception {
        SimpleService service = new SimpleService() {
            public Integer sum(Integer... values) {
                Integer result = 0;
                if (values != null) {
                    for (Integer i : values) {
                        result += i;
                    }
                }
                return result;
            }
        };
        context.registerService(SimpleService.class.getName(), service, null);
    }

    public void stop(BundleContext context) throws Exception {
    }
}
